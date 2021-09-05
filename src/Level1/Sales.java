package Level1;

import java.util.Scanner;

public class Sales {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        int[] sales;

        for (int t = 0; t < T; t++) {
            int n = in.nextInt();
            int sum = 0;

            sales = new int[n];

            for (int i = 0; i < n; i++) {
                sales[i] = in.nextInt();
            }

            for (int i = 1; i < n; i++) {
                int count = 0;
                for (int j = 0; j < i; j++) {
                    if (sales[i] >= sales[j]) {
                        count++;
                    }
                }

                sum += count;
            }

            System.out.println(sum);
        }

        in.close();
    }
}
