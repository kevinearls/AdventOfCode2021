import com.kevinearls.adventofcode2021.common.MyUtils;

import java.util.List;

public class Hydrothermal {
    public static final int gridSize=1000;  //  Change to 1000 for real data, 10 for test data
    int[][] grid=new int[gridSize][gridSize];

    public static void main(String[] args) throws Exception{
        Hydrothermal h = new Hydrothermal();
        //List<String> input = h.getTestData();
        List<String> input = h.loadData();

        for (String line : input ) {
            line = line.replace(" -> ", ",");
            String[] parts=line.split(",");

            // Flip if necessary
            int x1=Integer.parseInt(parts[0]);
            int y1=Integer.parseInt(parts[1]);
            int x2=Integer.parseInt(parts[2]);
            int y2=Integer.parseInt(parts[3]);

            //System.out.println(x1 + "," + y1 + " -> " + x2 +", " + y2);
            if (x1 == x2) {
                //System.out.print("Good input: ");
                y1 = Math.min(Integer.parseInt(parts[1]), Integer.parseInt(parts[3]));
                y2 = Math.max(Integer.parseInt(parts[1]), Integer.parseInt(parts[3]));
                for (int y = y1; y <= y2; y++) {
                    h.grid[x1][y]++;
                }
            } else if (y1 == y2) {
                //System.out.print("Good input: ");
                x1 = Math.min(Integer.parseInt(parts[0]), Integer.parseInt(parts[2]));
                x2 = Math.max(Integer.parseInt(parts[0]), Integer.parseInt(parts[2]));
                for (int x = x1; x <= x2; x++) {
                    h.grid[x][y1]++;
                }
            } else {
                //System.out.println("Diagonal: " + x1 + "," + y1 + " -> " + x2 +", " + y2);
                int xIncrement=1;
                int yIncrement=1;
                if (x1 > x2) {
                    xIncrement=-1;
                }
                if (y1 > y2) {
                    yIncrement=-1;
                }
                int x=x1;
                int y=y1;
                h.grid[x][y]++;
                while (x != x2) {  // is this off by one?
                    x += xIncrement;
                    y += yIncrement;
                    h.grid[x][y]++;
                }
            }
        }

        int overlap=0;
        for (int r=0; r< gridSize; r++) {
            for (int col=0; col<gridSize; col++) {
                //System.out.print(h.grid[r][col] + " ");
                if (h.grid[r][col] > 1) {
                    overlap++;
                }
            }
            //System.out.println("");
        }

        System.out.println("Overlap : " + overlap);  // 5124 for part1  ; for part2 19748 is too low, 19771 is too low
    }

    public List<String> loadData() throws Exception {
        String fileName = "/Users/kearls/sources/kevinearls/AdventOfCode2021/Day5/resources/input.txt";
        List<String> contents = MyUtils.loadFromFile(fileName);
        return contents;
    }

    public List<String> getTestData() throws Exception{
        String fileName = "/Users/kearls/sources/kevinearls/AdventOfCode2021/Day5/resources/test.txt";
        List<String> contents = MyUtils.loadFromFile(fileName);
        return contents;
    }
}
