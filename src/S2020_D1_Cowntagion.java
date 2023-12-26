import java.util.*;
import java.io.*;

public class S2020_D1_Cowntagion {
    static HashMap<Integer, HashSet<Integer>> adj;
    static HashSet<Integer> notExplored;
    static int day = 0;
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);


        notExplored = new HashSet<>();
        adj = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        
        for (int i = 1; i<=n; i++) {
            adj.put(i, new HashSet<>());
        }

        for (int i = 0; i<n-1; i++) {
            String str = br.readLine();
            String[] s = str.split("\\s");
            int t1 = Integer.parseInt(s[0]);
            int t2 = Integer.parseInt(s[1]);
            notExplored.add(t1);
            notExplored.add(t2);

            HashSet<Integer> added = adj.get(t1);
            added.add(t2);
            adj.put(t1, added);

            HashSet<Integer> adde = adj.get(t2);
            adde.add(t1);
            adj.put(t2, adde);
        }

        dfs(1, 1, 1);
        pw.println(day);
        pw.close();
    }
    static void dfs(int from, int town, int infected) {
        if (notExplored.isEmpty()) {return;}

        HashSet<Integer> con = adj.get(town);
        con.remove(from);

        if (infected<=con.size()) {
            dfs(town, town, infected*2);
            day++;
        } else {
            for (int el : con) {
                dfs(town, el, 1);
                notExplored.remove(el);
                day++;
            }
        }
    }
}