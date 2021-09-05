package Level1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ReverseNumber {
    static int reverse(int number) {
        String[] temp = Integer.toString(number).split("");

        List<String> list = Arrays.asList(temp);

        Collections.reverse(list);

        StringBuilder num = new StringBuilder();

        for (String i : list) {
            num.append(i);
        }

        return Integer.parseInt(num.toString());
    }

    static boolean palindrome(int number) {
        String num = Integer.toString(number);

        int i = 0;

        while (i != num.length()/2) {
            if (num.charAt(i) != num.charAt(num.length()-i-1)) {
                return false;
            }

            i++;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        for (int t = 0; t < T; t++) {
            int number = in.nextInt();
            int reverse = reverse(number);

            if (palindrome(number + reverse)) {
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }
        }

        in.close();
    }
}
