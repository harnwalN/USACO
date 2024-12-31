package bronze;
import java.io.*;
import java.util.*;

public class B2022_O2_CountingLiars {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> g = new ArrayList<>();
        ArrayList<Integer> l = new ArrayList<>();

        HashSet<Integer> test = new HashSet<>();

        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if (type.equals("G")) {
                g.add(num);
                test.add(num);
            } else {
                l.add(num);
                test.add(num);
            }
        }
        int max = 0;
        for (int num : test) {
            int skipped = 0;
            boolean skip = false;
            int count = 0;

            for (int greater : g) {
                if (num>=greater) {
                    count++;
                } else {
                    skipped++;
                    if (skipped>=n-max) {
                        skip = true;
                        break;
                    }
                };
            }
            if (skip) {continue;}
            else {
                for (int less: l) {
                    if (num<=less) {
                        count++;
                    } else {
                        skipped++;
                        if (skipped>=n-max) {
                            skip = true;
                            break;
                        }
                    }
                }
            }
            if (skip) {continue;}
            else{max = Math.max(max, count);}
        }
        pw.print(n-max);
        pw.close();
    }
}
