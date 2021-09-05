package Level2;

import java.util.Scanner;

public class BombRange {
    static int n;
    static int[][] map;
    static void bomb(int y, int x) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
                return ;
        }
        else {
            map[y][x] = 1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        while (t-- > 0) {
            n = in.nextInt();
            map = new int[n][n];
            in.nextLine();

            String[] ranges = in.nextLine().split(", ");

            for (int i = 0; i < ranges.length; i++) {
                String[] points = ranges[i].split(" ");

                for (int j = 0; j < points.length; j += 2) {
                    int y = Integer.parseInt(points[j]);
                    int x = Integer.parseInt(points[j+1]);
                    bomb(y, x);

                    for (int k = 0; k <= i; k++) {
                        bomb(y+(k+1), x);
                        bomb(y-(k+1), x);
                        bomb(y, x+(k+1));
                        bomb(y, x-(k+1));
                    }
                }
            }

            int count = 0;

            for (int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if (map[i][j] == 0) count++;
                }
            }

            System.out.println(count);
        }

        in.close();
    }
}
