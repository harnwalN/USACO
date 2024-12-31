import java.io.*;
import java.util.*;

public class CSESForestQueries {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] forest = new int[n+1][n+1];

        for (int r = 1; r<=n; r++) {
            String row = br.readLine();
            for (int c = 1; c<=n; c++) {
                forest[r][c] = forest[r-1][c]+forest[r][c-1]-forest[r-1][c-1];
                if (row.substring(c-1, c).equals("*")) forest[r][c]++;
            }
        }

        for (int i = 0; i<q; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            pw.println(forest[r2][c2]-forest[r2][c1-1]-forest[r1-1][c2]+forest[r1-1][c1-1]);
        }

        pw.close();
    }
}
