package HomeWork.FamilyTree.Model;

import java.time.LocalDate;
import java.util.List;

public interface FamilyMember extends NamedEntity {
    enum Gender { MALE, FEMALE }
    LocalDate getBirthDate();
    List<FamilyMember> getChildren();
    List<FamilyMember> getParents();
    void addChild(FamilyMember child);
    void addParent(FamilyMember parent);
    String getFamilyInfo();
}
