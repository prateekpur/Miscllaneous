import java.io.Console;
import java.math.BigInteger;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by neha on 4/29/18.
 */
public class Prob69 {
  static int range = 1000000;
  static BitSet primes = Utils.getPrimesBitset(range);
  static int relPrime[] = new int[range];
  public static void main(String[] args) {
    new Prob69().Bruteforce();
  }



  public static void Bruteforce() {
    getRelPrimes(131074);
    long start = System.currentTimeMillis();
    //setting relative prime count for all prime numbers and their powers
    for (int i = 2; i < range; ++i) {
      if (!primes.get(i)) {
        relPrime[i - 1] = i - 1;
        // calculating for powers of prime
        // will break out of for loop when i ^^ j > range, so j wont reach upper limit
        for (int j = 2; j < range; ++j) {
          if (Math.pow(i, j) > range) {
            break;
          }
          System.out.println("Number : " + (int)Math.pow(i, j) + " : Relative prime :" + (int)(Math.pow(i, j) - Math.pow(i, j-1)));
          relPrime[(int)Math.pow(i, j) - 1] = (int)(Math.pow(i, j) - Math.pow(i, j-1));
        }
      }
    }

    for (int i = 2; i < range; ++i) {
      if (relPrime[i - 1] == 0) {
        relPrime[i - 1] = getRelPrimes(i);
      }
    }
    float max = 0f;
    int maxNum = 0;
    float ratios[] = new float[range];
    for (int i = 2; i < range; ++i) {
      if (relPrime[i-1] == -1)  {
        getRelPrimes(i);
      }
      float ratio = (float)(i) / (float)relPrime[i-1];
      ratios[i-1] = ratio;
      if (max < ratio)  {
        max = ratio;
        maxNum = i;
      }
    }
    System.out.println("Solution took " +  Long.toString(System.currentTimeMillis() - start));
    System.out.println("Max : " + max + " : Number : " + maxNum + " : ratio :"+ratios[maxNum-1]);
  }

  static int getRelPrimes(int num)  {
    Set<Integer> set = getPrimeFactors(num);
    BigInteger total = new BigInteger(Integer.toString(num));
    for (int i : set) {
      total = total.multiply(new BigInteger(Integer.toString(i-1)));
      total = total.divide(new BigInteger(Integer.toString(i)));
    }
    return total.intValue();
  }

  static Set<Integer> getPrimeFactors(int num)  {
    Set<Integer> set = new HashSet<>();
    for (int i = 2; i < Math.sqrt(num); ++ i ) {
      if (num % i == 0) {
        if (!primes.get(i)) {
          set.add(i);
        }
        if (!primes.get(num/i)) {
          set.add(num/i);
        }
      }
    }
    return set;
  }
}
