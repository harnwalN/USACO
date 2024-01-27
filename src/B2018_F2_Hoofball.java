import java.util.*;
import java.io.*;

public class B2018_F2_Hoofball {
    public static int[] dist;
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        //BufferedReader br = new BufferedReader(new FileReader("hoofball.in"));
        //PrintWriter pw = new PrintWriter(new FileWriter("hoofball.out"));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        dist = new int[n+1];

        for (int i = 0; i<n; i++) {
            int x = Integer.parseInt(st.nextToken());
            dist[i] = x;
        }
        dist[n] = Integer.MAX_VALUE;
        Arrays.sort(dist);

        int count = 0;

        int last = dist[0];
        boolean r = true;
        boolean skip = true;
        for (int i = 1; i<n-1; i++) {

            int d = dist[i];
            int left = d-last;
            int right = dist[i+1]-d;
            last = d;
            
            if (!r) {
                if (left<=right) {
    
                } else {
                    if (skip) {
                        r = !r;
                        skip = false;
                        continue;
                    } else {
                        count++;
                        r= !r;
                        skip = true;
                        continue;
                    }
                }
            } else {
                if (right<left) {

                } else{
                    if (skip) {
                        r = !r;
                        skip = false;
                        continue;
                    } else {
                        count++;
                        skip = true;
                        r=!r;
                        continue;
                    }
                }
            }
            skip = false;
        }

        if (r) {

        }
        pw.println(count);
        pw.close();
    }
}
