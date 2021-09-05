package Level1;

import java.util.Scanner;

public class Chinese {
    static int male;
    static boolean checkRegion(String arr) {
        int one = 0;

        for (int i = 0; i < 6; i++) {
            if (arr.charAt(i) == '1') {
                one++;
            }
        }

        return one == 1;
    }

    static boolean checkBirth(String arr) {
        int year = Integer.parseInt(arr.substring(6, 10));
        int month = Integer.parseInt(arr.substring(10, 12));
        int day = Integer.parseInt(arr.substring(12, 14));
        int addday = 0;
        int max = 30;

        if (year < 1900 || year > 2014) return false;
        if (month < 1 || month > 12) return false;
        if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) {
            addday++;
        }
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                max = 31; break;
            case 4: case 6: case 9: case 11:
                max = 30; break;
            case 2:
                max = 28 + addday; break;
        }

        if (day < 1 || day > max) return false;

        return true;
    }

    static boolean checkOrder(String arr) {
        if (arr.charAt(14) == 0 && arr.charAt(15) == 0 && arr.charAt(16) == 0) return false;

        int temp = arr.charAt(16) - '0';

        if (temp % 2 == 0) {
            male = 2;
        }
        else {
            male = 1;
        }

        return true;
    }

    static boolean checkSum(String arr) {
        char check = '!';
        int checksum = 0, cnt;
        for (int i = 0; i < 17; i++) {
            cnt = arr.charAt(i) - '0';
            checksum += cnt * (int) Math.pow(2, 17-i);
            checksum %= 11;
        }

        if (checksum < 10 && checksum >= 0) check = (char) (checksum+'0');
        else if(checksum == 10) check = 'X';
        if (check != arr.charAt(17)) return false;

        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        in.nextLine();
        boolean valid = true;

        for (int t = 0; t < T; t++) {
            String arr = in.nextLine();
            System.out.println(arr);

            valid = checkRegion(arr);

            if (valid) {
                valid = checkBirth(arr);
            }

            if (valid) {
                valid = checkOrder(arr);
            }

            if (valid) {
                valid = checkSum(arr);
            }

            if (!valid)
                System.out.println("Invalid");
            else {
                if (male == 1)
                    System.out.println("Male");
                else
                    System.out.println("Female");
            }
        }

        in.close();
    }
}
