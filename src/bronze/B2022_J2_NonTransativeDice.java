package bronze;
import java.io.*;
import java.util.*;

public class B2022_J2_NonTransativeDice {
    static HashSet<String> perms;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());
        perms = new HashSet<>();
        genPerms("");

        for (int test = 0; test<t; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] d1 = new int[4];
            int[] d2 = new int[4];

            for (int i = 0; i<4; i++) {
                d1[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i<4; i++) {
                d2[i] = Integer.parseInt(st.nextToken());
            }

            int need = game(d1, d2); // if positive, d1 wins; if negative, d2 wins
            if (need==0) {
                pw.println("no");
                continue;
            }
            else if (need<0) {
                int[] temp = d1.clone();
                d1 = d2.clone();
                d2 = temp;
            }

            // d1 wins d2, d2 wins d3, d3 wins d1
            boolean worked = false;
            for (String perm : perms) {
                int[] d3 = new int[4];
                for (int i = 0; i<4; i++) {
                    d3[i] = Integer.parseInt(perm.substring(i, i+1))+1;
                    
                }
                if (game(d1, d3)<0 && game(d2, d3)>0) {
                    pw.println("yes");
                    worked = true;
                    break;
                }
            }
            if (!worked) {
                pw.println("no");
            }
        }

        pw.close();
    }

    public static void genPerms(String str) {
        if (str.length()<4) {
            for (int i = 0; i<=9; i++) {
                genPerms(str+i);
            }
        }
        else {
            perms.add(str);
        }
    }

    public static int game(int[] d1, int[]d2) {
        int one = 0;
        int two = 0;
        for (int x : d1) {
            for (int y : d2) {
                if (x>y) {
                    one++;
                } else if (x<y) {
                    two++;
                }
            }
        }
        return one-two;
    }
}
