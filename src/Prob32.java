import java.util.HashSet;
import java.util.Set;

/**
 * Created by ppuri on 10/9/2014.
 */
public class Prob32 {
  public static void main(String args[])  {
    for (int i = 100; i < 9999999; ++i) {
      Set<Integer> set = getFactorsLessThanSquareRoot(i);
      for (int fact : set)  {
        if (factorsIncludeAllDigits(i, fact, i/fact)) {
          System.out.println( "num : " + i + "factor 1 : " + fact + "factor 2 :" + i/fact);
        }
      }
    }
  }

  private static Set<Integer> getFactorsLessThanSquareRoot(int num)  {
    Set<Integer> set = new HashSet<>();
    if (num == 15628) {
      System.out.println("");
    }
    for (int i = 2; i <= Math.sqrt(num); ++i) {
      if (num % i == 0) {
        set.add(i);
      }
    }
    return set;
  }

  private static boolean factorsIncludeAllDigits(int num, int fact1, int fact2) {
    String s = Integer.toString(num) + Integer.toString(fact1) + Integer.toString(fact2);
    if (s.length() != 10) {
      return false;
    }
    // adding all characters to a set. At end set should have a length of 10
    Set<Character> set = new HashSet<>();
    for (char c: s.toCharArray()) {
      set.add(c);
    }
    return set.size() == 10;
  }
}
