package Level1;

import java.util.Scanner;

public class ReverseString {
    static boolean check(char[] sentence, int k) {
        int pal = 0, j = 0, limit;

        for (int i = 0; i < sentence.length; i++) {
            if (sentence[i] != '\0')
                j++;
        }

        limit = j;

        for (int i = 0; i < j; i++, j--) {
            if (sentence[i+k] == sentence[j-1+k])
                pal++;
        }

        if (pal == (limit+1)/2) return true;
        else return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt(), i, j, k;
        int strLen;
        char[] temp;
        in.nextLine();

        for (int t = 0; t < T; t++) {
            System.out.print(t+1 + " ");
            String sentence = in.nextLine();
            int count = 0;

            strLen = sentence.length();

            for (k = 3; k <= strLen; k++) {
                for (j = 0; j < strLen-k+1; j++) {
                    temp = new char[strLen+1];

                    for (i = j; i < k+j; i++) {
                        temp[i] = sentence.charAt(i);
                    }
                    temp[i] = '\0';

                    if (check(temp, j)) {
                        StringBuilder output = new StringBuilder();

                        for (i = 0; i < k; i++)
                            output.append(temp[j + i]);

                        System.out.print(output + " ");
                        count++;
                    }
                }
            }

            System.out.println("총 회문의 갯수: " + count);
        }

        in.close();
    }
}
