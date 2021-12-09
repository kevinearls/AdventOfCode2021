import com.kevinearls.adventofcode2021.common.MyUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class LanternFish {
    public static final int newFishValue=8;
    int resetFishValue=6;
    int days = 256;

    public static void main(String[] args) throws Exception {
        LanternFish lf = new LanternFish();
        //List<String> in = lf.getTestData();  // gets test data
        List<String> in = lf.loadData();  // Gets real data
        List<Integer> fish = lf.createIntegerList(in.get(0));

        System.out.println("Initial State = " + fish);
        long[] state = new long[newFishValue + 1];
        for (Integer f:fish) {
            state[f]++;
        }
        System.out.print("At start ");
        lf.printStatus(state);

        // Note 0 value to be added to 6 and to be used to reset 8 laster
        for (int day=1; day <= lf.days; day++) {
            long[] newState=new long[state.length];  // Maybe we can just update state here
            long additions=state[0];
            for (int i=1; i< state.length; i++) {
                newState[i-1] = state[i];
            }
            newState[lf.resetFishValue] += additions;
            newState[newFishValue] = additions;

            state=newState;
        }

        // System.out.println("Final state");
        long sum = 0;
        for (int i=0; i < state.length; i++) {
            System.out.println(i + ": " + state[i]);
            sum += state[i];
        }

        System.out.println("Finished with " + sum + " fish");  // 360268 for part 1
        // 1632146183902 is correct for part 2
    }

    public void printStatus(long[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(i + ":" + data[i] + ", ");
        }
        System.out.println("");
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
