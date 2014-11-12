import java.math.BigInteger;

/**
 * Created by ppuri on 10/8/2014.
 */
public class Prob25 {

  public static void main(String args[])  {
    BigInteger fib1 = new BigInteger("1"), fib2 = new BigInteger("1");
    int cnt = 2;
    while (length(fib2) < 1000)  {
      BigInteger tmp = fib1.add(fib2);
      fib1 = fib2;
      fib2 = tmp;
      ++cnt;
    }
  }


  public static int length(BigInteger num){
    return num.toString().length();
  }
}
