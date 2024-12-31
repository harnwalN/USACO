package bronze;
import java.io.*;
import java.util.StringTokenizer;

public class B2022_J3_Drought {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0 ; i<n; i++) {
            int m = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            long[] hunger = new long[m];
            long min = Long.MAX_VALUE;
            for (int j= 0; j<m; j++) {
                hunger[j] = Long.parseLong(st.nextToken());
                min = Math.min(min, hunger[j]);
            }
            /*if (nums.size()==1) {
                if (hunger[0]>=0) {
                    pw.println(0);
                } else {
                    pw.print(-1);
                }
                continue;
            }*/
            if (m==1) {
                if (hunger[0]>=0) {
                    pw.println(0);
                } else {
                    pw.println(-1);
                }
                continue;
            }
            if (hunger[0]>hunger[1] || hunger[m-1]>hunger[m-2]) {
                pw.println(-1);
                continue;
            }
            pw.println(test(m, hunger, min));
        }
        pw.close();
    }

    public static long test(int m, long[] hunger, long min) {
        for (long i = min; i>=0; i--) {
            long s = sim(i, hunger.clone());
            if (s!=-1) {
                return s;
            }
        }return -1;
    }

    public static long sim(long x, long[] hunger) {
        long used = 0;
        long last = 0;
        for (int i = 0; i<hunger.length; i++) {
            last = hunger[i]-last-x;
            used+=hunger[i]-x;
            if (last<0) {return -1;}
        }
        if (last == 0) {
            return used;
        } else {
            return -1;
        }
    }
}