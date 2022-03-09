package blackjack;
import java.util.Random;
import java.util.Scanner;
public class Game {
    GUI gui = new GUI();
    Random random = new Random();
    Scanner input = new Scanner(System.in);
    Player[] p;
    Card[] c;
    int maxScore;

    // constructor
    public Game()
    {
        p = new Player[4];
        c = new Card[52];
        maxScore = 0;
    }

    // generate the card deck
    public void generateCardDeck()
    {
        for(int i=0 ; i <= 12 ; i++)
        {
            if (i >= 10)
            {
                c[i] = new Card(0,i, 10);
                continue;
            }
            c[i] = new Card(0,i,i+1);
        }
        for (int i=13 ; i <= 25 ; i++)
        {
            if (i >= 23)
            {
                c[i] = new Card(1,i%13,10);
                continue;
            }
            c[i] = new Card(1,i%13,(i%13)+1);
        }
        for (int i=26 ; i <= 38 ; i++)
        {
            if (i >= 36 )
            {
                c[i] = new Card(2,i%13,10);
                continue;
            }
            c[i] = new Card(2,i%13,(i%13)+1);
        }
        for (int i=39 ; i <= 51 ; i++)
        {
            if (i >= 49)
            {
                c[i] = new Card(3,i%13,10);
                continue;
            }
            c[i] = new Card(3,i%13,(i%13)+1);
        }
    }

    // method that draw card randomly from the card deck
    public Card randomCard()
    {
        while(true)
        {
            int randNumber = random.nextInt(52);
            if (c[randNumber] == null)
                continue;
            Card thisCard = c[randNumber];
            c[randNumber] = null;
            return thisCard;
        }

    }



    // method that sets the information of the players
    public void setPlayerInfo()
    {
        for (int i=0 ; i < 4 ; i++)
        {
            System.out.println("Enter the name of player number " + (i+1) );
            String pName = input.next();
            p[i] = new Player();
            p[i].setName(pName);
            p[i].playerHand[p[i].numberOfCards] = randomCard();
            gui.updatePlayerHand(p[i].playerHand[p[i].numberOfCards], i);
            p[i].numberOfCards++;
            p[i].playerHand[p[i].numberOfCards] = randomCard();
            gui.updatePlayerHand(p[i].playerHand[p[i].numberOfCards], i);
            p[i].numberOfCards++;
            p[i].sumScore();
            System.out.println("Score : " + p[i].getScore());
        }
    }

    // method to update the maximum score
    public void update_max_score()
    {
        maxScore = 0;
        for (int i=0 ; i < 3 ; i++)
        {

            if (p[i].isLose() == true)
            {
                continue;
            }
            if (p[i].getScore() >= maxScore && p[i].getScore() <= 21)
                maxScore = p[i].getScore();
        }
    }


}
