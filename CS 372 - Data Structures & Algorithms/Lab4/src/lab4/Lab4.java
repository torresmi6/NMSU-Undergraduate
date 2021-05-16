package lab4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Lab4 {

	public static void bfs() {
		
		HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
		Scanner scnr = new Scanner(System.in);
		HashMap<Integer, List<Integer>> edges = new HashMap<Integer, List<Integer>>();
		int v1 = 0, v2, start = -1;
		System.out.println("Enter number of vertices and edges:");
		scnr.nextLine();
		
		System.out.println("Enter Line of edges (type exit in last line to quit)");
		while(scnr.hasNextInt()) {
			v1 = scnr.nextInt();
			if(start < 0) {
				start = v1;
			}
			
			if(!visited.containsKey(v1)) {
				visited.put(v1, false);
			}
			if(edges.containsKey(v1)) {
				v2 = scnr.nextInt();
				edges.get(v1).add(v2);
				
				if(!visited.containsKey(v2)) {
					visited.put(v2, false);
				}
			}
			else {
				edges.put(v1, new ArrayList<Integer>(0));
				v2 = scnr.nextInt();
				edges.get(v1).add(v2);
				
				if(!visited.containsKey(v2)) {
					visited.put(v2, false);
				}
			}
		}
		
		Queue<Integer> vert = new LinkedList<>();
		vert.add(start);
		int temp;
		while(!vert.isEmpty()) {
			temp = vert.remove();
			System.out.print(temp + " ");
			visited.put(temp, true);
			if(edges.get(temp) != null) {
				for(int i = 0; i < edges.get(temp).size(); i++) {
					if(visited.get(edges.get(temp).get(i)) == false) {
						vert.add(edges.get(temp).get(i));
					}
				}
			}
		}
		
	}
	
	public static void shortestPath() {
		
		HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
		Scanner scnr = new Scanner(System.in);
		HashMap<Integer, List<Integer>> edges = new HashMap<Integer, List<Integer>>();
		int v1 = 0, v2, start = -1, path = 0;
		System.out.println("Enter number of vertices and edges:");
		int dest = scnr.nextInt() - 1;
		scnr.nextLine();
		
		
		System.out.println("Enter Line of edges (type exit in last line to quit)");
		while(scnr.hasNextInt()) {
			v1 = scnr.nextInt();
			if(start < 0) {
				start = v1;
			}
			
			if(!visited.containsKey(v1)) {
				visited.put(v1, false);
			}
			if(edges.containsKey(v1)) {
				v2 = scnr.nextInt();
				edges.get(v1).add(v2);
				
				if(!visited.containsKey(v2)) {
					visited.put(v2, false);
				}
			}
			else {
				edges.put(v1, new ArrayList<Integer>(0));
				v2 = scnr.nextInt();
				edges.get(v1).add(v2);
				
				if(!visited.containsKey(v2)) {
					visited.put(v2, false);
				}
			}
		}
		
		Queue<Integer> vert = new LinkedList<>();
		HashMap<Integer, Integer> back = new HashMap<Integer, Integer>();
		
		vert.add(start);
		int temp;
		while(!vert.isEmpty()) {
			temp = vert.remove();
			if(temp == dest) {
				while(temp != start) {
					path++;
					temp = back.get(temp);
				}
				System.out.println(path);
				break;
			}
			visited.put(temp, true);
			if(edges.get(temp) != null) {
				for(int i = 0; i < edges.get(temp).size(); i++) {
					if(visited.get(edges.get(temp).get(i)) == false) {
						vert.add(edges.get(temp).get(i));
						back.put(edges.get(temp).get(i), temp);
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) {

		bfs();
		System.out.println();
		shortestPath();
	}

}
