package bronze;
import java.io.*;
import java.util.*;

public class B2016_F3_LoadBalancing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("balancing.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("balancing.out"));

        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] pos = new int[n][2];

        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            pos[i][0] = Integer.parseInt(st.nextToken());
            pos[i][1] = Integer.parseInt(st.nextToken());
        }
        int total_min = Integer.MAX_VALUE;
        int smallest_poss = n/4;
        if (n%4!=0){smallest_poss = (n/4)+1;}

        for (int[] cord : pos) {
            int xx = cord[0]-1;
            for (int[] crd : pos) {
                int yy = crd[1]-1;
                int ur = 0; 
                int ul = 0; 
                int dr = 0;
                int dl = 0;

                int cur_max = 0;

                for (int[] coord : pos) {
                    int x = coord[0];
                    int y = coord[1];
                    if (x<xx) {
                        if (y<yy) {
                            dl++;
                        } else {
                            ul++;
                        }
                    } else {
                        if (y<yy) {
                            dr++;
                        } else{
                            ur++;
                        }
                    }
                }
                cur_max = Math.max(Math.max(ur, ul), Math.max(dr, dl));
                if (cur_max==smallest_poss) {pw.println(cur_max);pw.close();return;}
                total_min = Math.min(cur_max, total_min);
            }
        }

        pw.println(total_min);
        pw.close();
    }
}