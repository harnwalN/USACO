import java.io.*;
import java.util.*;

public class B2018_D1_MixingMilk {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("mixmilk.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("mixmilk.out"));

        HashMap<Integer, Integer> c = new HashMap<>(); // indexed 1-3
        HashMap<Integer, Integer> m = new HashMap<>(); // indexed 1-3

        for (int i = 0; i<3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            c.put(i, Integer.parseInt(st.nextToken()));
            m.put(i, Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i<100; i++) {
            int cur = m.get(i%3);

            int next = m.get((i+1)%3);
            int cap = c.get((i+1)%3);

            if (cur<=cap-next) {
                next+=cur;
                cur = 0;
            } else {
                cur-=cap-next;
                next = cap;
            }
            m.put(i%3, cur);
            m.put((i+1)%3, next);
        }

        for (int i = 0; i<3; i++) {
            pw.println(m.get(i));
        }
        pw.close();
    }
}
