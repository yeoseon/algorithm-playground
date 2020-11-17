package Solutions;

import java.util.Random;

/**
 * 1. 지뢰를 랜덤으로 배치한다.
 * 2. 주변 지뢰를 판단하여 배열을 출력한다.
 *
 * for문을 줄이기 위해 지뢰를 랜덤으로 배치하는 순간 주변 좌표의 지뢰 개수를 +1 한다.
 */
public class MineSweeper {
    private static final int ROW = 10;
    private static final int COL = 10;
    private static final int MINE_COUNT = 10;

    private static final String NONE_MINE = "-";
    private static final String MINE = "*";

    private String[][] mindArray = new String[ROW][COL];
    private Integer[][] mindSweeper = new Integer[ROW][COL];

    public static void main(String[] args) {
        MineSweeper mindSweeper = new MineSweeper();
        mindSweeper.run();
    }

    public void run() {
        initArrays();

        setRandomMine(MINE_COUNT);

        printMineArray();
        printMinesweeper();
    }

    private void initArrays() {
        for(int i = 0; i < ROW; i++) {
            for(int j = 0; j < COL; j++) {
                mindArray[i][j] = NONE_MINE;
                mindSweeper[i][j] = 0;
            }
        }
    }

    private void setRandomMine(int mineCount) {
        Random random = new Random();

        while(mineCount > 0) {
            int randomRow = random.nextInt(ROW);
            int randomCol = random.nextInt(COL);

            if(MINE.equals(mindArray[randomRow][randomCol])) {
                mineCount++;
            }
            else {
                mindArray[randomRow][randomCol] = MINE;
                countMines(randomRow, randomCol);
            }
            mineCount--;
        }
    }

    private void countMines(int row, int col) {
        for(int i = row - 1; i <= row + 1; i++) {
            for(int j = col - 1; j <= col + 1; j++) {
                if(i < 0 || j < 0 || i >= ROW || j >= COL || (i == row && j == col)) {
                    continue;
                }
                mindSweeper[i][j]++;
            }
        }
    }

    private void printMineArray() {
        for(int i = 0; i < ROW; i++){
            for (int j = 0; j < COL; j++){
                System.out.print(mindArray[i][j]);
            }
            System.out.println();
        }
    }

    private void printMinesweeper() {
        for(int i = 0; i < ROW; i++){
            for (int j = 0; j < COL; j++){
                System.out.print(mindSweeper[i][j]);
            }
            System.out.println();
        }
    }
}
