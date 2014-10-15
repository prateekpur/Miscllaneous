import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ppuri on 10/15/2014.
 */
public class Prob38 {
  public static void main(String args[])  {
    List<Integer> li = new ArrayList<>();
    long max = 0;
    li.add(192*1);
    li.add(192*2);
    li.add(192*3);
    areNumbersPandigital(li);
    for (int i = 2; i <= 9999; ++i) {
      // combined length of all multiples. When length = 9, check for Pandigital
      int len = 0;
      li.clear();
      for (int j = 1; j <10; ++j) {
        len += Utils.getLength(i*j);
        if (len <= 9) {
          li.add(i*j);
        }
        if (len == 9) {
          if (max < areNumbersPandigital(li)) {
            max = areNumbersPandigital(li);
          }
        }
        if (len > 9)  {
          break;
        }
      }
    }
    System.out.println(max);
  }

  private static long areNumbersPandigital(List<Integer> nums) {
    Set<Integer> set = new HashSet<>();
    List<Integer> allDigits = new ArrayList<>();
    for (int i : nums)  {
      List<Integer> li = Utils.getDigits(i);
      for (int digit : li)  {
        allDigits.add(digit);
        if (!set.add(digit))  {
          return 0;
        }
      }
    }
    long sum = 0;
    if (set.size() == 9)  {
      sum += allDigits.get(8) * 1;
      sum += allDigits.get(7) * 10;
      sum += allDigits.get(6) * 100;
      sum += allDigits.get(5) * 1000;
      sum += allDigits.get(4) * 10000;
      sum += allDigits.get(3) * 100000;
      sum += allDigits.get(2) * 1000000;
      sum += allDigits.get(1) * 10000000;
      sum += allDigits.get(0) * 100000000;
    }
    System.out.println(sum);
    return sum;
  }
}
