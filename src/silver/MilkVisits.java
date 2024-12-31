// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class MilkVisits {
	static Node[] nodes;
	static Edge[] edges;
	static Trip [] trips;
	static int n;
	static int m;
	static int[] SP;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new FileWriter("milkvisits.out"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		String breedsString = br.readLine();
		String[] breeds = new String[n];
		for (int i = 0; i<n; i++) {
			breeds[i] = breedsString.substring(i, i+1);
		}

		nodes = new Node[n];
		edges = new Edge[n-1];
		trips = new Trip[m];
		SP = new int[n-1];

        for (int i = 0; i<n; i++) {
			Node node = new Node(i+1, breeds[i]);
			nodes[i] = node; // to get node #i, get nodes[i-1];
		}

		for (int i = 0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			Edge edge = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			edges[i] = edge;
		}

		for (int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			Trip trip = new Trip(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), st.nextToken());
			trips[i] = trip;
		}

		final long startTime = System.currentTimeMillis();

		for (int i = 0; i<m; i++) {
			if (check(trips[i]) == true) {
				SP = new int[n-1];
				pw.print("1");
			} else {
				SP = new int[n-1];
				pw.print("0");
			}
		}

		pw.close();
		final long endTime = System.currentTimeMillis();

		System.out.println("Total execution time: " + (endTime - startTime));
	}

	public static boolean check (Trip trip) {
		int start = trip.getStart();
		int end = trip.getEnd();
		String n_breed = trip.getBreed();

		if (start == end) {
			if (nodes[start-1].getBreed().equals(n_breed)) {
				return true;
			} else {
				return false;
			}
		}

		int[] path = new int[n];
		int[] solved_path = new int[n];
		HashSet<Integer> visited = new HashSet<>();
		DFS(start, end, path, 0, visited, solved_path);

		for (int el: SP) {
			if ((el!=0) && nodes[el-1].getBreed().equals(n_breed)) {
				return true;
			}
		}
		return false;
	}

	public static void DFS (int current, int end, int[] path, int pathIndex, HashSet<Integer> visited, int[] solved_path) {
		
		path[pathIndex] = current; // update the path

		if (SP[0] != 0) {
			return;
		}
		
		
		if (current == end) { // if we have found the node we're looking for, return its path
			for (int i = 0; i<n-1; i++) {
				SP[i] = path[i];
			}
		}

		// If this is not the right node:
		ArrayList<Integer> un_poss = Edge.checkEdges(nodes[current-1]); // possible branches of this node to search
		ArrayList<Integer> poss = new ArrayList<>();
		HashSet<Integer> pathnums = new HashSet<>();
		for (int i = 0; i<=pathIndex; i++) {
			pathnums.add(path[i]);
		}
		for (int el:un_poss) {
			if (!pathnums.contains(el)) {
				poss.add(el);
			}
		}

		boolean searched = visited.contains(current); // has this been searched before?
		if (searched) {
			return; // go back to search loop
		}

		for (int el : poss) {
			if (!visited.contains(el)) { // if there is an searched branch, search it
				DFS(el, end, path, pathIndex+1, visited, solved_path);
			}
		}

		// if code reaches here, the end is not in this branch
		path[pathIndex] = 0;
		visited.add(current); // if we have exhausted all branches, mark the current node as searched
		return; // go back to parent loop search
	}

	public static class Trip {
		int start;
		int end;
		String breed;

		public Trip(int s, int e, String b) {
			start = s;
			end = e;
			breed = b;
		}

		public int getStart() {
			return start;
		}

		public int getEnd() {
			return end;
		}

		public String getBreed() {
			return breed;
		}
	}

	public static class Node {
		int number;
		String breed;

		public Node(int num, String c) {
			number = num;
			breed = c;
		}

		public Node(int num, String c, boolean vis) {
			number = num;
			breed = c;
		}

		public int getNumber() {
            return number;
        }

		public String getBreed() {
			return breed;
		}
	}

	public static class Edge {
		int node1;
		int node2;
		static int index = 0;

		public Edge(int n1, int n2) {
			node1 = n1;
			node2 = n2;
		}

		public int contains(int target) {
			if ((node1==target)) {
				return node2;
			}
			if (node2==target){
				return node1;
			}

			else return -1;
		}
		public static ArrayList<Integer> checkEdges(Node n1) {
            ArrayList<Integer> out = new ArrayList<>();
			int number = n1.getNumber();
			for (Edge edge : edges) {
				int num = edge.contains(number);
				if (num!=-1) {
					out.add(num);
				}
			}
            return out;
		}
	}
}
