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

    public FamilyTreePresenter(FamilyTreeView view, FamilyTreeService<T> familyTreeService, FamilyMemberFactory<T> factory) {
        this.view = view;
        this.familyTreeService = familyTreeService;
        this.factory = factory;
    }

    public void start() {
        while (true) {
            view.showMenu();
            for (int i = 1; i <= 6; i++) {
                view.showOption(i, getOptionDescription(i));
            }
            int choice = view.getUserChoice();
            switch (choice) {
                case 1: addHuman(); break;
                case 2: showFamilyTree(); break;
                case 3: sortByName(); break;
                case 4: sortByBirthDate(); break;
                case 5: saveToFile(view.getInput("Введите имя файла: ")); break;
                case 6: return;
                default: view.showMessage("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private String getOptionDescription(int option) {
        switch (option) {
            case 1: return "Добавить человека";
            case 2: return "Показать всё семейное древо";
            case 3: return "Сортировать по имени";
            case 4: return "Сортировать по дате рождения";
            case 5: return "Сохранить в файл";
            case 6: return "Выход";
            default: return "Неизвестная опция";
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
        view.showFamilyTree((List<FamilyMember>) (List<?>) members);
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
}
