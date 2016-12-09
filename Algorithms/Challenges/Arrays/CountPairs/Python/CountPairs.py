def stringAsIntArr(str):
    elems = str.split(" ")
    arr = []
    for elem in elems:
       arr.append(int(elem))
    return arr;

def countPairs(arr, k):
    dict = {}
    count = 0;
    for i in arr:
        if i not in dict:
            dict[i] = 1
        else:
            dict[i] = dict[i] + 1
    for i in arr:
        if k - i in dict:
            if i == k - i:
                num = dict[i] - 1
                count += num * (num + 1)
                del dict[i]
            else:
                count += 1
    return count / 2

def solve(input):
    params = input.split("; ")
    arr = stringAsIntArr(params[0])
    k = int(params[1])
    return str(countPairs(arr, k))

input_file = open("io/tests.txt", "r")
output_file = open("io/solution.txt", "w")
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
