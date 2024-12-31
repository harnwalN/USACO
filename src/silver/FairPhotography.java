import java.util.*;
import java.io.*;

public class FairPhotography {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new FileReader("fairphoto.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("fairphoto.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int n = Integer.parseInt(st.nextToken());
    Cow[] cows = new Cow[n];
    int[][] prefixBreed = new int[n][2]; //(index, (G sum, H sum))
    
    int G_rs = 0;
    int H_rs = 0;
    
    for (int i = 0; i<n; i++) {
        st = new StringTokenizer(br.readLine());
        cows[i] = new Cow();
        cows[i].x = Integer.parseInt(st.nextToken());
        cows[i].breed = st.nextToken();
    }
    
    Arrays.sort(cows);
    
    for (int i = 0; i<n; i++) {
        if (cows[i].breed.equals("G")) {
            G_rs+=1;
        } else if (cows[i].breed.equals("H")) {
            H_rs+=1;
        }
        prefixBreed[i][0] = G_rs;
        prefixBreed[i][1] = H_rs;
    }
        
    int start = 0;
    int end = 0;
    int max = -1;
    boolean g_present = false;
    boolean h_present = false;
    int[] wbc = new int[2]; // window breed count
    boolean go = true;
    
    while (go == true) {
        if (start == end) {
            if (start == 0){
                wbc[0] = prefixBreed[end][0];
                wbc[1] = prefixBreed[end][1];
            }
            else {
                wbc[0] = prefixBreed[start-1][0];
                wbc[1] = prefixBreed[start-1][1];
            }
        } else {
            if (start == 0) {
                wbc[0] = 0;
                wbc[1] = 0;
            } else{
                wbc[0] = prefixBreed[end][0] - prefixBreed[start-1][0]; // G
                wbc[1] = prefixBreed[end][1] - prefixBreed[start-1][1]; // H
            }
        }
        
        if (wbc[0] > 0) {
            g_present = true;
        } else {
            g_present = false;
        }
        if (wbc[1] > 0) {
            h_present = true;
        } else {
            h_present = false;
        }
        
        if (cows[end].x-cows[start].x>max) {
            if (g_present && h_present && wbc[0] == wbc[1]) {
                max = cows[end].x-cows[start].x;
            } else if ((g_present && !h_present) || (!g_present && h_present)) {
                max = cows[end].x-cows[start].x;
            }
        }

        if (end < n) {
            if (wbc[0]>wbc[1]) {
                end+=wbc[0]-wbc[1];
            }
            if (wbc[1]>wbc[0]) {
                end+=wbc[1]-wbc[0];
            }
            if (end>n-1) {
                start+=1;
                end=start;
            }

            /*pw.print("start end: ");
            pw.print(start);
            pw.print(" ");
            pw.println(end);

            pw.print("wbc: ");
            pw.print(wbc[0]);
            pw.print(" ");
            pw.println(wbc[1]);

            pw.println(max);*/
        } else if (start<n && end>=n) {
            start+=1;
            end = start;
            /*pw.print("start end: ");
            pw.print(start);
            pw.print(" ");
            pw.println(end);

            pw.print("wbc: ");
            pw.print(wbc[0]);
            pw.print(" ");
            pw.println(wbc[1]);

            pw.println(max);*/
        } else {
            go = false;

            /*pw.print("start end: ");
            pw.print(start);
            pw.print(" ");
            pw.println(end);

            pw.print("wbc: ");
            pw.print(wbc[0]);
            pw.print(" ");
            pw.println(wbc[1]);*/

            pw.print(max);
        }
        //pw.println("---------------");
    }

    pw.close();
}
  
  static class Cow implements Comparable<Cow> {
    String breed;
    int x;
    
    Cow() {
        this.x = -1;
        this.breed = null;
    }
    
    Cow(int x, String breed) {
      this.x = x;
      this.breed = breed;
    }
    
    public int compareTo(Cow other) {
      return this.x - other.x;
    }

    public String toString() {
        return breed + " " + x;
    }
  }
}
