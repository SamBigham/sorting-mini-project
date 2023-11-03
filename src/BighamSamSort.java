import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class BighamSamSort implements Sorter {
    
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new BighamSamSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  BighamSamSort() {
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

 
/*
 * it's bogo sort! My favorite sorting algorithm
 */
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
     if(values.length == 0){
        return;
    }
    T[] arr = Arrays.copyOf(values, values.length -1);

    if(values.length == 0){
        return;
    }
    
    int correct = checkTrue(values, order); //checks whether the array is correct. if not randomizes it
    while(correct != -1){
        
        arr = Shuffle(values, correct); // randomizes array
        correct = checkTrue(values, order);
    }
    values = arr;
  }

/*
 * input: val -> an array of T values
 * input: numcorrect: the number of currently correct values there are
 * output: T[] -> a shuffled array
 * 
 * randomizes the array starting from the last currently correct value
 */
  public <T> T[] Shuffle(T[] val, int numCorrect){
    Random rand = new Random();
    for(int i = numCorrect; i < val.length; i++){
        int swap = rand.nextInt(val.length);
        T temp = val[swap];
        val[swap] = val[i];
        val[i] = temp;
    }
    return val;
  }

  /*
   * checks whether the array is sorted or not
   * input: val -> array of values
   * input: order -> a comparator
   * 
   * output: int -> either a positive value depending on how many currently correct values there are,
   *  or a -1 to indicate it's not been sorted yet.
   */
  public <T> int checkTrue(T[] val, Comparator<? super T> order ){
    for(int i = 0; i<val.length -1; i++){
        if(order.compare(val[i], val[i +1]) > 0){
            return i;
        }
    }
    return -1;
  }

}
