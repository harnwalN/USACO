import java.util.*;
import java.io.*;

public class S2019_J3_MountainView {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter pw = new PrintWriter(System.out);

        BufferedReader br = new BufferedReader(new FileReader("mountains.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("mountains.out"));

        int n = Integer.parseInt(br.readLine());

        int[][] peaks = new int[n][2];

        for (int i =0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            peaks[i][0] = Integer.parseInt(st.nextToken());
            peaks[i][1] = Integer.parseInt(st.nextToken());
        }

        int visible = 0;

        HashSet<Integer> nposs = new HashSet<>();

        for (int i = 0; i<n; i++) {
            if (nposs.contains(i)) {continue;}
            int cnt = 0;
            boolean broke = false;
            for (int j = cnt; j<n; j++) {
                if (nposs.contains(j)) {continue;}
                int result = check(peaks[i], peaks[j]);
                if (result == 0 && i!=j) {
                    nposs.add(j);
                }
                else if (result == 1) {
                    nposs.add(j);
                }
                else if (result == 2) {
                    nposs.add(i);
                    broke = true;
                    continue;
                }
            }
            if (!broke) {visible++;}
            cnt++;
        }

        pw.println(visible);
        pw.close();
    }

    public static int check(int[] a, int[] b) {
        // 0 if same
        // 1 if a covers b
        // 2 if b covers a
        // 3 if independent

        if (a[0]==b[0] && a[1] == b[1]) {
            return 0;
        }
        else if (b[1]<=(-1*Math.abs(b[0]-a[0]))+a[1]) {
            return 1;
        }
        else if (a[1]<=(-1*Math.abs(b[0]-a[0]))+b[1]) {
            return 2;
        }
        else {return 3;}
    }
}
