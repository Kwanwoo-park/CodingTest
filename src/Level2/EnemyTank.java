package Level2;

import java.util.Scanner;

public class EnemyTank {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int count = 0;
            in.nextLine();

            char[][] map = new char[n][];

            for (int i = 0; i < n; i++) {
                map[i] = in.nextLine().toCharArray();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 'T') {
                        for (int k = 1; i-k >= 0; k++) {
                            if (map[i-k][j] == 'T' || map[i-k][j] == 'B' || map[i-k][j] == 'X') break;
                            else if (map[i-k][j] == 'E') {
                                count++;
                                map[i-k][j] = 'X';
                                break;
                            }
                        }
                        for(int k = 1; i+k < n; k++) {
                            if (map[i+k][j] == 'T' || map[i+k][j] == 'B' || map[i+k][j] == 'X') break;
                            else if (map[i+k][j] == 'E') {
                                count++;
                                map[i+k][j] = 'X';
                                break;
                            }
                        }
                        for (int k = 1; j-k >= 0; k++) {
                            if (map[i][j-k] == 'T' || map[i][j-k] == 'B' || map[i][j-k] == 'X') break;
                            else if (map[i][j-k] == 'E') {
                                count++;
                                map[i][j-k] = 'X';
                                break;
                            }
                        }
                        for(int k = 1; j+k < n; k++) {
                            if (map[i][j+k] == 'T' || map[i][j+k] == 'B' || map[i][j+k] == 'X') break;
                            else if (map[i][j+k] == 'E') {
                                count++;
                                map[i][j+k] = 'X';
                                break;
                            }
                        }
                    }
                }
            }

            System.out.println(count);
        }

        in.close();
    }
}
