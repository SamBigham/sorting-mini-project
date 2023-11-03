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

  // public <T> void stupidsort(T[] values, Comparator<? super T> order){
  //   values[1] = null;
  // }

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
     if(values.length == 0){
        return;
    }
    T[] arr = Arrays.copyOf(values, values.length -1);

    if(values.length == 0){
        return;
    }
    
    int correct = checkTrue(values, order);
    while(correct != -1){
        
        arr = Shuffle(values, correct);
        correct = checkTrue(values, order);
    }
    values = arr;
  }


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

  public <T> int checkTrue(T[] val, Comparator<? super T> order ){
    for(int i = 0; i<val.length -1; i++){
        if(order.compare(val[i], val[i +1]) > 0){
            return i;
        }
    }
    return -1;
  }

}
