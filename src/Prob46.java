import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Created by ppuri on 11/11/2014.
 */
public class Prob46 {
  public static void main(String args[]) {
    System.out.println(System.currentTimeMillis());
    Set<Integer> squares = Utils.getSquares(1000);
    Utils.loadPrimes("C:\\Prateek\\Project_Euler\\Miscllaneous\\src\\prime_numbers");
    Utils.getPrimes(100000000);
    boolean found = false;
    for (long i = 35; !found; i = i+2)  {
      if (Utils.primes.contains(i)) {
        continue;
      }
      found = true;
      // continue if the odd number is prime and not composite
      for (int j : Utils.listPrimes)  {
        if (j > i)  {
          break;
        }
        if (squares.contains(i-j)) {
          //System.out.println("Number found : " + i);
          found = false;
          continue;
        }
      }
      if (found)  {
        System.out.println("Number found : " + i);
      }
    }
    System.out.println(System.currentTimeMillis());
  }
}
