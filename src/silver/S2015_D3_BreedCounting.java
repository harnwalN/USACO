import java.io.*;
import java.util.StringTokenizer;

public class S2015_D3_BreedCounting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("bcount.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("bcount.out"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] prefix = new int[3][n+1];
        // 0:J, 1:H, 2:G

        for (int i = 1; i<=n; i++) {
            int c = Integer.parseInt(br.readLine());
            prefix[c%3][i] = prefix[c%3][i-1]+1;
            prefix[(c+1)%3][i] = prefix[(c+1)%3][i-1];
            prefix[(c+2)%3][i] = prefix[(c+2)%3][i-1];
        }

        for (int i = 0; i<q; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pw.println((prefix[1][e]-prefix[1][s-1]) + " " + (prefix[2][e]-prefix[2][s-1]) + " " + (prefix[0][e]-prefix[0][s-1]));
        }
        pw.close();
    }
}
