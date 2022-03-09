package blackjack;
import java.util.Scanner;
public class BlackJack {
    static Game g = new Game();
    public static void main(String[] args) {
        GUI gui = new GUI();
        Scanner input = new Scanner(System.in);
        g.generateCardDeck();
        g.setPlayerInfo();
        gui.runGUI(g.c,g.p[0].playerHand,g.p[1].playerHand,g.p[2].playerHand,g.p[3].playerHand);
        for (int turn =0 ; turn < 3 ; turn++)
        {
            System.out.println("Player number " + (turn+1) + " has score : " + g.p[turn].getScore());
            System.out.println("1) Hit \n2) Stand");
            int press = input.nextInt();
            if (press == 2)
            {
                g.update_max_score();
                System.out.println("Maximum Score is : " + g.maxScore);
            }
            else if (press == 1)
            {
                g.p[turn].playerHand[g.p[turn].numberOfCards] = g.randomCard();
                gui.updatePlayerHand(g.p[turn].playerHand[g.p[turn].numberOfCards], turn);
                g.p[turn].numberOfCards++;
                g.p[turn].sumScore();
                g.update_max_score();
                if (g.p[turn].getScore() > 21)
                {
                    g.p[turn].setLose(true);
                    System.out.println("Player number " + (turn+1) + " has Score : " + g.p[turn].getScore() + " so he had BUSTED!");
                    g.update_max_score();
                    System.out.println("Maximum Score is : " + g.maxScore);

                }
                else if (g.p[turn].getScore() == 21)
                {
                    g.p[turn].setBlackjack(true);
                    System.out.println("Player number " + (turn+1) + " is Black Jack!");

                }
                else {
                    g.update_max_score();
                    System.out.println("Maximum Score is : " + g.maxScore);
                    turn--;
                }
            }
        }
        while(true)
        {
            if (g.p[3].getScore() > g.maxScore && g.p[3].getScore() <= 21 || g.maxScore == 0)
            {
                System.out.println("Dealer's Score : " + g.p[3].getScore());
                System.out.println("Dealer is Won!");
                break;
            }
            else if (g.p[3].getScore() <= g.maxScore)
            {
                g.p[3].playerHand[g.p[3].numberOfCards] = g.randomCard();
                gui.updateDealerHand(g.p[3].playerHand[g.p[3].numberOfCards], g.c);
                g.p[3].numberOfCards++;
                g.p[3].sumScore();
                System.out.println("Dealer Score is : " + g.p[3].getScore());
            }
            else if (g.p[3].getScore() > 21)
            {
                System.out.println("Dealer's Score : " + g.p[3].getScore());
                System.out.println("Dealer is BUSTED!");
                int sum =0 ;
                for (int i=0 ; i < 3 ; i++)
                {
                    if (g.p[i].getScore() == g.maxScore)
                        sum++;
                }
                if (sum == 1)
                {
                    for (int i=0 ; i< 3 ;i++)
                    {
                        if ( g.p[i].getScore() == g.maxScore)
                        {
                            System.out.println("Player number : " + (i+1) + " is WON!");
                            break;
                        }
                    }
                }
                else
                {
                    System.out.println("PUSH!");
                }
                break;
            }
            else if (g.p[3].getScore() == 21 && g.maxScore == 21)
            {
                System.out.println("PUSH!");
                break;
            }

        }

    }
}
