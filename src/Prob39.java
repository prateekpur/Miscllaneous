/**
 * Created by ppuri on 10/15/2014.
 */
public class Prob39 {
  public static void main(String args[])  {
    for (int i = 1; i < 1000; i = i+2)  {
      int a = i+i+2;
      int b = i * (i+2);
      int c = (int)Math.sqrt(a*a + b*b);
      if (a+b+c < 1000) {
        System.out.println("a : "+a + " b :"+b + " c :"+c);
      }
    }
  }
}
