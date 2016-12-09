import unittest
import OddCountElements as oce

class OddCountElementsTest(unittest.TestCase):

    def test_equal(self):
        arr = [ 5, 1, 2, 4, 4, 3, 4, 1, 5 ]
        result = [ 2, 3, 4 ]

        # assertEquals(expected, actual, delta);
        self.assertEquals(result, oce.oddTimeElems(arr));

if __name__ == '__main__':
    unittest.main()
