import unittest
import Factorial

class FactorialTest(unittest.TestCase):

    def test_equal(self):
        self.assertEqual(1, 1)

    def test_true(self):
        self.assertTrue(True)

if __name__ == '__main__':
    unittest.main()
