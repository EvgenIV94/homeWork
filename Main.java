package Seminars.Seminars_1.HomeWork1;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Family_tree family_tree = new Family_tree();
        Family_ties familyTies = new Family_ties(family_tree);
        FileOperations fileHandler = new FileHandler();

        Human human1 = new Human("Мария", Human.Gender.Female, LocalDate.of(1955, 5, 12));
        Human human2 = new Human("Василий", Human.Gender.Male, LocalDate.of(1951, 3, 22));
        Human human3 = new Human("Ольга", Human.Gender.Female, LocalDate.of(1980, 8, 19));
        Human human4 = new Human("Алексей", Human.Gender.Male, LocalDate.of(1979, 6, 15));
        Human human5 = new Human("Александра", Human.Gender.Female, LocalDate.of(2002, 1, 9));
        Human human6 = new Human("Олег", Human.Gender.Male, LocalDate.of(2002, 1, 9));
        Human human7 = new Human("Фатима", Human.Gender.Female, LocalDate.of(2023, 7, 1));

        family_tree.addHuman(human1);
        family_tree.addHuman(human2);
        family_tree.addHuman(human3);
        family_tree.addHuman(human4);
        family_tree.addHuman(human5);
        family_tree.addHuman(human6);
        family_tree.addHuman(human7);

        familyTies.addParentChildRelation("Мария", "Ольга");
        familyTies.addParentChildRelation("Василий", "Ольга");
        familyTies.addParentChildRelation("Ольга", "Олег");
        familyTies.addParentChildRelation("Олег", "Фатима");

        try {
            fileHandler.writeFile("family_tree.dat", family_tree.getPeople());
            System.out.println("Данные успешно записаны в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }

        try {
            List<Human> peopleFromFile = fileHandler.readFile("family_tree.dat");
            System.out.println("Данные успешно считаны из файла:");
            for (Human human : peopleFromFile) {
                System.out.println(human.getFamilyInfo());
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при чтении из файла: " + e.getMessage());
        }
    }
}
