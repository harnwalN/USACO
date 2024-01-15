import java.io.*;
import java.util.*;

public class B2019_D2_WhereAmI {
    public static HashSet<String> perms;
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter pw = new PrintWriter(System.out);

        BufferedReader br = new BufferedReader(new FileReader("whereami.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("whereami.out"));

        int n = Integer.parseInt(br.readLine());

        perms = new HashSet<>();

        String str = br.readLine();
        pw.print(perm(str));
        pw.close();
    }

    public static int perm(String str) {
        int min = 0;
        int length = 1;

        while (length<=str.length()) {
            for (int i = 0; i<=str.length()-length; i++) {
                String added = str.substring(i, i+length);
                if (perms.contains(added)) {
                    min = Math.max(min, added.length()+1);
                } else {
                    perms.add(added);
                }
            }
            length++;
        }
        return min;
    }
}
