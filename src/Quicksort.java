import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author Madel Sibal
 */
public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {
  } // Quicksort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    quicksort(values, order, 0, values.length - 1);
  } // sort(T[], Comparator<? super T>)

  /**
   * Sorts an array through a recursive Quicksort algorithm.
   */
  private <T> void quicksort(T[] arr, Comparator<? super T> order, int low, int high) {
    if (low < high) {
      int partitionIndex = partition(arr, order, low, high);

      // Uses recursion to sort elements before and after partition
      quicksort(arr, order, low, partitionIndex - 1);
      quicksort(arr, order, partitionIndex + 1, high);
    }
  }

  /**
   * Partitions the array into two subarrays, returning the index of the pivot element.
   */
  private <T> int partition(T[] arr, Comparator<? super T> order, int low, int high) {
    T pivot = arr[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
      if (order.compare(arr[j], pivot) <= 0) {
        i++;
        // Swap arr[i] and arr[j]
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

    // Swap arr[i+1] and arr[high]
    T temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;

    return i + 1; // Returns the index of the pivot element
  }
} // class Quicksort
