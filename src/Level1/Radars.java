package Level1;

import java.util.Scanner;

public class Radars {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();

		for (int t = 0; t < T; t++) {
			int x = in.nextInt();
			int y = in.nextInt();
			int r = in.nextInt();
			int n = in.nextInt();
			int count = 0;

			for (int i = 0; i < n; i++) {
				int x1 = in.nextInt(), y1 = in.nextInt();

				double dis = Math.sqrt(Math.pow(x-x1, 2) + Math.pow(y-y1, 2));

				if (dis <= r) count++;
			}

			System.out.println("#" + (t+1) + " " + count);
		}

		in.close();
	}
}
