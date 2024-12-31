import java.io.*;
import java.util.*;

public class S2018_J2_RentalService {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] cows = new int[n];
        for (int i = 0; i<n; i++) {
            cows[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(cows);

        TreeMap<Integer, Integer> milk = new TreeMap<>();
        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            milk.put(p, q);
        }

        int[] rental = new int[r];
        for (int i = 0; i<r; i++) {
            rental[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rental);
        

        long sum = 0;
        for (int i = 0; i<n; i++) {
            int cow = cows[i];

            int ifr = rental[r-1];
            int ifm = 0;
            ArrayList<Integer> used = new ArrayList<>();
            TreeMap<Integer, Integer> mil = new TreeMap(milk);
            while(milk.get(mil.lastKey())<cow) {
                ifm+=mil.get(mil.lastKey()) * mil.lastKey();
                cow-=mil.get(mil.lastKey());
                used.add(mil.lastKey());
                mil.remove(mil.lastKey());
            }

            ifm+=cow*mil.lastKey();

            if (ifr>=ifm) {
                sum+=ifr;
                r--;
            } else {
                sum+=ifm;
                for (int key : used) {
                    milk.remove(key);
                }
                milk.put(milk.lastKey(), milk.get(milk.lastKey())-cow);
                if (milk.get(milk.lastKey())==0) {milk.remove(milk.lastKey());}
            }
        }
        pw.println(sum);
        pw.close();
    }
}
