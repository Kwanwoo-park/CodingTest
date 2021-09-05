package Level1;

import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        in.nextLine();
        char[] temp = in.nextLine().toCharArray();
        int[] numbers = new int[temp.length];

        for (int i = 0; i < temp.length; i++) {
            numbers[i] = Integer.parseInt(String.valueOf(temp[i]));
        }

        while (t-- > 0) {
            String answer = "";
            String sentence = in.nextLine();
            int remain = sentence.length() % 7;

            for (int i = 0; i < 7-remain; i++) {
                sentence += (char) ('a'+i);
            }

            int count = sentence.length() / 7;

            for (int i = 0; i < count; i++) {
                String tmp = sentence.substring(7*i, 7*(i+1));

                for (int j : numbers) {
                    answer += tmp.charAt(j-1);
                }
            }

            System.out.println(answer);
        }

        in.close();
    }
}
