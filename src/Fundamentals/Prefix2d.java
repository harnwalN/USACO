package Fundamentals;
import java.util.*;
import java.io.*;

public class Prefix2d {
	public static void main(String[] args) throws IOException {
		// Input: # of rows (r), # of columns (c), then r rows of c single spaced integers
		// ex. 3 5
		//     1 2 3 4 5
		//     1 2 3 4 5
		//     1 2 3 4 5

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		int[][] prefix2d = new int[r+1][w+1]; // 1-indexed to make construction easier

		for (int i = 1; i<=r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j<=w; j++) {
				prefix2d[i][j] = prefix2d[i-1][j]+prefix2d[i][j-1]-prefix2d[i-1][j-1]+Integer.parseInt(st.nextToken());
			}
		}

		// Print out resulting 2d prefix array
		pw.println();
		for (int i = 1; i<=r; i++) {
			for (int j = 1; j<=w; j++) {
				pw.print(prefix2d[i][j]+" ");
			}
			pw.println();
		}
		pw.close();
	}
}