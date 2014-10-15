import java.io.IOException;

/**
 * Created by ppuri on 10/15/2014.
 */
public class Prob37 {
  final static int[] powers = new int[]{1,10,100,1000,10000,100000,1000000,10000000,100000000,1000000000};

  public static void main(String args[]) throws IOException {
    Utils.getPrimes();
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
    return num%powers[getLength(num)-1];
  }

  private static int removeRightDigit(int num) {
    return num/10;
  }

  // finds length upto 10 digits.
  private static int getLength(int num) {
    if (num > 100000000) {
      return 9;
    } else if (num > 10000000) {
      return 8;
    } else if (num > 1000000) {
      return 7;
    } else if (num > 100000) {
      return 6;
    } else if (num > 10000) {
      return 5;
    } else if (num > 1000) {
      return 4;
    } else if (num > 100) {
      return 3;
    } else if (num > 10) {
      return 2;
    } else  {
      return 1;
    }
  }
}
