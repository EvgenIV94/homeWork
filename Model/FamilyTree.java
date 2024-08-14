package Seminars.Seminars_1.HomeWork1.Model;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree<E extends FamilyMember> {
    private List<E> members = new ArrayList<>();

    public void addMember(E member) {members.add(member);}

    public List<E> getMembers() {return members;}

    public E getByName(String name) {
        return members.stream()
                .filter(member -> member.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void addParentChildRelation(E parent, E child) {
        parent.addChild(child);
        child.addParent(parent);
    }
}
