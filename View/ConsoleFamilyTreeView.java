// File: HomeWork/FamilyTree/View/ConsoleFamilyTreeView.java
package HomeWork.FamilyTree.View;

import HomeWork.FamilyTree.Model.FamilyMember;
import HomeWork.FamilyTree.Model.FamilyMember.Gender;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ConsoleFamilyTreeView implements FamilyTreeView {
    private Scanner scanner;

    public ConsoleFamilyTreeView() {this.scanner = new Scanner(System.in);}

    @Override
    public void showMenu() {System.out.println("\nМеню:");}

    @Override
    public void showOption(int number, String description) {System.out.println(number + ". " + description);}

    @Override
    public int getUserChoice() {
        System.out.print("Выберите опцию: ");
        return Integer.parseInt(scanner.nextLine());
    }

    @Override
    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    @Override
    public void showMessage(String message) {System.out.println(message);}

    @Override
    public Gender getGender() {
        System.out.print("Введите пол (M/F): ");
        String genderInput = scanner.nextLine().trim().toUpperCase();
        return genderInput.equals("M") ? Gender.MALE : Gender.FEMALE;
    }

    @Override
    public LocalDate getBirthDate() {
        System.out.print("Введите дату рождения (dd.MM.yyyy): ");
        String dateInput = scanner.nextLine().trim();
        return LocalDate.parse(dateInput, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @Override
    public void showFamilyTree(List<FamilyMember> members) {
        System.out.println("\nСемейное древо:");
        for (FamilyMember member : members) {
            System.out.println(member.getFamilyInfo());
        }
    }

    @Override
    public void showFamilyRelations(FamilyMember member) {
    }
}
