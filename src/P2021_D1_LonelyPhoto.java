import java.io.*;
import java.util.*;

public class P2021_D1_LonelyPhoto {
    static boolean[] cows;
    static HashSet<Long> g;
    static HashSet<Long> h;
    static int lonely = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        g = new HashSet<>();
        h = new HashSet<>();

        long n = Long.parseLong(br.readLine());

        cows = new boolean[(int) n]; // G = True, H = False
        String cowString = br.readLine();

        for (long i = 0; i<n; i++) {
            if (cowString.substring((int) i, (int) i+1).equals("G")) {
                cows[(int) i] = true;
                g.add(i);
            } else {
                cows[(int) i] = false;
                h.add(i);
            }
        }

        for (long left = 0; left<n-2; left++) {
            long numH = 0;
            long numG = 0;
            for (long right = left; right<n; right++) {
                if (cows[(int) right]) {numG++;}
                else {numH++;}
                if ((right-left>=2) && (numH == 1 || numG ==1)) {lonely++;}
            }
        }
        pw.println(lonely);
        pw.close();
    }
}
