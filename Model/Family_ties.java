package Seminars.Seminars_1.HomeWork1.Model;

import java.util.List;

public class Family_ties<E extends FamilyMember> {
    private Family_tree<E> family_tree;
    private List<String> relations;

    public Family_ties(Family_tree<E> family_tree) {
        this.family_tree = family_tree;
    }

    public void addParentChildRelation(String parentName, String childName) {
        E parent = family_tree.getByName(parentName);
        E child = family_tree.getByName(childName);

        if (parent != null && child != null) {
            parent.addChild(child);
            child.addParent(parent);
        } else {
            System.out.println("Отсутствует.");
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семейные связи:\n");
        for (String relation : relations) {
            stringBuilder.append(relation).append("\n");
        }
        return stringBuilder.toString();
    }
}
