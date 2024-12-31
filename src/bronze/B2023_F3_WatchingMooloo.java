package bronze;
import java.io.*;
import java.util.*;

public class B2023_F3_WatchingMooloo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        HashMap<Integer, Long> m = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            m.put(i, Long.parseLong(st.nextToken()));
        }

        long money = k+1;

        for (int i = 1; i<n; i++) {
            long cur = m.get(i);
            long last = m.get(i-1);
            long duration = cur-last;

            money+=Math.min(duration, k+1);
        }
        pw.println(money);
        pw.close();
    }
}
