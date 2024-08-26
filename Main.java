package HomeWork.FamilyTree;

import HomeWork.FamilyTree.Model.*;
import HomeWork.FamilyTree.Presenter.*;
import HomeWork.FamilyTree.View.*;

public class Main {
    public static void main(String[] args) {
        FamilyTreeView view = new ConsoleFamilyTreeView();
        FamilyTree<Human> familyTree = new FamilyTree<>();
        FileHandler<Human> fileHandler = new FileHandler<>();
        FamilyTreeService<Human> service = new FamilyTreeService<>(familyTree, fileHandler);
        FamilyMemberFactory<Human> factory = new HumanFactory();
        FamilyTreePresenter<Human> presenter = new FamilyTreePresenter<>(view, service, factory);
        presenter.start();
    }
}
