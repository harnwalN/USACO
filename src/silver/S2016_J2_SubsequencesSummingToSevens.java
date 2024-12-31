import java.io.*;

public class S2016_J2_SubsequencesSummingToSevens {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("div7.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("div7.out"));

        int n = Integer.parseInt(br.readLine());
        long[] prefix = new long[n+1];
        int maxLen = 0;
        prefix[0] = 0;
        for (int i = 1; i<n+1; i++) {
            prefix[i] = prefix[i-1]+Integer.parseInt(br.readLine());
        }


        int left = 0, right = 1;
        while (left <= n-1) {
            if ((prefix[right]-prefix[left])%7==0) {
                maxLen = Math.max(maxLen, right-left);
            }
            if (right<n) {
                right++;
            }
            else {
                left++;
                right = left+1+maxLen;
                if (right>n) {break;}
            }
        }
        pw.println(maxLen);
        pw.close();
    }
}
