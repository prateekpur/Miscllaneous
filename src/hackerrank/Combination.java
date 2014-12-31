package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by Prateek on 12/30/2014.
 */
public class Combination {
  public static void main(String args[]) throws IOException {
    BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    String temp = bfr.readLine();
    int tests = Integer.parseInt(temp);
    BigInteger one  = new BigInteger("1");
    BigInteger modulo = new BigInteger("1000000000");
    for (int i = 0; i < tests; ++i) {
      temp = bfr.readLine();
      StringBuilder bld = new StringBuilder("");
      int n = Integer.parseInt(temp);
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
        bld.append(prevVal.mod(modulo));
        bld.append(" ");
      }
      System.out.println(bld.toString());
    }
  }
}
