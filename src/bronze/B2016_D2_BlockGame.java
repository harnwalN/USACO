package bronze;
import java.io.*;

public class B2016_D2_BlockGame {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("blocks.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("blocks.out"));

        int[] ch = new int[26];

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i<n; i++) {
            int[] a0 = new int[26];
            int[] a1 = new int[26];
            String[] w = br.readLine().split("\\s");

            for (int c = 0; c<w[0].length(); c++) {
                a0[Character.getNumericValue(w[0].charAt(c))-10] +=1;
            }
            for (int c = 0; c<w[1].length(); c++) {
                a1[Character.getNumericValue(w[1].charAt(c))-10] +=1;
            }
            
            for (int j = 0; j<26; j++) {
                ch[j]+=Math.max(a0[j], a1[j]);
            }
        }

        for (int i = 0; i<26; i++) {
            pw.println(ch[i]);
        }
        pw.close();
    }
}