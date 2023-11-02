import java.util.Arrays;
import java.util.Comparator;

/**
 * My implementation of a sorting algorithm, inspired by TimSort.
 * 
 * @author Samuel A. Rebelsky (for documentation) & Madel Sibal
 */
public class SibalMadelSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new SibalMadelSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  SibalMadelSort() {
  } // SibalMadelSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    int len = values.length;
    
    // Use insertion sort on the array if it is small-sized
    if (len < 10) {
      insertionSort(values, order);
      return;
    }
    
    // Divide the array into parts, each block with a size of 32 elements
    int block = 32;
    
    for (int i = 0; i < len; i += block) {
      int left = i;
      int right = Math.min(i + block - 1, len - 1);
      
      // Sort each block using insertion sort
      insertionSort(values, order, left, right);
    }
    
    /** 
     * Merge the sorted blocks using a nested for loop, 
     * which merges the blocks in multiple steps
     */
    for (int size = block; size < len; size = 2 * size) {
      for (int left = 0; left < len; left += 2 * size) {
        int middle = Math.min(left + size - 1, len - 1);
        int right = Math.min(left + 2 * size - 1, len - 1);
        merge(values, order, left, middle, right);
      }
    }
  }

  // Implementation of insertionSort
  private <T> void insertionSort(T[] arr, Comparator<? super T> order) {
    insertionSort(arr, order, 0, arr.length - 1);
  }

  private <T> void insertionSort(T[] arr, Comparator<? super T> order, int left, int right) {
    for (int i = left + 1; i <= right; i++) {
      T key = arr[i];
      int j = i - 1;
      while (j >= left && order.compare(arr[j], key) > 0) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;
    }
  }

  // Implementation of merge
    private <T> void merge(T[] arr, Comparator<? super T> order, int left, int middle, int right) {
        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        T[] leftArray = Arrays.copyOfRange(arr, left, middle + 1);
        T[] rightArray = Arrays.copyOfRange(arr, middle + 1, right + 1);

        int i = 0, j = 0;
        int k = left;

        while (i < leftSize && j < rightSize) {
            if (order.compare(leftArray[i], rightArray[j]) <= 0) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }

        while (i < leftSize) {
            arr[k++] = leftArray[i++];
        }
        while (j < rightSize) {
            arr[k++] = rightArray[j++];
        }
    }
}






