import java.io.*;
import java.util.*;

public class S2017_D1_MyCowAteMyHomework {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("homework.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("homework.out"));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] grades = new int[n];
        for (int i = 0; i<n; i++) {
            grades[i] = Integer.parseInt(st.nextToken());
        }

        int[] suffixSum = new int[n];
        int[] suffixMin = new int[n];

        suffixMin[n-1] = Integer.MAX_VALUE;

        for (int i = n-2; i>=0; i--) {
            suffixSum[i] = suffixSum[i+1]+grades[i+1];
            suffixMin[i] = Math.min(grades[i+1], suffixMin[i+1]);
        }
        double ans = -1;
        ArrayList<Integer> answer = new ArrayList<>();
        for (int k = 0; k<=n-3; k++) {
            double avg = ((double)suffixSum[k]-suffixMin[k])/(n-k-2);
            if(avg>ans) {
                ans = avg;
                answer = new ArrayList<>();
                answer.add(k+1);
            } else if (avg==ans) {
                answer.add(k+1);
            }
        }
        for (int el : answer) {
            pw.println(el);
        }
        pw.close();
    }
}
