import java.io.*;
import java.util.*;

public class ballet {
	public static boolean works = true;
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		int n = Integer.parseInt(br.readLine());
		String[] inst = new String[n];
		for (int i = 0; i<n; i++) {
			inst[i] = br.readLine();
		}

		Cow cow = new Cow();
		int[][] returned = sim(inst, cow);
		int dX = Math.abs(returned[0][0] - returned[1][0])+1;
		int dY = Math.abs(returned[0][1] - returned[1][1])+1;

		if (works == false) {
			pw.print(-1);
		} else {
			pw.println(dX*dY);
		}
		pw.close();
	}

	public static int[][] sim(String[] instr, Cow cow) {
		for (String inst : instr) {
			String leg = inst.substring(0,2);
			String mvmt = inst.substring(2,3);

			int check = cow.move(leg, mvmt);
			if (check == -1) {
				works = false;
				return new int[0][0];
			}
		}
		return cow.getMax();
	}

	public static class Cow {
		int[] FLpos;
		int[] FRpos;
		int[] RLpos;
		int[] RRpos;

		int[] max;

		int[] min;
		/*
		Starting config:

		FL(0,1) FR(1,1)
		RL(0,0) RR(1,0)

		*/
		int dir = 0; // 0 north, 1 east, 2 south, 3 west

		HashMap<String, int[]> pos = new HashMap<>();


		public Cow(){
			max = new int[2];
			max[0] = 1;
			max[1] = 1;

			min = new int[2];
			min[0] = 0;
			min[1] = 0;

			FLpos = new int[2];
			FLpos[0] = 0;
			FLpos[1] = 1;

			FRpos = new int[2];
			FRpos[0] = 1;
			FRpos[1] = 1;

			RLpos = new int[2];
			RLpos[0] = 0;
			RLpos[1] = 0;

			RRpos = new int[2];
			RRpos[0] = 1;
			RRpos[1] = 0;

			pos.put("FL", FLpos);
			pos.put("FR", FRpos);
			pos.put("RL", RLpos);
			pos.put("RR", RRpos);
		}

		int move(String leg, String way) {
			//System.out.println("move " + leg + " " + way);
			int[] lpos = pos.get(leg);
			dir%=4;
			if (way.equals("F")) {
				if (dir == 0) { // North
					lpos[1] +=1;
				} else if (dir == 1) { // East
					lpos[0] +=1;
				} else if (dir == 2) { // South
					lpos[1] -=1;
				} else if (dir == 3) { // West
					lpos[0] -=1;
				}
				checkMax(lpos);
			} else if(way.equals("B")) {
				if (dir == 0) { // North
					lpos[1] -=1;
				} else if (dir == 1) { // East
					lpos[0] -=1;
				} else if (dir == 2) { // South
					lpos[1] +=1;
				} else if (dir == 3) { // West
					lpos[0] +=1;
				}
				checkMax(lpos);
			} else if (way.equals("P")) {
				//System.out.println("Pivoting from ("+lpos[0]+","+lpos[1]+")");
				for (int[] oleg : pos.values()) {
					//System.out.print("("+oleg[0]+","+oleg[1]+") --> ");
					int dX = oleg[0]-lpos[0];
					int dY = oleg[1]-lpos[1];
					oleg[0] = dY+lpos[0];
					oleg[1] = (-1*dX)+lpos[1];
					//System.out.println("("+oleg[0]+","+oleg[1]+")");
				}
				dir+=1;
				//System.out.println("Pivoted");
				checkMax();
			}
			int check = 0;
			for (int[] p : pos.values()) {
				if (Arrays.equals(p, lpos)) {check+=1;}
			}
			if (check>=2) {return -1;}
			else {return 1;}
		}

		private void checkMax(int[] lpos) {
			max[0] = Math.max(max[0], lpos[0]);
			max[1] = Math.max(max[1], lpos[1]);

			min[0] = Math.min(min[0], lpos[0]);
			min[1] = Math.min(min[1], lpos[1]);
		}
		private void checkMax() {
			for (int[] leg : pos.values()) {
				checkMax(leg);
			}
		}

		public int[][] getMax() {
			int[][] returned = new int[2][2];
			returned[0] = max;
			returned[1] = min;
			return returned;
		}

		public HashMap<String, int[]> getEnd() {
			/* System.out.println("Final: ");
			for (String str : pos.keySet()) {
				int[] leg = pos.get(str);
				System.out.println(str+": ("+leg[0]+","+leg[1]+")");
			}*/
			return pos;
		}
	}	
}