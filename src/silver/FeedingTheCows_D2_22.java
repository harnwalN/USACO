import java.util.*;
import java.io.*;

public class FeedingTheCows_D2_22 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());
        Test[] tests = new Test[t];

        for (int i = 0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tests[i] = new Test(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), br.readLine());
        }

        for (Test test : tests) {
            sim(test, new int[test.getNK()[0]]);
        }

    }

    public static void sim(Test test, int[] answer) {
        int[] nk = test.getNK();
        int n = nk[0];
        int k = nk[1];
        boolean[] breeds = test.getBreeds();

        for (boolean G : breeds) {
            if (G) {
                
            }
        }
    }

    public static class Test {
        int n;
        int k;
        boolean[] breeds; // true = Guernsey, false = Holstein
        String str_breed;

        public Test(int N, int K, String Str_breed) {
            n = N;
            k = K;

            breeds = new boolean[n];
            for (int i = 0; i<n; i++) {
                breeds[i] = Str_breed.substring(i, i+1).equals("G");
            }
            str_breed = Str_breed;
        }

        public int[] getNK() {
            int[] returned = new int[2];
            returned[0] = n;
            returned[1] = k;
            return returned;
        }

        public boolean[] getBreeds() {
            return breeds;
        }

        public String toString() {
            return "("+n+","+k+","+str_breed+")";
        }
    }
}
