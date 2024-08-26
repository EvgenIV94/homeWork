package HomeWork.FamilyTree.Model;

import java.io.IOException;
import java.util.List;

public class FamilyTreeService<T extends FamilyMember> {
    private FamilyTree<T> familyTree;
    private FileHandler<T> fileHandler;

    public FamilyTreeService(FamilyTree<T> familyTree, FileHandler<T> fileHandler) {
        this.familyTree = familyTree;
        this.fileHandler = fileHandler;
    }

    public void addMember(T member) {familyTree.addMember(member);}
    public void removeMember(T member) {familyTree.removeMember(member);}
    public List<T> getMembers() {return familyTree.getMembers();}

    public void sortByName() {
        List<T> members = familyTree.getMembers();
        members.sort((m1, m2) -> m1.getName().compareTo(m2.getName()));
    }

    public void sortByBirthDate() {
        List<T> members = familyTree.getMembers();
        members.sort((m1, m2) -> m1.getBirthDate().compareTo(m2.getBirthDate()));
    }

    public void saveFamilyTree(String filename) {
        try {
            fileHandler.writeFile(filename, familyTree.getMembers());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
