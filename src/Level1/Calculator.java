package Level1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        String expression;
        in.nextLine();
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Character> operator = new ArrayList<>();

        for (int t = 0; t < T; t++) {
            expression = in.nextLine();
            String temp = "";

            for (int i = 0; i < expression.length(); i++) {
                if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                    operator.add(expression.charAt(i));
                    numbers.add(Integer.parseInt(temp));
                    temp = "";
                }
                else {
                    temp += expression.charAt(i);
                }
            }

            numbers.add(Integer.parseInt(temp));

            int sum = numbers.get(0);

            for (int i = 0; i < operator.size(); i++) {
                if (operator.get(i) == '+') {
                    sum += numbers.get(i+1);
                }
                else {
                    sum -= numbers.get(i+1);
                }
            }

            System.out.println(sum);
            operator.clear();
            numbers.clear();
        }

        in.close();
    }
}
