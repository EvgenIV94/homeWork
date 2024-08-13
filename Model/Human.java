package Seminars.Seminars_1.HomeWork1.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements FamilyMember {
    private static final long serialVersionUID = 1L;

    public enum Gender { Male, Female }

    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private transient List<FamilyMember> parents;
    private transient List<FamilyMember> children;

    public Human(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate, null);
    }

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    @Override
    public String getName() { return name; }
    @Override
    public LocalDate getBirthDate() { return birthDate; }
    @Override
    public void addChild(FamilyMember child) { this.children.add(child); }
    @Override
    public void addParent(FamilyMember parent) { this.parents.add(parent); }
    @Override
    public List<FamilyMember> getChildren() { return children; }
    public List<FamilyMember> getParents() { return parents; }

    @Override
    public String getFamilyInfo() {
        throw new UnsupportedOperationException("Unimplemented method 'getFamilyInfo'");
    }

}
