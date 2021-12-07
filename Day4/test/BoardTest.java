import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    @Test
    void testRowWinner() {
        List<String> testData = getTestBoard();
        Board board = new Board(testData);
        assertFalse(board.isWinner());
        assertFalse(board.hasWon());

        board.tryToMark("21");
        board.tryToMark("9");
        board.tryToMark("14");
        board.tryToMark("16");
        assertFalse(board.isWinner());
        board.tryToMark("7");

        assertTrue(board.isWinner());
        assertTrue(board.hasWon());
    }

    @Test
    void testExampleWinner() {
        List<String> testData = getThirdTestBoard();
        Board board = new Board(testData);
        assertFalse(board.isWinner());
        assertFalse(board.hasWon());

        String[] numbersArray = {"7", "4", "9", "5", "11", "17", "23", "2", "0", "14", "21", "24"};
        for (int i=0; i<numbersArray.length; i++) {
            //System.out.println("Marking " + numbersArray[i]);
            board.tryToMark(numbersArray[i]);
            //System.out.println(board.toString());
            if (numbersArray[i] != "24") {
                assertFalse(board.isWinner());
                assertFalse(board.hasWon());
            }
        }

        assertTrue(board.isWinner());
        assertTrue(board.hasWon());

        // Now calculate the score
        int sumOfUnmarkedNumbers = board.calculateSumOfUnmarkedNumbers();
        assertEquals(188, sumOfUnmarkedNumbers);

        int score = sumOfUnmarkedNumbers * 24;
        System.out.println("Score: " + score);
        assertEquals(4512, score);
    }


    @Test
    void testColumnWinner() {
        List<String> testData = getTestBoard();
        Board board = new Board(testData);
        assertFalse(board.isWinner());
        assertFalse(board.hasWon());

        board.tryToMark("0");
        board.tryToMark("24");
        board.tryToMark("7");
        board.tryToMark("5");
        board.tryToMark("19");

        assertTrue(board.isWinner());
        assertTrue(board.hasWon());
    }

    private List<String> getTestBoard() {
        List<String> data = new ArrayList<>();
        data.add("22 13 17 11  0");
        data.add(" 8  2 23  4 24");
        data.add("21  9 14 16  7");
        data.add(" 6 10  3 18  5");
        data.add(" 1 12 20 15 19");

        return data;
    }

    private List<String> getThirdTestBoard() {
        List<String> data = new ArrayList<>();
        data.add("14 21 17 24 4");
        data.add("10 16 15 9 19");
        data.add("18 8 23 26 20");
        data.add("22 11 13 6 5");
        data.add("2 0 12 3 7");

        return data;
    }
}
