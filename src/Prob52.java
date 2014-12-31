import java.util.*;

/**
 * Created by Prateek on 12/31/2014.
 */
public class Prob52 {
  public static void main(String args[])  {
    final long max = Long.MAX_VALUE/6;
    for (long i = 1l; i < max; ++i) {
      List<Integer> li = new ArrayList<>();
      li = Utils.getDigits(i);
      Collections.sort(li);
      List<Integer> newList = new ArrayList<>();
      newList = Utils.getDigits(i*2l);
      if (!listsAreSame(li, newList)) {
        continue;
      }
      newList = Utils.getDigits(i*3l);
      if (!listsAreSame(li, newList)) {
        continue;
      }
      newList = Utils.getDigits(i*4l);
      if (!listsAreSame(li, newList)) {
        continue;
      }
      newList = Utils.getDigits(i*5l);
      if (!listsAreSame(li, newList)) {
        continue;
      }
      newList = Utils.getDigits(i*6l);
      if (!listsAreSame(li, newList)) {
        continue;
      }
      System.out.println(i);
    }
  }

  public static boolean listsAreSame(List<Integer> l1, List<Integer> l2)  {
    if (l1.size() != l2.size()) {
      return false;
    }
    Collections.sort(l1);
    Collections.sort(l2);
    for (int i = 0; i < l1.size(); ++i) {
      if (l1.get(i) != l2.get(i)) {
        return false;
      }
    }
    return true;
  }
}
