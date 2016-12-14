"""
Description
Given a string return the lexicographic maximum/minimum rotation

Example:

Input: input_string int (0 = min, 1 = max)
rotate 1

Output: output_rotation
terota
"""

def allRotations(string):
    n = len(string)
    arr = []
    combo_str = string + string
    for i in range(n):
        arr.append(combo_str[i:i+n])
    return arr

def getMaxRotation(string):
    rotations = allRotations(string)
    rotations.sort()
    return rotations[-1]

def getMinRotation(string):
    rotations = allRotations(string)
    rotations.sort()
    return rotations[0]

def solve(input):
    params = input.split(" ")
    string = params[0]
    i = int(params[1])
    if i == 0: return str(getMinRotation(string))
    if i == 1: return str(getMaxRotation(string))
    return "Invlid Input"

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
