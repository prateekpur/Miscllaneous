import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by ppuri on 10/2/2014.
 */
public class Prob12 {
  public static void main(String args[])  {
    System.out.println(System.currentTimeMillis());
    Utils.loadPrimes("C:\\Prateek\\Project_Euler\\Miscllaneous\\src\\prime_numbers");
    int cnt = 2, curNumber = 1;
    int t = getNumberOfFactors(20);
    while(getNumberOfFactors(curNumber) < 500)  {
      curNumber += cnt;
      cnt++;
    }
    System.out.println(curNumber);
    System.out.println(System.currentTimeMillis());
  }

  public static int getNumberOfFactors(int num)  {
    int factors = 1;
    Iterator<Integer> iter = Utils.primes.iterator();
    while(iter.hasNext()) {
      int prime = iter.next();
      if (prime > num) {
        break;
      }
      if (num % prime == 0) {
        int pow = 0;
        //find power of prime which can divide num
        for (int i = 1; i < 100000; ++i)  {
          if (num % Math.pow(prime, i) != 0)  {
            pow = i-1;
            break;
          }
        }
        factors *= (pow+1);
      }
    }
    return factors;
  }

}
