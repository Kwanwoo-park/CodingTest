package Level2;

import java.util.Scanner;

public class Building {
    static void checkBuilding(String[][] arr, int[][] floor, int n) {
        int count;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j].equals("B")) {
                    if (arr[i-1][j].equals("P") || arr[i][j-1].equals("P") || arr[i+1][j].equals("P") || arr[i][j+1].equals("P")) {
                        floor[i][j] = 1;
                    }
                    else {
                        count = 1;

                        for (int k = 1; i - k >= 0; k++) {
                            if (arr[i-k][j].equals("B")) count++;
                        }

                        for (int k = 1; j - k >= 0; k++) {
                            if (arr[i][j-k].equals("B")) count++;
                        }

                        for (int k = 1; i + k < n; k++) {
                            if (arr[i+k][j].equals("B")) count++;
                        }

                        for (int k = 1; j + k < n; k++) {
                            if (arr[i][j+k].equals("B")) count++;
                        }

                        floor[i][j] = count;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[][] building;
        int[][] buildFloor;

        int t = in.nextInt();

        while (t-- > 0) {
            int result = 0, totalHeight = 0;

            int n = in.nextInt(), height = in.nextInt();
            in.nextLine();

            building = new String[n][n];
            buildFloor = new int[n][n];

            for (int i = 0; i < n; i++) {
                building[i] = in.nextLine().split(" " );
            }

            checkBuilding(building, buildFloor, n);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(buildFloor[i][j] + " ");

                    totalHeight += buildFloor[i][j];

                    if (buildFloor[i][j] >= height) result++;
                }
                System.out.println("");
            }

            System.out.println(totalHeight + ", " + result);
        }

        in.close();
    }
}
