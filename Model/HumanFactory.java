package HomeWork.FamilyTree.Model;

import java.time.LocalDate;

public class HumanFactory implements FamilyMemberFactory<Human> {
    @Override
    public Human create(String name, FamilyMember.Gender gender, LocalDate birthDate) {
        return new Human(name, gender, birthDate);
    }
}
