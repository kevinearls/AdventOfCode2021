import com.kevinearls.adventofcode2021.common.MyUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Bingo {
    public List<String> numbers = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Bingo bingo = new Bingo();
        //List<String> numbers = bingo.loadNumbers("Day4/resources/test.txt");
        List<String> content = bingo.getTestData();

        // Fist line is numbers
        String[] numbersArray = content.get(0).split(",");
        bingo.numbers = Arrays.asList(numbersArray);
        // What kind of data structure to use here?  Define a board class?
        List<Board> boards = bingo.loadBoards(content);
        System.out.println("Got " + boards.size() + " boards");

        /*for (Board b:boards) {
            System.out.println("-------------------------------------");
            System.out.println(b.toString());
        }*/

    }

    public int playPart2(List<String> numbers, List<Board> boards) {
        for (String number:numbers) {
            System.out.println("Playing " + number);
            for (Board b :boards) {
                b.tryToMark(number);
            }

            // FYI could combine this with the other loop
            for (Iterator<Board> it = boards.iterator(); it.hasNext(); ) {
                Board b = it.next();
                if (b.isWinner()) {
                    System.out.println("We have a winner!!!");
                    System.out.println(b.toString());
                    int sumOfUnmarkedNumbers = b.calculateSumOfUnmarkedNumbers();
                    int score = sumOfUnmarkedNumbers * Integer.parseInt(number);
                    System.out.println("Got a score of " + score);
                    if (boards.size() == 1) {
                        return score;
                    }
                    //return score;
                    it.remove();
                }
            }

            // Test...

        }

        // Should never get here
        return 0;
    }

    public int playPart1(List<String> numbers, List<Board> boards) {
        for (String number:numbers) {
            System.out.println("Playing " + number);
            for (Board b :boards) {
                b.tryToMark(number);
            }

            for (int i=0; i < boards.size(); i++) {
                Board b=boards.get(i);
                if (b.isWinner()) {
                    System.out.println("We have a winner!!!");
                    System.out.println(b.toString());
                    int sumOfUnmarkedNumbers = b.calculateSumOfUnmarkedNumbers();
                    int score = sumOfUnmarkedNumbers * Integer.parseInt(number);
                    System.out.println("Got a score of " + score);
                    boards.remove(b);
                    return score;
                }
            }
        }

        // Should never get here
        return 0;
    }

    public List<Board> loadBoards(List<String> input) {
        List<Board> boards = new ArrayList<>();
        // skip the first 2 lines, read 5, skip 1...
        for (int i=2; i < input.size(); i+=6) {
            Board b = new Board(input.subList(i, i+5));
            boards.add(b);
        }

        return boards;
    }

    public List<String> getNumbers(List<String> input) {
        String[] numbersArray = input.get(0).split(",");
        List<String> numbers = Arrays.asList(numbersArray);

        return numbers;
    }

    public List<String> loadData() throws Exception {
        String fileName = "/Users/kearls/sources/kevinearls/AdventOfCode2021/Day4/resources/input.txt";
        List<String> contents = MyUtils.loadFromFile(fileName);
        return contents;
    }

    public List<String> getTestData() throws Exception{
        String fileName = "/Users/kearls/sources/kevinearls/AdventOfCode2021/Day4/resources/test.txt";
        List<String> contents = MyUtils.loadFromFile(fileName);
        return contents;
    }
}
