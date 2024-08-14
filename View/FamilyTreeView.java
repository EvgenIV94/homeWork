package Seminars.Seminars_1.HomeWork1.View;

import Seminars.Seminars_1.HomeWork1.Model.FamilyMember;
import Seminars.Seminars_1.HomeWork1.Model.Human;

import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeView {
    void showMenu();
    int getUserChoice();
    String getInput(String prompt);
    Human.Gender getGender();
    LocalDate getBirthDate();
    void showMessage(String message);
    void showFamilyTree(List<FamilyMember> members);
    void showFamilyRelations(FamilyMember member);
}



