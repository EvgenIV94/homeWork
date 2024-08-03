package Seminars.Seminars_1.HomeWork1;

import java.io.IOException;
import java.util.List;

public interface FileOperations {
    void writeFile(String filename, List<Human> people) throws IOException;
    List<Human> readFile(String filename) throws IOException, ClassNotFoundException;
}
