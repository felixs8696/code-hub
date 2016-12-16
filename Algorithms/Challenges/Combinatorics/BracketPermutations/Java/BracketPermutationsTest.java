import org.junit.Test;
import static org.junit.Assert.*;

public class BracketPermutationsTest {
  private static final double DELTA = 1e-15;

  @Test
  public void smallTest() {
    BracketPermutations bp = new BracketPermutations();
    String[] solution = {"{{{}}}", "{{}{}}", "{{}}{}", "{}{{}}", "{}{}{}"};

    assertArrayEquals(solution, bp.bracketPermutations(3));
  }

  @Test
  public void mediumTest() {
    BracketPermutations bp = new BracketPermutations();
    String[] solution = {"{{{{}}}}", "{{{}{}}}", "{{{}}{}}", "{{{}}}{}", "{{}{{}}}", "{{}{}{}}", "{{}{}}{}", "{{}}{{}}", "{{}}{}{}", "{}{{{}}}", "{}{{}{}}", "{}{{}}{}", "{}{}{{}}", "{}{}{}{}"};

    assertArrayEquals(solution, bp.bracketPermutations(4));
  }

  @Test
  public void largeTest() {
    BracketPermutations bp = new BracketPermutations();
    String[] solution = {"{{{{{}}}}}", "{{{{}{}}}}", "{{{{}}{}}}", "{{{{}}}{}}", "{{{{}}}}{}", "{{{}{{}}}}", "{{{}{}{}}}", "{{{}{}}{}}", "{{{}{}}}{}", "{{{}}{{}}}", "{{{}}{}{}}", "{{{}}{}}{}", "{{{}}}{{}}", "{{{}}}{}{}", "{{}{{{}}}}", "{{}{{}{}}}", "{{}{{}}{}}", "{{}{{}}}{}", "{{}{}{{}}}", "{{}{}{}{}}", "{{}{}{}}{}", "{{}{}}{{}}", "{{}{}}{}{}", "{{}}{{{}}}", "{{}}{{}{}}", "{{}}{{}}{}", "{{}}{}{{}}", "{{}}{}{}{}", "{}{{{{}}}}", "{}{{{}{}}}", "{}{{{}}{}}", "{}{{{}}}{}", "{}{{}{{}}}", "{}{{}{}{}}", "{}{{}{}}{}", "{}{{}}{{}}", "{}{{}}{}{}", "{}{}{{{}}}", "{}{}{{}{}}", "{}{}{{}}{}", "{}{}{}{{}}", "{}{}{}{}{}"};

    assertArrayEquals(solution, bp.bracketPermutations(5));
  }

}
