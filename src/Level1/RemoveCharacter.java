package Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RemoveCharacter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        in.nextLine();

        while (t-- > 0) {
            char[] sentence = in.nextLine().toCharArray();
            ArrayList<Character> list = new ArrayList<>();

            for (char i : sentence) {
                list.add(i);
            }

            int i = 0;

            while (i < list.size()-1) {
                if (list.get(i) == list.get(i+1)) {
                    list.remove(i);
                    list.remove(i);
                    i = 0;
                }
                else {
                    i++;
                }
            }

            for (Character c : list) {
                System.out.print(c);
            }

            System.out.println("");
        }

        in.close();
    }
}
