import java.util.*;
import java.io.*;

public class S2018_O2_LemonadeStand {
    public static void main(String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lemonade.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("lemonade.out"));

        int n = Integer.parseInt(br.readLine());
        int[] waits = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            waits[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(waits);
        int ans = 0;
        int len = 0;
        for (int i = n-1 ; i>=0; i--) {
            if (waits[i]>=len) {
                len++;
                ans++;
            }
        }
        pw.println(len);
        pw.close();
    }
}
