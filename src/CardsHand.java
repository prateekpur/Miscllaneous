import javax.print.attribute.standard.PrinterLocation;
import java.util.*;

/**
 * Stores 5 cards
 */
public class CardsHand {
  static Set<String> royalFlush = new HashSet<>();
  // set royal flush contains card vales required for royal flush. It does not check for suite, that is done in method isRoyalFlush90
  static {
    royalFlush.add("10");
    royalFlush.add("J");
    royalFlush.add("Q");
    royalFlush.add("K");
    royalFlush.add("A");
  }

  PlayingCard cards[] = new PlayingCard[5];
  private short cardsAdded = 0;
  // result stores values for each rank. Booleans are stores as 1 - True, 0 - False
  // Example if a hand has Royal Flush , result will have a Pair RANK.RoyalFlush, 1
  // For Two Pairs, result will store score of highest Pair
  // One Pair - result stores score of 1 pair
  // Highest - result stores score of highest card
  Map<Prob54.RANK, Integer> result = new HashMap<>();

  public void addCard(PlayingCard c) {
    cards[cardsAdded] = c;
    ++cardsAdded;
  }

  boolean isRoyalFlush() {
    Prob54.SUITE firstSuite = cards[0].getSuite();
    if (firstSuite == cards[1].getSuite() && firstSuite == cards[2].getSuite() && firstSuite == cards[3].getSuite()
        && firstSuite == cards[4].getSuite()) {
      // set royalFlush has cards needed for a Royal Flush
      if (royalFlush.contains(cards[0].getVal()) && royalFlush.contains(cards[1].getVal()) &&
          royalFlush.contains(cards[2].getVal()) && royalFlush.contains(cards[3].getVal()) &&
          royalFlush.contains(cards[4].getVal())) {
        return true;
      }
    }
    return false;
  }

  /**
   *
   * @return - Highest value card if straight flush exists, otherwise return 0
   */
  int isStraightFlush()  {
    Prob54.SUITE firstSuite = cards[0].getSuite();
    if (firstSuite == cards[1].getSuite() && firstSuite == cards[2].getSuite() && firstSuite == cards[3].getSuite()
        && firstSuite == cards[4].getSuite())  {
      return isConsecutive();
    }
    return 0;
  }

  private int isConsecutive() {
    List<PlayingCard> li = new ArrayList<>();
    for (PlayingCard c : cards) {
      li.add(c);
    }
    Collections.sort(li);
    if ((li.get(0).score == li.get(1).score - 1) && (li.get(1).score == li.get(2).score - 1) &&
        (li.get(2).score == li.get(3).score - 1) && (li.get(3).score == li.get(4).score - 1)) {
      return li.get(0).score;
    }
    return 0;
  }

  /**
   *
   * @return  - Highest card if Four of a kind exists, otherwise return 0
   */
  int isFourOfAKind()  {
    // scores[0] will not be sued because no card has score = 0
    int scores[] = new int[15];
    for(PlayingCard c : cards)  {
      scores[c.score]++;
      if (scores[c.score] == 4) {
        return c.score;
      }
    }
    return 0;
  }

  int isFullHouse()  {
    int id = isThreeOfAKind();
    if (id != 0) {
      // checking for pair
      PlayingCard pairCard = null;
      for (PlayingCard c : cards) {
        if (c.score == id)  {
          continue;
        } else if (pairCard == null)  {
          pairCard = c;
        } else  {
          if (pairCard.score == c.score) {
            return id;
          }
        }
      }
    }
    return 0;
  }

  int isFlush() {
    int score = 0;
    Prob54.SUITE suite = cards[0].getSuite();
    for (PlayingCard c : cards) {
      if(c.getSuite() != suite) {
        return 0;
      } else  {
        if (c.score > score)  {
          score = c.score;
        }
      }
    }
    return score;
  }

  int isStraight()  {
    return isConsecutive();
  }

  /**
   *
   * @return score if "Three of a kind" is found return value else return 0
   */
  int isThreeOfAKind()  {
    // count will have number of cards in hand for each score
    int count[] = new int[15];
    for (PlayingCard c : cards) {
      count[c.score]++;
      if (count[c.score] == 3)  {
        return c.score;
      }
    }
    return 0;
  }

  /**
   * Finds whether hand has two pairs
   * @return score of the highest if 2 pairs exist, otherwise return 0
   */
  int isTwoPairs()  {
    int numPairs = 0, highestPair = 0;
    int scores[] = new int[15];
    for (PlayingCard c : cards) {
      scores[c.score]++;
      if(scores[c.score] == 2)  {
        ++numPairs;
        if (c.score > highestPair)  {
          highestPair = c.score;
        }
      }
    }
    if (numPairs == 2)  {
      return highestPair;
    }
    return 0;
  }

  /**
   * Finds if the hand has one pair
   * @return score of the pair pair exists otherwise return 0
   */
  int isOnePair() {
    int scores[] = new int[15];
    for (PlayingCard c : cards) {
      scores[c.score]++;
      if (scores[c.score] == 2) {
        return c.score;
      }
    }
    return 0;
  }

  int highestValueCardInHand()  {
    int max = 0;
    for (PlayingCard c : cards) {
      if (c.score > max)  {
        max = c.score;
      }
    }
    return max;
  }

  int highestValueCard(List<PlayingCard> li)  {
    Collections.sort(li);
    return li.get(0).score;
  }

  /**
   * Method assumes Four of a kind exists and has been stores in results map
   * @return
   */
  int getFifthCardInFourOfAKind() {
    int score = result.get(Prob54.RANK.FourOfAKind);
    int fifthScore = 0;
    for (PlayingCard c : cards) {
      if (c.score != score) {
        fifthScore = c.score;
        break;
      }
    }
    return fifthScore;
  }

  /**
   * Method assumes Full House result has been stores in results map
   * @return
   */
  int getPairInFullHouseHand()  {
    int score = result.get(Prob54.RANK.FullHouse);
    int pair = 0;
    for (PlayingCard c : cards) {
      if (c.score != score) {
        pair = c.score;
        break;
      }
    }
    return pair;
  }

  int getSecondPairInTwoPairsHand() {
    int score = result.get(Prob54.RANK.TwoPairs);
    int card1 = 0, card2 = 0;
    for (PlayingCard c : cards) {
      if (c.score == score) {
        continue;
      } else  {
        if (c.score == card1)  {
          return card1;
        } else if (c.score == card2)  {
          return card2;
        } else if (card1 == 0 || card2 == 0) {
          if (card1 == 0) {
            card1 = c.score;
          } else  {
            card2 = c.score;
          }
        }
      }
    }
    // This return should not get executed, was added to avoid compilation error.
    return 0;
  }

  void calculateRanks() {
    if (isRoyalFlush()) {
      result.put(Prob54.RANK.RoyalFlush, 1);
    } else  {
      result.put(Prob54.RANK.RoyalFlush, 0);
    }
    result.put(Prob54.RANK.StraightFlush, isStraightFlush());
    result.put(Prob54.RANK.FourOfAKind, isFourOfAKind());
    result.put(Prob54.RANK.FullHouse, isFullHouse());
    result.put(Prob54.RANK.Flush, isFlush());
    result.put(Prob54.RANK.Straight, isStraight());
    result.put(Prob54.RANK.ThreeOfAKind, isThreeOfAKind());
    result.put(Prob54.RANK.TwoPairs, isTwoPairs());
    result.put(Prob54.RANK.OnePair, isOnePair());
    result.put(Prob54.RANK.HighCard, highestValueCardInHand());
  }
}