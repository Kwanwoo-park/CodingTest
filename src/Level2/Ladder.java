package Level2;

import java.io.*;
import java.util.StringTokenizer;

public class Ladder {
    int[][] arr;
    public Ladder(int len) {
        arr = new int[len][len];
    }

    void add(int f, int s) {
        arr[f][s] = 1;
        arr[f][s+1] = 2;
    }

    int start (int idx) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][idx] == 1 || arr[i][idx] == 2) {
                if (arr[i][idx] == 1 && arr[i][idx+1] == 2) {
                    idx++;
                }
                else {
                    idx--;
                }
            }
        }

        return idx;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int testNum = Integer.parseInt(in.readLine());
        String inputString;

        for (int i = 0; i < testNum; i++) {
            int max = 0;
            inputString = in.readLine();
            StringTokenizer st = new StringTokenizer(inputString, " ");

            int matrix = Integer.parseInt(st.nextToken());
            Ladder ladder = new Ladder(matrix);

            for (int j = 0; j < matrix; j++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if (max < y) {
                    max = y;
                }
                ladder.add(x, y);
            }

            out.write("#" + (i+1) + " ");
            for (int j = 1; j <= max+1; j++) {
                out.write(ladder.start(j) + " ");
            }
            out.write("\r\n");
            out.flush();
        }

        out.close();
        in.close();
    }
}
