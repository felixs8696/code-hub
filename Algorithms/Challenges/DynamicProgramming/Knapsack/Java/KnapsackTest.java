import org.junit.Test;
import static org.junit.Assert.*;

public class KnapsackTest {
  private static final double DELTA = 1e-15;

  @Test
  public void withRepetitionTest1() {
    Knapsack ks = new Knapsack();
    int[] weights = { 6, 3, 4, 2 };
    int[] values = { 30, 14, 16, 9 };
    int k = 10;

    assertEquals(48, ks.knapsackWithRepetition(weights, values, k), DELTA);
  }

  @Test
  public void withRepetitionTest2() {
    Knapsack ks = new Knapsack();
    int[] weights = { 1, 6, 9 };
    int[] values = { 10, 5, 6 };
    int k = 12;

    assertEquals(120, ks.knapsackWithRepetition(weights, values, k), DELTA);
  }

  @Test
  public void withRepetitionTest3() {
    Knapsack ks = new Knapsack();
    int[] weights = { 3, 4, 4, 4, 8 };
    int[] values = { 5, 4, 2, 6, 11 };
    int k = 9;

    assertEquals(15, ks.knapsackWithRepetition(weights, values, k), DELTA);
  }

  @Test
  public void withoutRepetitionTest1() {
    Knapsack ks = new Knapsack();
    int[] weights = { 6, 3, 4, 2 };
    int[] values = { 30, 14, 16, 9 };
    int k = 10;

    assertEquals(46, ks.knapsackWithoutRepetition(weights, values, k), DELTA);
  }

  @Test
  public void withoutRepetitionTest2() {
    Knapsack ks = new Knapsack();
    int[] weights = { 1, 6, 9 };
    int[] values = { 10, 5, 6 };
    int k = 12;

    assertEquals(16, ks.knapsackWithoutRepetition(weights, values, k), DELTA);
  }

  @Test
  public void withoutRepetitionTest3() {
    Knapsack ks = new Knapsack();
    int[] weights = { 3, 4, 4, 4, 8 };
    int[] values = { 5, 4, 2, 6, 11 };
    int k = 9;

    assertEquals(11, ks.knapsackWithoutRepetition(weights, values, k), DELTA);
  }

  @Test
  public void withoutRepetitionTestLarge() {
    Knapsack ks = new Knapsack();
    int[] weights = { 382745, 799601, 909247, 729069, 467902, 44328, 34610, 698150, 823460, 903959, 853665, 551830, 610856, 670702, 488960, 951111, 323046, 446298, 931161, 31385, 496951, 264724, 224916, 169684 };
    int[] values = { 825594, 1677009, 1676628, 1523970, 943972, 97426, 69666, 1296457, 1679693, 1902996, 1844992, 1049289, 1252836, 1319836, 953277, 2067538, 675367, 853655, 1826027, 65731, 901489, 577243, 466257, 369261 };
    int k = 6404180;

    assertEquals(13549094, ks.knapsackWithoutRepetition(weights, values, k), DELTA);
  }
}
