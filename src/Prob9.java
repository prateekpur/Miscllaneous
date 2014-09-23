import java.util.ArrayList;
import java.util.List;

/**
 * Created by ppuri on 9/23/2014.
 */
public class Prob9 {
  public static void main(String args[])  {
    for (int i = 4; i < 1000 ; ++i) {
      //System.out.println("Num : " + i);
      for (String s : getTriplets(i)) {
        //System.out.println(s);
      }
    }
  }

  public static String[] getTriplets(int num) {
    List<Integer> factors = new ArrayList<Integer>();
    if (num % 2 != 0) return new String[1];
    num = num / 2;
    //get factors of num/2
    for (int i = 1; i <= Math.floor(Math.sqrt(num)); ++i) {
      if (num % i == 0) {
        factors.add(i);
      }
    }
    String[] triples = new String[factors.size()];
    int cntTriples = 0;
    for (int i : factors) {
      int j = num / i;
      int num1 = i*i + j*j;
      int num2 = Math.abs(i*i - j*j);
      if (num1+num2+(num*2) == 1000)  {
        System.out.println(num*2 + "," + num1 + "," + num2);
      }
      if (num1 < 1000 && num2 < 1000) {
        triples[cntTriples] = num*2 + "," + num1 + "," + num2;
      }
    }
    return triples;
  }
}
