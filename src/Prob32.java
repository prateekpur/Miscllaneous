import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ppuri on 10/9/2014.
 */
public class Prob32 {
  public static void main(String args[])  {
    Set<Integer> pandigit = new HashSet<>();
    int sum = 0;
    for (int i = 100; i < 9999999; ++i) {
      if (doDigitsRepeat(i)) {
        continue;
      }
     // System.out.println(i);
      Set<Integer> set = getFactorsLessThanSquareRoot(i);
      for (int fact : set)  {
        if (factorsIncludeAllDigits(i, fact, i/fact)) {
          if (!pandigit.contains(i))  {
            pandigit.add(i);
            sum += i;
          }
        }
      }
    }
    System.out.println("Product : "+sum);
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

  private static boolean doDigitsRepeat(int num) {
    Set<Integer> digits = new HashSet<>();
    int dig;
    while (num > 0) {
      dig = num%10;
      if (dig == 0) {
        return true;
      }
      if (digits.contains(dig)) {
        return true;
      }
      digits.add(dig);
      num /= 10;
    }
    return false;
  }

  private static boolean factorsIncludeAllDigits(int num, int fact1, int fact2) {
    String s = Integer.toString(num) + Integer.toString(fact1) + Integer.toString(fact2);
    if (s.contains("0"))  {
      return false;
    }
    if (s.length() != 9) {
      return false;
    }
    // adding all characters to a set. At end set should have a length of 10
    Set<Character> set = new HashSet<>();
    for (char c: s.toCharArray()) {
      set.add(c);
    }
    return set.size() == 9;
  }
}
