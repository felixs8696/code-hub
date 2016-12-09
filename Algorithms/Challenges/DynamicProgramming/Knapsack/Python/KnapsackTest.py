import unittest
import Knapsack as ks

class KnapsackTest(unittest.TestCase):

    def test_with_repetition_1(self):
        weights = [ 6, 3, 4, 2 ]
        values = [ 30, 14, 16, 9 ]
        k = 10
        self.assertEquals(48, ks.knapsackWithRepetition(weights, values, k))

    def test_with_repetition_2(self):
        weights = [ 1, 6, 9 ]
        values = [ 10, 5, 6 ]
        k = 12
        self.assertEquals(120, ks.knapsackWithRepetition(weights, values, k))

    def test_with_repetition_3(self):
        weights = [ 3, 4, 4, 4, 8 ]
        values = [ 5, 4, 2, 6, 11 ]
        k = 9
        self.assertEquals(15, ks.knapsackWithRepetition(weights, values, k))

    def test_without_repetition_1(self):
        weights = [ 6, 3, 4, 2 ]
        values = [ 30, 14, 16, 9 ]
        k = 10
        self.assertEquals(46, ks.knapsackWithoutRepetition(weights, values, k))

    def test_without_repetition_2(self):
        weights = [ 1, 6, 9 ]
        values = [ 10, 5, 6 ]
        k = 12
        self.assertEquals(16, ks.knapsackWithoutRepetition(weights, values, k))

    def test_without_repetition_3(self):
        weights = [ 3, 4, 4, 4, 8 ]
        values = [ 5, 4, 2, 6, 11 ]
        k = 9
        self.assertEquals(11, ks.knapsackWithoutRepetition(weights, values, k))

    def test_without_repetition_large(self):
        weights =  [ 382745, 799601, 909247, 729069, 467902, 44328, 34610, 698150, 823460, 903959, 853665, 551830, 610856, 670702, 488960, 951111, 323046, 446298, 931161, 31385, 496951, 264724, 224916, 169684 ]
        values = [ 825594, 1677009, 1676628, 1523970, 943972, 97426, 69666, 1296457, 1679693, 1902996, 1844992, 1049289, 1252836, 1319836, 953277, 2067538, 675367, 853655, 1826027, 65731, 901489, 577243, 466257, 369261 ]
        k = 6404180
        self.assertEquals(13549094, ks.knapsackWithoutRepetition(weights, values, k))


if __name__ == '__main__':
    unittest.main()
