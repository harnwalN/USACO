package bronze;
import java.util.*;
import java.io.*;

public class B2018_O3_FamilyTree {
    static String a;
    static String b;
    static int[] result;
    static HashSet<String> visited;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter pw = new PrintWriter(System.out);

        BufferedReader br = new BufferedReader(new FileReader("family.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("family.out"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        a = new String(st.nextToken());
        b = new String(st.nextToken());

        HashMap<String, Cow> cows = new HashMap<>();

        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String x = st.nextToken();
            String y = st.nextToken();

            if (cows.containsKey(x)) {
                cows.get(x).children.add(y);
            }
            else {
                Cow cow = new Cow();
                cow.children.add(y);
                cows.put(x, cow);
            }

            if (cows.containsKey(y)) {
                cows.get(y).mother = x;
            }
            else {
                Cow cow = new Cow();
                cow.mother = x;
                cows.put(y, cow);
            }
        }
        result = new int[]{0, 0};
        visited = new HashSet<>();

        dfs(a, b, cows, new int[] {0, 0}); // vertical, horizontal
        if (result[0]<0) {
            visited = new HashSet<>();
            dfs(b, a, cows, new int[] {0, 0});
            String temp = b;
            b=a;
            a=temp;
        }

        if (result[0] ==0 && result[1] == 0) {
            pw.print("NOT RELATED");
            pw.close();
        }
        else if (result[1] == 1) {
            if (result[0] == 0) {
                pw.print("SIBLINGS");
                pw.close();
            } else {
                pw.print(b+" is the ");
                for (int i = 1; i<result[0]; i++) {
                    pw.print("great-");
                }
                pw.print("aunt of " + a);
                pw.close();
            }
        } else if (result[1] == 0) {
            pw.print(b+" is the ");
            if (result[0]==1) {pw.print("mother");}
            else if (result[0] == 2) {pw.print("grand-mother");}
            else {
                for (int i = 2; i<result[0]; i++) {
                    pw.print("great-");
                }
                pw.print("grand-mother");
            }
            pw.print(" of "+ a);
        } else {pw.print("COUSINS");}
        pw.close();
    }

    public static void dfs (String position, String target, HashMap<String, Cow> cows, int[] path) {
        visited.add(position);
        if (!position.equals(target)) {
            for (String cow : cows.get(position).children) {
                if (!visited.contains(cow)) {dfs(cow, target, cows, new int[]{path[0]-1, path[1]+1});}
            }
            if (!cows.get(position).mother.equals("") && !visited.contains(cows.get(position).mother)) 
            {
                dfs(cows.get(position).mother, target, cows, new int[]{path[0]+1, path[1]});
            }
            return;
        } else {
            result[0] = path[0];
            result[1] = path[1];
            return;
        }

    }

    public static class Cow {
        public String mother;
        public ArrayList<String> children;

        public Cow () {
            children = new ArrayList<>();
            mother = "";
        }

        public ArrayList<String> getChildren() {
            return children;
        }

        public String getMother() {
            return mother;
        }
    }
}
