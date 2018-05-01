import java.math.BigInteger;

/**
 * Created by neha on 4/15/18.
 */
public class Prob63 {
  public static void main (String args[])  {
    BigInteger ten = new BigInteger("10");
    int cnt = 0;
    //int pow = 2;
    // powers of number >= 10 will have more than required digits
    for (int i = 2; i <= 9; ++i)  {
      for (int pow = 1; pow < 50; ++pow)  {
        BigInteger high = ten.pow(pow);
        BigInteger low = ten.pow(pow-1);
        BigInteger curr = new BigInteger(Integer.toString(i));
        if (curr.pow(pow).compareTo(high) == -1 && curr.pow(pow).compareTo(low) == 1)  {
          ++cnt;
        }
        if (curr.pow(pow).compareTo(low) == -1) {
          break;
        }
      }
    }
    System.out.println(cnt);
  }
}
