package HomeWork.FamilyTree.Model;

import java.io.IOException;
import java.util.List;

public interface FileOperations<T extends FamilyMember> {
    void writeFile(String filename, List<T> people) throws IOException;
    List<T> readFile(String filename) throws IOException, ClassNotFoundException;
}