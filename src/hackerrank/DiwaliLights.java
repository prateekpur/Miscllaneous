package hackerrank;

import sun.security.util.BigInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by Prateek on 12/30/2014.
 */
public class DiwaliLights {
  public static void main(String args[]) throws IOException {
    BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    String temp = bfr.readLine();
    int tests = Integer.parseInt(temp);
    for (int i = 0; i < tests; ++i) {
      temp = bfr.readLine();
      int n = Integer.parseInt(temp);
      BigInteger b = new BigInteger("2");
      b = b.pow(n).subtract(new BigInteger("1"));
      b = b.mod(new BigInteger("100000"));
      System.out.println(b);
    }
  }
}

