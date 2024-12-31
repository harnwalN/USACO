package bronze;
import java.io.*;
import java.util.HashSet;

public class B2017_O3_ModernArt {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter pw = new PrintWriter(System.out);

        BufferedReader br = new BufferedReader(new FileReader("art.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("art.out"));

        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n+1][n+1];

        int[][] colors = new int[10][4]; // 0 nothing, 1 is 1, 2 is 2, ... 9 is 9
        // 0: min row, 1: max row, 2: min col, 3: max col
        

        for (int i = 1; i<=n; i++) {
            String line = br.readLine();
            for (int j = 1; j<=n; j++) {
                int color = Integer.parseInt(line.substring(j-1, j));
                grid[i][j] = color;
                colors[color][0] = Math.min((colors[color][0] == 0 ? j : colors[color][0]), j);
                colors[color][1] = Math.max((colors[color][1] == 0 ? j : colors[color][1]), j);
                colors[color][2] = Math.min((colors[color][2] == 0 ? i : colors[color][2]), i);
                colors[color][3] = Math.max((colors[color][3] == 0 ? i : colors[color][3]), i);
            }
        }

        // everything is indexed starting from 1
        HashSet<Integer> possible = new HashSet<>();
        for (int i = 1; i<10; i++) {
            possible.add(i);
        }

        for (int i = 1; i<=9; i++) {
            if (colors[i][0]==0) {possible.remove(i);continue;}
            int[] params = colors[i];

            for (int y = params[2]; y<=params[3]; y++) {
                for (int x = params[0]; x<=params[1]; x++) {
                    if (grid[y][x]!=i) {possible.remove(grid[y][x]);}
                }
            }
        }
        pw.println(possible.size());

        /*for (int i = 1; i<10; i++) {
            int[] color = colors[i];
            pw.print(i+": ");
            for (int param: color) {
                if (param==0) {break;}
                pw.print(param);
                pw.print(", ");
            }
            pw.println();
        }*/

        pw.close();
    }
}
