package Seminars.Seminars_1.HomeWork1.Presenter;

import Seminars.Seminars_1.HomeWork1.Model.FamilyMember;
import Seminars.Seminars_1.HomeWork1.Model.FamilyTree;
import Seminars.Seminars_1.HomeWork1.View.FamilyTreeView;
import java.time.LocalDate;
import java.util.List;
import Seminars.Seminars_1.HomeWork1.Model.Human;

public class FamilyTreePresenter {
    private FamilyTreeView view;
    private FamilyTree<FamilyMember> familyTree;

    public FamilyTreePresenter(FamilyTreeView view, FamilyTree<FamilyMember> familyTree) {
        this.view = view;
        this.familyTree = familyTree;
    }

    public void start() {
        boolean running = true;
        while (running) {
            view.showMenu();
            int choice = view.getUserChoice();
            switch (choice) {
                case 1:
                    addHuman();
                    break;
                case 2:
                    showFamilyTree();
                    break;
                case 3:
                    addParent();
                    break;
                case 4:
                    showFamilyRelations();
                    break;
                case 5:
                    saveFamilyTree();
                    break;
                case 6:
                    view.showMessage("Выход из приложения...");
                    running = false;
                    break;
                default:
                    view.showMessage("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }

    private void addHuman() {
        String name = view.getInput("Введите имя: ");
        Human.Gender gender = view.getGender();
        LocalDate birthDate = view.getBirthDate();
        
        FamilyMember member = new Human(name, gender, birthDate);
        familyTree.addMember(member);
        
        view.showMessage("Человек добавлен.");
    }

    private void addParent() {
        String parentName = view.getInput("Введите имя родителя: ");
        String childName = view.getInput("Введите имя ребенка: ");
        FamilyMember parent = familyTree.getByName(parentName);
        FamilyMember child = familyTree.getByName(childName);
        if (parent != null && child != null) {
            familyTree.addParentChildRelation(parent, child);
            view.showMessage("Родитель добавлен.");
        } else {
            view.showMessage("Родитель или ребенок не найдены.");
        }
    }

    private void showFamilyTree() {
        List<FamilyMember> members = familyTree.getMembers();
        view.showFamilyTree(members);
    }

    private void showFamilyRelations() {
        String name = view.getInput("Введите имя для показа родственных связей: ");
        FamilyMember member = familyTree.getByName(name);
        if (member != null) {
            view.showFamilyRelations(member);
        } else {
            view.showMessage("Член семьи не найден.");
        }
    }

    private void saveFamilyTree() {
    }
}