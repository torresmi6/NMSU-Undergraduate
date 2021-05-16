package vacuumMidterm;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import aima.core.search.framework.problem.Problem;
import aima.core.search.uniformed.DepthFirstSearch;
import aima.core.search.framework.qsearch.GraphSearch;

public class vacuumProblem implements Problem<char[], char[]>{

	char[] initialState = new char[4];
	
	// An input prompt will appear at runtime.
	// Input the initial state.
	// The first character is where the vacuum starts at. Ex) A, B, or C
	// The next input is if there is dirt or not in room A	1 = dirty  0 = clean
	// The next input is if there is dirt or not in room B	1 = dirty  0 = clean
	// The last input is if there is dirt or not in room C	1 = dirty  0 = clean
	// Ex) A 1 1 1 means the vacuum starts in room A and all rooms are dirty
	public static void main(String[] args) {
		
		char[] initialState = new char[4];
		Scanner scnr = new Scanner(System.in);
		System.out.println("Input Initial State (Ex -> A 1 1 1) Use different lines for each character:");
		for(int i = 0; i < 4; i++) {
			initialState[i] = scnr.next().charAt(0);
		}
		scnr.close();
		vacuumProblem problem = new vacuumProblem(initialState);
		GraphSearch<char[], char[]> search = new GraphSearch<char[],char[]>();
		//QueueFactory queueFac = new QueueFactory();
		//Queue<Node<char[],char[]>> frontier;
		//frontier = QueueFactory.createLifoQueue();
		
		DepthFirstSearch<char[], char[]> dfs = new DepthFirstSearch<char[], char[]>(search);
		System.out.println(dfs.findState(problem));
		
	}

	//Constructor
	public vacuumProblem(char[] initialState) {
		this.initialState = initialState;
	}
	
	
	@Override
	public char[] getInitialState() {
		// TODO Auto-generated method stub
		return initialState;
	}

	@Override
	public List<char[]> getActions(char[] state) {
		ArrayList<char[]> actions = new ArrayList<char[]>();
		char[] suck = {'S'};
		
		if(state[0] == 'A') {
			char[] temp = {'A', 'B'};
			actions.add(temp);
			temp[1] = 'C';
			actions.add(temp);
			actions.add(suck);
			return actions;
		}
		if(state[0] == 'B') {
			char[] temp = {'B', 'A'};
			actions.add(temp);
			temp[1] = 'C';
			actions.add(temp);
			actions.add(suck);
			return actions;
		}
		if(state[0] == 'C') {
			char[] temp = {'C', 'A'};
			actions.add(temp);
			temp[1] = 'B';
			actions.add(temp);
			actions.add(suck);
			return actions;
		}
		
		return actions;
	}

	public char[] toA(char[] state) {
		if(state[1] == '1' && state[2] == '1' && state[3] == '1') {
			char[] temp = {'A','1','1','1'};
			return temp;
		}
		if(state[1] == '1' && state[2] == '1' && state[3] == '0') {
			char[] temp = {'A','1','1','0'};
			return temp;
		}
		if(state[1] == '1' && state[2] == '0' && state[3] == '0') {
			char[] temp = {'A','1','0','0'};
			return temp;
		}
		if(state[1] == '0' && state[2] == '0' && state[3] == '0') {
			char[] temp = {'A','0','0','0'};
			return temp;
		}
		if(state[1] == '0' && state[2] == '1' && state[3] == '1') {
			char[] temp = {'A','0','1','1'};
			return temp;
		}
		if(state[1] == '0' && state[2] == '0' && state[3] == '1') {
			char[] temp = {'A','0','0','1'};
			return temp;
		}
		if(state[1] == '0' && state[2] == '1' && state[3] == '0') {
			char[] temp = {'A','0','1','0'};
			return temp;
		}
		if(state[1] == '1' && state[2] == '0' && state[3] == '1') {
			char[] temp = {'A','1','0','1'};
			return temp;
		}
		return state;
	}
	
	public char[] toB(char[] state) {
		if(state[1] == '1' && state[2] == '1' && state[3] == '1') {
			char[] temp = {'B','1','1','1'};
			return temp;
		}
		if(state[1] == '1' && state[2] == '1' && state[3] == '0') {
			char[] temp = {'B','1','1','0'};
			return temp;
		}
		if(state[1] == '1' && state[2] == '0' && state[3] == '0') {
			char[] temp = {'B','1','0','0'};
			return temp;
		}
		if(state[1] == '0' && state[2] == '0' && state[3] == '0') {
			char[] temp = {'B','0','0','0'};
			return temp;
		}
		if(state[1] == '0' && state[2] == '1' && state[3] == '1') {
			char[] temp = {'B','0','1','1'};
			return temp;
		}
		if(state[1] == '0' && state[2] == '0' && state[3] == '1') {
			char[] temp = {'B','0','0','1'};
			return temp;
		}
		if(state[1] == '0' && state[2] == '1' && state[3] == '0') {
			char[] temp = {'B','0','1','0'};
			return temp;
		}
		if(state[1] == '1' && state[2] == '0' && state[3] == '1') {
			char[] temp = {'B','1','0','1'};
			return temp;
		}
		return state;
	}
	
	public char[] toC(char[] state) {
		if(state[1] == '1' && state[2] == '1' && state[3] == '1') {
			char[] temp = {'C','1','1','1'};
			return temp;
		}
		if(state[1] == '1' && state[2] == '1' && state[3] == '0') {
			char[] temp = {'C','1','1','0'};
			return temp;
		}
		if(state[1] == '1' && state[2] == '0' && state[3] == '0') {
			char[] temp = {'C','1','0','0'};
			return temp;
		}
		if(state[1] == '0' && state[2] == '0' && state[3] == '0') {
			char[] temp = {'C','0','0','0'};
			return temp;
		}
		if(state[1] == '0' && state[2] == '1' && state[3] == '1') {
			char[] temp = {'C','0','1','1'};
			return temp;
		}
		if(state[1] == '0' && state[2] == '0' && state[3] == '1') {
			char[] temp = {'C','0','0','1'};
			return temp;
		}
		if(state[1] == '0' && state[2] == '1' && state[3] == '0') {
			char[] temp = {'C','0','1','0'};
			return temp;
		}
		if(state[1] == '1' && state[2] == '0' && state[3] == '1') {
			char[] temp = {'C','1','0','1'};
			return temp;
		}
		return state;
	}
	@Override
	public char[] getResult(char[] state, char[] action) {
		
		if(action[0] == 'S') {
			if(state[0] == 'B') {
				if(state[1] == '1' && state[2] == '1' && state[3] == '1') {
					char[] temp = {'B','1','0','1'};
					return temp;
				}
				if(state[1] == '1' && state[2] == '1' && state[3] == '0') {
					char[] temp = {'B','1','0','0'};
					return temp;
				}
				if(state[1] == '1' && state[2] == '0' && state[3] == '0') {
					char[] temp = {'B','1','0','0'};
					return temp;
				}
				if(state[1] == '0' && state[2] == '0' && state[3] == '0') {
					char[] temp = {'B','0','0','0'};
					return temp;
				}
				if(state[1] == '0' && state[2] == '1' && state[3] == '1') {
					char[] temp = {'B','0','0','1'};
					return temp;
				}
				if(state[1] == '0' && state[2] == '0' && state[3] == '1') {
					char[] temp = {'B','0','0','1'};
					return temp;
				}
				if(state[1] == '0' && state[2] == '1' && state[3] == '0') {
					char[] temp = {'B','0','0','0'};
					return temp;
				}
				if(state[1] == '1' && state[2] == '0' && state[3] == '1') {
					char[] temp = {'B','1','0','1'};
					return temp;
				}
			}
			if(state[0] == 'A') {
				if(state[1] == '1' && state[2] == '1' && state[3] == '1') {
					char[] temp = {'A','0','1','1'};
					return temp;
				}
				if(state[1] == '1' && state[2] == '1' && state[3] == '0') {
					char[] temp = {'A','0','1','0'};
					return temp;
				}
				if(state[1] == '1' && state[2] == '0' && state[3] == '0') {
					char[] temp = {'A','0','0','0'};
					return temp;
				}
				if(state[1] == '0' && state[2] == '0' && state[3] == '0') {
					char[] temp = {'A','0','0','0'};
					return temp;
				}
				if(state[1] == '0' && state[2] == '1' && state[3] == '1') {
					char[] temp = {'A','0','1','1'};
					return temp;
				}
				if(state[1] == '0' && state[2] == '0' && state[3] == '1') {
					char[] temp = {'A','0','0','1'};
					return temp;
				}
				if(state[1] == '0' && state[2] == '1' && state[3] == '0') {
					char[] temp = {'A','0','1','0'};
					return temp;
				}
				if(state[1] == '1' && state[2] == '0' && state[3] == '1') {
					char[] temp = {'A','0','0','1'};
					return temp;
				}
			}
			if(state[0] == 'C') {
				if(state[1] == '1' && state[2] == '1' && state[3] == '1') {
					char[] temp = {'C','1','1','0'};
					return temp;
				}
				if(state[1] == '1' && state[2] == '1' && state[3] == '0') {
					char[] temp = {'C','1','1','0'};
					return temp;
				}
				if(state[1] == '1' && state[2] == '0' && state[3] == '0') {
					char[] temp = {'C','1','0','0'};
					return temp;
				}
				if(state[1] == '0' && state[2] == '0' && state[3] == '0') {
					char[] temp = {'C','0','0','0'};
					return temp;
				}
				if(state[1] == '0' && state[2] == '1' && state[3] == '1') {
					char[] temp = {'C','0','1','0'};
					return temp;
				}
				if(state[1] == '0' && state[2] == '0' && state[3] == '1') {
					char[] temp = {'C','0','0','0'};
					return temp;
				}
				if(state[1] == '0' && state[2] == '1' && state[3] == '0') {
					char[] temp = {'C','0','1','0'};
					return temp;
				}
				if(state[1] == '1' && state[2] == '0' && state[3] == '1') {
					char[] temp = {'C','1','0','0'};
					return temp;
				}
			}
		}
		
		if(action[1] == 'B') {
			return toB(state);
		}
		if(action[1] == 'C') {
			return toC(state);
		}
		if(action[1] == 'A') {
			return toA(state);
		}

		return null;
	}

	@Override
	public boolean testGoal(char[] state) {
		if(state[1] == '0' && state[2] == '0' && state[3] == '0') {
			return true;
		}
		return false;
	}

	@Override
	public double getStepCosts(char[] state, char[] action, char[] stateDelta) {
		return 1;
	}

}