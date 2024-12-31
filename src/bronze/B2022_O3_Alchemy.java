package bronze;
import java.io.*;
import java.util.*;

public class B2022_O3_Alchemy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n+1];
        ArrayList<Integer>[] cook = new ArrayList[n+1];
        for (int i = 0; i<n; i++) {
            cook[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i<=n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int k = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] recipes = new ArrayList[k];
        
        for (int i = 0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            ArrayList<Integer> added = new ArrayList<>();
            for (int j = 0; j<m; j++) {
                int x = Integer.parseInt(st.nextToken());
                added.add(x);
                cook[x].add(l);
            }
        }

        for (int i = 1; i<n; i++) { // for each product
            ArrayList<Integer> poss = recipes[i];
            if (poss==null) {continue;}
            int times = Integer.MAX_VALUE;
            for (int ing : poss) {
                times = Math.min(times, a[ing]);
            }
                for (int ing : poss) {
                a[ing] = a[ing]-times;
            }
            a[i]+=times;
            
        }

        pw.println(a[n]);
        pw.close();
    }
}
