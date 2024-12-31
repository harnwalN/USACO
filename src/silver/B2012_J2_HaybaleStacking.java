import java.io.*;
import java.util.*;

public class B2012_J2_HaybaleStacking {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] bales = new int[n];
        for (int i = 0; i<k ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            bales[start]++;
            if (end!=n-1) {bales[end+1]--;}
        }
        for (int i = 1; i<n; i++) {
            bales[i] += bales[i-1];
        }
        Arrays.sort(bales);
        pw.println(bales[bales.length/2]);
        pw.close();
    }
}
