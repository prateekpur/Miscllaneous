import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Prateek on 12/31/2014.
 */
public class Prob54 {
  static Set<String> royalFlush = new HashSet<>();

  public static void main(String args[])  {
    royalFlush.add("10");
    royalFlush.add("J");
    royalFlush.add("Q");
    royalFlush.add("K");
    royalFlush.add("A");
    List<CardsHand> hands = new ArrayList<>();
    int cnt = 0;
    try{
      BufferedReader br = new BufferedReader(new FileReader("C:\\prateek\\projects\\Miscllaneous\\src\\resource\\poker.txt"));
      String line = br.readLine();
      while (line != null) {
        ++cnt;
        String s[] = line.split(" ");
        CardsHand tmp = new CardsHand();
        tmp.addCard(new PlayingCard(s[0]));
        tmp.addCard(new PlayingCard(s[1]));
        tmp.addCard(new PlayingCard(s[2]));
        tmp.addCard(new PlayingCard(s[3]));
        tmp.addCard(new PlayingCard(s[4]));
        tmp.calculateRanks();
        hands.add(tmp);
        CardsHand tmp1 = new CardsHand();
        tmp1.addCard(new PlayingCard(s[5]));
        tmp1.addCard(new PlayingCard(s[6]));
        tmp1.addCard(new PlayingCard(s[7]));
        tmp1.addCard(new PlayingCard(s[8]));
        tmp1.addCard(new PlayingCard(s[9]));
        tmp1.calculateRanks();
        hands.add(tmp1);
        boolean res = firstPlayerWins(tmp, tmp1);
        if (res)  {
          System.out.println(cnt);
        }
        line = br.readLine();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   *
   * @param first
   * @param second
   * @return True if first player wins , false if second player wins
   */
  public static boolean firstPlayerWins(CardsHand first, CardsHand second) {
    //sorting cards for both players
    List<PlayingCard> liFirst = new ArrayList<>(), liSecond = new ArrayList<>();
    liFirst.add(first.cards[0]);
    liFirst.add(first.cards[1]);
    liFirst.add(first.cards[2]);
    liFirst.add(first.cards[3]);
    liFirst.add(first.cards[4]);
    liSecond.add(second.cards[0]);
    liSecond.add(second.cards[1]);
    liSecond.add(second.cards[2]);
    liSecond.add(second.cards[3]);
    liSecond.add(second.cards[4]);
    Collections.sort(liFirst);
    Collections.reverse(liFirst);
    Collections.sort(liSecond);
    Collections.reverse(liSecond);

    if (first.result.get(RANK.RoyalFlush) == 1)  {
      return true;
    }
    if (first.result.get(RANK.StraightFlush) != 0 || second.result.get(RANK.StraightFlush) != 0)  {
      return first.result.get(RANK.StraightFlush) > second.result.get(RANK.StraightFlush);
    }
    if (first.result.get(RANK.FourOfAKind) != 0 || second.result.get(RANK.FourOfAKind) != 0)  {
      int res =  first.result.get(RANK.StraightFlush) - second.result.get(RANK.StraightFlush);
      if (res > 0)  {
        return true;
      } else if (res < 0) {
        return false;
      } else  {
        return first.getFifthCardInFourOfAKind() > second.getFifthCardInFourOfAKind();
      }
    }
    if (first.result.get(RANK.FullHouse) != 0 || second.result.get(RANK.FullHouse) != 0)  {
      int res = first.result.get(RANK.FullHouse) - second.result.get(RANK.FullHouse);
      if (res == 0) {
        return first.getPairInFullHouseHand() > second.getPairInFullHouseHand();
      } else  {
        return res > 0;
      }
    }
    if (first.result.get(RANK.Flush) != 0 || second.result.get(RANK.Flush) != 0)  {
      return first.result.get(RANK.Flush) > second.result.get(RANK.Flush);
    }
    if (first.result.get(RANK.Straight) != 0 || second.result.get(RANK.Straight) != 0)  {
      return first.result.get(RANK.Straight) > second.result.get(RANK.Straight);
    }
    if (first.result.get(RANK.ThreeOfAKind) != 0 || second.result.get(RANK.ThreeOfAKind) != 0) {
      int res = first.result.get(RANK.ThreeOfAKind) - second.result.get(RANK.ThreeOfAKind);
      if (res != 0) {
        return res > 0;
      } else  {
        // comparing highest cards
        for (int i = 0; i < 5; ++i) {
          int score1 = liFirst.get(i).score;
          int score2 = liSecond.get(i).score;
          if (score1 != score2) {
            return score1 > score2;
          }
        }
      }
    }
    if (first.result.get(RANK.TwoPairs) != 0 || second.result.get(RANK.TwoPairs) != 0)  {
      int res = first.result.get(RANK.TwoPairs) - second.result.get(RANK.TwoPairs);
      if (res != 0) {
        return res > 0;
      } else  {
        res = first.getSecondPairInTwoPairsHand() - second.getSecondPairInTwoPairsHand();
        if (res != 0) {
          return res > 0;
        } else  {
          //Compare fifth card
          int firstFifth = 0, secondFifth = 0;
          for (PlayingCard c : first.cards) {
            if (!(c.score == first.result.get(RANK.TwoPairs) || c.score == first.getSecondPairInTwoPairsHand()))  {
              firstFifth = c.score;
            }
          }
          for (PlayingCard c : second.cards) {
            if (!(c.score == second.result.get(RANK.TwoPairs) || c.score == second.getSecondPairInTwoPairsHand()))  {
              secondFifth = c.score;
            }
          }
          return firstFifth > secondFifth;
        }
      }
    }
    if (first.result.get(RANK.OnePair) != 0  || second.result.get(RANK.OnePair) != 0)  {
      int res = first.result.get(RANK.OnePair) - second.result.get(RANK.OnePair);
      if (res != 0) {
        return res > 0;
      } else  {
        //get cards without pair
        List<PlayingCard> li1 = new ArrayList<>();
        li1.addAll(liFirst);
        List<PlayingCard> li2 = new ArrayList<>();
        li2.addAll(liSecond);
        //removing pairs
        int index1 = 0, index2 = 0;
        for (int i = 0; i < 5; ++i) {
          if (li1.get(i).score == first.result.get(RANK.OnePair)) {
            if (index1 == 0)  {
              index1 = i;
            } else  {
              index2 = i;
            }
          }
        }
        li1.remove(index1);
        li1.remove(index2);
        index1 = 0;
        index2 = 0;
        for (int i = 0; i < 5; ++i) {
          if (li2.get(i).score == second.result.get(RANK.OnePair)) {
            if (index1 == 0)  {
              index1 = i;
            } else  {
              index2 = i;
            }
          }
        }
        li2.remove(index1);
        li2.remove(index2);

        for (int i = 0; i < 5; ++i) {
          int res1 = li1.get(i).score - li2.get(i).score;
          if (res1 != 0)  {
            return res1 > 0;
          }
        }
      }
    }
    // comparing highest cards
    for (int i = 0; i < 5; ++i) {
      int res1 = liFirst.get(i).score - liSecond.get(i).score;
      if (res1 != 0)  {
        return res1 > 0;
      }
    }

    return false;
  }

  enum RANK {
    HighCard, OnePair, TwoPairs, ThreeOfAKind, Straight, Flush, FullHouse, FourOfAKind,StraightFlush, RoyalFlush;
  }

  enum SUITE {
    Club('C', 0), Diamond('D', 1), Heart('H', 2), Spade('S', 3);
    private SUITE(char c, int id) {
      name = c;
      index = id;
    }
    char name;
    // index is used when storing suites in an array
    int index;
  }
}
