"""
Description
By starting at the top of the triangle below and moving to adjacent numbers
on the row below, find the maximum total from top to bottom of the triangle.

Runtime:
Space:

Example:

Input: num_rows; row_1; row_2; ...; row_n
4; 3; 7 4; 2 4 6; 8 5 9 3

Output: max_sum
23
"""

def max_sum_path(triangle, rows):
    sums = [ [ 0 for x in range(rows) ] for y in range(rows) ]
    sums[rows - 1] = triangle[rows - 1]
    for i in range(rows - 1, 0, -1):
      for j in range(i):
        sums[i - 1][j] = max(sums[i][j] + triangle[i - 1][j], sums[i][j + 1] + triangle[i - 1][j])
    return sums[0][0]

def solve(input):
    params = input.split('; ')
    N = int(params[0])
    triangle = [ [ 0 for x in range(N) ] for y in range(N) ]
    for j in range(1, N + 1):
        row = params[j].split(' ')
        for k in range(len(row)):
            triangle[j - 1][k] = int(row[k])
    return str(max_sum_path(triangle, N))

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
