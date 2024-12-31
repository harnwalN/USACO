import java.io.*;
import java.util.*;

public class S2019_D3_MilkVisits {
    public static ArrayList<Integer> path;
    public static Edge[] edges;
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter pw = new PrintWriter(System.out)
        BufferedReader br = new BufferedReader(new FileReader("milkvisits.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("milkvisits.out"));

        path = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        edges = new Edge[n+1]; // 1 indexed
        String cowString = br.readLine();
        for (int i = 1; i<=n; i++) {
            int cow = 0;
            if (cowString.substring(i-1, i).equals("H")){
                cow++;
            }
            edges[i] = new Edge(i,cow);
        }
        for (int i = 0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].addEdge(b);
            edges[b].addEdge(a);
        }

        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> al = new ArrayList<>();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            al.add(start);
            dfs(start, end, al, new HashSet<Integer>());
            int type = st.nextToken().equals("G") ? 0:1;
            boolean worked = false;
            for (int ii = 0; ii<path.size(); ii++) {
                if (edges[path.get(ii)].getCow()==type) {
                    pw.print(1);
                    worked = true;
                    break;
                }
            }
            if (!worked) {
                pw.print(0);
            }
            path = new ArrayList<Integer>();
        }
        pw.close();
    }

    public static int dfs(int cur, int end, ArrayList<Integer> p, HashSet<Integer> visited) {
        if (cur==end) {
            path = p;
            return 1;
        } else {
            for (int child : edges[cur].getConnected()) {
                if (visited.contains(child)) {continue;}
                ArrayList<Integer> pCopy = new ArrayList<>(p);
                pCopy.add(child);
                HashSet<Integer> visitedCopy = new HashSet<>(visited);
                visitedCopy.add(cur);
                if (dfs(child, end, pCopy, visitedCopy)==1) {
                    return 1;
                }
            }
            return 0;
        }
    }

    public static class Edge {
        int number;
        int cow; // 0 is G, 1 is H
        ArrayList<Integer> connected;
        public Edge(int n, int c) {
            number = n;
            cow = c;
            connected = new ArrayList<>();
        }
        public int getCow() {
            return cow;
        }
        public int getNumber() {
            return number;
        }
        public void addEdge(int e) {
            connected.add(e);
        }
        public ArrayList<Integer> getConnected() {
            return connected;
        }
    }
}
