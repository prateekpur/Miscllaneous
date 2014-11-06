import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Prateek on 11/6/2014.
 */
public class Prob55 {
  public static void main(String args[])  {
    System.out.println(System.currentTimeMillis());
    Set<BigInteger> pentagonMap = new HashSet<>();
    Set<BigInteger> triangleMap = new HashSet<>();
    Set<BigInteger> hexagonMap = new HashSet<>();
    //generate list of pentagon numbers
    for (int i = 143; i < 150000; ++i) {
      //long j = i*(3*i-1)/2;
      BigInteger j = BigInteger.valueOf(i);
      j = j.multiply(BigInteger.valueOf((3*i-1)/2));
      pentagonMap.add(j);
      j = BigInteger.valueOf(i);
      j = j.multiply(BigInteger.valueOf((i+1)/2));
      triangleMap.add(j);
      j = BigInteger.valueOf(i);
      j = j.multiply(BigInteger.valueOf(2*i - 1));
      hexagonMap.add(j);
    }
    triangleMap.retainAll(pentagonMap);
    triangleMap.retainAll(hexagonMap);
  }
}
