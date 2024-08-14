package Seminars.Seminars_1.HomeWork1;

import Seminars.Seminars_1.HomeWork1.View.*;
import Seminars.Seminars_1.HomeWork1.Model.FamilyMember;
import Seminars.Seminars_1.HomeWork1.Model.FamilyTree;
import Seminars.Seminars_1.HomeWork1.Presenter.*;

public class Main {
    public static void main(String[] args) {
         FamilyTreeView view = new ConsoleFamilyTreeView();
        FamilyTree<FamilyMember> familyTree = new FamilyTree<>();
        FamilyTreePresenter presenter = new FamilyTreePresenter(view, familyTree);
        presenter.start();
    }
}
