import java.util.ArrayList;
import java.util.List;

/**
 * Created by ppuri on 9/22/2014.
 */
public class Prob2 {
  public static void main(String args[])  {
    List<Integer> nums = new ArrayList<Integer>(100000);
    long total = 0;
    nums.add(1);
    nums.add(2);
    int firstNum = 1, secNum = 2, cnt = 0;
    while(firstNum + secNum < 4000000)  {
      nums.add(firstNum + secNum);
      int tmp = firstNum + secNum;
      if (tmp % 2 == 0) {
        total += tmp;
      }
      firstNum = secNum;
      secNum = tmp;
      ++cnt;
    }
  }
}
