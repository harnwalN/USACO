package bronze;
import java.util.*;
import java.io.*;

public class B2022_J1_Herdle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int[] green = new int[26];

        int[] answer = new int[26];
        String[] order = new String[9];

        for (int i = 0; i<3; i++) {
            String str = br.readLine();
            for (int j = 0; j<3; j++) {
                answer[Character.getNumericValue(str.charAt(j))-10]++;
                order[(3*i)+j] = str.substring(j, j+1);
            }
        }

        int[] guess = new int[26];

        for (int i = 0; i<3; i++) {
            String str = br.readLine();
            for (int j = 0; j<3; j++) {
                guess[Character.getNumericValue(str.charAt(j))-10]++;
                if(order[(3*i)+j].equals(str.substring(j, j+1))) {
                    green[Character.getNumericValue(str.charAt(j))-10]++;
                }
            }
        }

        int g = 0;
        for (int el : green) {
            g+=el;
        }
        pw.println(g);

        int y = 0;
        for (int i = 0; i<26; i++) {
            y+=Math.min(answer[i], guess[i])-green[i];
        }
        pw.println(y);
        pw.close();
    }
}
