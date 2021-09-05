package Level2;

import java.util.Scanner;

public class EWSN {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        int n = in.nextInt();
        in.nextLine();

        String[][] map = new String[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = in.next();
            }
            in.nextLine();
        }

        while (t-- > 0) {
            int y = in.nextInt()-1, x = in.nextInt()-1, count = in.nextInt();

            while (count-- > 0) {
                if (y < 0 || x < 0 || y >= n || x >= n) {
                    count = 1;
                    break;
                }

                char direction = map[y][x].charAt(0);
                int value = Integer.parseInt(String.valueOf(map[y][x].charAt(1)));

                switch (direction) {
                    case 'N': y -= value; break;
                    case 'S': y += value; break;
                    case 'W': x -= value; break;
                    case 'E': x += value; break;
                }
            }

            if (count == -1) {
                int value = Integer.parseInt(String.valueOf(map[y][x].charAt(1)));
                System.out.println(value*1000);
            }
            else {
                System.out.println(10000);
            }
        }

        in.close();
    }
}

/*
3
7
E3 S2 S4 S5 E2 S1 S5
N2 S3 S2 E1 N3 W4 N1
W1 N1 E3 W3 S3 W1 S3
E3 S2 N2 S2 E1 N2 W3
N3 E3 S1 N1 W3 E1 W1
E1 N2 W1 N3 S2 N3 W5
N5 E1 N4 W3 N5 W1 S1
3 4 3
2 3 4
4 6 5
* */
