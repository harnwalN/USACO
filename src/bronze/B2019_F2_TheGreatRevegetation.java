package bronze;
import java.io.*;
import java.util.*;

public class B2019_F2_TheGreatRevegetation {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter pw = new PrintWriter(System.out);

        BufferedReader br = new BufferedReader(new FileReader("revegetate.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("revegetate.out"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> pastures = new ArrayList<>();
        pastures.add(new ArrayList<>());
        ArrayList<HashSet<Integer>> cant = new ArrayList<>();
        cant.add(new HashSet<>());
        for (int i = 1; i<=n; i++) {
            pastures.add(new ArrayList<>());
            cant.add(new HashSet<>());
        }

        for (int i = 1; i<=m ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pastures.get(a).add(b);
            pastures.get(b).add(a);
        }

        for (int i = 1; i<=n; i++) {
            ArrayList<Integer> connected = pastures.get(i);
            HashSet<Integer> no = cant.get(i);
            int out = 1;
            while (out<=4) {
                if(no.contains(out)){out++;}
                else {break;}
            }
            pw.print(out);

            for (int pasture : connected) {
                cant.get(pasture).add(out);
            }
        }
        pw.close();
    }
}
