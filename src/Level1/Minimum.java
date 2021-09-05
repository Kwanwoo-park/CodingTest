package Level1;

import java.util.Scanner;

public class Minimum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        int[] bridge, dp;

        while (t-- > 0) {
            int n = in.nextInt();

            bridge = new int[n];
            dp = new int[n];

            for (int i = 0; i < n; i++) {
                bridge[i] = in.nextInt();
            }

            if (n <= 3) {
                System.out.println(Math.min(bridge[0], Math.min(bridge[1], bridge[2])));
            }
            else {
                for (int i = 0; i < 3; i++) {
                    dp[i] = bridge[i];
                }
            }

            for (int i = 3; i < n; i++) {
                dp[i] = bridge[i] + Math.min(dp[i-1], Math.min(dp[i-2], dp[i-3]));
            }

            int min = Integer.MAX_VALUE;

            for (int i = n-1; i > n-4; i--) {
                if (dp[i] <= min)
                    min = dp[i];
            }

            System.out.println(min);
        }

        in.close();
    }
}
