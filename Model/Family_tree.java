package Seminars.Seminars_1.HomeWork1.Model;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Family_tree<E extends FamilyMember> {
    private List<E> members;

    public Family_tree() {
        this.members = new ArrayList<>();
    }

    public void addMember(E member) {
        members.add(member);
    }

    public List<E> getMembers() {
        return members;
    }

    public E getByName(String name) {
        for (E member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public void addParentChildRelation(String parentName, String childName) {
        E parent = getByName(parentName);
        E child = getByName(childName);

        if (parent != null && child != null) {
            parent.addChild(child);
            child.addParent(parent);
        } else {
            System.out.println("Отсутствует.");
        }
    }

    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(members);
        }
    }

    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            members = (List<E>) ois.readObject();
        }
    }
}
