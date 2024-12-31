package bronze;
import java.io.*;
import java.util.*;

public class B2016_O2_BullInAChinaShop {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter pw = new PrintWriter(System.out);

        BufferedReader br = new BufferedReader(new FileReader("bcs.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("bcs.out"));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] og = new int[n+1][n+1];
        int[] ogparams = new int[4];
        for (int i = 1 ; i<=n; i++) {
            String line = br.readLine();
            for (int j = 1; j<=n; j++) {
                if (line.substring(j-1, j).equals(".")) {
                    og[i][j] = 0;
                } else {
                    og[i][j] = 1;
                    ogparams[0] = Math.min((ogparams[0]==0 ? j : ogparams[0]), j);
                    ogparams[1] = Math.max((ogparams[1]==0 ? j : ogparams[1]), j);
                    ogparams[2] = Math.min((ogparams[2]==0 ? i : ogparams[2]), i);
                    ogparams[3] = Math.max((ogparams[3]==0 ? i : ogparams[3]), i);
                }
            }
        }
        boolean[] works = new boolean[k+1];
        int[][] w = new int[k+1][2];
        int[][] params = new int[k+1][4]; 
        int[][][] pieces = new int[k+1][n+1][n+1];
        for (int i = 1; i<=k; i++) {
            int[][] piece = pieces[i];
            int[] param = params[i];
            for (int row = 1; row<=n; row++) {
                String line = br.readLine();
                for (int col = 1; col<=n; col++) {
                    if (line.substring(col-1, col).equals(".")) {
                        piece[row][col] = 0;
                    } else {
                        piece[row][col] = 1;
                        param[0] = Math.min((param[0]==0 ? col : param[0]), col);
                        param[1] = Math.max((param[1]==0 ? col : param[1]), col);
                        param[2] = Math.min((param[2]==0 ? row : param[2]), row);
                        param[3] = Math.max((param[3]==0 ? row : param[3]), row);
                    }
                }
            }
        }
        /*pw.println("og: ");
        for (int i = 0; i<4; i++) {pw.print(ogparams[i]+" ");}
        pw.println();

        for (int i = 1; i<=k; i++) {
            pw.println(i+": ");
            int[] param = params[i];
            for (int j = 0; j<4; j++) {
                pw.print(param[j]+" ");
            }
            pw.println();
        }*/

        for (int p = 1; p<=k; p++) {
            int[][] piece = pieces[p];
            int[] param = params[p];
            for (int startrow = ogparams[2]; startrow<=ogparams[2]+(ogparams[3]-ogparams[2]+1)-(param[3]-param[2]+1); startrow++) {
                for (int startcol = ogparams[0]; startcol<=ogparams[0]+(ogparams[1]-ogparams[0]+1)-(param[1]-param[0]+1); startcol++) {
                    boolean worked = true;
                    for (int i = startrow; i<startrow+(param[3]-param[2]+1); i++) {
                        for (int j = startcol; j<startcol+(param[1]-param[0]+1); j++) {
                            if (!(piece[i-startrow+param[2]][j-startcol+param[0]] == 1 && og[i][j] == 0)) {
                                continue;
                            } else {
                                worked = false;
                                break;
                            }
                        }
                        if (!worked){break;}
                    }
                    if (worked) {
                        works[p] = true;
                        w[p][0] = startrow;
                        w[p][1] = startcol;
                        break;
                    }
                }
                if (works[p]) {
                    break;
                }
            }
        }
        /*int l = 0;
        for (int i = 1; i<=k; i++) {
            if (works[i]) {
                pw.print(i+" ");
                l=i;
                break;
            }
        }
        for (int i = 1; i<=k; i++) {
            if (works[i]&&i!=l) {
                pw.print(i);
                break;
            }
        }*/

        for (int x = 1; x<=k; x++) {
            if (!works[x]) {continue;}

            int r1 = w[x][0];
            int c1 = w[x][1];
            int[][] p1 = pieces[x];
            int[] par1 = params[x];
            int[][] test = new int[n+1][n+1];
            for (int i = 1;  i<=n; i++) {
                for (int j = 1; j<=n; j++) {
                    test[i][j] = og[i][j];
                }
            }

            for (int i = r1; i<r1+(par1[3]-par1[2]+1); i++) {
                for (int j = c1; j<c1+(par1[1]-par1[0]+1); j++) {
                    if (test[i][j]==1 && p1[i-r1+par1[2]][j-c1+par1[0]]==1) {
                        test[i][j]-=1;
                    }
                }
            }

            int[][] testKeeper = new int[n+1][n+1];
            for (int i = 1;  i<=n; i++) {
                for (int j = 1; j<=n; j++) {
                    testKeeper[i][j] = test[i][j];
                }
            }

            boolean ye = true;

            for (int y = 1; y<=k; y++) {
                if (!works[y]||y==x) {continue;}

                int r2 = w[y][0];
                int c2 = w[y][1];
                int[][] p2 = pieces[y];
                int[] par2 = params[y];
                for (int l = 1;  l<=n; l++) {
                    for (int j = 1; j<=n; j++) {
                        test[l][j] = testKeeper[l][j];
                    }
                }

                for (int i = r2; i<r2+(par2[3]-par2[2]+1); i++) {
                    for (int j = c2; j<c2+(par2[1]-par2[0]+1); j++) {
                        if (p2[i-r2+par2[2]][j-c2+par2[0]]==1 ) {
                            if (test[i][j]==0) {
                                ye=false;
                                break;
                            } else {
                                test[i][j]-=1;
                            }
                        }
                    }
                    if (!ye) {
                        break;
                    }
                }
                if (ye) {
                    for (int f = 1; f<=k; f++) {
                        for (int g = 1; g<=k; g++) {
                            if (!(test[f][g]==0)) {
                                ye = false;
                            }
                        }
                    }
                    if (!ye) {continue;}
                    if (x>y) {
                        pw.println(y+" "+x);
                        pw.close();return;
                    } else{
                        pw.println(x+" "+y);
                        pw.close();return;
                    }
                }
            }
        }
        pw.close();
    }
}