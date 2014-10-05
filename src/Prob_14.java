import java.util.*;

/**
 * Created by Prateek on 10/4/2014.
 */
public class Prob_14 {

  public static Map<Long, Long> numbers = new HashMap<>();
  static long maxLength = 0, maxNum = 0;

  public static void main(String args[])  {
    numbers.put(1l, 1l);
    numbers.put(2l, 2l);
    System.out.println(System.currentTimeMillis());
    Set<Long> set = new HashSet<>();
    for (long i = 3; i < 1000000; ++i) {
      if (set.contains(i))  {
        continue;
      }
      try {
        List<Long> li = getSequence(i);
        addToMap(li);
      } catch (Exception e) {
        set.add(i);
      }
    }
    System.out.println(System.currentTimeMillis());
  }

  public static void addToMap(List<Long> li) {
    long lastNum = li.get(li.size() - 1);
    long totLength = li.size();
    if (numbers.containsKey(lastNum)) {
      totLength += numbers.get(lastNum);
      // reducing 1 because last number is already part of the list
      totLength -= 1;
    }
    if (totLength > maxLength)  {
      maxLength = totLength;
      maxNum = li.get(0);
    }
    for(long num : li) {
      numbers.put(num, totLength--);
    }
  }

  public static List<Long> getSequence(long num)  {
    //System.out.println(num);
    List<Long> li = new ArrayList<Long>();
    while (!numbers.containsKey(num))  {
      li.add(num);
      if (num % 2 == 0) {
        num /= 2;
      } else  {
        num = 3 * num + 1;
      }
    }
    if (numbers.containsKey(num)) {
      li.add(num);
    }
    return li;
  }
}
