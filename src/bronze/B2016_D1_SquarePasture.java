package bronze;
import java.util.*;
import java.io.*;

public class B2016_D1_SquarePasture {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("square.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("square.out"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] xs = new int[4];
        int[] ys = new int[4];

        xs[0] = Integer.parseInt(st.nextToken());
        ys[0] = Integer.parseInt(st.nextToken());
        xs[1] = Integer.parseInt(st.nextToken());
        ys[1] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        xs[2] = Integer.parseInt(st.nextToken());
        ys[2] = Integer.parseInt(st.nextToken());
        xs[3] = Integer.parseInt(st.nextToken());
        ys[3] = Integer.parseInt(st.nextToken());

        Arrays.sort(xs);
        Arrays.sort(ys);

        pw.print((int) Math.pow(Math.max(xs[3]-xs[0], ys[3]-ys[0]), 2));
        pw.close();
    }
}
