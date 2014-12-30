import java.io.IOException;

/**
 * Created by ppuri on 10/15/2014.
 */
public class Prob37 {
  final static int[] powers = new int[]{1,10,100,1000,10000,100000,1000000,10000000,100000000,1000000000};

  public static void main(String args[]) throws IOException {
    Utils.getPrimes(100000000);
    long sum = 0l;
    boolean rotatePrime = true;
    for (int i = 10; i < 100000000; ++i)  {
      if (Utils.primes_bitset.get(i))  {
        continue;
      }
      int tmp = i;
      while(tmp > 0)  {
        if (Utils.primes_bitset.get(tmp)) {
          rotatePrime = false;
          break;
        }
        tmp = removeLeftDigit(tmp);
      }
      tmp = i;
      while(tmp > 0)  {
        if (Utils.primes_bitset.get(tmp)) {
          rotatePrime = false;
          break;
        }
        tmp = removeRightDigit(tmp);
      }
      if (rotatePrime)  {
        sum += i;
      }
      rotatePrime = true;
    }
    System.out.println(sum);
  }

  private static int removeLeftDigit(int num) {
    return num%powers[Utils.getLength(num)-1];
  }

  private static int removeRightDigit(int num) {
    return num/10;
  }

}
