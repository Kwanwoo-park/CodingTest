package Level1;

import java.util.Scanner;

public class DoorLock {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        in.nextLine();
        String password = in.nextLine();

        while (t-- > 0) {
            String numbers = in.nextLine();

            if (numbers.contains(password)) {
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
        }

        in.close();
    }
}
