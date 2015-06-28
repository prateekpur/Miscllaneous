package codejam;

/**
 * Created by Prateek on 4/11/2015.
 */
public class Pancake {
  public static void main(String args[])  {
    int diners[] = new int[100];
    int pancakes[] = {1,2,1,2};
    int boundary = 0;
    int time = 0;
    while (doesAnyoneHasGreaterThan3(pancakes, boundary)) {
      time++;
    }
  }

  static boolean doesAnyoneHasGreaterThan3(int[] pancakes, int boundary)  {
    int maxIndex = -1;
    for (int i = 0; i < boundary; ++i)  {
      if (pancakes[i] > 3 && maxIndex == -1)  {
        maxIndex = i;
      } else if (pancakes[i] > pancakes[maxIndex]) {
        maxIndex = i;
      }
    }
    if (maxIndex != -1) {
      int cakes = pancakes[maxIndex];
      pancakes[maxIndex] = pancakes[maxIndex] / 2;
      pancakes[boundary] = cakes - pancakes[maxIndex];
    }
    return maxIndex == -1;
  }
}
