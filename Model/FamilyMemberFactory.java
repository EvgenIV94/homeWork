package HomeWork.FamilyTree.Model;

import java.time.LocalDate;

public interface FamilyMemberFactory<T extends FamilyMember> {
    T create(String name, FamilyMember.Gender gender, LocalDate birthDate);
}
