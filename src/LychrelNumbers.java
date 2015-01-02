import java.math.BigInteger;

/**
 * Solution to https://projecteuler.net/problem=55
 */
public class LychrelNumbers {
  public static void main(String args[])  {
    reverse("1023");
    for (int i = 10; i < 10000; ++i) {
      boolean lychrel = true;
      BigInteger b = new BigInteger(Integer.toString(i));
      for (int iter = 0; iter < 50; ++iter) {
        String s = reverse(b.toString());
        b = b.add(new BigInteger(s));
        s = reverse(b.toString());
        if (s.equalsIgnoreCase(b.toString())) {
          //System.out.println(i + " : " + iter);
          lychrel = false;
          break;
        }
      }
      if (lychrel)  {
        System.out.println(i);
      }
    }
  }

  static String reverse(String s) {
    String s1 = "";
    for (int i = s.length()-1; i >= 0; --i)  {
      s1 = s1 + s.charAt(i);
    }
    return s1;
  }
}
