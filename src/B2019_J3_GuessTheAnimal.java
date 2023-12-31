import java.io.*;
import java.util.*;

public class B2019_J3_GuessTheAnimal {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter pw = new PrintWriter(System.out);

        BufferedReader br = new BufferedReader(new FileReader("guess.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("guess.out"));

        HashSet<String> traits = new HashSet<>();
        HashMap<String, HashSet<String>> trtoa = new HashMap<>(); // trait to animals
        HashMap<String, ArrayList<String>> atotr = new HashMap<>(); // animal to traits

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String animal = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            ArrayList<String> atraits = new ArrayList<>();
            for (int j = 0; j<k; j++) {
                String tr = st.nextToken();
                if (!traits.contains(tr)) {
                    traits.add(tr);
                    HashSet<String> added = new HashSet<>();
                    added.add(animal);
                    trtoa.put(tr, added);
                } else { // trait already exists
                    HashSet<String> added = trtoa.get(tr);
                    added.add(animal);
                    trtoa.put(tr, added); //replace with updated set
                }
                atraits.add(tr);
            }
            atotr.put(animal, atraits);
        }

        int max = 0;
        for (String oanim : atotr.keySet()) {
            ArrayList<String> tr = atotr.get(oanim);
            for (String canim : atotr.keySet()) {
                int amax = 0;
                if (oanim.equals(canim)) {continue;}
                for (String tra : tr) {
                    if (trtoa.get(tra).contains(canim)) {amax++;}
                }
                max = Math.max(amax, max);
            }
        }

        pw.println(max+1);
        pw.close();
    }
}
