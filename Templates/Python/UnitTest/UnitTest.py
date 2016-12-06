import unittest

class UnitTest(unittest.TestCase):

    def test_equal(self):
        self.assertEqual(1, 1)

    def test_true(self):
        self.asserTrue(True)

if __name__ == '__main__':
    unittest.main()
