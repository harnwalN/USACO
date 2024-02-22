package Fundamentals;
import java.io.*;
import java.util.StringTokenizer;

public class MaxSubarraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n];
        StringTokenizer st =  new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) num[i] = Integer.parseInt(st.nextToken());

        long runningPrefix = num[0];
        long maxSum = num[0];
        long minPrefix = Math.min(num[0], 0);

        for (int i = 1; i<n; i++) {
            runningPrefix+=num[i];
            maxSum = Math.max(maxSum, runningPrefix-minPrefix);
            minPrefix = Math.min(runningPrefix, minPrefix);
        }

        pw.println(maxSum);
        pw.close();
    }
}
