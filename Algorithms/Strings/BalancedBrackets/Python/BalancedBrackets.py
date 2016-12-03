openBrackets = ['(', '{', '[']
closedBrackets = [')', '}', ']']

def bracketsMatch(open, closed):
    if (open == '(' and closed == ')') or (open == '{' and closed == '}') or (open == '[' and closed == ']'):
        return True
    return False

def isBalanced(str):
    stack = [];
    for c in str:
        if c in openBrackets: stack.append(c);
        elif c in closedBrackets:
            if not stack or not bracketsMatch(stack.pop(), c): return False
    return True

def solve(input):
    return str(isBalanced(input))

# Taken from Templates/Python/FileIO/fileio.py
input_file = open("../io/tests.txt", "r");
output_file = open("../io/py-sol.txt", "w");
debug = True

test = input_file.readline()
while test != '':
    test = test.rstrip("\r\n")
    solution = solve(test)
    if debug: solution +=  ": '%s'" % test
    output_file.write(solution + "\n")
    test = input_file.readline()

input_file.close();
output_file.close();
