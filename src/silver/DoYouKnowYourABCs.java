import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DoYouKnowYourABCs {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> al = new ArrayList<>();

        for (int i = 0; i<7; i++) {
            al.add(Integer.parseInt(st.nextToken()));
        }

        BubbleSort(al, al.size());
        
        int A = al.get(0);
        int B = al.get(1);
        int C = al.get(6)-(A+B);

        pw.print(A);
        pw.print(" ");
        pw.print(B);
        pw.print(" ");
        pw.print(C);
        pw.close();
    }

    static void BubbleSort(ArrayList<Integer> ar, int it) {
        int len = it;
        int swaps=0;

        for (int i = 0; i<len-1; i++) {
            if (ar.get(i)>ar.get(i+1)) {
                swaps+=1;

                int temp = ar.get(i);
                ar.set(i, ar.get(i+1));
                ar.set(i+1, temp);
            }
        }

        if (swaps!=0) {
            BubbleSort(ar, it-1);
        }
    }
}