import java.util.*;
import java.io.*;

public class B2022_F1_SleepingInClass {
    static int change;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc<t; tc++) {
            change = 0;
            int n = Integer.parseInt(br.readLine());
            ArrayList<Integer> times = new ArrayList<>();

            int max = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i<n; i++) {
                int value = Integer.parseInt(st.nextToken());
                max = Math.max(value, max);
                times.add(value);
            }

            int changes = fixes(times, max, n);
            pw.println(changes);
        }
        pw.close();
    }

    public static int fixes(ArrayList<Integer> times, int max, int n) {
        int changes = 0;
        while(!check(times)) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i<n; i++) {
                if (times.get(i)<min) {
                    min = times.get(i);
                    index = i;
                }
            }
            if (index == 0) {
                int v1 = times.remove(0);
                int v2 = times.remove(0);
                times.add(0, v1+v2);
            } else if(index == times.size()-1) {
                int v1 = times.remove(index-1);
                int v2 = times.remove(index-1);
                times.add(v1+v2);
            } else {
                int v1 = times.get(index-1);
                int v2 = times.get(index);
                int v3 = times.get(index+1);

                if (v1<=v3) {
                    times.remove(index-1);
                    times.remove(index-1);
                    times.add(index-1, v1+v2);
                } else {
                    times.remove(index);
                    times.remove(index);
                    times.add(index, v2+v3);
                }
            }
            n-=1;
            changes++;
        }
        
        return changes;
    }

    private static boolean check(ArrayList<Integer> times) {
        int c = times.get(0);
        for (int el: times) {
            if (el!=c){return false;}
        }
        return true;
    }
}
