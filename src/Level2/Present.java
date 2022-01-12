package Level2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Present {
    static final int total_weight = 20;
    static final int MAX = 5;

    String name;
    int price;
    int weight;

    public Present(String name, int price, int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public static void main(String[] args) throws IOException {
        String[] lines;
        List<String> input = new ArrayList<>();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while (!(line = in.readLine()).equals("끝")) {
            lines = line.split(" ");

            Collections.addAll(input, lines);
        }

        Present[] present = new Present[MAX];
        Present[][] dp = new Present[MAX+1][total_weight+1];

        int current_weight, total_price = 0, goal, index = 0;

        current_weight = Integer.parseInt(input.get(index++));
        goal = total_weight - current_weight;

        for (int i = 0; i < MAX; i++) {
            String name = input.get(index++);
            int p = Integer.parseInt(input.get(index++));
            int weight = Integer.parseInt(input.get(index++));

            present[i] = new Present(name, p, weight);
        }

        for (int i = 0; i <= MAX; i++) {
            for (int j = 0; j <= goal; j++) {
                dp[i][j] = new Present("", 0, 0);
            }
        }

        for (int i = 1; i <= MAX; i++) {
            for (int j = 1; j <= goal; j++) {
                if (present[i-1].weight <= j) {
                    if (present[i-1].price + dp[i-1][j-present[i-1].weight].price > dp[i-1][j].price) {
                        dp[i][j].price = present[i-1].price + dp[i-1][j-present[i-1].weight].price;
                        dp[i][j].weight = present[i-1].weight + dp[i-1][j-present[i-1].weight].weight;
                        dp[i][j].name = present[i-1].name + "\n" + dp[i-1][j-present[i-1].weight].name;
                    }
                    else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
                total_price = Math.max(total_price, dp[i][j].price);
            }
        }

        String resultStr = "";
        boolean end = false;

        for (int i = 1; i <= MAX; i++) {
            for (int j = 1; j <= goal; j++) {
                if (total_price == dp[i][j].price) {
                    resultStr = dp[i][j].price + "\n" + dp[i][j].weight + "\n" + dp[i][j].name;
                    end = true;
                    break;
                }
            }
            if (end) break;
        }

        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        out.write(resultStr);

        out.flush();
        out.close();
        in.close();
    }
}
