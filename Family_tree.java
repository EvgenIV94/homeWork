package Seminars.Seminars_1.HomeWork1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Family_tree implements Iterable<Human>{
    private List<Human> people;

    public Family_tree() {this.people = new ArrayList<>();}
    public void addHuman(Human human) {people.add(human);}

    public Human getByName(String name) {
        for (Human human : people) {
            if (human.getName().equals(name))
                return human;
        }return null;}

    public List<Human> getPeople() {return people;}

    @Override
    public Iterator<Human> iterator() {return people.iterator();}

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nСписок всех членов семьи:\n\n");
        for (Human human : people){
            stringBuilder.append(human);
            stringBuilder.append("\n\n");
        }return stringBuilder.toString();}

    
    public void sortByName() {people.sort(Comparator.comparing(Human::getName));}
    public void sortByBirthDate() {people.sort(Comparator.comparing(Human::getBirthDate));}
}

