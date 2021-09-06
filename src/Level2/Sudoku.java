package Level2;

import java.util.Scanner;

public class Sudoku {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        SudokuTest test = new SudokuTest();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                test.map[i][j] = in.nextInt();
            }
        }

        test.recheck();

        in.close();
    }
}
/*4 5 2 6 1 8 3 7 9
3 7 1 4 2 9 8 6 5
9 8 1 5 7 3 2 4 1
7 3 4 1 6 2 5 6 8
6 2 9 8 4 5 7 1 3
8 1 5 3 9 8 6 2 4
2 9 3 7 5 4 1 8 6
1 4 8 4 3 6 9 5 7
5 6 7 9 8 1 4 3 2*/