package Level1;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class Triangle {
    static Point[] points;

    static boolean check() {
        if ((points[0].x == points[1].x) && (points[0].y == points[1].y) || (points[0].x == points[2].x) && (points[0].y == points[2].y)
                || (points[2].x == points[1].x) && (points[2].y == points[1].y))
            return false;

        double slope1 = (double) (points[0].y-points[1].y) / (points[0].x - points[1].x);
        double slope2 = (double) (points[0].y-points[2].y) / (points[0].x - points[2].x);

        return slope1 != slope2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        for (int t = 0; t < T; t++) {
            points = new Point[3];
            int[] dic = new int[3];

            for (int i = 0; i < 3; i++) {
                points[i] = new Point();
                points[i].x = in.nextInt();
                points[i].y = in.nextInt();
            }

            if (check()) {
                dic[0] = (int) Math.pow(points[0].x - points[1].x, 2) + (int) Math.pow(points[0].y - points[1].y, 2);
                dic[1] = (int) Math.pow(points[0].x - points[2].x, 2) + (int) Math.pow(points[0].y - points[2].y, 2);
                dic[2] = (int) Math.pow(points[2].x - points[1].x, 2) + (int) Math.pow(points[2].y - points[1].y, 2);

                Arrays.sort(dic);

                if (dic[2] == (dic[0] + dic[1])) {
                    System.out.println(1);
                }
                else if(dic[2] > (dic[0] + dic[1])) {
                    System.out.println(2);
                }
                else {
                    System.out.println(3);
                }
            }
            else {
                System.out.println(0);
            }
        }

        in.close();
    }
}
