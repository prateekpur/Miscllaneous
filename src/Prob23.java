import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ppuri on 10/8/2014.
 */
public class Prob23 {
  /*public static void main(String[] args) {
    System.out.println(new Prob23().run());
  }*/


  private static final int LIMIT = 28123;

  private boolean[] isAbundant = new boolean[LIMIT + 1];

  public String run() {
    // Compute look-up table
    for (int i = 1; i < isAbundant.length; i++)
      isAbundant[i] = isAbundant(i);

    int sum = 0;
    for (int i = 1; i <= LIMIT; i++) {
      if (!isSumOf2Abundants(i))  {
        sum += i;
        System.out.println(i);
      }
    }
    return Integer.toString(sum);
  }


  private boolean isSumOf2Abundants(int n) {
    for (int i = 0; i <= n; i++) {
      if (isAbundant[i] && isAbundant[n - i]) {
        if (n == 1141)  {
          System.out.println(" i : " + i);
          System.out.println(" n-i : " +  (n-i));
        }
        return true;
      }
    }
    return false;
  }


  private static boolean isAbundant(int n) {
    if (n < 1)
      throw new IllegalArgumentException();

    int sum = 1;  // Sum of factors less than n
    int end = (int)Math.sqrt(n);
    for (int i = 2; i <= end; i++) {
      if (n % i == 0)
        sum += i + n / i;
    }
    if (end * end == n)
      sum -= end;
    return sum > n;
  }
  public static void main(String args[])  {
    //System.out.println(new Prob23().run());
    List<Integer> perfectNumbers = new ArrayList<>();
    List<Integer> abundantNumbers = new ArrayList<>();
    getPerfectNumbers(perfectNumbers, abundantNumbers);
    Set<Integer> sumNums = sumAllAbundantNumbers(abundantNumbers);
    long sum = 0;
    for (int i = 1; i < 28123; ++i) {
      if (!sumNums.contains(i)) {
        sum += i;
        System.out.println(i);
      }
    }
    System.out.println(sum);
  }

  public static void getPerfectNumbers(List<Integer> perfectNum, List<Integer> abundantNum) {
    List<Integer> li = new ArrayList<>();
    for (int i = 2; i < 28123 ; ++i)  {
      List<Integer> factors = new ArrayList<>();
      factors.add(1);
      for (int j = 2; j <= Math.sqrt(i); ++j)  {
        if (i % j == 0) {
          factors.add(j);
          if (Math.sqrt(i) != j) {
            factors.add(i / j);
          }
        }
      }
      int sum = 0;
      for (int num : factors) {
        sum += num;
      }
      if (i == sum) {
        perfectNum.add(i);
      }
      if (i < sum)  {
        abundantNum.add(i);
      }
    }
  }

  public static Set<Integer> sumAllAbundantNumbers(List<Integer> abundantNums)  {
    Set<Integer> sumAbundantNums = new HashSet<>();
    for (int i : abundantNums)  {
      for (int j : abundantNums)  {
        if(i+j == 8) {
          System.out.println(" ");
        }
        sumAbundantNums.add(i + j);
      }
    }
    return sumAbundantNums;
  }

}
