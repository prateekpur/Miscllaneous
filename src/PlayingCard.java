import java.util.*;

/**
 * Created by Prateek on 12/31/2014.
 */
public class PlayingCard implements Comparable<PlayingCard>{
  static Map<Character, Prob54.SUITE> suites = new HashMap<>();
  static {
    suites.put(Character.toUpperCase('H'), Prob54.SUITE.Heart);
    suites.put(Character.toUpperCase('D'), Prob54.SUITE.Diamond);
    suites.put(Character.toUpperCase('S'), Prob54.SUITE.Spade);
    suites.put(Character.toUpperCase('C'), Prob54.SUITE.Club);
  }
  private String val;
  private Prob54.SUITE suite;
  int score;
  public PlayingCard(String s)  {
    val = s.substring(0,s.length() - 1);
    suite = PlayingCard.suites.get(s.charAt(s.length() - 1));
    switch (val)  {
      case "1" :
        score = 1;
        break;
      case "2" :
        score = 2;
        break;
      case "3" :
        score = 3;
        break;
      case "4" :
        score = 4;
        break;
      case "5" :
        score = 5;
        break;
      case "6" :
        score = 6;
        break;
      case "7" :
        score = 7;
        break;
      case "8" :
        score = 8;
        break;
      case "9" :
        score = 9;
        break;
      case "T" :
        score = 10;
        break;
      case "J" :
        score = 11;
        break;
      case "Q" :
        score = 12;
        break;
      case "K" :
        score = 13;
        break;
      case "A" :
        score = 14;
        break;
    }
  }

  public String getVal() {
    return val;
  }

  public Prob54.SUITE getSuite() {
    return suite;
  }

  @Override
  public int compareTo(PlayingCard o) {
    return score - o.score;
  }
}
