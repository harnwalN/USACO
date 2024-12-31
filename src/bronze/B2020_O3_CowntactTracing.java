package bronze;
import java.io.*;
import java.util.*;

public class B2020_O3_CowntactTracing {
    public static int value;
    public static int end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        //BufferedReader br = new BufferedReader(new FileReader("tracing.in"));
        //PrintWriter pw = new PrintWriter(new FileWriter("tracing.out"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        end = 0;
        value = 0;

        String inf = br.readLine();
        for (int i = 0; i<n; i++) {
            if (inf.substring(i, i+1).equals(1)) {
                end++;
            }
        }

        TreeMap<Integer,HashSet<Integer>> interactions = new TreeMap<>();

        for (int i = 0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            HashSet<Integer> added = new HashSet<>();
            int time = Integer.parseInt(st.nextToken());
            added.add(Integer.parseInt(st.nextToken()));
            added.add(Integer.parseInt(st.nextToken()));
            interactions.put(time, added);
        }

        int starters = 0;
        int min = 0;
        int max = 0;

        for (int i = 1; i<=n; i++) {
            sim(n, interactions);
            if (value==-1) {
                continue;
            } else {
                min = Math.min(min, value);
                max = Math.max(max, value);
            }
        }
    }

    public static int sim(int cow, TreeMap<Integer, HashSet<Integer>> interactions) {
        for (int time : interactions.keySet()) {
            HashSet<Integer> interaction = interactions.get(time);
            //if (interaction.contains(cow)) {for (int el: interaction){if(el!=cow){sim()}}}
        }
        
        return -1;
    }
}
