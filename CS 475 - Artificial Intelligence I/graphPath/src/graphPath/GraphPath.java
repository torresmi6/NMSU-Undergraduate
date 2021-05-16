// Michael Torres
// GraphPath
// Finding a path assignment
// Finds a path between 2 nodes in a given graph from a formatted txt file.
// 2-9-21
package graphPath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class GraphPath {

	
	public static void findPath(String file) throws IOException {
		
		//Insert test files in src folder
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String currentLine = reader.readLine();

		boolean duplicate = false;
		int numNodes = 0;
		int start = 0;
		int end = 0;
		String[] fileLine = new String[3];
		
		try { 
			fileLine = currentLine.split(" ");
			numNodes = Integer.parseInt(fileLine[0]);
			start = Integer.parseInt(fileLine[1]);
			end = Integer.parseInt(fileLine[2]);
		} 
		
		catch(Exception e){
			System.out.println("Input file is not formatted correctly");
		}
		
		// make array of linked lists. The index is the node, the integers in the lists, are those connected to that node
		LinkedList<Integer>[] graph = new LinkedList[numNodes + 1];
				
		while((currentLine = reader.readLine()) != null) {
			try { 
				fileLine = currentLine.split(" ");
			}
			catch(Exception e){
				System.out.println("Input file is not formatted correctly");
			}
			// put edge into graph array. Add second node to first node's list and vice versa
			if(graph[Integer.parseInt(fileLine[0])] == null) {
				graph[Integer.parseInt(fileLine[0])] = new LinkedList<Integer>();
			}
			
			if(graph[Integer.parseInt(fileLine[1])] == null) {
				graph[Integer.parseInt(fileLine[1])] = new LinkedList<Integer>();
			}
			
			graph[Integer.parseInt(fileLine[0])].add(Integer.parseInt(fileLine[1]));
			graph[Integer.parseInt(fileLine[1])].add(Integer.parseInt(fileLine[0]));
			
		}
		
		// Graph nodes are linked by edges at this point in linked lists
		ArrayList<Integer> path = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> possible = new ArrayList<ArrayList<Integer>>();
		
		// Path starts at start node
		path.add(start);
		
		// Add the initial possible paths from the start node
		for(int i = 0; i < graph[start].size(); i++){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(start);
			temp.add(graph[start].get(i));
			possible.add(temp);
		}
		
		while(possible.isEmpty() == false) {
		
			path = possible.remove(possible.size()-1);
		
			//System.out.println("Path: " + path);
			//System.out.println("Possible: " + possible);
			
			// If end of path is the goal num, print out path and return
			if(path.get(path.size()-1) == end) {
				System.out.println("Solution: " + path);
				return;
			}
			// loop through linked list at the last node of path
			for(int i = 0; i < graph[path.get(path.size()-1)].size(); i++) {
				duplicate = false;
				for(int a = 0; a < path.size(); a++) {
					if(graph[path.get(path.size()-1)].get(i) == path.get(a)) {
						duplicate = true;
					}
				}
				
				if(duplicate == false) {
					ArrayList<Integer> tempPos = new ArrayList<Integer>();
					for(int b = 0; b < path.size(); b++) {
						tempPos.add(path.get(b));
					}
					tempPos.add(graph[path.get(path.size()-1)].get(i));
					possible.add(tempPos);
				}
			}
		}

		// By this point, all possibilities have been looked at, there is no solution
		System.out.println("No Solution");
	}
	
	// Tests 4 different test cases.
	// 1 and 2 are both solvable standard graphs
	// 3 is unsolvable as it is technically 2 unconnected graphs
	// 4 is a duplicate of 3, except it has one extra connection that connects the two graphs
	public static void main(String[] args) {
		
		String file1 = "src/test1.txt";
		String file2 = "src/test2.txt";
		String file3 = "src/test3.txt";
		String file4 = "src/test4.txt";
		try {
		findPath(file1);
		findPath(file2);
		findPath(file3);
		findPath(file4);
		}
		catch(Exception e) {
			System.out.println("Can't read file");
		}
	}

}
