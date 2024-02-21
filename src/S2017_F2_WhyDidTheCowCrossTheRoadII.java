import java.io.*;
import java.util.*;

public class S2017_F2_WhyDidTheCowCrossTheRoadII {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("maxcross.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("maxcross.out"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] crosswalks = new int[n+1];
    
        for (int i = 0; i<b; i++) {
            crosswalks[Integer.parseInt(br.readLine())] = 1;
        }

        int first = 0;
        for (int i = 1; i<=k; i++) {
            if (crosswalks[i] == 1) first++;
        }
        int min = k;
        for (int nw = k+1; nw<=n; nw++) {
            first+=crosswalks[nw];
            first-=crosswalks[nw-k];

            min = Math.min(first, min);
            if (min==0) {
                pw.println(0);
                pw.close();
                return;
            }
        }
        pw.println(min);
        pw.close();
    }
}
