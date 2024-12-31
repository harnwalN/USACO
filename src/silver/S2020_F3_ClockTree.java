import java.util.*;
import java.io.*;

public class S2020_F3_ClockTree {
    static HashSet<Integer> notExplored;
    static HashMap<Integer, Integer> times;
    static HashMap<Integer, Integer> timesO;
    static HashMap<Integer, HashSet<Integer>> adj;
    static HashMap<Integer, HashSet<Integer>> adjO;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String[] s = str.split("\\s");
        adj = new HashMap<>();
        adjO = new HashMap<>();
        notExplored = new HashSet();
        times = new HashMap<>();
        timesO = new HashMap<>();

        for (int i = 1; i<=n; i++) {
            HashSet<Integer> a = new HashSet<>();
            adj.put(i, a);
        }

        for (int i = 1; i<=n; i++) {
            notExplored.add(i); // set up notExplored
            times.put(i, Integer.parseInt(s[i-1])); // set up times of rooms
        }

        for (int i = 1; i<n; i++) { // set up room neighbors from tunnels
            String t = br.readLine();
            String[] tunnels = t.split("\\s");
            int r1 = Integer.parseInt(tunnels[0]);
            int r2 = Integer.parseInt(tunnels[1]);

            HashSet<Integer> a1 = adj.get(r1);
            HashSet<Integer> a2 = adj.get(r2);

            a1.add(r2);
            a2.add(r1);

            adj.put(r1, a1);
            adj.put(r2, a2);
        }
        adjO.putAll(adj);
        timesO.putAll(times);

        int num = 0;
        for (int el : notExplored) {
            System.out.println("Path:");
            int returned = dfs(el, -1, notExplored.clone());
            num+=returned;
            System.out.println("Returned: " + returned);
            adj = new HashMap<>(adjO);
            times = new HashMap<>(timesO);

        }

        pw.println(num);
        pw.close();
    }

    public static int dfs(int room, int from, Object ne) {
        System.out.println(from + " ->" + room);
        if (from != -1) {
            times.put(room, times.get(room)+1);
        }
        int curTime = times.get(room);
        int addTime = 0;
        HashSet<Integer> branches = adj.get(room);
        branches.remove(from);

        for (int el : branches) {
            addTime+=dfs(el, room, ne);
            addTime+=1;
        }
        curTime+=addTime;
        curTime%=12;

        adj.put(room, new HashSet<Integer>());
        branches = new HashSet<Integer>();

        if (branches.isEmpty() && from !=-1) {
            int cur = times.get(room);
            times.put(room, 12);
            return (12-(times.get(room)%12));
        }
        if (curTime == 12 || curTime == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}