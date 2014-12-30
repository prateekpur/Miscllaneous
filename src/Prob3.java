/**
 * Created by ppuri on 9/22/2014.
 */
public class Prob3 {
  //775146
  public static void main(String args[])  {
    // 0th place of the array is not being used
    Utils.loadPrimes("C:\\prateek\\work\\Miscllaneous\\src\\prime_numbers");
    System.out.println(System.currentTimeMillis());
    long num = 600851475143l;
    for (long i : Utils.primes)  {
      if (num%i == 0) {
        System.out.println(i);
      }
    }
  }
}
