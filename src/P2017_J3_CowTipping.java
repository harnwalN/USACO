import java.util.*;
import java.io.*;

public class P2017_J3_CowTipping {
    static int[][] grid;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("cowtip.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("cowtip.out"));

        int n = Integer.parseInt(br.readLine());

        grid = new int[n][n];
        for (int i = 0; i<n; i++) {
            String str = br.readLine();
            for (int j = 0; j<n; j++) {
                grid[i][j] = Integer.parseInt(str.substring(j, j+1));

            }

        }
        int switches = 0;

        for (int i = n-1; i>=0; i--) {
            for (int j = n-1; j>=0; j--) {
                if (grid[i][j]%2 == 1) {
                    switc(i, j);
                    switches+=1;
                }
            }
        }

        pw.println(switches);
        pw.close();
    }

    public static void switc(int i, int j) {
        for (int row = 0; row<=i; row++) {
            for (int col = 0; col<=j; col++) {
                grid[row][col]+=1;
            }
        }
    }
}
