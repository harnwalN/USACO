package bronze;
import java.io.*;
import java.util.*;

public class B2023_F2_StampGrid {
    static BufferedReader br;
    static PrintWriter pw;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i<t; i++) {
            br.readLine();
            
            int gmaxX = 0, gmaxY = 0;
            int gminX = Integer.MAX_VALUE, gminY = Integer.MAX_VALUE;
            // grid
            int n = Integer.parseInt(br.readLine());
            int[][] grid = new int[n][n];
            for (int l = 0; l<n; l++) {
                String str = br.readLine();
                for (int j = 0; j<n; j++) {
                    if (str.substring(j, j+1).equals("*")){
                        grid[l][j] = 1;
                        gmaxX = Math.max(j, gmaxX);
                        gminX = Math.min(j, gminX);
                        gmaxY = Math.max(l, gmaxY);
                        gminY = Math.max(l, gminY);
                    } else {
                        grid[l][j] = 0;
                    }
                }
            }

            int smaxX = 0, smaxY = 0;
            int sminX = Integer.MAX_VALUE, sminY = Integer.MAX_VALUE;
            //stamp
            int k = Integer.parseInt(br.readLine());
            int[][] stamp = new int[k][k];
            for (int l = 0; l<k; l++) {
                String str = br.readLine();
                for (int j = 0; j<k; j++) {
                    if (str.substring(j, j+1).equals("*")){
                        stamp[l][j] = 1;
                        smaxX = Math.max(j, smaxX);
                        sminX = Math.min(j, sminX);
                        smaxY = Math.max(l, smaxY);
                        sminY = Math.max(l, sminY);
                    } else {
                        stamp[l][j] = 0;
                    }
                }
            }

            if (k ==1 && n ==1) {
                pw.println("YES");
                continue;
            }

            if (test(n, k, grid, stamp, gmaxX, gminX, gmaxY, gminY, smaxX, sminX, smaxY, sminY)) {
                pw.println("YES");
            } else {
                pw.println("NO");
            }
        }

        pw.close();
    }

    public static boolean test(int n, int k, int[][] grid, int[][] stamp, int gmx, int gnx, int gmy, int gny, int smx, int snx, int smy, int sny){
        if (gmx-gnx<smx-snx || gmy-gny<smy-sny) {
            return false;
        }
        
        int[][] comp = new int[k][k];
        for (int i = 0; i<k; i++) {
            for (int h = 0; h<4; h++){
                for (int j = 0; j<k; j++) {
                    comp[i][j] +=stamp[i][j];
                }
                stamp = turn(stamp);
            }

        }

        for (int row = 0; row<n; row++) {
            for (int col = 0; col<n; col++) {
                if (grid[row][col] == 1) {
                   add(row, col, comp, grid); 
                }
            }
        }
        return true;
    }

    public static void add(int r, int c, int[][] stamp, int [][] grid) {
        int len = stamp.length;
        for (int i = 0; i<len; i++) {
            for (int j = 0; j<len; j++) {
                if (stamp[i][j] == 1 && grid[r+i][c+j] == 1) {
                    grid[r+i][c+j] = grid[r+i][c+j]+1;
                }
            }
        }
    }

    public static int[][] turn(int[][] stamp) {
        int k = stamp.length;
        int[][] prev = stamp.clone();
        for (int i = 0; i<stamp.length; i++) {
            for (int j = 0; j<stamp.length; j++) {
                stamp[i][j] = prev[i-(k/2)+k][-j+(k/2)+k];
            }
        }
        return stamp;
    }
}
