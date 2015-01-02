import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Prateek on 11/6/2014.
 */
public class Prob56 {
  public static void main(String args[])  {
    System.out.println(System.currentTimeMillis());
    Utils.loadPrimes("C:\\Prateek\\Project_Euler\\Miscllaneous\\src\\prime_numbers");
    List<Integer> squares = new ArrayList<>();
    for (int i = 1; i < 10000; ++i) {
      squares.add(2*i*i);
    }
    for (int i = 9; i < Integer.MAX_VALUE; i = i + 2 )  {
      if (Utils.primes.contains(i)) {
        continue;
      }
    }
  }
}
