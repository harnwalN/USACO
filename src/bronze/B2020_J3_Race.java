package bronze;
import java.io.*;
import java.util.*;

public class B2020_J3_Race {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter pw = new PrintWriter(System.out);

        BufferedReader br = new BufferedReader(new FileReader("race.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("race.out"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int dist = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i<n; i++) {
            pw.println(test(Integer.parseInt(br.readLine()), dist));
        }

        pw.close();
    }

    public static int test(int x, int dist) {
        if (sum(x)>=dist) {
            while(sum(x)>=dist+x) {
                x--;
            }
            if(sum(x)>=dist) {
                return x;
            }
            else {
                return test(x, dist);
            }
        }

        else {
            int place = sum(x);
            int time = x;
            int trying = x;
            int left = dist-place;

            while(true) {
                if((sum(trying+1)-sum(x))+(sum(trying)-sum(x))<=left-1) {
                    place = sum(x)+(sum(trying+1)-sum(x)+(sum(trying)-sum(x)));
                    trying+=1;
                }
                else {
                    break;
                }
            }

            if (trying>x){time+=(trying-x)+(trying-x)-1;}
            if (place<dist-x) {
                left = dist-place-x;
                while(place<dist-x) {
                    if (left<=trying) {time++;break;}
                    else {
                        left-=trying;
                        place+=trying;
                        time++;
                    }
                }
            }
            return time+1;
        }
    }

    public static int sum(int i) {
        if (i%2==0) {
            return i/2*(i+1);
        } else {
            return i + (((i-1)/2)*(i));
        }
    }
}
