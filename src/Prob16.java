import java.math.BigInteger;

/**
 * Created by Prateek on 10/5/2014.
 */
public class Prob16 {
  /*private static int calcDigits(String s)
  {
    int sum = 0;

    for (int i = 0; i < s.length(); i++)
    {
      Character c = new Character(s.charAt(i));
      String z = c.toString();
      int j = Integer.parseInt(z);
      sum += j;
    }

    return sum;
  }

  public static void main(String[] args)
  {
    long begin = System.currentTimeMillis();

    BigInteger n = BigInteger.valueOf(2);
    n = n.pow(1000);
    System.out.println(calcDigits(n.toString()));

    long end = System.currentTimeMillis();
    System.out.println(end - begin + "ms");
  }*/
  public static void main(String args[])  {
    BigInteger b = new BigInteger("2");
    b = b.pow(1000);
    String s = b.toString();
    int i = 0;
    for (char c : s.toCharArray())  {
      i += Integer.parseInt(new Character(c).toString());
    }
    System.out.println(i);
  }
}
