import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Prateek on 2/4/2016.
 */
public class Prob47 {
  static List<Integer> primes = new ArrayList<>();

  public Prob47() {
  }

  public static void main(String args[])  {
    long time = System.currentTimeMillis();
    Utils.getPrimes(9999999);
    primes.addAll(Utils.listPrimes);
    Set<Integer> numbers = new HashSet<>();
    for (int i = 2; i < Integer.MAX_VALUE; ++i) {
      Set<Integer> s = getPrimeFactors(i);
      if (s.size() >= 4)  {
        numbers.add(i);
        if (numbers.contains(i-1) && numbers.contains(i-2) && numbers.contains(i-3))  {
          System.out.println("Number Found : "+i);
          System.exit(0);
        }
        System.out.println(i);
        System.out.println("Factors");
        StringBuffer s1 = new StringBuffer("");
        for (int j : s) {
          s1.append(j);
          s1.append(",");
        }
        System.out.println(s1.toString());
      }
    }
  }

  static Set<Integer> getPrimeFactors(int i) {
    Set<Integer> s = new HashSet<>();
    for (int j : primes)  {
      if (j >= i) {
        return s;
      }
      if (i % j == 0) {
        s.add(j);
      }
    }
    return s;
  }
}
