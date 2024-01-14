import java.io.*;
import java.util.*;

public class S2019_J1_GrassPlanting {
    public static int max = 0;

    public static HashMap<Integer,Integer> paths;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new FileReader("planting.in"));
        PrintWriter pw = new PrintWriter(new PrintWriter("planting.out"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter pw = new PrintWriter(System.out);
        paths = new HashMap<>();
        
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i<=n; i++) {
            paths.put(i, 0);
        }

        for (int i = 1; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            paths.put(a, paths.get(a)+1);
            paths.put(b, paths.get(b)+1);
        }

        for (int i = 1; i<=n; i++) {
            max = Math.max(max, paths.get(i));
        }
        pw.println(max+1);
        pw.close();
    }
}
