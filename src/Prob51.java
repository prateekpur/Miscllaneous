import java.util.*;

/**
 * Created by Prateek on 12/31/2014.
 */
public class Prob51 {
  public static void main(String args[])  {
    long time = System.currentTimeMillis();
    Utils.getPrimes(9999999);
    List<Integer> li = new ArrayList<>();
    li.addAll(Utils.listPrimes);
    List<Integer> newLi = new ArrayList<>();
    Map<String, String> map = new HashMap<>();
    for (int i : li)  {
      String s = getPattern((i));
      String s1[] = s.split(",");
      for (String s2 : s1)  {
        if (s2.equalsIgnoreCase(""))  {
          continue;
        }
        String nums = map.get(s2);
        if (nums == null)  {
          map.put(s2, Integer.toString(i));
        } else {
          map.put(s2, nums + "," + i);
        }
      }
    }
    int lowestInt = Integer.MAX_VALUE;
    for (String s : map.values()) {
      String s1[] = s.split(",");
      if (s1.length < 8)  {
        continue;
      } else  {
        for (String s2 : s1)  {
          int tmp = Integer.parseInt(s2);
          if (tmp < lowestInt)  {
            lowestInt = tmp;
          }
        }
      }
    }
    System.out.println(System.currentTimeMillis() - time);
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

  public static boolean hasRepeatingDigits(int num)  {
    List<Integer> li = Utils.getDigits(num);
    boolean arr[] = new boolean[10];
    for (int i : li)  {
      if (arr[i]) {
        return true;
      }
      arr[i] = true;
    }
    return false;
  }
}


//121313
//121*1*