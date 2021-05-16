from search import *

class NQueensProblemCon(Problem):

    def __init__(self, N, k):
    	super().__init__(tuple([-1] * N))
    	self.N = N
    	self.k = k
    	self.expandCnt = 0
    def actions(self, state):
        """In the leftmost empty column, try all non-conflicting rows."""
        if state[-1] != -1:
            return []  # All columns filled; no successors
        else:
            self.expandCnt += 1
            col = state.index(-1)
            return [row for row in range(self.N)
                    if not self.conflicted(state, row, col)]

    def result(self, state, row):
        """Place the next queen at the given row."""
        col = state.index(-1)
        new = list(state[:])
        new[col] = row
        return tuple(new)

    def conflicted(self, state, row, col):
        """Would placing a queen at (row, col) conflict with anything?"""
        return any(self.conflict(row, col, state[c], c)
                   for c in range(col))

    def conflict(self, row1, col1, row2, col2):
        """Would putting two queens in (row1, col1) and (row2, col2) conflict?"""
        return (row1 == row2 or  # same row
                col1 == col2 or  # same column
                row1 - col1 == row2 - col2 or  # same \ diagonal
                row1 + col1 == row2 + col2)  # same / diagonal

    def goal_test(self, state):
        """Check if all columns filled, no conflicts."""
        if self.expandCnt < self.N:
            return False
	        
        if self.numConflicts(state) == self.k:	
            return True

	# return not any(self.conflicted(state, state[col], col)
                      # for col in range(len(state)))

    def h(self, node):
        """Return number of conflicting queens for a given node"""
        num_conflicts = 0
        for (r1, c1) in enumerate(node.state):
            for (r2, c2) in enumerate(node.state):
                if (r1, c1) != (r2, c2):
                    num_conflicts += self.conflict(r1, c1, r2, c2)

        return num_conflicts

    def numConflicts(self, state):
        numCon = 0
	
        for i in range(len(state)):
	        for x in range(len(state)):
                        numCon = numCon + (self.conflict(state[i], i, state[x], x) and i != x)
        return numCon 
def main():
	
# Change the 4 and 6 (N and K) for different test cases
	n = 4
	k = 6
	t = NQueensProblemCon(n, k)
	breadth_first_tree_search(t)
	print("Searcher	n	k	Number of nodes expanded")
	print("BFS		",n,"	",k,"	", t.expandCnt)
	depth_first_tree_search(t)
	print("DFS		",n,"	",k,"	", t.expandCnt)
	depth_limited_search(t)
	print("DLS		",n,"	",k,"	", t.expandCnt)
	iterative_deepening_search(t)
	print("IDS		",n,"	",k,"	", t.expandCnt)
main()