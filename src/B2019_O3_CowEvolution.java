import java.io.*;
import java.util.*;

public class B2019_O3_CowEvolution {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter pw = new PrintWriter(System.out);

        BufferedReader br = new BufferedReader(new FileReader("evolution.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("evolution.out"));

        int n = Integer.parseInt(br.readLine());

        HashMap<String, ArrayList<String>> traits = new HashMap<>();

        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());

            String[] str = new String[c];

            for (int j = 0; j<c; j++) {
                str[i] = st.nextToken();
            }

            for (String el : str) {
                ArrayList<String> link;
                if (traits.containsKey(el)) {
                    link = traits.get(el);
                } else {
                    link = new ArrayList<>();
                }
            }
        }

        pw.close();
    }

    public static class Node {
        String parent;
        ArrayList<String> child;
        Boolean hasChild;

        public Node(String p, ArrayList<String> c, Boolean h) {
            parent = p;
            child = c;
            hasChild = h;
        }

        public String getParent() {
            return parent;
        }

        public ArrayList<String> getChild() {
            return child;
        }

        public Boolean hasChild() {
            return hasChild;
        }
    }
}


/*

4
2 spots firebreathing
0
2 firebreathing flying
2 telepathic flying

*/