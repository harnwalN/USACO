import java.io.*;

public class MadScientist {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("breedflip.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("breedflip.out"));


        int n = Integer.parseInt(br.readLine());
        String wanted = br.readLine();
        String has = br.readLine();

        int flips = 0;
        boolean streak = false;

        for (int i = 0; i<n; i++) {
            if (wanted.substring(i,i+1).equals(has.substring(i,i+1))) {
                if (streak == true) {
                    streak = false;
                    flips+=1;
                }
            } else {
                streak = true;
            }
        }

        pw.print(flips);
        pw.close();
    }
}

/*
 * Find error, and keep going until no error and flip that string
 * Have Variable to keep track of how many flips
 * Boolean that starks at false to keep track if you are currently in an error streak
 * if chart at index for present equals char at wanted, check if boolean error streak true
 * if true, keep going
 * if false, add one to flips and make boolean false again
 * Output flips
 */