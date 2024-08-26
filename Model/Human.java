package HomeWork.FamilyTree.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements FamilyMember {
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private List<FamilyMember> children = new ArrayList<>();
    private List<FamilyMember> parents = new ArrayList<>();

    public Human(String name, Gender gender, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    @Override
    public String getName() { return name; }

    @Override
    public LocalDate getBirthDate() { return birthDate; }

    @Override
    public List<FamilyMember> getChildren() { return children; }

    @Override
    public List<FamilyMember> getParents() { return parents; }

    @Override
    public String getFamilyInfo() {
        return "Имя: " + name + ", Пол: " + gender + ", Дата рождения: " + birthDate;
    }

    @Override
    public void addChild(FamilyMember child) { children.add(child); }

    @Override
    public void addParent(FamilyMember parent) { parents.add(parent); }
}
