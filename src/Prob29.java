import java.util.HashSet;
import java.util.Set;

/**
 * Created by ppuri on 10/9/2014.
 */
public class Prob29 implements Runnable {
  public static void main(String args[])  {
    System.out.println(System.currentTimeMillis());
    (new Thread(new Prob29())).start();


  }
  public void run() {
    Set<Double> set = new HashSet<>();
    for (int i = 2; i <=100; ++i)  {
      for (int j = 2; j <=100; ++j) {
        set.add(Math.pow(i, j));
      }
    }
  }
}
