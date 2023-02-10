import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Pig {

    //Initializes dice
    public static Die d1;
    public static Die d2;

    //Initializes game
    public static boolean playingGame;

    //Initializes score
    public static int playerScore;

    //Initializes turn counter
    public static int numTurns;

    public int  turnScore;

    private PigViewer window;

    public Pig(){
        //Creates two default 6 sided dice
        d1 = new Die(window);
        d2 = new Die(window);

        //Creates the player's scorecard:
        playerScore = 0;
        turnScore = 0;

        //Set turn counter to 0
        numTurns = 0;

        window = new PigViewer(this, d1, d2);
    }

    public static void main(String[] args) {

        Pig p = new Pig();
        p.run();
    }

    public void run(){
        //Prints instructions
        printInstructions();
        window.setScreenStatus(0);
        window.repaint();

        Scanner s = new Scanner(System.in);

        System.out.println("Type '1' to begin!");
        int input = s.nextInt();

        if (input == 1){
            //Starts the game
            playingGame = true;
        }

        while(playingGame)
        {
            window.setScreenStatus(1);
            window.repaint();

            turnScore = 0;
            playerScore += takeTurn();
            window.repaint();

            //Only prints the score if the game is not over
            if(playingGame)
            {
                System.out.println("Total Score = "+ playerScore);
            }
        }
    }

    public int takeTurn()
    {
        boolean takingTurn = true;

        //Makes a new scanner
        Scanner scanner = new Scanner(System.in);

        //Intiallize the counter for the roll score and turn score
        int rollScore = 0;


        while(takingTurn)
        {
            //Asks the player to roll
            System.out.println();
            System.out.println("Would you like to roll or hold?"
                    +"(r for roll, h for hold)");
            String answer = scanner.nextLine();

            //Checks what action the user chose and acts accordingly
            if(answer.equals("r"))
            {
                rollScore = roll(d1, d2);
                window.repaint();
                //If the roll was not doubles,
                //adds the roll score to the turn score
                if(rollScore > 0)
                {
                    turnScore += rollScore;
                    System.out.println("Current score for this turn = "+ turnScore);

                    //Checks if the game is won
                    if((playerScore + turnScore) >= 100)
                    {
                        numTurns++;
                        window.setScreenStatus(2);
                        window.repaint();
                        System.out.println("Game over, You win!");
                        System.out.println("You won in "+numTurns+" turns!");
                        playingGame = false;
                        return 0;
                    }
                }
                else
                {
                    //Resets the turn score and ends the turn
                    turnScore = 0;
                    numTurns++;
                    return turnScore;
                }
            }
            //Checks if the player chose to hold
            else if(answer.equals("h"))
            {
                numTurns++;
                return turnScore;
            }
            //Easter egg (I needed another dice method)
            else if(answer.equals("this is a dicey move"))
            {
                d1.easterEgg();
                return 0;
            }
            else
            {
                System.out.println("Not a valid input");
                return 0;
            }
        }
        return 0;
    }

    public int roll(Die d1, Die d2)
    {
        //Rolls both die
        int d1Value = d1.roll();
        int d2Value = d2.roll();

        //Prints the results of the roll
        System.out.println("d1 = "+ d1Value);
        System.out.println("d2 = "+ d2Value);

        //Ends the turn if doubles are rolled
        if(d1Value == d2Value)
        {
            System.out.println("You rolled doubles! This turn is over.");
            return (0);
        }
        else
        {
            return (d1Value + d2Value);
        }
    }

    public void printInstructions()
    {
        //Gets the number of sides each die has
        int d1Sides = d1.getSides();

        System.out.println("Welcome to Pig!");
        System.out.println("The goal of the game is to get to your total score " +
                "to 100 points in the least amount of turns!");
        System.out.println("At the start of each turn, you will roll two dice with " +
                d1Sides+" sides each.");
        System.out.println("If you roll doubles, your turn is over"+
                "and you gain no points.");
        System.out.println("If you roll any other combination of numbers,"+
                "that sum gets added to your points!");
        System.out.println("After you roll, you can choose to roll again or hold.");
        System.out.println("If you hold, your turn is over and you keep"+
                "any points you won that turn.");
        System.out.println("You can roll again as many times as you'd like,"+
                " as long as you don't roll doubles.");
        System.out.println();
    }

    public Die getD1() {
        return d1;
    }

    public Die getD2() {
        return d2;
    }

    public boolean isPlayingGame() {
        return playingGame;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getNumTurns() {
        return numTurns;
    }

    public int getTurnScore() {
        return turnScore;
    }
}
