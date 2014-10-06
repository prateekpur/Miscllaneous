/**
 * Created by Prateek on 10/5/2014.
 */
public class Prob17 {
  public static void main(String args[])  {
    long size = 0;
    long size1to99 = 0;
    // counting 1 to 10
    StringBuffer oneToTen = new StringBuffer("one" +
        "two" +
        "three" +
        "four" +
        "five" +
        "six" +
        "seven" +
        "eight" +
        "nine");
    size1to99 += oneToTen.length();
    //counting 11 to 20
    StringBuffer sb2 = new StringBuffer("ten" +
        "eleven" +
        "twelve" +
        "thirteen" +
        "fourteen" +
        "fifteen" +
        "sixteen" +
        "seventeen" +
        "eighteen" +
        "nineteen");
    size1to99 += sb2.length();
    //counting 21 to 30
    size1to99 += "twenty".length()*10 + oneToTen.length();
    //counting 31 to 40
    size1to99 += "thirty".length()*10 + oneToTen.length();
    //counting 41 to 50
    size1to99 += "forty".length()*10 + oneToTen.length();
    //counting 51 to 60
    size1to99 += "fifty".length()*10 + oneToTen.length();
    //counting 61 to 70
    size1to99 += "sixty".length()*10 + oneToTen.length();
    //counting 71 to 80
    size1to99 += "seventy".length()*10 + oneToTen.length();
    //counting 81 to 90
    size1to99 += "eighty".length()*10 + oneToTen.length();
    //counting 91 to 99
    size1to99 += "ninety".length()*10 + oneToTen.length();
    //counting 1 to 100
    //size *= 10;
    //one hundred 100 times
    size += "onehundredand".length()*99 + "onehundred".length();
    size += "twohundredand".length()*99 + "twohundred".length();
    size += "threehundredand".length()*99 + "threehundred".length();
    size += "fourhundredand".length()*99 + "fourhundred".length();
    size += "fivehundredand".length()*99 + "fivehundred".length();
    size += "sixhundredand".length()*99 + "sixhundred".length();
    size += "sevenhundredand".length()*99 + "sevenhundred".length();
    size += "eighthundredand".length()*99 + "eighthundred".length();
    size += "ninehundredand".length()*99 + "ninehundred".length();
    size += "onethousand".length();
    System.out.println(size + size1to99 * 10);
    //dSystem.out.println(size1to99 * 3);
  }
}
