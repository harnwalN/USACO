import java.io.*;
import java.util.*;

public class S2018_D1_Convetion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw =  new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        TreeMap<Integer, Integer> times = new TreeMap<>();
        HashSet<Integer> ti = new HashSet<>();

        int extra = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (!ti.contains(x)) {
                times.put(x, 1);
                ti.add(x);
            } else {
                times.put(x, times.get(x)+1);
                extra++;
            }
        }

        int[] cows = new int[times.size()+extra];

        int k = 0;
        for (int x : times.keySet()) {
            cows[k] = x;
            k++;
            for (int i = 1; i<times.get(x); i++) {
                cows[k] = x;
                k++;
            }
        }

        int max = 0;
        int left = c-1;
        int last = cows[0];

        for (int i = 1; i<cows.length-1; i++) {
            if (left>0) {
                int a = 0;
                if (left!=c-1) {a = cows[i]-cows[i-1];}
                else {a = Integer.MAX_VALUE;}
                int b = cows[i+1]-cows[i];
                if (a<=b) {
                    left--;
                    max = Math.max(max, cows[i]-last);
                    continue;
                }
            }
            
            last = cows[i];
            left = c-1;
        }

        pw.println(max);

        pw.close();
;    }
}
