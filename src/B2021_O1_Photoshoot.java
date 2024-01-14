import java.util.*;
import java.io.*;

public class B2021_O1_Photoshoot {
    static HashMap<String, Integer> perms;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());

        String str = br.readLine();
        
        for (int i = str.length()-1; i>=0; i--) {
            if ((i+1)%2==0 && str.substring(i, i+1).equals("G")) {str = str.substring(0, i);}
            else if (i%2==0 && str.substring(i, i+1).equals("H")) {str = str.substring(0, i);}
            else {break;}
        }
        if(str.length()==0) {pw.println(0);pw.close(); return;}
        if (str.length()%2==1) {str = str.substring(0, str.length()-1);}

        String first = str.substring(0, 2);
        perms = new HashMap<>();
        perms("");
        int swaps = 0;

        while(str.length()>2) {
            String added = str.substring(str.length()-2, str.length());
            if (perms.get(first+added)>0) {
                swaps++;
                str = reverse(str);
                first = str.substring(0, 2);
            }
            str = str.substring(0, str.length()-2);
        }

        if (str.equals("GH")){swaps++;}
        pw.print(swaps);
        pw.close();
    }

    public static String reverse(String s) {
        String reverse = "";
        for (int i = s.length()-1; i>=0; i--) {
            reverse+=s.substring(i, i+1);
        }
        return reverse;
    }
    public static void perms(String s) {
        if (s.length() ==4) {
            String s1 = s.substring(0, 1);
            String s2 = s.substring(1, 2);
            String s3 = s.substring(2, 3);
            String s4 = s.substring(3, 4);

            int before = 0;
            if (s4.equals("G")) {before++;}
            if (s3.equals("G")){before--;}
            int after = 0;
            if (s1.equals("G")) {after++;}
            if (s2.equals("G")) {after--;}

            perms.put(s, after-before);
            return;
        }
        perms(s+"G");
        perms(s+"H");
    }
}
/*
1010101010
GGGHGH
HGHG

GGGHGHHG
GGGHGH
HGHGGG
HGHG


10101010
GHHGHGGG

GGGHGHHG
*GGGHGH
*HGHGGG
HGHG
HGHGGGHG (4)

GGGHGHHG
*GGGHGH
*GGGH
GG
GGGHGHHG (2)

GGGHGH

*/