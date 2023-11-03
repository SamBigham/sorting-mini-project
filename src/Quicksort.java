import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author Your Name Here
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

  /*
   * main sort method -> when called will call other quicksort methods
   */
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {

    T[] arr = QuicksortHelper(values, 0, values.length -1, order); 
    values = arr;
  } // sort(T[], Comparator<? super T>

  /*
   * uses recursion to quicksort an array
   * input: values -> array of T[] values
   * input: lb -> lower bound
   * input: hb -> higher bound
   * input: order -> comparator
   * 
   * quick sort helper calls partitioner to find a pivot point and then sort the array from that
   * quick sort helper also calls itself recursively until the array is sorted.
   */
  public <T> T[] QuicksortHelper(T[] values, int lb, int hb, Comparator<? super T> order){
    if(lb < hb){
      int j = partitioner(values, lb, hb, order);
      QuicksortHelper(values, lb, j-1, order); // lower half of array
      QuicksortHelper(values, j + 1, hb, order); //upper half based on j
    }
    return values;
  }

  /*
   * 
   * input: val -> array of T[] values
   * input: lb -> lower bound
   * input: hb -> higher bound
   * input: order -> comparator
   * 
   *  partitioner takes the hb as a pivot point, and swaps i and j vals based on pivot.
   */
  public <T> int partitioner(T[] val, int lb, int hb, Comparator<? super T> order){

    T pivot = val[hb];
    int i = lb-1; // will be incremented first
    T temp = null;

    for(int j = lb; j < hb; j++){ //while lb < hb... once hb <= lb, then 
      if(order.compare(val[j], pivot) <= 0){
        i++; 
      temp = val[i]; //swaps values 
      val[i] = val[j];
      val[j] = temp;
      }
    }//for
    temp = val[i+1];//swaps i + 1 with pivot
    val[i+1] = val[hb];
    val[hb] = temp;
    return i+1; //... sorted value
  }


} // class Quicksort
