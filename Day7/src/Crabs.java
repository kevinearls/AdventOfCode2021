import com.kevinearls.adventofcode2021.common.MyUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Crabs {
     public static void main(String[] args) throws Exception {
          Crabs crabs = new Crabs();
          //List<String> in = crabs.getTestData();
          List<String> in = crabs.loadData();
          List<Integer> startingPositions=crabs.createIntegerList(in.get(0));
          int max= crabs.findMaxPositio(startingPositions);
          System.out.println("Initial positions: " + startingPositions + " MAX: " + max);

          int positionToMoveTo=-1;
          int minimumMoves=Integer.MAX_VALUE;
          int[] costs=crabs.calculateFuelCosts(max);
          for (int target=1; target <= max ; target ++) {
               int totalMoves=0;
               for (Integer current:startingPositions) {
                    totalMoves += costs[Math.abs(target - current)];  // Differenece between part 1 and 2 here is for part 1 we just use the index vale
               }
               if (totalMoves < minimumMoves) {
                    positionToMoveTo=target;
                    minimumMoves=totalMoves;
               }
               //System.out.println("For position " + target + " total moves " + totalMoves );
          }

          System.out.println("Moves " + minimumMoves + " to position " + positionToMoveTo);  // part1 342730
          // For part 2 the total is 92335207
     }

     public int[] calculateFuelCosts(int size) {
          int[] contents = new int[size+1];
          int runningTotal=0;
          for (int i=0; i<=size; i++) {
               runningTotal+=i;
               contents[i] = runningTotal;
          }

          return contents;
     }


     public int findMaxPositio(List<Integer> data) {
          int max=Integer.MIN_VALUE;
          for (Integer i:data) {
               if (i > max) {
                    max = i;
               }
          }
          return max;
     }


     public List<String> loadData() throws Exception {
          String fileName = "/Users/kearls/sources/kevinearls/AdventOfCode2021/Day7/resources/input.txt";
          List<String> contents = MyUtils.loadFromFile(fileName);
          return contents;
     }

     public List<String> getTestData() throws Exception{
          String fileName = "/Users/kearls/sources/kevinearls/AdventOfCode2021/Day7/resources/testInput.txt";
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
