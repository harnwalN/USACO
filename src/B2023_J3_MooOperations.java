import java.util.*;
import java.io.*;

public class B2023_J3_MooOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        boolean MOM = false;
        boolean OOO = false;
        boolean OOM = false;
        boolean MOO = false;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i<n; i++) {
            String str = br.readLine();
            if (str.length()==3) {
                if (str.equals("MOO")) {pw.println(0);}
                else if (str.substring(1, 2).equals("M")) {pw.println(-1);}
                else {
                    int sum = 0;
                    if (str.substring(0, 1).equals("O")) {
                        sum++;
                    }
                    if (str.substring(2, 3).equals("M")) {
                        sum++;
                    }
                    pw.println(sum);
                }
                continue;
            } else if(str.length()<3){pw.println(-1); continue;}
            for (int s = 3; s<=str.length(); s++) {
                String ss = str.substring(s-3, s);
                if (ss.equals("MOO")) {pw.println(str.length()-3); MOO=true; break;}
                else if(ss.equals("MOM")) {MOM=true;}
                else if(ss.equals("OOO")) {OOO=true;}
                else if(ss.equals("OOM")) {OOM=true;}
            }
            if (!MOO){
                if (MOM || OOO) {pw.println(str.length()-2);}
                else if (OOM) {pw.println(str.length()-1);}
                else {pw.println(-1);}
            }
            MOM = false;
            OOO = false;
            OOM = false;
            MOO=false;
        }
        pw.close();
    }
}
