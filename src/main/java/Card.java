public class Card implements Comparable<Card> {
    private String name;
    private String suit;

    public Card(String name, String suit) {
        this.name = name;
        this.suit = suit;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuit() {
        return this.suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return getName() + " of " + getSuit();
    }

    @Override
    public int compareTo(Card card) {
        if (getName().equals(card.getName()) && getSuit().equals(card.getSuit())) {
            return 0;
        }
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
        int currRank = -1;
        int compareRank = -1;
        int currSuit = -1;
        int compareSuit = -1;
        for (int i = 0; i < ranks.length && (currRank == -1 || compareRank == -1); i++) {
            if (getName().equals(ranks[i])) {
                currRank = i;
            }
            if (card.getName().equals(ranks[i])) {
                compareRank = i;
            }
        }
        for (int i = 0; i < suits.length && (currSuit == -1 || compareSuit == -1); i++) {
            if (getSuit().equals(suits[i])) {
                currSuit = i;
            }
            if (card.getSuit().equals(suits[i])) {
                compareSuit = i;
            }
        }
        if (currRank == compareRank) {
            return Integer.compare(currSuit, compareSuit);
        }
        return Integer.compare(currRank, compareRank);
    }
}
