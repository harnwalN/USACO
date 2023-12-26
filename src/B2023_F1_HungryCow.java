import java.util.*;
import java.io.*;

public class B2023_F1_HungryCow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long t = Long.parseLong(st.nextToken());
        ArrayList<Long> b = new ArrayList<>();
        HashMap<Long, Long> dtb = new HashMap<>();

        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            long days = Long.parseLong(st.nextToken());
            long bales = Long.parseLong(st.nextToken());
            b.add(days);
            dtb.put(days, bales);
        }
        dtb.put(t+1, 0L);
        b.add(t+1);

        long eaten = 0;

        long stash = 0;
        long lday = 0;

        for (int i = 0; i<n+1; i++) {
            long days = b.get(i);
            long bales = dtb.get(days);

            long pday = days-lday;

            if (pday>stash) {
                eaten+=stash;
                stash = 0;
            } else {
                stash-=pday;
                eaten+=pday;
            }
            stash+=bales;
            lday = days;
        }

        pw.print(eaten);
        pw.close();
    }

}
