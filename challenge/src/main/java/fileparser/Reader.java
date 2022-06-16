package fileparser;

import java.io.*;
import java.nio.file.*;

public class Reader {

    public static final String GRID = "GRID ";
    public static final String START = "START ";
    public static final String DATA = "DATA";
    public int totalRow = 0;
    public int totalCol = 0;
    public int startingRow = 0;
    public int startingCol = 0;

    public void load(Path path) throws IOException {
        File file = path.toFile();
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String input;

        while ((input = br.readLine()) != null) {

            if (input.startsWith(GRID)) {
                input = input.substring(GRID.length()).trim();
                String[] splitString = input.split(" ");
                totalRow = Integer.parseInt(splitString[1]);
                totalCol = Integer.parseInt(splitString[2]);
                System.out.printf("totalRow = %d\n totalCol = %d\n", totalRow, totalCol);

            } else if (input.startsWith(START)) {
                input = input.substring(START.length()).trim();
                String[] splitString = input.split(" ");
                startingRow = Integer.parseInt(splitString[1]);
                startingCol = Integer.parseInt(splitString[2]);
                System.out.printf("startingRow = %d\n startingCol = %d\n", startingRow, startingCol);

            } else if (input.startsWith("#")) {
                continue;
            }
        }
        ;
        br.close();
    }

    // public char[][] parse() {

    // }
}