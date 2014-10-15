/**
 * Created by Prateek on 10/14/2014.
 */
public class Prob33 {
  public static void main(String args[]) {
    int denom = 1, numem = 1;
    for (int i = 10; i <100; ++i) {
      for (int j = i+1; j <=100; ++j)  {
        if (i == j) {
          continue;
        }
        if (isRatioSame(i, j))  {
          //System.out.println("i : " + i + " j :"+j);
          denom *= j;
          numem *= i;
        }
      }
    }
    System.out.println("Denom " + denom + "Numerator " + numem);
  }

  private static boolean isRatioSame(int num1, int num2)  {
    int digit1_num1, digit2_num1, digit1_num2, digit2_num2;
    double fraction1 = (double)num1 / num2;
    digit1_num1 = num1 % 10;
    digit2_num1 = num1 / 10;
    digit1_num2 = num2 % 10;
    digit2_num2 = num2 / 10;
    if (digit1_num1 == digit2_num2)  {
      if ((double)digit2_num1/digit1_num2 == fraction1) {
        return true;
      }
    } else if (digit2_num1 == digit1_num2)  {
      if ((double)digit1_num1/digit2_num2 == fraction1) {
        return true;
      }
    } else  {
      return false;
    }
    return false;
  }
}
