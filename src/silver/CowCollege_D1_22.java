
import java.util.*;
import java.io.*;

public class CowCollege_D1_22 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        long[] maxP = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i<n; i++) {
            maxP[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(maxP);
        int in = 0;
        long max = -1;
        long maxInd = -1;

        for (int i = n-1; i>=0; i--) {
            long m = maxP[i];
            in+=1;
            if (in*m>=max) {
                max = in*m;
                maxInd = m;
            }
        }

        pw.print(max+" "+maxInd);
        pw.close();
    }
}