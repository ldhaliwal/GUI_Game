import javax.swing.*;
import java.awt.*;

public class PigViewer extends JFrame{

    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 800;

    private final int scoreY = 600;
    private final int numTurnsY = 780;
    private final int numTurnsX = 350;
    private final int turnScoreX = 160;
    private final int totalScoreX = 540;

    private final int d1X = 160;
    private final int d2X = 480;

    private final int WIN_X = 330;
    private final int WIN_Y = 600;

    private Image image;

    private Pig p;

    private int screenStatus;

    private Die d1;
    private Die d2;

    public PigViewer(Pig p){
        this.p = p;

        screenStatus = 0;

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Pig");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void setScreenStatus(int screenStatus) {
        this.screenStatus = screenStatus;
    }

    public int getScreenStatus() {
        return screenStatus;
    }

    public void setDice(Die d1, Die d2) {
        this.d1 = d1;
        this.d2 = d2;
    }


    public void paint(Graphics g){
        g.drawRect(0, 22, WINDOW_WIDTH, WINDOW_HEIGHT);

        //shows the instructions when the program is first run
        if(screenStatus == 0){
            image = new ImageIcon("Resources/Instructions.png").getImage();
            g.drawImage(image, 0, 22, WINDOW_WIDTH, WINDOW_HEIGHT, this);

        }
        //shows the playing screen while the user is taking turns
        else if (screenStatus == 1) {
            //draws the background image
            image = new ImageIcon("Resources/Turn.png").getImage();
            g.drawImage(image, 0, 22, WINDOW_WIDTH, WINDOW_HEIGHT, this);

            //draws the dice
            d1.draw(g, d1X);
            d2.draw(g, d2X);

            //draws all values for turn points, total points, and number of turns taken
            g.setFont(new Font("Monospaced", Font.PLAIN, 100));

            String turns = String.valueOf(p.getNumTurns());
            String total = String.valueOf(p.getPlayerScore());
            String thisTurn = String.valueOf(p.getTurnScore());

            g.drawString(turns, numTurnsX, numTurnsY);
            g.drawString(total, totalScoreX, scoreY);
            g.drawString(thisTurn, turnScoreX, scoreY);
        }
        //shows the winning screen if the game is over
        else if (screenStatus == 2){
            //draws the background
            image = new ImageIcon("Resources/Win.png").getImage();
            g.drawImage(image, 0, 22, WINDOW_WIDTH, WINDOW_HEIGHT, this);

            //prints out the number of turns it took the user to win
            String turns = String.valueOf(p.getNumTurns());
            g.setFont(new Font("Monospaced", Font.PLAIN, 100));
            g.drawString(turns, WIN_X, WIN_Y);
        }
    }
}
