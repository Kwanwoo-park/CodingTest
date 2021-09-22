package Level2;

import java.util.Scanner;

public class StringSlide {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        in.nextLine();

        while (t-- > 0) {
            String str = in.nextLine();
            String temp = str.charAt(0) + "";

            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i-1) != str.charAt(i)) temp += str.charAt(i);
            }


        }

        in.close();
    }
}
