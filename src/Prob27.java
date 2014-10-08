/**
 * Created by ppuri on 10/8/2014.
 */
public class Prob27 {

  public static void main(String args[])  {
    Utils.loadPrimes("C:\\Prateek\\Project_Euler\\Miscllaneous\\src\\prime_numbers");
    findPrimes(1, 1);
  }

  public static int findPrimes(int a, int b)  {
    int len = 0;
    int prime = 0;
    for (int n = 1; n<Integer.MAX_VALUE; ++n) {
      prime = (n*n) + a*n + b;
      ++len;
    }
    return len;
  }
}
