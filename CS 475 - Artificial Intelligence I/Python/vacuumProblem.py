#!/usr/bin/env python
# coding: utf-8

# In[ ]:


from search import *

class vacuumProblem(Problem):
    
    def _init_(self, initial, goal):
        print("start")
        self.initial = initial
        self.goal = goal

    def actions(self, state):
        """Return the actions that can be executed in the given
        state. The result would typically be a list, but if there are
        many actions, consider yielding them one at a time in an
        iterator, rather than building them all at once."""
        print("actions")
        if state[0] == 'A':
            return ["S","AB","AC"]
        if state[0] == 'B':
            return ["S","BA","BC"]
        if state[0] == 'C':
            return ["S","CA","CB"]

    def result(self, state, action):
        print("result")
        if action[0] == 'S':
            temp4 = list(state)
            if state[0] == 'A':
                temp4[1] = '0'
            if state[0] == 'B':
                temp4[2] = '0'
            if state[0] == 'C':
                temp4[3] = '0'
            print(temp4)
            return (temp4)
        
        if action[1] == 'A':
            temp1 = list(state)
            temp1[0] = 'A'
            print(temp1)
            return (temp1)
        
        if action[1] == 'B':
            temp2 = list(state)
            temp2[0] = 'B'
            print(temp2)
            return (temp2)
        
        if action[1] == 'C':
            temp3 = list(state)
            temp3[0] = 'C'
            print(temp3)
            return (temp3)

    def goal_test(self, state):
        """Return True if the state is a goal. The default method compares the
        state to self.goal or checks for state in self.goal if it is a
        list, as specified in the constructor. Override this method if
        checking against a single self.goal is not enough."""
        if isinstance(self.goal, list):
            return is_in(state, self.goal)
        else:
            return state == self.goal
def main():
    initial = "A111"
    goal = ["A000", "B000", "C000"]
    problem = vacuumProblem(initial, goal)
    depth_first_tree_search(problem)
    print("done")

main()


# In[ ]:





# In[ ]:




