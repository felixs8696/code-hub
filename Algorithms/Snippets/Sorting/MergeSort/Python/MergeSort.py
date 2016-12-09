"""
Description
Stable sort an array of integers using divide and conquer
Runtime: Best: O(N log N), Average: O(N log N), Worst: O(N log N)
Space: O(N)

Example:

Input: int_array
[1, 6, 7, 4, 5]

Output: int_array
[1, 4, 5, 6, 7]
"""

def solve(input):
    return str("solution")

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
