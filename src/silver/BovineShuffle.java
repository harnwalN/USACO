import java.io.*;
import java.util.*;

public class BovineShuffle {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("shuffle.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        
        String str = br.readLine();
        String[] a = str.split("\\s");
        
        HashMap<Integer, Integer> posToA = new HashMap<> ();
        
        for (int i = 0; i<a.length; i++) {
            posToA.put(i+1, Integer.parseInt(a[i]));
        }


        
        pw.close();
    }
            
        
}