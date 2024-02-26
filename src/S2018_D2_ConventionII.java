import java.io.*;
import java.util.*;

public class S2018_D2_ConventionII {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("convention2.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("convention2.out"));

        int n = Integer.parseInt(br.readLine());

        Cow[] a_order = new Cow[n];
        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Cow cow = new Cow(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            a_order[i] = cow;
        }

        Arrays.sort(a_order);
        int ans = 0;
        int time = a_order[0].getArrival();

        PriorityQueue<Cow> pq = new PriorityQueue<>(
            new Comparator<Cow>() {
                public int compare(Cow a, Cow b) {
                    return a.getSeniority()-b.getSeniority();
                }
            }
        );
        pq.add(a_order[0]);

        int i = 1;
        while(!pq.isEmpty()) {
            Cow cow = pq.poll();
            ans = Math.max(ans, time-cow.getArrival());
            time+=cow.getTime();

            for (int ii=i; ii<n; ii++) {
                if (a_order[ii].getArrival()<=time) {
                    pq.add(a_order[ii]);
                    i++;
                } else if (pq.isEmpty()) {
                    if (i<n) {
                        pq.add(a_order[i]);
                        time = a_order[i].getArrival();
                        i++;
                    }
                } else {
                    break;
                }
            }
        }
        pw.println(ans);
        pw.close();
    }

    public static class Cow implements Comparable<Cow> {
        int seniority;
        int arrival;
        int time;

        public Cow(int s, int a, int t) {
            seniority = s;
            arrival = a;
            time = t;
        }
        public int getSeniority() {
            return seniority;
        }
        public int getArrival() {
            return arrival;
        }
        public int getTime() {
            return time;
        }
        public int compareTo(Cow c) {
            if (arrival>c.getArrival()) {
                return 1;
            } else if (arrival==c.getArrival()) {
                return 0;
            } else {
                return -1;
            }
        }
    }
}
