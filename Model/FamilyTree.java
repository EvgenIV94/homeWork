package HomeWork.FamilyTree.Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyMember> implements Iterable<E> {
    private List<E> members;

    public FamilyTree() {this.members = new ArrayList<>();}
    public void addMember(E member) {members.add(member);}

    public void removeMember(E member) {
        members.remove(member);
        for (E m : members) {
            m.getChildren().remove(member);
            m.getParents().remove(member);
        }
    }

    public List<E> getMembers() {return members;}

    public E getByName(String name) {
        for (E member : members) {
            if (member.getName().equals(name))
                return member;
        }
        return null;
    }

    public void sortByName() {members.sort(Comparator.comparing(E::getName));}
    public void sortByBirthDate() {members.sort(Comparator.comparing(E::getBirthDate));}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E member : members) {
            sb.append(member.getFamilyInfo()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {return members.iterator();}
}
