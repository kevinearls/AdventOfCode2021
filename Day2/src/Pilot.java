import com.kevinearls.adventofcode2021.common.MyUtils;

import java.util.ArrayList;
import java.util.List;

public class Pilot {
    public static void main(String[] args) throws Exception{
        Pilot p = new Pilot();
        int result = p.pilot1(p.getTestData());
        System.out.println("Got: " + result); // Should be 150

        result = p.pilot1(p.loadData());
        System.out.println("Got: " + result);  // Got 2070300

        // part 2
        result = p.pilot2(p.getTestData());
        System.out.println("Got: " + result); // Should be 900

        result = p.pilot2(p.loadData());
        System.out.println("Got: " + result);  // should be 2078985210

    }

    public int pilot1(List<String> moves) {
        int horizontal = 0;
        int depth = 0;

        for (String move:moves) {
            String[] parts = move.split(" ");
            // check for 2 parts
            String direction = parts[0];
            int value = Integer.parseInt(parts[1].trim());

            switch (direction) {
                case "forward": horizontal += value;
                break;
                case "down": depth += value;
                break;
                case "up": depth -=value;
                break;
            }
        }

        return horizontal * depth;
    }

    public int pilot2(List<String> moves) {
        int horizontal = 0;
        int depth = 0;
        int aim = 0;

        for (String move:moves) {
            String[] parts = move.split(" ");
            String direction = parts[0];

            int units = Integer.parseInt(parts[1].trim());

            switch (direction) {
                case "forward":
                    horizontal += units;
                    depth += (aim * units);
                    break;
                case "down": aim += units;
                    break;
                case "up": aim -= units;
                    break;
            }
        }

        return horizontal * depth;
    }

    public List<String> loadData() throws Exception {
        String fileName = "Day2/resources/input.txt";
        List<String> contents = MyUtils.loadFromFile(fileName);
        return contents;
    }

    public List<String> getTestData() {
        List<String> contents = new ArrayList<>();
        contents.add("forward 5");
        contents.add("down 5");
        contents.add("forward 8");
        contents.add("up 3");
        contents.add("down 8");
        contents.add("forward 2");

        return contents;
    }
}
