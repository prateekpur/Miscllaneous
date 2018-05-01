import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by neha on 4/15/18.
 */
public class Prob62 {
  public static void main(String args[])  {
    Map<String, List<Long>> map = new HashMap<>();
    List<Long> li1 = new ArrayList<>(); li1.add(105l);
    //map.put(num3, li1);
    //li1.clear();li1.add(501);
    //boolean b = map.containsKey(num2);
    for (long i = 1; i <= 2097151; ++i) {
      String digs = getDigitsSorted( i * i * i);
      if (map.containsKey(digs))  {
        List<Long> li = map.get(digs);
        li.add(i*i*i);
        map.put(digs, li);
      } else  {
        List<Long> li = new ArrayList<>();
        li.add(i*i*i);
        map.put(digs, li);
      }
    }
    long min = Long.MAX_VALUE;
    for (String digs : map.keySet())  {
      if (map.get(digs).size() == 5)  {
        for (long l : map.get(digs))  {
          if (l < min)  {
            min = l;
          }
        }
      }
    }
    System.out.println(min);
  }

  /**
   * returns digits in a number with their frequency. Digits are sorted in increasing order
   * Example 100 returns "02,11" 13541 returns "12,31,41,51"
   * @param num
   * @return
   */
  static String getDigitsSorted(long num) {
    int digs[] = new int[10];
    while (num > 0) {
      digs[(int)(num % 10)]++;
      num = num / 10;
    }
    StringBuilder bld = new StringBuilder();
    for (int i = 0; i < 10; ++i)  {
      if (digs[i] == 0) {
        continue;
      }
      bld.append(i);
      bld.append(",");
      bld.append(digs[i]);
    }
    return bld.toString();
  }
}
