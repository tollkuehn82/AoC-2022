package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day1 {

    public void solvePuzzle() {
        Map<Integer, Integer> elf2CaloriesMap = new HashMap<>();
        int elfNo = 1;

        // read in input txt line by line
        try {
            Scanner scanner = new Scanner(new File("src/day1/input.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // next elf comes...
                if (line.isBlank()) {
                    elfNo++;
                    continue;
                }

                // get the current calories of the elf; if its the start of the new elf (current calories null) start with 0 calories
                Integer calInMap = elf2CaloriesMap.get(elfNo);
                if (calInMap == null) {
                    calInMap = 0;
                }

                // get the calories from the current line
                int calLine = Integer.parseInt(line);

                // add elf with new calory value to map
                elf2CaloriesMap.put(elfNo, calLine + calInMap);
            }
        } catch (FileNotFoundException ex) {
            // do nothing
        }

        // sort map by value
        Map<Integer, Integer> elf2CaloriesMapSorted = new HashMap<>();

        elf2CaloriesMapSorted = MapUtil.sortByValue(elf2CaloriesMap);

        // print out sorted map (part1)
        System.out.println(elf2CaloriesMapSorted);

        // print out calory number of the top three elfes (part2)
        System.out.println(elf2CaloriesMapSorted.get(143) + elf2CaloriesMapSorted.get(142) + elf2CaloriesMapSorted.get(163));
    }
}
