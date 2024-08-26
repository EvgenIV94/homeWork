package HomeWork.FamilyTree.Presenter;

import HomeWork.FamilyTree.Model.FamilyMember;
import HomeWork.FamilyTree.Model.FamilyTreeService;
import HomeWork.FamilyTree.Model.FamilyMemberFactory;
import HomeWork.FamilyTree.View.FamilyTreeView;

import java.time.LocalDate;
import java.util.List;
public class FamilyTreePresenter<T extends FamilyMember> {
    private FamilyTreeView view;
    private FamilyTreeService<T> familyTreeService;
    private FamilyMemberFactory<T> factory;
    private List<MenuOption> menuOptions;

    public FamilyTreePresenter(FamilyTreeView view, FamilyTreeService<T> familyTreeService, FamilyMemberFactory<T> factory) {
        this.view = view;
        this.familyTreeService = familyTreeService;
        this.factory = factory;

        menuOptions = List.of(
            new AddHumanOption(),
            new ShowFamilyTreeOption(),
            new SortByNameOption(),
            new SortByBirthDateOption(),
            new SaveToFileOption(),
            new AddChildOption(),
            new ShowFamilyRelationsOption(),
            new ExitOption()
    );

    }

    public FamilyTreeView getView() {
        return view;
    }

    public void start() {
        while (true) {
            view.showMenu();
            for (int i = 0; i < menuOptions.size(); i++) {
                MenuOption option = menuOptions.get(i);
                view.showOption(i + 1, option.getDescription());
            }
            int choice = view.getUserChoice();
            if (choice > 0 && choice <= menuOptions.size()) {
                menuOptions.get(choice - 1).execute(this);
            } else {
                view.showMessage("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    public void addHuman() {
        String name = view.getInput("Введите имя: ");
        FamilyMember.Gender gender = view.getGender();
        LocalDate birthDate = view.getBirthDate();
        
        T human = factory.create(name, gender, birthDate);
        familyTreeService.addMember(human);
        
        view.showMessage("Человек добавлен.");
    }

    public void showFamilyTree() {
        List<T> members = familyTreeService.getMembers();
        view.showFamilyTree(members);
    }

    public void sortByName() {
        familyTreeService.sortByName();
        view.showMessage("Отсортировано по имени.");
    }

    public void sortByBirthDate() {
        familyTreeService.sortByBirthDate();
        view.showMessage("Отсортировано по дате рождения.");
    }

    public void saveToFile(String filename) {
        familyTreeService.saveFamilyTree(filename);
        view.showMessage("Фамильное древо сохранено в файл: " + filename);
    }

    public void removeHuman() {
        String name = view.getInput("Введите имя человека для удаления: ");
        T member = (T) familyTreeService.getMembers().stream()
                                    .filter(m -> m.getName().equals(name))
                                    .findFirst()
                                    .orElse(null);
        if (member != null) {
            familyTreeService.removeMember(member);
            view.showMessage("Человек удален.");
        } else {
            view.showMessage("Человек не найден.");
        }
    }
    public void addChild() {
        String parentName = view.getInput("Введите имя родителя: ");
        String childName = view.getInput("Введите имя ребенка: ");
        T parent = (T) familyTreeService.getMembers().stream()
            .filter(m -> m.getName().equals(parentName))
            .findFirst()
            .orElse(null);
        T child = (T) familyTreeService.getMembers().stream()
            .filter(m -> m.getName().equals(childName))
            .findFirst()
            .orElse(null);
    
        if (parent != null && child != null) {
            parent.addChild(child);
            child.addParent(parent);
            view.showMessage("Связь добавлена.");
        } else {
            view.showMessage("Родитель или ребенок не найден.");
        }
    }
    
    public void showFamilyRelations() {
        String name = view.getInput("Введите имя для просмотра связей: ");
        T member = (T) familyTreeService.getMembers().stream()
            .filter(m -> m.getName().equals(name))
            .findFirst()
            .orElse(null);
    
        if (member != null) {
            view.showFamilyRelations(member);
        } else {
            view.showMessage("Человек не найден.");
        }
    }
    

    public void exit() {System.exit(0);}
}
