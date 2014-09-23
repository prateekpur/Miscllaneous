/**
 * Created by ppuri on 9/22/2014.
 */
public class Prob3 {
  //775146
  public static void main(String args[])  {
    // 0th place of the array is not being used
    System.out.println(System.currentTimeMillis());
    boolean nums[] = new boolean[775147];
    for (int i = 2; i < 775147; ++i)  {
      if (!nums[i]) {
        //System.out.println(i);
        for (int j = i+1; j < 775147; ++j) {
          if (!nums[j]) {
            if (j % i == 0) {
              nums[j] = true;
            }
          }
        }
      }
    }
    System.out.println(System.currentTimeMillis());
  }
}
