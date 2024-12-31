import java.util.*;
import java.io.*;

public class S2016_O2_DiamondCollector {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("diamond.in"));
        PrintWriter pw = new PrintWriter("diamond.out");

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] diamonds = new int[n];
        for(int i = 0; i<n; i++) {
            diamonds[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(diamonds);

        int left = 0, right = 1;
        int count = 0;

        while (right<n) {
            int a = diamonds[left];
            int b = diamonds[right];
            if (b-a<=k) {
                count+=right-left;
                right++;
            } else {
                left+=1;
                if (left==right) {right++;}
            }
        }
        pw.println(count);
        pw.close();
    }
}
