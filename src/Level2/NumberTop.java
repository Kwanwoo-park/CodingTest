package Level2;

import java.io.*;
import java.util.Arrays;

public class NumberTop {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        int[] in_str = new int[50];
        int testNum = Integer.parseInt(in.readLine());
        int[] count = new int[10], order = new int[10];
        int col_count = 1;
        int[][] count_arr = new int[10][2], num_tower = new int[10][50];
        int ji, i, j, k;
        double dec_num, col_total;

        for (int idx = 0; idx < testNum; idx++) {
            Arrays.fill(in_str, -1);
            Arrays.fill(count, 0);
            Arrays.fill(order, 0);

            str = in.readLine();

            for (i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
                    in_str[i] = str.charAt(i)-'0';
            }

            for (i = 0; i < str.length(); i++)
                count[in_str[i]]++;

            order[0] = in_str[0];
            in_str[0] = -1;

            for (i = 0; i < 10; i++) {
                for (j = 1; j < 49; j++) {
                    if (order[i] == in_str[j]) {
                        in_str[j] = -1;
                    }
                }

                for (k = 1; k < 49; k++) {
                    if (in_str[k] != -1) {
                        col_count++;
                        order[i+1] = in_str[k];
                        break;
                    }
                }
            }

            for (i = 0; i < col_count; i++) {
                count_arr[i][0] = order[i];
                count_arr[i][1] = count[order[i]];
            }

            for (i = 0; i < 10; i++) {
                for (j = 0; j < 50; j++) {
                    num_tower[i][j] = -1;
                }
            }

            for (i = 0; i < 10; i++) {
                for (j = 0; j < count_arr[i][1]; j++) {
                    num_tower[i][j] = count_arr[i][0];
                }
            }

           /* System.out.println("숫자 탑: ");
            for (i = 0; i < col_count; i++) {
                for (j = 0; j < col_count; j++) {
                    if (num_tower[i][j] == -1) {
                        continue;
                    }
                    System.out.print(num_tower[i][j] + " ");
                }
                System.out.println("");
            }*/

            col_total = 0;

            for (k = 0; k < 49; k++) {
                dec_num = 0;
                ji = 0;

                for (i = 9; i >= 0; i--) {
                    if (num_tower[i][k] == -1) {
                        continue;
                    }
                    dec_num += num_tower[i][0] * Math.pow(10, ji);
                    ji++;
                }

                col_total += dec_num;
            }

            out.write("#" + (idx+1) + " " + (long) col_total + "\r\n");

            for (i = 0; i < 10; i++) {
                count[i] = 0;
                order[i] = 0;

                for (j = 0; j < 2; j++) {
                    count_arr[i][j] = 0;
                }
            }

            col_count = 1;
        }

        out.close();
        in.close();
    }
}
