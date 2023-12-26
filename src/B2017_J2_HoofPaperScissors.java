import java.util.*;
import java.io.*;

public class B2017_J2_HoofPaperScissors {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("hps.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("hps.out"));

        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> case1 = new HashMap<>();
        case1.put("1 2", 1);
        case1.put("2 3", 1);
        case1.put("3 1", 1);
        case1.put("2 1", 0);
        case1.put("3 2", 0);
        case1.put("1 3", 0);
        HashMap<String, Integer> case2 = new HashMap<>();
        case2.put("1 3", 1);
        case2.put("3 2", 1);
        case2.put("2 1", 1);
        case2.put("3 1", 0);
        case2.put("2 3", 0);
        case2.put("1 2", 0);
        HashMap<String, Integer> case3 = new HashMap<>();
        case3.put("2 1", 1);
        case3.put("1 3", 1);
        case3.put("3 2", 1);
        case3.put("1 2", 0);
        case3.put("3 1", 0);
        case3.put("2 3", 0);
        HashMap<String, Integer> case4 = new HashMap<>();
        case4.put("2 3", 1);
        case4.put("3 1", 1);
        case4.put("1 2", 1);
        case4.put("3 2", 0);
        case4.put("1 3", 0);
        case4.put("2 1", 0);
        HashMap<String, Integer> case5 = new HashMap<>();
        case5.put("3 1", 1);
        case5.put("1 2", 1);
        case5.put("2 3", 1);
        case5.put("1 3", 0);
        case5.put("2 1", 0);
        case5.put("3 2", 0);
        HashMap<String, Integer> case6 = new HashMap<>();
        case6.put("3 2", 1);
        case6.put("2 1", 1);
        case6.put("1 3", 1);
        case6.put("2 3", 0);
        case6.put("1 2", 0);
        case6.put("1 3", 0);

        ArrayList<HashMap<String,Integer>> cases = new ArrayList<>();
        cases.add(case1);
        cases.add(case2);
        cases.add(case3);
        cases.add(case4);
        cases.add(case5);
        cases.add(case6);

        int[] c = new int[6];

        for (int i = 0; i<n; i++) {
            int j = 0;
            String str = br.readLine();
            for (HashMap<String, Integer> el : cases){
                if (!el.containsKey(str)) {
                    j++;
                    continue;
                }
                if (el.get(str) == 1) {
                    c[j]++;
                }
                j++;
            }
        }
        int max = -1;
        for (int el : c) {
            if (el> max) {max = el;}
        }
        pw.println(max);
        pw.close();
    }
}
