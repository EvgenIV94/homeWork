package Seminars.Seminars_1.HomeWork1.Model;

import java.time.LocalDate;
import java.util.List;

public interface FamilyMember extends NamedEntity {
    LocalDate getBirthDate();
    List<FamilyMember> getChildren();
    List<FamilyMember> getParents();
    <E extends FamilyMember> void addChild(E child);
    <E extends FamilyMember> void addParent(E parent);
}
