def transpose(matrix):
    return [ [ matrix[i][j] for i in range(len(matrix)) ] for j in range(len(matrix[0])) ]

def flipY(matrix):
    targetEnd = len(matrix) - 1;
    for i in range(len(matrix) / 2):
        for j in range(len(matrix[0])):
            temp = matrix[i][j]
            matrix[i][j] = matrix[targetEnd - i][j]
            matrix[targetEnd - i][j] = temp
    return matrix

def flipX(matrix):
    targetEnd = len(matrix[0]) - 1;
    for i in range(len(matrix)):
        for j in range(len(matrix[0]) / 2):
            temp = matrix[i][j]
            matrix[i][j] = matrix[i][targetEnd - j]
            matrix[i][targetEnd - j] = temp
    return matrix

def rotate(matrix, dir):
    if len(matrix) == 0 or len(matrix[0]) == 0: return matrix
    matrix = transpose(matrix)
    if dir == 1:
        matrix = flipX(matrix)
    else:
        matrix = flipY(matrix)
    return matrix
