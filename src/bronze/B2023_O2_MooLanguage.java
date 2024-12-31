package bronze;
import java.util.*;
import java.io.*;

public class B2023_O2_MooLanguage {
    static ArrayList<ArrayList<String>> result;
    static int wc;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        result = new ArrayList<>();
        wc = 0;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            ArrayList<String> nouns = new ArrayList<>();
            ArrayList<String> iv = new ArrayList<>();
            ArrayList<String> tv = new ArrayList<>();
            ArrayList<String> con = new ArrayList<>();
            result.removeAll(result);
            wc = 0;

            for (int j = 0; j<n; j++) {
                st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                String type = st.nextToken();

                if (type.equals("noun")) {
                    nouns.add(str);
                } else if (type.equals("intransitive-verb")) {
                    iv.add(str);
                } else if (type.equals("transitive-verb")) {
                    tv.add(str);
                } else if (type.equals("conjunction")) {
                    con.add(str);
                }
            }

            test(n,c,p,nouns,iv,tv, con);
            wc+=Math.min(con.size(), result.size()/2);
            pw.println(wc);
            wc = 0;
            for (int l = 0; l<result.size(); l++) {
                ArrayList<String> sentence = result.get(l);
                for (int k = 0; k<sentence.size(); k++) {
                    pw.print(sentence.get(k));
                    if (k>=2 && k<sentence.size()-1) {
                        pw.print(", ");
                    } else if(k<=1 && k<sentence.size()-1) {
                        pw.print(" ");
                    } else if (k == sentence.size()-1){
                        if (l == result.size()-1) {
                            pw.print(".");
                        } else if (l%2 == 1) {
                            pw.print(". ");
                        }
                        else if (con.size() == 0) {
                            pw.print(".");
                            if (l<result.size()-1){pw.print(" ");}
                        } else if (l%2 == 0 && con.size()!=0) {
                            pw.print(" " + con.remove(0) + " ");
                        }
                    }
                }
            }
            pw.println();
        }
        pw.close();
    }

    public static void test(int n, int c, int p, ArrayList<String> nouns, ArrayList<String> iv, ArrayList<String> tv, ArrayList<String> con) {
        int numN = nouns.size();
        int numIV = iv.size();
        int numTV = tv.size();
        int numCON = con.size();
        p+=numCON-1;

        int sentences = 0;

        ArrayList<ArrayList<String>> queue = new ArrayList<>();
        int tvSentences = 0;
        int tvMax = Math.min(numTV, numN/2);
        for (int i = 0; i<tvMax && sentences<=p; i++) {
            ArrayList<String> added = new ArrayList<>();
            added.add(nouns.remove(0));
            added.add(tv.remove(0));
            added.add(nouns.remove(0));
            numN-=2;
            numTV--;
            queue.add(added);

            tvSentences++;
            sentences++;
            wc+=3;
        }

        int ivMax = Math.min(numIV, numN);
        for (int i = 0; i<ivMax&& sentences<=p; i++) {
            ArrayList<String> added = new ArrayList<>();
            added.add(nouns.remove(0));
            added.add(iv.remove(0));
            numN--;
            numIV--;

            result.add(added);
            sentences++;
            wc+=2;
        }

        for (int i = 0; i<Math.min(c+1, Math.min(numN, tvSentences)); i++) {
            ArrayList<String> added = queue.get(i);
            added.add(nouns.remove(0));
            numN--;
            wc++;
        }

        for (ArrayList<String> sentence : queue) {
            result.add(sentence);
        }
    }
}
