import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Prateek on 5/22/2018.
 */
public class Prob74 {
  static Map<Long, Long> factorial;
  static int chainsize[] = new int [1000001];

  public static void main(String args[])  {
    factorial = new HashMap<>();
    //1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880
    factorial.put(0l, 1l);
    factorial.put(1l, 1l);
    factorial.put(2l, 2l);
    factorial.put(3l, 6l);
    factorial.put(4l, 24l);
    factorial.put(5l, 120l);
    factorial.put(6l, 720l);
    factorial.put(7l, 5040l);
    factorial.put(8l, 40320l);
    factorial.put(9l, 362880l);
    for (int i = 0; i < 1000000; ++i) {
      Set<Long> set = new HashSet<>();
      long l = calcFactorial(i);
      set.add(l);
      while(set.size() <= 60)  {

        l = calcFactorial(l);
        if (set.contains(l))  {
          break;
        }
        set.add(l);
      }
      if (set.size() == 59) {
        System.out.println("^^^^^^" + i);
      }
    }
  }

  static long calcFactorial(long n) {
    long num = n;
    long sum = 0l;
    if (factorial.containsKey(n)) {
      return factorial.get(n);
    }
    do {
      if (factorial. containsKey(n))  {
        sum += factorial.get(n);
        break;
      }
      sum += factorial.get(n%10);
      n /= 10;
    } while (n > 0);
    factorial.put(num, sum);
    return sum;
  }
}
