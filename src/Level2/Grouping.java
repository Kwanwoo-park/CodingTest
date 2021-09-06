package Level2;

import java.util.Scanner;
import java.util.Vector;

public class Grouping {
    static String s;
    static Vector<Integer> groupNum = new Vector<>();
    static int[][] map;
    static int n, group = 1, count;

    static void naming(int y, int x) {
        map[y][x] = group;
    }

    static int search(int y, int x) {
        if (x < 0 || y < 0 || x >= n || y >= n) return -1;

        return map[y][x];
    }

    static void countCell(int y, int x) {
        naming(y, x);
        if (search(y-1, x) == 1) {
            count++;
            countCell(y-1, x);
        }
        if (search(y+1, x) == 1) {
            count++;
            countCell(y+1, x);
        }
        if (search(y, x+1) == 1) {
            count++;
            countCell(y, x+1);
        }
        if (search(y, x-1) == 1) {
            count++;
            countCell(y, x-1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        while (t-- > 0) {
            n = in.nextInt();

            map = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = in.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1) {
                        group++;
                        count = 1;
                        countCell(i, j);
                        groupNum.addElement(count);
                    }
                }
            }

            System.out.print(group-1 + " ");

            for (int i = 0; i < group-1; i++) {
                System.out.print(groupNum.elementAt(i) + " ");
            }

            System.out.println(" ");

            group = 1;
            count = 0;
            groupNum.clear();
        }

        in.close();
    }
}
/*
* 7
8
1 1 1 0 1 1 0 0
0 0 1 0 0 1 1 1
0 1 1 1 0 1 1 0
1 1 1 0 0 1 1 0
0 0 0 0 0 0 0 0
0 1 1 1 1 0 1 1
1 1 1 0 0 1 0 0
1 1 0 0 1 1 1 0
7
1 1 1 0 1 1 0
0 0 1 0 0 1 1
0 1 1 1 0 1 1
1 1 1 0 0 1 1
0 0 0 0 0 0 0
0 1 1 1 1 0 1
1 1 1 0 0 1 0
5
1 1 1 0 1
0 0 1 0 0
0 1 1 1 0
1 1 1 0 0
0 0 0 0 0
7
1 1 1 0 1 1 0
0 0 1 0 0 1 1
0 1 1 1 0 1 1
1 1 1 0 0 1 1
0 0 0 0 0 0 0
0 1 1 1 1 0 1
1 1 1 0 0 1 0
10
1 1 1 0 1 1 1 1 0 1
0 0 1 0 0 0 1 1 1 0
1 1 1 0 0 0 0 0 0 0
0 0 1 0 0 1 1 1 0 1
0 0 1 0 0 0 1 1 1 0
1 1 1 0 0 0 0 0 0 0
0 1 1 1 0 1 1 1 0 0
0 0 0 0 0 1 1 1 0 1
0 0 1 0 0 0 1 1 1 0
1 1 1 0 0 0 0 0 0 0
9
1 1 1 0 1 1 1 1 0
0 0 1 0 0 0 1 1 1
1 1 1 0 0 0 0 0 0
0 0 1 0 0 1 1 1 0
0 0 1 0 0 0 1 1 1
1 1 1 0 0 0 0 0 0
0 1 1 1 0 1 1 1 0
0 0 0 0 0 1 1 1 0
0 0 1 0 0 0 1 1 1
6
1 1 1 0 1 1
0 0 1 0 0 0
1 1 1 0 0 0
0 0 1 0 0 1
0 0 1 0 0 0
1 1 1 0 0 0*/