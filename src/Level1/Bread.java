package Level1;

import java.util.Scanner;

public class Bread {
    static int[][] map;
    static int n, m;
    static int count = 0;
    static boolean dfs(int i, int j) {
        if (i <= 0 || j <= 0 || i >= n || j >= m) {
            return false;
        }

        if (map[i][j] == 0) {
            map[i][j] = 1;

            dfs(i+1, j);
            dfs(i-1, j);
            dfs(i, j+1);
            dfs(i, j-1);

            return true;
        }

        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j)) {
                    count++;
                }
            }
        }

        System.out.println(count);

        in.close();
    }
}
