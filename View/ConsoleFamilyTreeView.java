package Seminars.Seminars_1.HomeWork1.View;
import Seminars.Seminars_1.HomeWork1.Model.FamilyMember;
import Seminars.Seminars_1.HomeWork1.Model.Human.Gender;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ConsoleFamilyTreeView implements FamilyTreeView {
    private Scanner scanner;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public ConsoleFamilyTreeView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void showMenu() {
        System.out.println("\nМеню:");
        System.out.println("1. Добавить человека");
        System.out.println("2. Показать всё семейное древо");
        System.out.println("3. Добавить родителя");
        System.out.println("4. Показать родственные связи");
        System.out.println("5. Сохранить семейное древо");
        System.out.println("6. Выйти из приложения");
        System.out.print("Выберите опцию: ");
    }

    @Override
    public int getUserChoice() {
        return Integer.parseInt(scanner.nextLine());
    }

    @Override
    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public Gender getGender() {
        System.out.print("Введите пол (M/F): ");
        String genderInput = scanner.nextLine().trim().toUpperCase();
        return genderInput.equals("M") ? Gender.Male : Gender.Female;
    }

    @Override
    public LocalDate getBirthDate() {
        System.out.print("Введите дату рождения (dd.MM.yyyy): ");
        String dateInput = scanner.nextLine().trim();
        return LocalDate.parse(dateInput, DATE_FORMATTER);
    }

    @Override
    public void showFamilyTree(List<FamilyMember> members) {
        System.out.println("\nСемейное древо:");
        for (FamilyMember member : members) {
            System.out.println(member);
        }
    }

    @Override
    public void showFamilyRelations(FamilyMember member) {
        System.out.println(member.getFamilyInfo());
    }
}
