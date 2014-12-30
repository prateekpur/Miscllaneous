import java.math.BigInteger;

/**
 * Created by ppuri on 11/11/2014.
 */
public class Prob48 {
  public static void main(String args[])  {
    BigInteger total = new BigInteger("0");
    for (int i = 1; i < 1000; ++i)  {
      BigInteger b = new BigInteger(Integer.toString(i));
      total = total.add(b.pow(i));
    }
    System.out.println(total.toString());
  }
}
