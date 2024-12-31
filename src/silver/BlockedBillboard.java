import java.util.*;
import java.io.*;

public class BlockedBillboard {
    public static void main (String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int[] bb1 = new int[4];
        int[] bb2 = new int[4];
        int[] truck = new int[4];

        //--------------------
        String sta = br.readLine();
        String[] stra = sta.split("\\s");

        for (int i=0; i<4; i++) {

            bb1[i] = Integer.parseInt(stra[i]);
        }
        String stb = br.readLine();
        String[] strb = sta.split("\\s");

        for (int i=0; i<4; i++) {

            bb2[i] = Integer.parseInt(strb[i]);
        }
        String stc = br.readLine();
        String[] strc = sta.split("\\s");

        for (int i=0; i<4; i++) {

            truck[i] = Integer.parseInt(strc[i]);
        }
        //--------------------

        int bb1Area = (bb1[3]-bb1[1])*(bb1[4]-bb1[2]);
        int bb2Area = (bb2[3]-bb2[1])*(bb2[4]-bb2[2]);


    }
}
