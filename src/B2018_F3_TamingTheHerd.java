import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class B2018_F3_TamingTheHerd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("taming.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("taming.out"));

        int n = Integer.parseInt(br.readLine());

        int[] log = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            log[i] = Integer.parseInt(st.nextToken());
            if (log[i]==-1 || log[i]==0 || log[i-1]==-1) {continue;}
            else if (i>0 && (log[i]!=log[i-1]+1)) {pw.println(-1); pw.close(); return;}
        }

        
        if (log[0]==-1 || log[0] == 0) {log[0] = 0;}
        else {pw.print(-1); pw.close();return;}

        int min = 0;
        int max = 0;

        for (int i = n-1; i>=0; i--) {
            int c = log[i];
            if (c>=0) {
                min++;
                max++;
                i-=c;
            } else {
                max++;
            }
        }
        
        pw.print(min+ " " + max);
        pw.close();
    }
}