import java.util.List;

public class Board {
    final int rows=5;
    final int columns=5;
    Square[][] theBoard = new Square[rows][columns];
    boolean hasWonGame =false;

    public Board(List<String> contents) {
        int lineNumber=0;
        for (String line: contents) {
            String[] values = line.trim().split("\\s+");
            for (int i=0; i< values.length; i++) {
                theBoard[lineNumber][i] = new Square(values[i]);
            }
            lineNumber ++;
        }
    }

    public boolean hasWon() {
        return hasWonGame;
    }

    // FIXME have this return a string
    @Override
    public String toString() {
        for (int row =0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                System.out.print(theBoard[row][col] + " ") ;
            }
            System.out.println("");
        }
        return "";
    }

    public void tryToMark(String value) {
        for (int row =0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (theBoard[row][col].getValue().equals(value)) {
                    theBoard[row][col].setMarked();
                    break;
                }
            }
        }
    }

    public boolean isWinner() {
        boolean result=false;
        for (int row=0; row<rows; row++) {
            boolean winner=true;
            for (int col=0; col < columns; col++) {
                //System.out.println("Checking by row - row " +row + ", col " + col + " value: " + fred[row][col]);
                if (!theBoard[row][col].isMarked()) {
                    winner=false;
                    // Continue here?
                }
            }
            if (winner) {
                System.out.println("Row " + row + " is a winner") ;
                this.hasWonGame =true;
                return true;
            }
        }

        for (int col=0; col < columns; col++) {
            boolean winner = true;
            for (int row=0; row < rows; row++) {
               // System.out.println("Checking by column - row " +row + ", Clo " + col + " value: " + fred[row][col]);
                if (!theBoard[row][col].isMarked()) {
                    winner=false;
                    // Continue here?
                }
            }
            if (winner) {
                System.out.println("Column " + col + " is a winner") ;
                this.hasWonGame=true;
                return true;
            }
        }

        return result;
    }

    public int calculateSumOfUnmarkedNumbers() {
        int score = 0;

        for (int row=0; row<rows; row++) {
            boolean winner = true;
            for (int col = 0; col < columns; col++) {
                if (!theBoard[row][col].isMarked()) {
                    score += Integer.parseInt(theBoard[row][col].getValue());
                }
            }
        }

        return score;
    }
}
