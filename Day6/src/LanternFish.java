import com.kevinearls.adventofcode2021.common.MyUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class LanternFish {
    int newFishValue=8;
    int resetFishValue=6;
    int days = 256;

    public static void main(String[] args) throws Exception {
        LanternFish lf = new LanternFish();
        //List<String> in = lf.getTestData();  // gets test data
        List<String> in = lf.loadData();  // Gets real data
        List<Integer> fish = lf.createIntegerList(in.get(0));

        System.out.println("Initial State = " + fish);

        for (int day=1; day <= lf.days; day++) {
            int additions=0;
            for (Integer f:fish) {
                if (f==0) {
                    additions++;
                }
            }

            // Todo decrement part...
            fish=lf.decrement(fish);
            for (int i=0; i< additions; i++) {
                fish.add(lf.newFishValue);
            }
            //System.out.println("At the end of day " + day +": " + fish);
            System.out.println("End of day: " + day);
        }

        System.out.println("Finished with " + fish.size() + " fish");  // 360268 for part 1
    }

    // Hacky.  There must be a better way to do this
    public List<Integer> decrement(List<Integer> data) {
        List<Integer> result = new ArrayList<>();
        for (Integer i:data) {
            if (i == 0) {
                result.add(resetFishValue);
            } else {
                result.add(i - 1);
            }
        }

        return result;
    }

    public List<String> loadData() throws Exception {
        String fileName = "/Users/kearls/sources/kevinearls/AdventOfCode2021/Day6/resources/input.txt";
        List<String> contents = MyUtils.loadFromFile(fileName);
        return contents;
    }

    public List<String> getTestData() throws Exception{
        String fileName = "/Users/kearls/sources/kevinearls/AdventOfCode2021/Day6/resources/testInput.txt";
        List<String> contents = MyUtils.loadFromFile(fileName);
        return contents;
    }

    public List<Integer> createIntegerList(String input) {
        String[] blah=input.split(",");
        List<String> blah2 = Arrays.asList(blah);
        List<Integer> values=new ArrayList<>();
        for (String s: blah2) {
            values.add(Integer.parseInt(s));
        }
        return values;
    }
}
