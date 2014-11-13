import java.util.Collections;

/**
 * Created by ppuri on 11/13/2014.
 */
public class Prob50 {
  static int maxSum = 1000000;
  public static void main(String args[])  {
    /// there are 78498 prime numbers less than million.
    Utils.loadPrimes("C:\\Prateek\\Project_Euler\\Miscllaneous\\src\\prime_numbers");
    Utils.getPrimes(maxSum);
    Collections.sort(Utils.listPrimes);
    int size = Utils.listPrimes.size();
    long primeSum[][] = new long[size][2];
    int sum = 0;
    for (int i = 0; i < size; ++i) {
      sum += Utils.listPrimes.get(i);
      primeSum[i][0] = Utils.listPrimes.get(i);
      primeSum[i][1] = sum;
    }
    int maxLength = 0;
    long maxEnd = 0;
    for (int i = 0; i < size; ++i) {
      if (i % 10000 == 0)  {
        System.out.println(" i : "+i);
      }
      long numReduce = 0;
      if (i != 0) {
        numReduce = primeSum[i-1][1];
      }
      int end = lastPrimePos(primeSum, numReduce, i);
      if (end - i > maxLength)  {
        maxLength = end - i+1;
        maxEnd = primeSum[end][1] - numReduce;
        System.out.println("Max length : " + maxLength + " : start : " + i + " : end :" + end);
      }
    }
    System.out.println("Max End : " + maxEnd);
  }

  public static int lastPrimePos(long[][] primeSum, long numReduce, int startPos) {
    int size = -1;
    for (int i = primeSum.length-1; i > startPos; i-- ) {
      long score = primeSum[i][1] - numReduce;
      if (score > maxSum) {
        continue;
      }
      if (Utils.primes.contains(score)) {
        return i;
      }
    }
    return -1;
  }

}
