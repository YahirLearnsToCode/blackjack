import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Deck deck = new Deck();
        Hand playerHand = new Hand();
        Hand housesHand = new Hand();

        deck.shuffle();

        //Hand deals
        for (int i = 0; i < 2; i++) {
            // get a card from the deck for each player, by turn
            playerHand.deal(deck.deal());
            housesHand.deal(deck.deal());
        }
        int playerValue = playerHand.getValue();
        int houseValue = housesHand.getValue();


        // Player's turn
        boolean playerDone = false;
        while (!playerDone) {
            System.out.println("Player Hand is worth: " + playerValue);
            System.out.println("House Hand is worth: " + houseValue);
            System.out.print("Would you like to Hit or Stand? H/S ");

            char input = myScanner.nextLine().trim().toUpperCase().charAt(0);

            if (input == 'H') {
                playerHand.deal(deck.deal());
                playerValue = playerHand.getValue();

                if (playerValue >= 21) playerDone = true;

            } else if (input == 'S') playerDone = true;
        }

        // Player busted end program
        if (playerValue > 21) {
            System.out.println("Player Hand is worth: " + playerValue);
            System.out.println("Sucka you lost");
            System.exit(1);
        }

        // House's draw
        while (houseValue < playerValue || houseValue < 21) {
            housesHand.deal(deck.deal());
            houseValue = housesHand.getValue();
        }

        System.out.println("House Hand is worth: " + houseValue);
        System.out.println("Player Hand is worth: " + playerValue);

        // Winner
        if (houseValue > 21)
            System.out.println("You WIN!");
        else
            System.out.println("House WINS!");
    }
}
