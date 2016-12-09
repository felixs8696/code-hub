import unittest
import CountPairs as cp

class CountPairsTest(unittest.TestCase):

    def test_distinct(self):
        arr = [1,2,3,4,5,6];
        k = 5;
        self.assertEqual(2, cp.countPairs(arr, k));

    def test_duplicates(self):
        arr = [2,2,2];
        k = 4;
        self.assertEqual(3, cp.countPairs(arr, k));

    def test_large(self):
        arr = [];
        for i in range(1, 100001):
            arr.append(i)
        k = 4;
        self.assertEqual(1, cp.countPairs(arr, k));

if __name__ == '__main__':
    unittest.main()
