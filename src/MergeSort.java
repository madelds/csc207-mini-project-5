import java.util.Comparator;

/**
 * Sort using merge sort.
 *
 * @author Madel Sibal
 */
public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    mergeSort(values, order);
  } // sort(T[], Comparator<? super T>)

  /**
   * Sort array using merge sort.
   */
  private <T> void mergeSort(T[] arr, Comparator<? super T> order) {
    int len = arr.length;
    if (len < 2) {
      return; // This means that the array is already sorted
    }

    // Calculate middle index
    int mid = len / 2;

    // Create left and right subarrays
    T[] left = (T[]) new Object[mid];
    T[] right = (T[]) new Object[len - mid];

    // Copy data to left and right subarrays
    System.arraycopy(arr, 0, left, 0, mid);
    System.arraycopy(arr, mid, right, 0, len - mid);

    // Sort subarrays
    mergeSort(left, order);
    mergeSort(right, order);

    // Merge sorted subarrays
    merge(arr, left, right, order);
  }

  /**
   * Merge subarrays into a single sorted array.
   */
  private <T> void merge(T[] arr, T[] left, T[] right, Comparator<? super T> order) {
    int leftLength = left.length;
    int rightLength = right.length;
    int i = 0, j = 0, k = 0;

    while (i < leftLength && j < rightLength) {
      if (order.compare(left[i], right[j]) <= 0) {
        arr[k++] = left[i++];
      } else {
        arr[k++] = right[j++];
      }
    }

    // If there are any remaining elements from left and right subarrays, copy them
    while (i < leftLength) {
      arr[k++] = left[i++];
    }
    while (j < rightLength) {
      arr[k++] = right[j++];
    }
  }
} // class MergeSort
