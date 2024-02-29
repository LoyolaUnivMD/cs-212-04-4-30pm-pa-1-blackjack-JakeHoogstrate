//pa1

//imports
import java.util.Scanner;
import java.util.Random;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        //variables to track scores
        int userScore= 0;
        int dealerScore= 0;

        //creating deck
        String[] deck = new String[52];
        String suits[] = {"S","D","C","H"};
        String num[] = {"2","3","4","5","6","7","8","9","T","J","Q","K","A"};
        int count =0;
            for (int y =0;y<num.length;y++){
                for (int z =0;z<suits.length;z++){
                    deck[count]=num[y]+suits[z];
                    count++;
                }
            }

        //initializing the hand objects
        Hand userHand = new Hand();
        Hand dealerHand = new Hand();

        //creating variable to use for random numbers
        int r = 0;

        //user draws 2 cards
        r = rand.nextInt(0, 52);
        userHand.add(deck[r]);
        r= rand.nextInt(0, 52);
        userHand.add(deck[r]);

        //dealer draws 2 cards
        r = rand.nextInt(0, 52);
        dealerHand.add(deck[r]);
        r = rand.nextInt(0, 52);
        dealerHand.add(deck[r]);

        //print out starting hands
        System.out.println("Let's Play BlackJack!");
        System.out.println();
        System.out.print("Player: ");
        userHand.showHand(false);
        System.out.println();
        System.out.print("Dealer: ");
        dealerHand.showHand(true);
        System.out.println();

        userScore = userHand.getValue();
        System.out.println(userScore);

        //user can hit or stay until they stay or bust
        while(true){
            System.out.println("Hit(1) or Stay(2)");
            int choice = scan.nextInt();
            if (choice==1){
                r = rand.nextInt(0, 52);
                userHand.add(deck[r]);
                System.out.println();
                System.out.print("Player: ");
                userHand.showHand(false);
                System.out.println();
                System.out.print("Dealer: ");
                dealerHand.showHand(true);
                System.out.println();

                userScore = userHand.getValue();
                System.out.println(userScore);
            }
            if (choice==2){
                break;
            }
            //bust
            userScore = userHand.getValue();
            if (userScore>21){
                break;
            }
        }
        userScore = userHand.getValue();


        //show dealers hand
        System.out.print("Dealer: ");
        dealerHand.showHand(false);
        System.out.println();
        dealerScore = dealerHand.getValue();
        System.out.println(dealerScore);

        //if user busts you lose
        if (userScore>21){
            System.out.println("You Lose.");
        }
        //if user doesn't bust
        else{
            while (dealerScore<17){
                //dealer hits until 17
                r = rand.nextInt(0, 52);
                dealerHand.add(deck[r]);
                dealerScore = dealerHand.getValue();
                System.out.print("Dealer: ");
                dealerHand.showHand(false);
                System.out.println();
                System.out.println(dealerScore);
            }
            //final winning/losing scenarios
            if (dealerScore>userScore&&dealerScore<22){
                System.out.println("Dealer wins!");
            }
            else if (userScore>dealerScore){
                System.out.println("You win!");
            }
            else{
                System.out.println("Tie!");
            }
        }










    


    }
}
