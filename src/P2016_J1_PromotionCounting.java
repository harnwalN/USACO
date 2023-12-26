import java.io.*;

public class P2016_J1_PromotionCounting {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter pw = new PrintWriter(System.out);

        BufferedReader br = new BufferedReader(new FileReader("promote.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("promote.out"));

        int[][] ranks = new int[4][2];

        for (int i = 0; i<4; i++) {
            String str = br.readLine();
            String[] s = str.split("\\s");

            for (int j = 0; j<2; j++) {
                ranks[i][j] = Integer.parseInt(s[j]);
            }
        }

        int toPlat = ranks[3][1] - ranks[3][0];
        int toGold = ranks[2][1]-(ranks[2][0]-toPlat);
        int toSilver = ranks[1][1]-(ranks[1][0]-toGold);
        
        pw.println(toSilver);
        pw.println(toGold);
        pw.println(toPlat);
        
        pw.close();
    }
}
