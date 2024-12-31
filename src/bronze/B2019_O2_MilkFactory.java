package bronze;
import java.io.*;
import java.util.*;

public class B2019_O2_MilkFactory {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("factory.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("factory.out"));

        int n = Integer.parseInt(br.readLine());

        HashSet<Integer> nposs = new HashSet<>();

        for (int i = 1; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            nposs.add(a);
        }

        int count = 0;
        for (int i = 1; i<=n; i++) {
            if (nposs.contains(i)) {continue;}
            else if (count!=0) {pw.println(-1);pw.close();break;}
            else {count=i;}
        }
        pw.println(count);
        pw.close();
    }
}
