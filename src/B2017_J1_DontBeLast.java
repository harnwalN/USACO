import java.util.*;
import java.io.*;

public class B2017_J1_DontBeLast {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("notlast.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("notlast.out"));

        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> cows = new HashMap<>();
        cows.put("Bessie", 0);
        cows.put("Elsie", 0);
        cows.put("Daisy", 0);
        cows.put("Gertie", 0);
        cows.put("Annabelle", 0);
        cows.put("Maggie", 0);
        cows.put("Henrietta", 0);

        
        for (int i = 0; i<n; i++) {
            String str = br.readLine();
            String[] s = str.split("\\s");

            String name = s[0];
            int milk = Integer.parseInt(s[1]);

            if (!cows.containsKey(name)) {
                cows.put(name, milk);
            } else {
                int newMilk = cows.get(name) + milk;
                cows.remove(name);
                cows.put(name, newMilk);
            }
        }
        
        int min = Integer.MAX_VALUE-1;
        int prevmin = Integer.MAX_VALUE;

        String prevname = "";

        for (int el : cows.values()) {
            if (el<min){min = el;}
        }

        ArrayList<String> toRemove = new ArrayList<>();
        for (String name : cows.keySet()) {
            int milk = cows.get(name);
            if (milk == min) {
                toRemove.add(name);
            }
        }

        for (String name : toRemove) {
            cows.remove(name);
        }

        if (cows.size() == 0) {
            pw.println("Tie");
            pw.close();
            return;
        } else {
            int count = 0;
            String name = "";
            min = Integer.MAX_VALUE;

            for (String cn : cows.keySet()) {
                int milk = cows.get(cn);
                if (milk<min){min = milk;}
            }
            for (String cn : cows.keySet()) {
                int milk = cows.get(cn);
                if (milk == min) {
                    count++;
                    name = cn;
                    if (count == 2) {
                        pw.println("Tie");
                        pw.close();
                        return;
                    }
                }
            }
            pw.println(name);
            pw.close();
            return;
        }
    }
}
