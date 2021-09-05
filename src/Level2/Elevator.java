package Level2;

import java.util.Scanner;

public class Elevator {
    static int count = 0;

    static void move(int start, int end) {
        int floor;
        if (start > end) {
            for (floor = start; floor >= end; floor--) {
                if (floor != 0) {
                    count++;
                }
            }
            count--;
        }
        else if (start < end) {
            for (floor = start; floor <= end; floor++) {
                if (floor != 0) {
                    count++;
                }
            }
            count--;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        int begin = 1;

        while (t-- > 0) {
            int order = in.nextInt(), target = in.nextInt();
            move(begin, order);
            move(order, target);
            begin = target;
        }

        System.out.println(count);

        in.close();
    }
}
