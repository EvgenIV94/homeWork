package Seminars.Seminars_1.HomeWork1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Family_tree<E extends Human> implements Iterable<E>{
    private List<E> people;

    public Family_tree() {this.people = new ArrayList<>();}
    public void addHuman(E human) {people.add(human);}

    public E getByName(String name) {
        for (E human : people) {
            if (human.getName().equals(name))
                return human;
        }return null;}

    public List<E> getPeople() {return people;}

    @Override
    public Iterator<E> iterator() {return (Iterator<E>) people.iterator();}

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nСписок всех членов семьи:\n\n");
        for (E human : people){
            stringBuilder.append(human);
            stringBuilder.append("\n\n");
        }return stringBuilder.toString();}

    
    public void sortByName() {people.sort(Comparator.comparing(Human::getName));}
    public void sortByBirthDate() {people.sort(Comparator.comparing(Human::getBirthDate));}
}

