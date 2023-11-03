import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.util.Random;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author Your Name
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter;

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  @Test
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void randomIntTest(){
    Integer[] original = { 5, 4, 3, 2, 2, 1, 2, 3, 4, 5, 6 ,7};
    Integer[] expected = { 1, 2, 2, 2,  3, 3, 4, 4, 5, 5, 6, 7};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  }

  @Test
  public void nullTest(){
    BigInteger[] original = {};
    BigInteger[] expected = {};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  }

  @Test
  public void multiTest(){
    String[] original1 = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] original2 = { "bravo", "alpha", "charlie", "delta", "foxtrot" };
    String[] original3 = { "bravo", "alpha", "charlie", "foxtrot", "delta" };
    String[] original4 = { "foxtrot", "delta", "charlie", "bravo", "alpha" };

    sorter.sort(original1, (x, y) -> x.compareTo(y));
    sorter.sort(original2, (x, y) -> x.compareTo(y));
    sorter.sort(original3, (x, y) -> x.compareTo(y));
    sorter.sort(original4, (x, y) -> x.compareTo(y));
    
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };

    assertArrayEquals(original1, expected);
    assertArrayEquals(original2, expected);
    assertArrayEquals(original3, expected);
    assertArrayEquals(original4, expected);
  }

  @Test
  public void numTest(){
    Integer[] original = {3, 2, 1, 1, 2, 3};
    Integer[] expected = {1, 1, 2, 2, 3, 3};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  }



} // class SortTester
