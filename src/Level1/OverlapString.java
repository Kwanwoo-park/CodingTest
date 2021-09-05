package Level1;

import java.util.Scanner;

public class OverlapString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        in.nextLine();
        String sentence = in.nextLine();

        while (t-- > 0) {
            String compare = in.nextLine();
            int count = 0;
            String temp;

            int[][] check = new int[100][100];

            for (int i = 1; i < compare.length()+1; i++) {
                for (int j = 1 ; j <= i; j++) {
                    check[i][j] = 0;
                }
            }

            for (int i = 1; i < compare.length(); i++) {
                for (int j = 1; j <= i; j++) {
                    temp = compare.substring(j-1, j+compare.length()-i);

                    if (check[i][j] != -1) {
                        if (sentence.contains(temp) && sentence.indexOf(temp) <= (sentence.length()-temp.length())) {
                            check[i][j] = 1;
                        }

                    }
                    if (check[i][j] == 1 || check[i][j] == -1) {
                        check[i+1][j] = -1;
                        check[i+1][j+1] = -1;
                    }
                }
            }

            for (int i = 1; i < compare.length(); i++) {
                for (int j = 1; j <= i; j++) {
                    if (check[i][j] == 1) {
                        temp = compare.substring(j-1, j+compare.length()-i);
                        System.out.print(temp + " ");
                        count++;
                    }
                }
            }

            System.out.println(count);
        }

        in.close();
    }
}
