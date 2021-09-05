package Level1;

import java.util.Scanner;

public class MinBall {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        in.nextLine();

        while (T-- > 0) {
            String balls = in.nextLine();

            int count = 1, max = 0;

            for (int i = 1; i < balls.length(); i++) {
                if (balls.charAt(i-1) == balls.charAt(i)) {
                    count++;
                }
                else {
                    max = Math.max(count, max);
                    count = 1;
                }
            }

            max = Math.max(count, max);

            System.out.println(balls.length() - max);
        }

        in.close();
    }
}
