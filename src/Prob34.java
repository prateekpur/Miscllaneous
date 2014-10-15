/**
 * Created by Prateek on 10/14/2014.
 */
public class Prob34 {
  final static int[] factorials = new int[] {1,1,2,6,24,120,720,5040,40320,362880};
  public static void main(String args[])  {
    long sum = 0l;
    for (int i = 3; i < Integer.MAX_VALUE; ++i) {
      if (i == getFactorialSums(i)) {
        sum += i;
      }
    }
    System.out.println(sum);
  }

  private static int getFactorialSums(int num)  {
    int sum = 0, tmp = num;
    while(num > 0)  {
      sum += factorials[num%10];
      if (sum > tmp)  {
        return sum;
      }
      num /= 10;
    }
    return sum;
  }
}
