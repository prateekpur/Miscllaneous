import java.util.ArrayList;
import java.util.List;

/**
 * Created by ppuri on 10/7/2014.
 */
public class Prob21 {
  public static void main(String args[])  {
    for (int i = 220; i < 10000; ++i) {
      List<Integer> li = getFactors(i);
      int sum = 0;
      for (int j : li)  {
        sum += j;
      }
      if (sum == 1 || sum == i) {
        continue;
      }
      li = getFactors(sum);
      int newsum = 0;
      for (int j : li)  {
        newsum += j;
      }
      if (i == newsum)  {
        System.out.println(" : "+sum + " : "+newsum);
      }
    }
  }

  public static List<Integer> getFactors(int num)  {
    List<Integer> li = new ArrayList<>();
    li.add(1);
    for (int i = 2; i <= Math.sqrt(num); ++i) {
      if (num % i == 0) {
        li.add(i);
        li.add(num / i);
      }
    }
    return li;
  }
}
