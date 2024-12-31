public class AscendingPrint{
    public static void main(String[] args) {
        printNumbers(5);
    }
    static void printNumbers(int N) {
        double n = (double) N;
        int s = (int) Math.pow(10.0, n-1);
        int m = (int) Math.pow(10.0, n);
        
        printN(s, m);
    }
    
    static void printN(int cur, int max) {
        if (cur>=max) {return;}
        else {
            System.out.println(cur);
            printN(cur+1, max);
        }
    }
}