import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author Madel Sibal
 */
public class InsertionSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  InsertionSort() {
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    int len = values.length;
    
    for (int i = 1; i < len; i++) {
      T key = values[i];
      int j = i - 1;
      
      while (j >= 0 && order.compare(values[j], key) > 0) {
        values[j + 1] = values[j];
        j--;
      }
      
      values[j + 1] = key;
    }
  } // sort(T[], Comparator<? super T>)
} // class InsertionSort
