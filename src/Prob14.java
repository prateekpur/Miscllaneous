import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ppuri on 10/2/2014.
 */
public class Prob14 {
  public static Map<Integer, Integer> length = new HashMap<Integer, Integer>();
  public static void main(String args[])  {
    int len = 0;
    length.put(1, 1);
    for (int i = 2; i < 1000000; ++i) {
      List<Integer> sequence = getLength(i);
      // putting all numbers in the sequence into map
      int totCnt = sequence.size();
      if(length.containsKey(sequence.get(sequence.size()-1))) {
        totCnt += length.get(sequence.get(sequence.size()-1));
      }
      for(int number : sequence) {
        length.put(number, totCnt);
        totCnt--;
      }
    }
  }

  public static List<Integer> getLength(int num)  {
    List<Integer> li = new ArrayList<Integer>();
    int len = 0;
    while (num != 1)  {
      if (length.containsKey(num))  {
        return li;
      } else  {
        li.add(num);
        if (num % 2 == 0) {
          num /= 2;
        } else  {
          num = 3 * num + 1;
        }
      }
    }
    return li;
  }
}
