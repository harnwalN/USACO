package bronze;
import java.util.*;
import java.io.*;

public class B2023_J2_AirCownditioningII {
    public static int min;
    public static Cow[] cows;
    public static AC[] acs;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;

        cows = new Cow[n];
        acs = new AC[m];

        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            cows[i] = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            acs[i] = new AC(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        perms("", m);

        pw.println(min);
        pw.close();
    }

    public static void perms(String used, int m) {
        if (used.length() == m) {
            works(used);
            return;
        }
        perms(used+"0", m);
        perms(used+"1", m);
    }

    public static boolean works (String used) {
        int[] grid = new int[101];

        int money = 0;

        for (int i = 0; i<used.length(); i++) {
            if (used.substring(i, i+1).equals("1")) {
                AC ac = acs[i];
                int start = ac.getStart();
                int end = ac.getEnd();
                int power = ac.getPower();
                money+=ac.getMoney();

                for (int x = start; x<=end; x++) {
                    grid[x]+=power;
                }
            }
        }

        for (Cow cow : cows){
            int start = cow.getStart();
            int end = cow.getEnd();
            int need = cow.getNeed();

            for (int i = start; i<=end; i++) {
                if (grid[i]<need) {
                    return false;
                }
            }
        }
        min = Math.min(money, min);
        return true;
    }

    public static void calc(String used) {

    }

    public static class AC{
        public int start;
        public int end;
        public int power;
        public int money;

        public AC(int start, int end, int power, int money) {
            this.start = start;
            this.end = end;
            this.power = power;
            this.money = money;
        }

        public int getStart() {
            return start;
        }
        public int getEnd() {
            return end;
        }
        
        public int getPower() {
            return power;
        }

        public int getMoney() {
            return money;
        }
    }

    public static class Cow{
        public int start;
        public int end;
        public int need;

        public Cow(int start, int end, int need) {
            this.start = start;
            this.end = end;
            this.need = need;
        }

        public int getStart() {
            return start;
        }
        public int getEnd() {
            return end;
        }
        
        public int getNeed() {
            return need;
        }
    }
}