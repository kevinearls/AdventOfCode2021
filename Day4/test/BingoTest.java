import org.junit.jupiter.api.Test;

import java.util.List;

public class BingoTest {
    @Test
    void part1Test() throws Exception{
        Bingo bingo=new Bingo();
        //List<String> input = bingo.getTestData();
        List<String> input = bingo.loadData();
        List<Board> boards = bingo.loadBoards(input);
        List<String> numbers = bingo.getNumbers(input);

        System.out.println("Got " + boards.size() + " boards");
        int score = bingo.playPart1(numbers, boards);

        System.out.println("Score was: " + score); // 44736
    }


    @Test
    void part2Test() throws Exception{
        Bingo bingo=new Bingo();
        //List<String> input = bingo.getTestData();
        List<String> input = bingo.loadData();
        List<Board> boards = bingo.loadBoards(input);
        List<String> numbers = bingo.getNumbers(input);

        System.out.println("Got " + boards.size() + " boards");
        int score = bingo.playPart2(numbers, boards);

        System.out.println("Score was: " + score);  // 1827
    }
}
