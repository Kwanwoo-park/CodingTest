package Level1;

import java.util.ArrayList;
import java.util.Scanner;

public class Present {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<String> info = new ArrayList<>();
        ArrayList<String> purchase = new ArrayList<>();
        int t = in.nextInt();
        in.nextLine();

        while (t-- > 0) {
            info.add(in.nextLine());
        }

        double weight = in.nextDouble();
        double total_weight = 0;
        int total_price = 0;

        while (info.size() > 0) {
            int max_index = 0, temp_price = 0, max_price = Integer.MIN_VALUE;
            double temp_weight = 0, max_weight = Double.MAX_VALUE;

            for (int i = 0; i < info.size(); i++) {
                String[] temp = info.get(i).split(" ");
                temp_weight = Double.parseDouble(temp[2]);
                temp_price = Integer.parseInt(temp[1]);

                if (weight/2 > total_weight + temp_weight) {
                    if (temp_price > max_price) {
                        max_price = temp_price;
                        max_weight = temp_weight;
                        max_index = i;
                    }
                }
            }

            if (max_weight + total_weight > weight/2) {
                break;
            }
            else {
                total_weight += max_weight;
                total_price += max_price;
                purchase.add(info.get(max_index));
                info.remove(max_index);
            }
        }

        System.out.println(weight/1000);
        System.out.println(total_price);
        System.out.println(total_weight/1000);
        for (String s : purchase) {
            System.out.println(s);
        }

        in.close();
    }
}
