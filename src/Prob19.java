/**
 * Created by ppuri on 10/7/2014.
 */
public class Prob19 {
  public static void main(String args[])  {
    //1st sunday 4/1/1900
    int count = 1;
    int totalDays = 0;
    for (int month = 9; month <=12; ++month)  {
      totalDays += numberOfDaysInMonth(month, 1901);
      if (totalDays % 7 == 0) {
        ++count;
        totalDays = 0;
      }
    }
    for (int year = 1902; year <= 2000; ++year) {
      for (int month = 1; month <=12; ++month)  {
        totalDays += numberOfDaysInMonth(month, year);
        if (totalDays % 7 == 0) {
          ++count;
          totalDays = 0;
        }
      }
    }
  }

  public static int numberOfDaysInMonth(int month, int year)  {
    if (month == 9 || month == 4 ||  month == 6 || month == 11) {
      return 30;
    } else if (month == 2)  {
      if (year % 4 == 0)  {
        if (year % 100 == 0 && year % 400 != 0) {
          return 28;
        }
        return 29;
      } else  {
        return 28;
      }
    } else  {
      return 31;
    }
  }
}
