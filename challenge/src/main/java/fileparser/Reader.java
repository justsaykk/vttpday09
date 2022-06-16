package fileparser;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Reader {

    public static final String GRID = "GRID ";
    public static final String START = "START ";
    public static final String DATA = "DATA";
    public int totalRow = 0;
    public int totalCol = 0;
    public int startingRow = 0;
    public int startingCol = 0;
    public char[][] charArr;

    public void load(Path path) throws IOException {
        File file = path.toFile();
        FileReader fr = new FileReader(file);
        // BufferedReader sc = new BufferedReader(fr);
        Scanner sc = new Scanner(fr);
        String input;

        while (sc.hasNextLine()) {
            input = sc.nextLine();

            if (input.startsWith(GRID)) {
                input = input.substring(GRID.length()).trim();
                String[] splitString = input.split(" ");
                totalRow = Integer.parseInt(splitString[0]);
                totalCol = Integer.parseInt(splitString[1]);
                System.out.printf("totalRow = %d\ntotalCol = %d\n", totalRow, totalCol);

            } else if (input.startsWith(START)) {
                input = input.substring(START.length()).trim();
                String[] splitString = input.split(" ");
                startingRow = Integer.parseInt(splitString[0]);
                startingCol = Integer.parseInt(splitString[1]);
                System.out.printf("startingRow = %d\nstartingCol = %d\n", startingRow, startingCol);
            } else if (input.startsWith("#")) {
                continue;
            } else if (input.startsWith(DATA)) {
                while (sc.hasNext()) {
                    System.out.println(sc.next());
                }
            }
        }
        ;
        sc.close();
    }
}