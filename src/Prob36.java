/**
 * Created by ppuri on 10/15/2014.
 */
public class Prob36 {
  public static void main(String args[])  {
    long sum = 0l;
    for (int i = 1; i < 1000000; ++i) {
      String s = Integer.toString(i);
      String reverse = new StringBuilder(s).reverse().toString();
      if (s.equalsIgnoreCase(reverse))  {
        String base2 = convertToBase2(i);
        String reverseBase2 = new StringBuilder(base2).reverse().toString();
        if (base2.equalsIgnoreCase(reverseBase2)) {
          sum += i;
        }
      }
    }
    System.out.println(sum);
  }

  private static String convertToBase2(int num) {
    String s = "";
    while(num > 0)  {
      s = num%2 + s;
      num /= 2;
    }
    return s;
  }

  private static int reverseNumber(int num) {
    int reverse = 0;
    return reverse;
  }
}
