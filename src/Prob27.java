/**
 * Created by ppuri on 10/8/2014.
 */
public class Prob27 implements Runnable {
  int low;
  int high;

  Prob27(int l, int h)  {
    low = l; high = h;
  }

  static int rangeLower = 1;
  static int rangeHigh = 1;

  public static void main(String args[])  {
    System.out.println(System.currentTimeMillis());
    Utils.loadPrimes("C:\\Prateek\\Project_Euler\\Miscllaneous\\src\\prime_numbers");
    (new Thread(new Prob27(-999, 1000))).start();


  }

  public void run() {
    //System.out.println(System.currentTimeMillis());
    //System.out.println("Low : " + low + " High : " + high);
    int maxLen = 0, maxA = 0, maxB = 0;
    for (int i = low; i < high; ++i)  {
      for (int j = -999; j < 1000; ++j)  {
        int len = findPrimes(i, j);
        if (len > maxLen) {
          maxLen = len;
          maxA = i;
          maxB = j;
        }
      }
    }
    System.out.println(" A :"+maxA + " maxB :"+maxB + " Max Length :"+maxLen);
    System.out.println(System.currentTimeMillis());
  }

  public static int findPrimes(int a, int b)  {
    int len = 0, maxLen = 0;
    long prime = 0;
    for (int n = 1; ; ++n) {
      prime = (n*n) + a*n + b;
      if (prime < 0)  {
        return len;
      }
      if (!Utils.primes.contains(prime)) {
        return len;
      }
      ++len;
    }
    // this line might not reach because a sequence will find some non-prime number
  }
}

