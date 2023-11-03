import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using merge sort.
 *
 * @author Your Name Here
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

  /*
   * where sort is called
   * input: values -> array to be sorted
   * input: order -> comparator
   * 
   * calls mergeHelper in order to use merge sort and sort the array
   */
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    if (values.length == 0) {
      return;
    }
    T[] arr = mergeHelper(values, order);
    for (int i = 0; i < arr.length; i++) {
      values[i] = arr[i];
    }
    System.out.println();

  } // sort(T[], Comparator<? super T>

  /*
   * mergeHelper
   * 
   * input: values -> array to be sorted
   * input: order -> comparator
   * 
   * splits array into two, and then it calls itself
   */
  public <T> T[] mergeHelper(T[] values, Comparator<? super T> order) {

    if (values.length <= 1) {
      return values;
    }
    int mid = values.length / 2;
    int n = values.length - 1;
    T[] val1 = Arrays.copyOfRange(values, 0, mid);
    T[] val2 = Arrays.copyOfRange(values, mid, n);

    val1 = mergeHelper(val1, order);
    val2 = mergeHelper(val2, order);

    return merge(val1, val2, order, values);
  }

  /*
   * merges the arrays
   * input: val1 -> array to be sorted based on val2
   * input: val2 -> array to be sorted based on val1
   * input: order -> comparator
   * input: values -> used for length and copying
   * 
   * output: T[] -> sorted array
   * 
   * sorts two arrays and combines them based on value
   */
  public <T> T[] merge(T[] val1, T[] val2, Comparator<? super T> order, T[] values) {
    T[] valTemp = Arrays.copyOf(values, values.length);
    int endTemp = 0;

    int i = 0, j = 0;

    while (i < val1.length && j < val2.length) {
      if (order.compare(val1[i], val2[i]) < 0) {
        valTemp[endTemp] = val1[i];
        endTemp++;
        i++;
      } else {
        valTemp[endTemp] = val2[j];
        endTemp++;
        j++;
      }
    }

    return valTemp;
  }

} // class MergeSort
