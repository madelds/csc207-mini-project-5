import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author Madel Sibal & Samuel A. Rebelsky
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
  } // reverseOrderedStringTest

  @Test
  public void orderedIntegerTest() {
    Integer[] original = { 1, 2, 3, 4, 5 };
    Integer[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedIntegerTest

  @Test
  public void reverseOrderedIntegerTest() {
    Integer[] original = { 5, 4, 3, 2, 1 };
    Integer[] expected = { 1, 2, 3, 4, 5 };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // reverseOrderedIntegerTest

  @Test
  public void emptyArrayTest() {
    String[] original = {};
    String[] expected = {};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // emptyArrayTest

  @Test
  public void duplicateStringTest() {
    String[] original = { "apple", "banana", "apple", "cherry" };
    String[] expected = { "apple", "apple", "banana", "cherry" };    sorter.sort(original, (x, y) -> x.compareTo(y));

    assertArrayEquals(original, expected);
  } // duplicateStringTest

    @Test
  public void singleElementArrayTest() {
    // Test sorting an array with a single element. It should remain the same.
    Integer[] original = { 42 };
    Integer[] expected = { 42 };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  }

} // class SortTester
