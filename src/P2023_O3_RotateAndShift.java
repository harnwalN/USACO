import java.io.*;
import java.util.*;

public class P2023_O3_RotateAndShift {
    static int[] pos;
    static int[] initialPos;

    static int[] active;
    static HashSet<Integer> done;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int  k = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        pos = new int[n];
        initialPos = new int[n];
        done =  new HashSet<>();

        st = new StringTokenizer(br.readLine());
        active = new int[k];
        for (int i = 0; i<k; i++) {
            active[i] = Integer.parseInt(st.nextToken());
            initialPos[i] = active[i];
        }

        for (int i = 0; i<n; i++) {
            pos[i] = i;
        }

        for (int i = 0; i<t; i++) {
            swapActive(k);
            updateActive(k, n);
            if((i+1)%n == 0) {
                checkPos(n);
                if (done.size() == n) {
                    break;
                }
            }
        }

        for (int i = 0; i<n-1; i++) {
            pw.print(pos[i]+ " ");
        }
        pw.print(pos[n-1]);
        pw.close();
    }

    public static void swapActive(int k) {
        int temp = pos[active[k-1]];
        for (int i = k-1; i>0; i--) {
            pos[active[i]] = pos[active[i-1]];
        }
        pos[active[0]] = temp;
    }

    public static void updateActive(int k, int n) {
        for (int i = 0; i<k; i++) {
            active[i] = (active[i]+1)%n;
        }
    }

    public static void checkPos(int n) {
        for (int i = 0; i<n; i++) {
            if (initialPos[i] == pos[i]){
                done.add(pos[i]);
            }
        }
    }
}
