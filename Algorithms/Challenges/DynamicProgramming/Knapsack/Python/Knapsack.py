"""
Description
Given a list of n items, each with w_i and dollar value v_i, and a weight
capacity W, what is the most valuable combination of items?

Example:

Input: weights_array; value_array; W
6 3 4 2; 30 14 16 9; 10
Output: item_nums, value
1 3; 46
"""

def stringAsIntArr(str):
    elems = str.split(" ")
    arr = []
    for elem in elems:
        arr.append(int(elem))
    return arr;

def knapsackWithRepetition(weights, values, W):
    K = [ 0 for x in range(W + 1) ]
    for w in range(1, W + 1):
        for i in range(1, len(values) + 1):
            if weights[i-1] <= w:
                K[w] = max(values[i-1] + K[w - weights[i-1]],  K[w])
            elif K[w - 1] > K[w]:
                K[w] = K[w - 1]
    return K[W]

def knapsackWithoutRepetition(weights, values, W):
    K = [ [ 0 for x in range(len(values) + 1) ] for y in range(W + 1) ]
    for w in range(1, W + 1):
        for i in range(1, len(values) + 1):
            if weights[i-1] <= w:
                K[w][i] = max(values[i-1] + K[w - weights[i-1]][i - 1],  K[w][i - 1])
            else:
                K[w][i] = K[w][i - 1]
    return K[W][len(values)]

def solve(input):
    params = input.split("; ")
    weights = stringAsIntArr(params[0])
    values = stringAsIntArr(params[1])
    k = int(params[2])
    return str(knapsackWithoutRepetition(weights, values, k))

input_file = open("io/tests.txt", "r");
output_file = open("io/solution.txt", "w");
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
