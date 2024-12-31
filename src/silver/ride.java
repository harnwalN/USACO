/*
ID: neelaks2
LANG: JAVA
TASK: ride
*/
import java.io.*;

class ride {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("ride.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("ride.out"));

        String comet = br.readLine();
        int csum = 1;
        String group = br.readLine();
        int gsum = 1;

        for (int i = 0; i<comet.length(); i++) {
            csum*=(Character.getNumericValue(comet.charAt(i))-9);
        }
        for (int i = 0; i<group.length(); i++) {
            gsum*=(Character.getNumericValue(group.charAt(i))-9);
        }
        if (gsum%47==csum%47) {
            pw.println("GO");
        } else {
            pw.println("STAY");
        }
        pw.close();
    }
}
