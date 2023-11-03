import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author Your Name Here
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

 /*
  * input: values -> array of value
  * input: order -> comparator
  * output: void -> values is sorted
  * this program uses insertion sort to sort an array
  */
  
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    for (int i = 1; i < values.length; i++){
    T val = values[i];
    int j = i - 1;

    while(j >= 0 && order.compare(values[j], val) >= 0){//moves everything to the left
      values[j+1] = values[j];
      j = j -1; //keeps going down the list till val is less than values[j] element 
    }
    values[j + 1] = val; 
    }

  } // sort(T[], Comparator<? super T>
} // class InsertionSort
