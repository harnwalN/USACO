import java.util.*;
import java.io.*;

public class Leaders_J1_23 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        boolean[] breeds = new boolean[n+1]; // false=G, true=H, start from index 1
        String str = br.readLine();
        String es = br.readLine();
        String[] Es = es.split("\\s");
        int[] e = new int[n+1];
        int u = 1;
        for (String el : Es) {
            e[u] = Integer.parseInt(el);
            u++;
        }

        int firstG=-1;
        int ge =0;
        int firstH=-1;
        int he=0;
        HashSet<Integer> hset = new HashSet<>();
        HashSet<Integer>gset = new HashSet<>();
        HashSet<Integer> ohset = new HashSet<>();
        HashSet<Integer> ogset = new HashSet<>();

        for (int i = 0; i<n; i++) {
            Boolean bool = str.substring(i, i+1).equals("H");
            breeds[i+1] = bool;
            if (bool){
                hset.add(i+1);
                ohset.add(i+1);
            }
            else {
                gset.add(i+1);
                ogset.add(i+1);
            }

            if (firstG==-1 && !bool) {
                firstG = i+1;
                ge = e[i+1];
            } else if (firstH==-1 && bool) {
                firstH = i+1;
                he = e[i+1];
            }
        }
        int[] two = new int[2];
        two[0] = 0;
        two[1] = 1;

        boolean hS = false;
        boolean gS = false;

        for (int j : two) {
            int first;
            int the;
            HashSet<Integer> set;
            if (j == 0) {
                first = firstH;
                the = he;
                set = hset;
            } else {
                first = firstG;
                the = ge;
                set = gset;
            }

            for (int i = first; i<=the; i++) {
                if(set.contains(i)) {
                    set.remove(i);
                }
                if (set.isEmpty()) {
                    if (j==0) {
                        hS = true;
                    }
                    else {
                        gS = true;
                    }
                    break;
                }
            }
        }
        int x = 0;
        if (gS) {
            for (int i = 1; i<firstG; i++) {
                if (e[i]>=firstG && ohset.contains(i)) {x++;}
            }
        }
        int y = 0;
        if (hS) {
            for (int i = 1; i<firstH; i++) {
                if (e[i]>=firstH && ogset.contains(i)) {
                    y++;
                }
                
            }
        }
        if (hS && gS) {x++;}
        pw.println(x+y);
        pw.close();
    }
}