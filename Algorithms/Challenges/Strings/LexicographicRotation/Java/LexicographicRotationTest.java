import org.junit.Test;
import static org.junit.Assert.*;

public class LexicographicRotationTest {
  private static final double DELTA = 1e-15;

  @Test
  public void basicTest() {
    LexicographicRotation lr = new LexicographicRotation();
    String string = "rotate";
    assertEquals(lr.getMaxRotation(string), "terota");
    assertEquals(lr.getMinRotation(string), "aterot");
  }

  @Test
  public void mediumTest() {
    LexicographicRotation lr = new LexicographicRotation();
    String string = "abcdefghijklmnopqrstuvwxyz";
    assertEquals(lr.getMaxRotation(string), "zabcdefghijklmnopqrstuvwxy");
    assertEquals(lr.getMinRotation(string), "abcdefghijklmnopqrstuvwxyz");
  }

  @Test
  public void duplicatesTest() {
    LexicographicRotation lr = new LexicographicRotation();
    String string = "xaxbxexf";
    assertEquals(lr.getMaxRotation(string), "xfxaxbxe");
    assertEquals(lr.getMinRotation(string), "axbxexfx");
  }
}
