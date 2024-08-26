package HomeWork.FamilyTree.View;

import HomeWork.FamilyTree.Model.FamilyMember;
import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeView {
    void showOption(int number, String description);
    void showMenu();
    int getUserChoice();
    String getInput(String prompt);
    FamilyMember.Gender getGender();
    LocalDate getBirthDate();
    void showMessage(String message);
    void showFamilyTree(List<? extends FamilyMember> members);
    void showFamilyRelations(FamilyMember member);
}