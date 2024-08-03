package Seminars.Seminars_1.HomeWork1;

import java.io.*;
import java.util.List;

public class FileHandler implements FileOperations {
    @Override
    public void writeFile(String fileName, List<Human> people) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(people);
        }
    }

    @Override
    public List<Human> readFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Human>) ois.readObject();
        }
    }
}
