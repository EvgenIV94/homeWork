package Seminars.Seminars_1.HomeWork1.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FamilyMember extends Serializable {
    enum Gender { Male, Female }

    String getName();
    LocalDate getBirthDate();
    void addChild(FamilyMember child);
    void addParent(FamilyMember parent);
    List<FamilyMember> getChildren();
    List<FamilyMember> getParents();
    String getFamilyInfo();
}
