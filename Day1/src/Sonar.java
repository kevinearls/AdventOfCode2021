import com.kevinearls.adventofcode2021.common.MyUtils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.kevinearls.adventofcode2021.common.MyUtils.readIntegersFromFile;

/*
    Day1 Part1 1288
 */
public class Sonar {

    public static void main(String[] args) throws Exception{
        Sonar sonar = new Sonar();

        sonar.withTestData();
        sonar.part1();
        sonar.part2WithTestData();
        sonar.part2WithRealData();
    }

    public void withTestData() {
        List<Integer> contents = getTestData();
        System.out.println("Test DataIncreases: " + countIncreases(contents)); // Should be 7
    }

    public void part1() throws Exception {
        String fullFileName = "/Users/kearls/sources/kevinearls/AdventOfCode2021/Day1/resources/input.txt";
        List<Integer> contents = readIntegersFromFile(fullFileName);
        System.out.println("Part 1 Increases: " + countIncreases(contents)); // should be 1288
    }

    public int part2(List<Integer> contents) {
        // test for size < 4 here...
        int count = 0;
        int previousSum = contents.get(0) + contents.get(1) + contents.get(2);
        for (int i=1; i < contents.size() -2 ; i++) {
            int currentSum = contents.get(i) + contents.get(i + 1) + contents.get(i + 2);
            if (currentSum > previousSum) {
                count++;
            }
            previousSum = currentSum;
        }

        return count;
    }

    public void part2WithTestData() {
        List<Integer> contents = getTestData();
        System.out.println("Using test data got " + part2(contents) + " increases");
    }

    public void part2WithRealData() throws Exception {
        String fullFileName = "/Users/kearls/sources/kevinearls/AdventOfCode2021/Day1/resources/input.txt";
        List<Integer> contents = MyUtils.readIntegersFromFile(fullFileName);
        System.out.println("Using real data got " + part2(contents) + " increases"); // should be 1311
    }

    public List<Integer> getTestData() {
        List<Integer> contents = new ArrayList<>();
        contents.add(199);
        contents.add(200);
        contents.add(208);
        contents.add(210);
        contents.add(200);
        contents.add(207);
        contents.add(240);
        contents.add(269);
        contents.add(260);
        contents.add(263);

        return contents;
    }

    public  int countIncreases(List<Integer> lines) {
        if (lines.size() < 2 ) {
            return 0;
        }

        int count = 0;
        int previous = Integer.MIN_VALUE;
        boolean first = true;

        for (int line:lines) {
            if (first) {
                first = false;
                previous = line;
            } else {
                if (line > previous) {
                    count++;
                }
                previous = line;
            }
        }

        return count;
    }
}
