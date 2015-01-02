import java.math.BigInteger;

/**
 * Created by Prateek on 1/2/2015.
 */
public class Prob57 {
  public static void main(String args[])  {
    System.out.println(Integer.MAX_VALUE);
    StringBuilder bld = new StringBuilder();
    BigInteger num = new BigInteger("1");
    BigInteger denom = new BigInteger("2");
    BigInteger two = new BigInteger("2");
    BigInteger one = new BigInteger("1");
    int cnt = 0;
    for (int i = 0; i < 1000; ++i) {
      //num = 2 * denom + num;
      num = denom.multiply(two).add(num);
      BigInteger swp = num;
      num = denom;
      denom = swp;
      //BigInteger newnum = 1 * denom + num;
      BigInteger newnum = one.multiply(denom).add(num);
      if (newnum.toString().length() > denom.toString().length()) {
        bld.append(newnum);
        bld.append("/");
        bld.append(denom);
        bld.append("    ");
        //bld.append(Character.PARAGRAPH_SEPARATOR);
        ++cnt;
      }
    }
    System.out.println(cnt);
  }
}
