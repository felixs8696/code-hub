"""
Description
Return all integers that appear an odd number of times in an array

Runtime: O(n)
Space: O(n)

Example:

Input: int_array
5 1 2 4 4 3 4 1 5

Output: int_array
2 3 4
"""

def stringAsIntArr(str):
    elems = str.split(" ")
    arr = []
    for elem in elems:
       arr.append(int(elem))
    return arr;

def oddTimeElems(arr):
    result = set()
    dict = {}
    for i in arr:
        if i not in dict:
            dict[i] = 1
            result.add(i)
        else:
            dict[i] = dict[i] + 1
            if dict[i] % 2 == 0:
                result.remove(i)
            else:
                result.add(i)
    return list(result)

def solve(input):
    arr = stringAsIntArr(input)
    return " ".join(map(str, oddTimeElems(arr)))

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
