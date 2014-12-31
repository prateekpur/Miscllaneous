import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by Prateek on 12/31/2014.
 */
public class Prob53 {
  public static void main(String args[]) throws IOException {
    BigInteger one  = new BigInteger("1");
    BigInteger million = new BigInteger("1000000");
    int cnt = 0;
    for (int i = 23; i <= 100; ++i) {
      StringBuilder bld = new StringBuilder("");
      int n = i;
      BigInteger prevVal = new BigInteger("1");
      bld.append(prevVal.toString());
      bld.append(" ");
      BigInteger n1 = new BigInteger(Integer.toString(n));
      for (int j = 1; j <= n; ++j) {
        BigInteger j1 = new BigInteger(Integer.toString(j));
        //prevVal = prevVal * (n - j + 1)/j;
        BigInteger tmp = n1.subtract(j1).add(one);
        prevVal = prevVal.multiply(tmp);
        prevVal = prevVal.divide(j1);
        if (prevVal.compareTo(million) == 1)  {
          ++cnt;
        }
      }
      System.out.println(cnt);
    }
  }

}
