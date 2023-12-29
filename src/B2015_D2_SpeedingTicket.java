import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B2015_D2_SpeedingTicket {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("speeding.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("speeding.out"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int rind = 101;
        int bind = 101;

        HashMap<Integer, Integer> timestamp = new HashMap<>(); // 1 if road, 2 if Bessie, 3 if both
        HashMap<Integer, Integer> road = new HashMap<>();
        HashMap<Integer, Integer> bessie = new HashMap<>();

        int miles = 0;
        for (int i = 0; i<n; i++) { // for roads
            st = new StringTokenizer(br.readLine());
            miles+=Integer.parseInt(st.nextToken());
            timestamp.put(miles, 1);
            road.put(miles, Integer.parseInt(st.nextToken()));
            rind = Math.min(rind, miles);
        }
        miles = 0;
        for (int i = 0; i<m; i++) { // for bessie
            st = new StringTokenizer(br.readLine());
            miles+=Integer.parseInt(st.nextToken());
            if(timestamp.containsKey(miles)) {
                timestamp.put(miles, 3);
            } else {
                timestamp.put(miles, 2);
            }
            bessie.put(miles, Integer.parseInt(st.nextToken()));
            bind = Math.min(miles, bind);
        }
        
        ArrayList<Integer> mile = new ArrayList<>();

        for (int el : timestamp.keySet()) {
            if (mile.size()==0) {mile.add(el);}
            for (int i = 0; i<mile.size(); i++) {
                if (el== mile.get(i)){continue;}
                if (el<mile.get(i)) {
                    mile.add(i, el);
                    break;
                } else if (i == mile.size()-1){
                    mile.add(el);
                    break;
                }
            }
        }
        
        int inf = 0;

        int cr = road.get(100);
        int cb = bessie.get(100);

        

        for (int i = mile.size()-1; i>=0; i--) {
            int el = mile.get(i);
            if (road.containsKey(el)) {
                cr = road.get(el);
            }
            if (bessie.containsKey(el)) {
                cb = bessie.get(el);
            }
            inf = Math.max(inf, cb-cr);
        }
        pw.print(inf);
        pw.close();
    }
}
