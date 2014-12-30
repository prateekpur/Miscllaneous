import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Set;

/**
 * Created by ppuri on 10/16/2014.
 */
public class Prob43 {
  static int cnt = 0;
  public static void main(String args[])  {
    multiplesOf7With5InMid();
    generatePermutations();
    System.out.println("golden standard");
    getGoldPermutations();
  }

  static void multiplesOf7With5InMid()  {
    for (int i = 105; i < 999; i+=7)  {
      int midDig = (i/10)%10;
      if (midDig == 5)  {
        //System.out.println(i);
      }
    }
  }

  static void generatePermutations()  {
    Set<String> set = new HashSet<String>();
    int digs[] = new int[] {0,9,8,7,6,5,4,3,2,1};
    while (Utils.getNextPerm(digs)) {
      StringBuilder bld = new StringBuilder();
      for (int i : digs)  {
        bld.append(i);
      }
      if (!set.add(bld.toString())) {
        System.out.println("Duplicate string");
      } else  {
        //System.out.println(bld.toString());
      }
    }
    System.out.println(set.size());
  }

  static void getGoldPermutations() {
    Set<String> set = new HashSet<String>();
    String s = getNextLexicographicPermutation("0987654321");
    while (!s.equalsIgnoreCase("last")) {
      s = getNextLexicographicPermutation(s);
      set.add(s);
      //System.out.println(s);
    }
    System.out.println(set.size());
  }

  static String getNextLexicographicPermutation(String a) {

    int largestIndexK = -1;         // if this stays negative, we are at last permutation
    int largestIndexL = 0;
    char[] b = a.toCharArray();     // holds the next permutation as we build it

    // Find the largest index k such that a[k] < a[k + 1].
    // If no such index exists, the permutation is the last permutation.
    for (int k = 0; k < a.length() - 1; k++) {
      if (a.charAt(k) < a.charAt(k + 1)) {
        largestIndexK = k;
      }
    }

    if (largestIndexK == -1) {
      //System.out.println("last permutation");
      return "last";
    }

    // Find the largest index l such that a[k] < a[l].
    // Since k + 1 is such an index, l is well defined and satisfies k < l.
    for (int l = 0; l < a.length(); l++) {
      if (a.charAt(largestIndexK) < a.charAt(l)) {
        largestIndexL = l;
      }
    }

    // Swap a[k] with a[l].
    b[largestIndexK] = a.charAt(largestIndexL);
    b[largestIndexL] = a.charAt(largestIndexK);

    // Reverse the sequence from a[k + 1] up to and including the final element a[n].
    String s = new String(b).substring(largestIndexK + 1);
    int x = 1;
    for (int i=s.length(); i > 0; i--) {
      b[largestIndexK + x] = s.charAt(i - 1);
      x++;
    }

    a = new String(b);

    return a;
  }

  public static boolean isPandigital(int digs[])  {
//    ++cnt;
//    if (cnt % 2000 == 0)  {
//      System.out.println(num + " : " + cnt);
//    }
    // Verifying divisibility
    //d2d3d4 divisible by 2 can be decided by d4
    if (digs[3]%2 != 0)  {
      return false;
    }
    //d3d4d5 divisible by 3
    long num1 = digs[2]*100+digs[3]*10+digs[4];
    if (num1 % 3 != 0)  {
      return false;
    }
    //d4d5d6 divisible by 5
    if (digs[5] == 0 || digs[5] == 5) {
      return false;
    }
    //d5d6d7 divisible by 7
    num1 = digs[4]*100+digs[5]*10+digs[6];
    if (num1 % 7 != 0)  {
      return false;
    }
    //d6d7d8 divisible by 11
    num1 = digs[5]*100+digs[6]*10+digs[7];
    if (num1 % 11 != 0) {
      return false;
    }
    //d7d8d9 divisible by 13
    num1 = digs[6]*100+digs[7]*10+digs[8];
    if (num1 % 13 != 0) {
      return false;
    }
    //d8d9d10 divisible by 17
    num1 = digs[7]*100+digs[8]*10+digs[9];
    if (num1 % 17 != 0) {
      return false;
    }
    return true;
  }
}
