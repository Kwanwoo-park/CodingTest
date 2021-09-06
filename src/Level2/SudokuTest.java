package Level2;

public class SudokuTest {
    int[][] map = new int[9][9];
    int[][] error = new int[9][9];
    int[] temp = new int[9];
    int[] result = new int[5], x = new int[5], y = new int[5];
    int testNum;

    void recheck() {
        for (int k = 0; k < 9; k++) {
            for (int i = 0; i < 9; i++) {
                for (int j = i+1; j < 9; j++) {
                    if (map[k][i] == map[k][j]) {
                        error[k][i]++;
                        error[k][j]++;
                    }
                    if (map[i][k] == map[j][k]) {
                        error[i][k]++;
                        error[j][k]++;
                    }
                }
            }
        }
        check();
    }

    void group(int a, int b) {
        int k = 0;

        for (int i = a+0; i < 3+a; i++) {
            for (int j = 0+b; j < 3+b; j++) {
                temp[k] = map[i][j];
                k++;
            }
        }
    }

    void check() {
        for (int i = 0; i < 9; i = i+3) {
            for (int j = 0; j < 9; j = j+3) {
                group(i, j);
                for (int k = 0; k < 9; k++) {
                    for (int l = k+1; l < 9; l++) {
                        if (temp[k] == temp[l]) {
                            error[i+(k/3)][j+(k%3)]++;
                            error[i+(l/3)][j+(l%3)]++;
                        }
                    }
                }
            }
        }
        rowChange();
    }

    int find(int[] arr) {
        int[] temp = new int[10];

        for (int i = 0; i < 9; i++) {
            temp[arr[i]] = 1;
        }

        for (int i = 1; i < 10; i++) {
            if (temp[i] == 0) {
                return i;
            }
        }
        return 0;
    }

    void colChange() {
        int[] checkNum = new int[9], num = new int[9];
        int a = 0, b = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (error[j][i] == 3) {
                    a = i;
                    b = j;
                    checkNum[j]++;
                }
            }

            if (checkNum[i] == 1) {
                map[b][a] = 0;
                for (int j = 0; j < 9; j++) {
                    num[j] = map[j][i];
                }
                map[b][a] = find(num);
            }
        }
        test();
    }

    void rowChange() {
        int a = 0, b = 0;
        int[] checkNum = new int[9], num = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (error[i][j] == 3) {
                    a = i;
                    b = j;
                    checkNum[i]++;
                }
            }

            if (checkNum[i] == 1) {
                map[a][b] = 0;
                for (int j = 0; j < 9; j++) {
                    num[j] = map[i][j];
                }
                map[a][b] = find(num);
            }
        }
        colChange();
    }

    void test() {
        int num = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (error[i][j] == 3) {
                    num++;
                }
            }
        }

        testNum = num;

        get();
    }

    void get() {
        int k = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (error[i][j] == 3) {
                    x[k] = i+1;
                    y[k] = j+1;
                    result[k] = map[i][j];
                    k++;
                }
            }
        }

        show();
    }

    void showNum() {
        for (int[] i : map) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println(" ");
        }
    }

    void show() {
        for (int i = 0; i <testNum; i++) {
            System.out.println(x[i] + " " + y[i] + " " + result[i]);
        }
    }
}
