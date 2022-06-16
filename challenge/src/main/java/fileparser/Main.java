package fileparser;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        Path path = Paths.get("./" + fileName);
        Reader reader = new Reader();
        reader.load(path);
    }
}
