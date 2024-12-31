package bronze;
import java.io.*;

public class B2018_F1_Teleportation{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("teleport.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("teleport.out"));

        String str = br.readLine();
        String[] str2 = str.split("\\s");

        int a = Integer.parseInt(str2[0]);
        int b = Integer.parseInt(str2[1]);

        int x = Integer.parseInt(str2[2]);
        int y = Integer.parseInt(str2[3]);

        int min = Math.abs(a-b);

        min = Math.min(min, Math.abs(a-x) + Math.abs(y-b)); // ax yb

        min = Math.min(min, Math.abs(a-y) + Math.abs(b-x));

        pw.println(min);
        pw.close();
        br.close();
    }
}