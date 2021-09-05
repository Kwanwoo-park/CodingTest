package Level1;

import java.util.Scanner;

public class Exchange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        int[] bill = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

        while (T-- > 0) {
            int price = in.nextInt(), money = in.nextInt();

            int exchange = money - price;

            for (int i : bill) {
                System.out.print(exchange / i + " ");
                exchange %= i;
            }
            System.out.println("");
        }

        in.close();
    }
}
