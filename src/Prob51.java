import java.util.*;

/**
 * Created by Prateek on 12/31/2014.
 */
public class Prob51 {
  public static void main(String args[])  {
    long time = System.currentTimeMillis();
    //char c[] = Integer.toString(1023).toCharArray();
    //System.out.println(new String(c));
    Utils.getPrimes(9999999);
    List<Integer> li = new ArrayList<>();
    li.addAll(Utils.listPrimes);
    Set<Integer> s1 = new HashSet<Integer>(), s2 = new HashSet<Integer>(),s3 = new HashSet<Integer>(),s4 = new HashSet<Integer>(),
        s5 = new HashSet<Integer>(),s6 = new HashSet<Integer>(),s7 = new HashSet<Integer>();
    groupNumbersBySize(li,s1,s2,s3,s4,s5,s6,s7);

    int min = Integer.MAX_VALUE;
    int cnt = 0;
    Set<Integer> twoRepeatingDigs = new HashSet<>();
    Set<Integer> threeRepeatingDigs = new HashSet<>();
    for (int i : li) {
      boolean b[] = hasRepeatingDigits(i);
      if (b[0])  {
        twoRepeatingDigs.add(i);
      }
      if (b[1])  {
        threeRepeatingDigs.add(i);
      }
    }
    System.out.println("Min : " + min);
    System.out.println("Time : ");
    System.out.println(System.currentTimeMillis() - time);
  }

  public static List<Integer> getPermutations(int num) {
    List<Integer> li = new ArrayList<>();
    List<Integer> digs = Utils.getDigits(num);
    List<Integer> duplicates = new ArrayList<>();
    int arr[] = new int[10];
   // for \
   // 987777777777\*/
    return li;
  }

  public static List<String> getPermutations3Digit(int i, int cnt)  {
    List<String> li = new ArrayList<>();
    char ch[] = Integer.toString(i).toCharArray();
    char ch1[] = Integer.toString(i).toCharArray();
    //111000 110100 110010 110001 101100 101010 101001 100110 100101 100011
    //011100 011010 011001 010110 010101 010011
    //001110 001101 001011
    //000111

    int k = -1, j = -1, l = -1;
    switch (cnt)  {
      case 0:
        k = 0; j = 1; l = 2;
        break;
      case 1:
        k = 0; j = 1; l = 3;
        break;
      case 2:
        k = 0; j = 1; l = 4;
        break;
      case 3:
        k = 0; j = 1; l = 5;
        break;
      case 4:
        k = 0; j = 2; l = 3;
        break;
      case 5:
        k = 0; j = 2; l = 4;
        break;
      case 6:
        k = 0; j = 2; l =5;
        break;
      case 7:
        k = 0; j = 3; l =4;
        break;
      case 8:
        k = 0; j = 3; l =5;
        break;
      case 9:
        k = 0; j = 4; l =5;
        break;
      case 10:
        k = 1; j = 2; l =3;
        break;
      case 11:
        k = 1; j = 2; l =4;
        break;
      case 12:
        k = 1; j = 2; l =5;
        break;
      case 13:
        k = 1; j = 3; l =4;
        break;
      case 14:
        k = 1; j = 3; l =5;
        break;
      case 15:
        k = 1; j = 4; l =5;
        break;
      case 16:
        k = 2; j = 3; l =4;
        break;
      case 17:
        k = 2; j = 3; l =5;
        break;
      case 18:
        k = 2; j = 4; l =5;
        break;
      case 19:
        k = 3; j = 4; l =5;
        break;
    }
    //ch1[j]= '0';ch1[k] = '0'; ch1[l] = '0';li.add(new String(ch1));ch1[j]= ch[j];ch1[k] = ch[k];ch1[l] = ch[l];
    ch1[j]= '1';ch1[k] = '1'; ch1[l] = '1';li.add(new String(ch1));ch1[j]= ch[j];ch1[k] = ch[k];ch1[l] = ch[l];
    ch1[j]= '2';ch1[k] = '2'; ch1[l] = '2';li.add(new String(ch1));ch1[j]= ch[j];ch1[k] = ch[k];ch1[l] = ch[l];
    ch1[j]= '3';ch1[k] = '3'; ch1[l] = '3';li.add(new String(ch1));ch1[j]= ch[j];ch1[k] = ch[k];ch1[l] = ch[l];
    ch1[j]= '4';ch1[k] = '4'; ch1[l] = '4';li.add(new String(ch1));ch1[j]= ch[j];ch1[k] = ch[k];ch1[l] = ch[l];
    ch1[j]= '5';ch1[k] = '5'; ch1[l] = '5';li.add(new String(ch1));ch1[j]= ch[j];ch1[k] = ch[k];ch1[l] = ch[l];
    ch1[j]= '6';ch1[k] = '6'; ch1[l] = '6';li.add(new String(ch1));ch1[j]= ch[j];ch1[k] = ch[k];ch1[l] = ch[l];
    ch1[j]= '7';ch1[k] = '7'; ch1[l] = '7';li.add(new String(ch1));ch1[j]= ch[j];ch1[k] = ch[k];ch1[l] = ch[l];
    ch1[j]= '8';ch1[k] = '8'; ch1[l] = '8';li.add(new String(ch1));ch1[j]= ch[j];ch1[k] = ch[k];ch1[l] = ch[l];
    ch1[j]= '9';ch1[k] = '9'; ch1[l] = '9';li.add(new String(ch1));ch1[j]= ch[j];ch1[k] = ch[k];ch1[l] = ch[l];
    return li;
  }

  public static List<String> getPermutations2Digit(int i, int cnt)  {
    List<String> li = new ArrayList<>();
    char ch[] = Integer.toString(i).toCharArray();
    char ch1[] = Integer.toString(i).toCharArray();
    if (i > 14) {
      return li;
    }
      //110000 101000 100100 100010 100001 011000 010100 010010 010001 001100 001010 001001 000110 000101 000011
    int k = -1, j = -1;
    switch (cnt) {
      case 0:
        k = 0; j = 1;
        break;
      case 1:
        k = 0; j = 2;
        break;
      case 2:
        k = 0; j = 3;
        break;
      case 3:
        k = 0; j = 4;
        break;
      case 4:
        k = 0; j = 5;
        break;
      case 5:
        k = 1; j = 2;
        break;
      case 6:
        k = 1; j = 3;
        break;
      case 7:
        k = 1; j = 4;
        break;
      case 8:
        k = 1; j = 5;
        break;
      case 9:
        k = 2; j = 3;
        break;
      case 10:
        k = 2; j = 4;
        break;
      case 11:
        k = 2; j = 5;
        break;
      case 12:
        k = 3; j = 4;
        break;
      case 13:
        k = 3; j = 5;
        break;
      case 14:
        k = 4; j = 5;
        break;
    }
    ch1[j]= '0';ch1[k] = '0';
    li.add(new String(ch1));
    ch1[j]= ch[j];ch1[k] = ch[k];
    ch1[j]= '1';ch1[k] = '1';
    li.add(new String(ch1));
    ch1[j]= ch[j];ch1[k] = ch[k];
    ch1[j]= '2';ch1[k] = '2';
    li.add(new String(ch1));
    ch1[j]= ch[j];ch1[k] = ch[k];
    ch1[j]= '3';ch1[k] = '3';
    li.add(new String(ch1));
    ch1[j]= ch[j];ch1[k] = ch[k];
    ch1[j]= '4';ch1[k] = '4';
    li.add(new String(ch1));
    ch1[j]= ch[j];ch1[k] = ch[k];
    ch1[j]= '5';ch1[k] = '5';
    li.add(new String(ch1));
    ch1[j]= ch[j];ch1[k] = ch[k];
    ch1[j]= '6';ch1[k] = '6';
    li.add(new String(ch1));
    ch1[j]= ch[j];ch1[k] = ch[k];
    ch1[j]= '7';ch1[k] = '7';
    li.add(new String(ch1));
    ch1[j]= ch[j];ch1[k] = ch[k];
    ch1[j]= '8';ch1[k] = '8';
    li.add(new String(ch1));
    ch1[j]= ch[j];ch1[k] = ch[k];
    ch1[j]= '9';ch1[k] = '9';
    li.add(new String(ch1));
    ch1[j]= ch[j];ch1[k] = ch[k];

    return li;
  }

  public static boolean numbersMatch(int num1, int num2, int diffDig) {
    char ch1[] = Integer.toString(num1).toCharArray();
    char ch2[] = Integer.toString(num2).toCharArray();
    int diffCnt = 0;
    char diff=' ';
    for(int i =0; i < ch1.length; ++i)  {
      if(ch1[i] != ch2[i])  {
        ++diffCnt;
        if (diffCnt > diffDig)  {
          return false;
        }
        if (diff == ' ')  {
          diff = ch2[i];
        } else  {
          if (diff != ch2[i]) {
            return false;
          }
        }
      }
    }

    if (diffCnt == diffDig) {
      return true;
    }

    //case where numbers diff by 1 digit, but replacing 2 digits in first number still gives 2nd number
    // example : 1332,  1343
    if (diffCnt == 1) {
      ch2 = Integer.toString(num2).toCharArray();
      int cnt = 0;
      for (char c : ch2)  {
        if (c == diff)  {
          ++cnt;
        }
      }
      if (cnt < 2)  {
        return false;
      }
    }
    return true;
  }

  public static String getPattern(int num)  {
    List<Integer> li = Utils.getDigits(num);
    boolean arr[] = new boolean[10];
    boolean repeat[] = new boolean[10];
    boolean moreThanTwice[] = new boolean[10];
    for (int i : li)  {
      if(arr[i] && repeat[i]) {
        moreThanTwice[i] = true;
      }
      if (arr[i]) {
        repeat[i] = true;
      }
      arr[i] = true;
    }
    StringBuffer buf = new StringBuffer("");
    for (int j = 0; j < 10; ++j)  {
      if (moreThanTwice[j]) {
        buf.append(digitAppearsMoreThanTwice(num, j));
        continue;
      }
      if (!repeat[j]) {
        continue;
      }
      for (int i : li)  {
        if ( i == j)  {
          buf.append("*");
        } else  {
          buf.append(i);
        }
      }
      buf.append(",");
    }
    return buf.toString();
  }

  public static String digitAppearsMoreThanTwice(int i, int dig) {
    List<Integer> li = Utils.getDigits(i);
    List<Integer> positions = new ArrayList<>();
    int cnt = 0;
    for ( int i1 = 0; i1 < li.size(); ++i1)  {
      if (li.get(i1) == dig)  {
        positions.add(i1);
      }
    }
    StringBuffer buf = new StringBuffer("");
    String s = new String();
    s = s + i;
    char ch[] = new char[10];
    switch (positions.size()) {
      case 3:
        ch = s.toCharArray();
        ch[positions.get(0)] = '*';
        ch[positions.get(1)] = '*';
        buf.append(ch);
        buf.append(",");
        ch = s.toCharArray();
        ch[positions.get(0)] = '*';
        ch[positions.get(2)] = '*';
        buf.append(ch);
        buf.append(",");
        ch = s.toCharArray();
        ch[positions.get(1)] = '*';
        ch[positions.get(2)] = '*';
        buf.append(ch);
        buf.append(",");
        break;
      case 4:
        ch = s.toCharArray();
        ch[positions.get(2)] = '*';
        ch[positions.get(3)] = '*';
        buf.append(ch);
        buf.append(",");
        ch = s.toCharArray();
        ch[positions.get(1)] = '*';
        ch[positions.get(3)] = '*';
        buf.append(ch);
        buf.append(",");
        ch = s.toCharArray();
        ch[positions.get(1)] = '*';
        ch[positions.get(2)] = '*';
        buf.append(ch);
        buf.append(",");
        ch = s.toCharArray();
        ch[positions.get(0)] = '*';
        ch[positions.get(3)] = '*';
        buf.append(ch);
        buf.append(",");
        ch = s.toCharArray();
        ch[positions.get(0)] = '*';
        ch[positions.get(2)] = '*';
        buf.append(ch);
        buf.append(",");
        ch = s.toCharArray();
        ch[positions.get(0)] = '*';
        ch[positions.get(1)] = '*';
        buf.append(ch);
        buf.append(",");
        break;
      case 5:
        // size = 5 permutations - 00***,0*0**,0**0*,0***0,*00**,*0*0*,*0**0,**00*,**0*0,***00
        ch = s.toCharArray();
        ch[positions.get(0)] = '*';
        ch[positions.get(1)] = '*';
        buf.append(ch);
        buf.append(",");
        ch = s.toCharArray();
        ch[positions.get(0)] = '*';
        ch[positions.get(2)] = '*';
        buf.append(ch);
        buf.append(",");
        ch = s.toCharArray();
        ch[positions.get(0)] = '*';
        ch[positions.get(3)] = '*';
        buf.append(ch);
        buf.append(",");
        ch = s.toCharArray();
        ch[positions.get(0)] = '*';
        ch[positions.get(4)] = '*';
        buf.append(ch);
        buf.append(",");
        ch = s.toCharArray();
        ch[positions.get(1)] = '*';
        ch[positions.get(2)] = '*';
        buf.append(ch);
        buf.append(",");
        ch = s.toCharArray();
        ch[positions.get(1)] = '*';
        ch[positions.get(3)] = '*';
        buf.append(ch);
        buf.append(",");
        ch = s.toCharArray();
        ch[positions.get(1)] = '*';
        ch[positions.get(4)] = '*';
        buf.append(ch);
        buf.append(",");
        ch = s.toCharArray();
        ch[positions.get(2)] = '*';
        ch[positions.get(3)] = '*';
        buf.append(ch);
        buf.append(",");
        ch = s.toCharArray();
        ch[positions.get(2)] = '*';
        ch[positions.get(4)] = '*';
        buf.append(ch);
        buf.append(",");
        ch = s.toCharArray();
        ch[positions.get(3)] = '*';
        ch[positions.get(4)] = '*';
        buf.append(ch);
        buf.append(",");
        break;
      case 6:
        //00****,0*0***,0**0**,0***0*,0****0,
        // ***00*,***0*0,****00
        ch = s.toCharArray();
        ch[positions.get(0)] = '*';
        ch[positions.get(1)] = '*';
        buf.append(ch);
        buf.append(",");
        ch = s.toCharArray();
        ch[positions.get(0)] = '*';
        ch[positions.get(2)] = '*';
        buf.append(ch);
        buf.append(",");
        ch = s.toCharArray();
        ch[positions.get(0)] = '*';
        ch[positions.get(3)] = '*';
        buf.append(ch);
        buf.append(",");
        ch = s.toCharArray();
        ch[positions.get(0)] = '*';
        ch[positions.get(4)] = '*';
        buf.append(ch);
        buf.append(",");
        ch = s.toCharArray();
        ch[positions.get(0)] = '*';
        ch[positions.get(5)] = '*';
        buf.append(ch);
        buf.append(",");
        //*00***,*0*0**,*0**0*,*0***0,
        ch = s.toCharArray();
        ch[positions.get(1)] = '*';
        ch[positions.get(2)] = '*';
        buf.append(ch);
        buf.append(",");
        ch = s.toCharArray();
        ch[positions.get(1)] = '*';
        ch[positions.get(3)] = '*';
        buf.append(ch);
        buf.append(",");
        ch = s.toCharArray();
        ch[positions.get(1)] = '*';
        ch[positions.get(4)] = '*';
        buf.append(ch);
        buf.append(",");
        ch = s.toCharArray();
        ch[positions.get(1)] = '*';
        ch[positions.get(5)] = '*';
        buf.append(ch);
        buf.append(",");
        //**00**,**0*0*,**0**0,
        ch = s.toCharArray();
        ch[positions.get(2)] = '*';
        ch[positions.get(3)] = '*';
        buf.append(ch);
        buf.append(",");
        ch = s.toCharArray();
        ch[positions.get(2)] = '*';
        ch[positions.get(4)] = '*';
        buf.append(ch);
        buf.append(",");
        ch = s.toCharArray();
        ch[positions.get(2)] = '*';
        ch[positions.get(5)] = '*';
        buf.append(ch);
        buf.append(",");
        ch = s.toCharArray();
        ch[positions.get(3)] = '*';
        ch[positions.get(4)] = '*';
        buf.append(ch);
        buf.append(",");
        ch = s.toCharArray();
        ch[positions.get(3)] = '*';
        ch[positions.get(5)] = '*';
        buf.append(ch);
        buf.append(",");
        ch = s.toCharArray();
        ch[positions.get(4)] = '*';
        ch[positions.get(5)] = '*';
        buf.append(ch);
        buf.append(",");
    }
      //get all permutations
      // size = 3 permutations - 00*,0*0,*00
      // size = 4 permutations - 00**,0*0*,0**0,*00*,*0*0,**00
      // size = 5 permutations - 00***,0*0**,0**0*,0***0,*00**,*0*0*,*0**0,**00*,**0*0,***00
      // size = 6 permutations - 00****,0*0***,0**0**,0***0*,0****0,*00***,*0*0**,*0**0*,*0***0,**00**,**0*0*,**0**0,***00*,***0*0,****00
    return buf.toString();
  }

  public static boolean[] hasRepeatingDigits(int num)  {
    List<Integer> li = Utils.getDigits(num);
    int arr[] = new int[10];
    boolean b[] = new boolean[2];
    for (int i : li)  {
      ++arr[i];
    }
    for (int i : arr) {
      if (i == 3) {
        b[1] = true;
      } else if (i == 2)  {
        b[0] = true;
      } else  {}
    }
    return b;
  }

  public static void groupNumbersBySize(List<Integer> li, Set<Integer> s1, Set<Integer> s2, Set<Integer> s3, Set<Integer> s4,
                                        Set<Integer> s5, Set<Integer> s6, Set<Integer> s7)  {
    for (int i : li)  {
      if (i < 10) {
        s1.add(i);
      } else if (i < 100) {
        s2.add(i);
      } else if (i < 1000)  {
        s3.add(i);
      } else if (i < 10000) {
        s4.add(i);
      } else if (i < 100000)  {
        s5.add(i);
      } else if (i < 1000000) {
        s6.add(i);
      } else if (i < 10000000)  {
        s7.add(i);
      } else  {

      }
    }
  }
}


//121313
//121*1*