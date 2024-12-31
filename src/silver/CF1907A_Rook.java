import java.util.*;
import java.io.*;

public class CF1907A_Rook {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h"};

        for (int i =0 ; i<n; i++) {
            String pos = br.readLine();
            String row = pos.substring(0, 1);
            int num = Integer.parseInt(pos.substring(1, 2));
            for (int j = 1; j<=8; j++) {
                if (j==num){continue;}
                pw.println(row+j);
            }
            for (String letter : letters) {
                if (letter.equals(row)) {
                    continue;
                } else {
                    pw.println(letter+num);
                }
            }
        }
        pw.close();
    }
}