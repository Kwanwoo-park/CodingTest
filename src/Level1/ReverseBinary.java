package Level1;

import java.util.ArrayList;
import java.util.Scanner;

public class ReverseBinary {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        while (T-- > 0) {
            int num = in.nextInt(), sum = 0;
            ArrayList<Integer> list = new ArrayList<>();

            while (num > 0) {
                list.add(num % 2);
                num /= 2;
            }

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == 0) {
                    sum += Math.pow(2, list.size()-1-i);
                }
            }

            System.out.println(sum);
        }

        in.close();
    }
}
