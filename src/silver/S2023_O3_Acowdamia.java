import java.io.*;
import java.util.*;

public class S2023_O3_Acowdamia {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] cows = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }
        
    }
}
