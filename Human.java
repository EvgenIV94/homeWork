package Seminars.Seminars_1.HomeWork1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private static final long serialVersionUID = 1L;
    public enum Gender{Male, Female}

    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private transient List<Human> parents;
    private transient List<Human> children;

    public Human(String name, Gender gender, LocalDate birthDate){
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public Human (String name, Gender gender, LocalDate birthDate, LocalDate deathDate){
        this(name, gender, birthDate);
        this.deathDate = deathDate;
    }

    public String getName(){return name;}
    public Gender getGender(){return gender;}
    public LocalDate getBirthDate(){return birthDate;}
    public LocalDate getDeathDate(){return deathDate;}

    public void addChild(Human child) {this.children.add(child);}
    public void addParent(Human parent) {this.parents.add(parent);}

    public List<Human> getParents() {return parents;}
    public List<Human> getChildren() {return children;}
    
    public int getAge() {
        LocalDate endDate = (deathDate != null) ? deathDate : LocalDate.now();
        return Period.between(birthDate, endDate).getYears();
    }
    public int getAgeAsOf(LocalDate date) {return Period.between(birthDate, date).getYears();}
    LocalDate specificDate = LocalDate.of(2024, 8, 3);

    @Override
    public String toString() {
        return "Имя: " + name + "\n" + 
               "Пол: " + gender + "\n" + 
               "Дата рождения: " + birthDate + "\n" + 
               (deathDate != null ? "Дата смерти: " + deathDate + "\n" : "") + 
               "Возраст: " + getAgeAsOf(specificDate);
    }
    public String getFamilyInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this).append("\n");
        if (!parents.isEmpty()) {
            stringBuilder.append("Родители: ");
            for (Human parent : parents) {
                stringBuilder.append(parent.getName()).append(" ");
            }
            stringBuilder.append("\n");
        }
        if (!children.isEmpty()) {
            stringBuilder.append("Дети: ");
            for (Human child : children) {
                stringBuilder.append(child.getName()).append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }
}
