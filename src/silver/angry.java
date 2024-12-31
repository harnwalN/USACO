// http://www.usaco.org/index.php?page=viewproblem2&cpid=594
// "Angry Cows"
 
import java.util.*;
import java.io.*;
 
public class angry {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("angry.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("angry.out"));
    String j1902 = br.readLine();
    String[] str = j1902.split("\\s");
    int n = Integer.parseInt(str[0]);
    int k = Integer.parseInt(str[1]);
    
    int[] index = new int[n];
    HashSet<Integer> bales = new HashSet<>();
    
    for (int i = 0; i<n; i++) {
        int input = Integer.parseInt(br.readLine()); 
        bales.add(input);
        index[0] = (input);
    }
    
    Arrays.sort(index);

    int min = 0;
    int max = 1000000000;

    int r = 0;

    while(min<max) {
        int midp = (max+min)/2;
        if (check(midp, n, index, bales, k)==true) {
            max=midp;
            r=midp;
        } else{
            min = midp+1;
        }
    }

    pw.print(r);
    pw.close();

  }

  static boolean check(int r, int n, int[] index, HashSet bales, int k) {
    int len = 2*r;

    int used = 0;
    int needed = n;
    int availible = k;

    int pos = index[0];

    int last;
    int next;
    int b = 0;
    int last_ind = 0;

    while (needed!=0 && used!=availible+1){
        pos+=len;
        for (int i = index[last_ind]; i<pos; i++) {
            if (bales.contains(i)) {
                last_ind+=1;
                needed-=1;
            }
        }
        last_ind +=1;
        pos = index[last_ind];
        used+=1;
    }

  if (needed==0) {
    return true;
  } else {
    return false;
  }

}
}


 
/* ANALYSIS
    N = 7, number of hay bales
    K = 2, number of angry cows given
    find R, minimum power of cow to explode all bales in K attempts
    
    |-------------------------------------------------------------------------------...--|
    (0) 1  3       8   10          18  20      25                                                       
 
 
    Test R:
        Sliding window with range 2R
 
    Binary search through values of R in order to find a working value
*/
 
