package blackjack;
import java.util.ArrayList;
public class Player {
    private String name;
    int score;
    Card[] playerHand;
    private boolean blackjack;
    private boolean lose;
    int numberOfCards;

    // constructor
    public Player()
    {
        score = 0;
        blackjack = false;
        lose = false;
        playerHand = new Card[11];
        numberOfCards = 0;
    }

    // setters & getters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isBlackjack() {
        return blackjack;
    }

    public void setBlackjack(boolean blackjack) {
        this.blackjack = blackjack;
    }

    public boolean isLose() {
        return lose;
    }

    public void setLose(boolean lose) {
        this.lose = lose;
    }




    // method that sum score of the player
    public void sumScore()
    {
        this.score =0;
        for (int i=0 ;i < this.numberOfCards ; i++)
        {
            this.score += playerHand[i].getValue();
        }
    }


}
