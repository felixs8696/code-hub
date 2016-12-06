import unittest
from RotateMatrix import rotate

class RotateMatrixTest(unittest.TestCase):

    def test_empty_matrix(self):
        test1 = [[]]
        sol_1 = [[]]
        self.assertEqual(rotate(test1, 0), sol_1)
        self.assertEqual(rotate(test1, 1), sol_1)

    def test_square_matrix_right(self):
        test1 = [[1,2,3], [4,5,6], [7,8,9]]
        sol_1 = [[7,4,1], [8,5,2], [9,6,3]]
        self.assertEqual(rotate(test1, 1), sol_1)

    def test_square_matrix_left(self):
        test1 = [[1,2,3], [4,5,6], [7,8,9]]
        sol_1 = [[3,6,9], [2,5,8], [1,4,7]]
        self.assertEqual(rotate(test1, 0), sol_1)

    def test_non_square_matrix_right(self):
        test1 = [[1,2,3], [4,5,6]]
        sol_1 = [[4,1], [5,2], [6,3]]
        self.assertEqual(rotate(test1, 1), sol_1)

    def test_non_square_matrix_left(self):
        test1 = [[1,2,3], [4,5,6]]
        sol_1 = [[3,6], [2,5], [1,4]]
        self.assertEqual(rotate(test1, 0), sol_1)

if __name__ == '__main__':
    unittest.main()
