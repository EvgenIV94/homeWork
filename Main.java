package Seminars.Seminars_1.HomeWork1;

import Seminars.Seminars_1.HomeWork1.View.*;
import Seminars.Seminars_1.HomeWork1.Presenter.*;

public class Main {
    public static void main(String[] args) {
        FamilyTreeView view = new ConsoleFamilyTreeView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(view);
        presenter.start();
    }
}
