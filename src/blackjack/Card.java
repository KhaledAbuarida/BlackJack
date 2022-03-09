package blackjack;

public class Card {
    private int suit;
    private int rank;
    private int value;

    // parameterized constructor
    public Card(int suit, int rank, int value)
    {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }
    // copy constructor
    public Card(Card card)
    {
        this.suit = card.suit;
        this.rank = card.rank;
        this.value = card.value;
    }
    // getters
    public int getSuit(){return this.suit;}
    public int getRank(){return this.rank;}
    public int getValue(){return this.value;}
    public void setSuit(int suit){this.suit = suit;}

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // display
    public void display()
    {
        System.out.println("suit : " + this.suit + " rank : " + this.rank + " value : " + this.value);
    }
}
