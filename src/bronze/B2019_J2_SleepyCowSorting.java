package bronze;
import java.io.*;
import java.util.*;

public class B2019_J2_SleepyCowSorting {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter pw = new PrintWriter(System.out);

        BufferedReader br = new BufferedReader(new FileReader("sleepy.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("sleepy.out"));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] cows = new int[n];
        for (int i = 0; i<n; i++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n-2; i>=0; i--) {
            int a = cows[i];
            int b = cows[i+1];
            if (a>b) {
                pw.print(i+1);
                pw.close();
                return;
            }
        }
        pw.print(0);
        pw.close();
    }
}
