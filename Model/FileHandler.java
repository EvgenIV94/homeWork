package HomeWork.FamilyTree.Model;

import java.io.*;
import java.util.List;

public class FileHandler<T extends FamilyMember> {

    public void writeFile(String filename, List<T> members) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(members);
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> readFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<T>) ois.readObject();
        }
    }
}
