/**
 * Created by ppuri on 9/22/2014.
 */
public class Prob1 {
  public static void main(String args[])  {
    int cnt = 0;
    for (int i = 0; i < 1000; i+=3) {
      cnt = cnt + i;
    }
    for (int i = 0; i < 1000; i+=5) {
      if (i%3 != 0) {
        cnt = cnt + i;
      }
    }
  }
}
