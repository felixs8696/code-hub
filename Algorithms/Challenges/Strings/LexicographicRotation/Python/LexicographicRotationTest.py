import unittest
import LexicographicRotation as lr

class LexicographicRotationTest(unittest.TestCase):

    def test_basic(self):
        string = 'rotate'
        self.assertEqual(lr.getMaxRotation(string), 'terota')
        self.assertEqual(lr.getMinRotation(string), 'aterot')

    def test_medium(self):
        string = 'abcdefghijklmnopqrstuvwxyz'
        self.assertEqual(lr.getMaxRotation(string), 'zabcdefghijklmnopqrstuvwxy')
        self.assertEqual(lr.getMinRotation(string), 'abcdefghijklmnopqrstuvwxyz')

    def test_duplicates(self):
        string = 'xaxbxexf'
        self.assertEqual(lr.getMaxRotation(string), 'xfxaxbxe')
        self.assertEqual(lr.getMinRotation(string), 'axbxexfx')

if __name__ == '__main__':
    unittest.main()
