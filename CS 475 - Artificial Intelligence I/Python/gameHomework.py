# Michael Torres
# Game Homework
# 4/2/21

from games import *

class gameHomework(Game):
    
    def __init__(self, initial, nextMove):
        self.initial = initial
        self.nextMove = nextMove
        
    def actions(self, state):
        actions = []
        if self.nextMove == 'A':
            if state[0] == 1:
                if state[1] != 2:
                    actions.append(2)
                    return actions
                else:
                    actions.append(3)
                    return actions
            if state[0] == 2:
                if state[1] != 3:
                    actions.append(3)
                    return actions
                else:
                    actions.append(4)
                    return actions
            if state[0] == 3:
                if state[1] != 4:
                    actions.append(4)
                    return actions
                if state[1] != 2:
                    actions.append(2)
                    return actions
        if self.nextMove == 'B':
            if state[1] == 4:
                if state[0] != 3:
                    actions.append(3)
                    return actions
                else:
                    actions.append(2)
                    return actions
            if state[1] == 3:
                if state[0] != 2:
                    actions.append(2)
                    return actions
                else:
                    actions.append(1)
                    return actions
            if state[1] == 2:
                if state[0] != 1:
                    actions.append(1)
                    return actions
                if state[0] != 3:
                    actions.append(3)
                    return actions
    
    def result(self, state, move):
        if self.nextMove == 'A':
            state = [move, state[1]]
            self.nextMove = 'B'
        else:
            state = [state[0], move]
            self.nextMove = 'A'
        return state
 
    def utility(self, state, player):
        if self.nextMove == 'A':
            if state[0] == 4:
                return 1
            if state[1] == 1:
                return -1
        if self.nextMove == 'B':
            if state[0] == 4:
                return -1
            if state[1] == 1:
                return -1
        return 0
    
    def terminal_test(self, state):
        if state[0] == 4 or state[1] == 1:
            return True
        return False
    
    def to_move(self, state):
        return self.nextMove
            
    def play_game(self, *players):
        """Play an n-person, move-alternating game."""
        state = self.initial
        while True:
            for player in players:
                move = player(self, state)
                state = self.result(state, move)
                if self.terminal_test(state):
                    self.display(state)
                    return self.utility(state, self.to_move(self.initial))
    
    def minmax_decision(state, game):
        """Given a state in a game, calculate the best move by searching
        forward all the way to the terminal states. [Figure 5.3]"""
        player = game.to_move(state)

        def max_value(state):
            if game.terminal_test(state):
                return game.utility(state, player)
            v = -np.inf
            for a in game.actions(state):
                v = max(v, min_value(game.result(state, a)))
            return v

        def min_value(state):
            if game.terminal_test(state):
                return game.utility(state, player)
            v = np.inf
            for a in game.actions(state):
                v = min(v, max_value(game.result(state, a)))
            return v

        # Body of minmax_decision:
        return max(game.actions(state), key=lambda a: min_value(game.result(state, a)))

# Change next move and initial for tests.
# initial is the current state
# next move denotes which player's turn it is
def main():
    initial = [1, 4]
    nextMove = 'A'
    game = gameHomework(initial, nextMove)
    print('With state: ', initial, ', Next Move: ' + nextMove + ',\nBest Move is: ')
    print(minmax_decision(initial, game))
    print('done')

main()

