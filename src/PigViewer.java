import javax.swing.*;
import java.awt.*;

public class PigViewer extends JFrame{

    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 800;

    private final int d1X = 160;
    private final int d2X = 480;

    private final int WIN_X = 315;
    private final int WIN_Y = 600;

    private Image image;

    private Pig p;

    private int screenStatus;

    private Die d1;
    private Die d2;

    public PigViewer(Pig p, Die d1, Die d2){
        this.p = p;

        this.d1 = d1;
        this.d2 = d2;

        screenStatus = 0;

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Pig");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void setScreenStatus(int screenStatus) {
        this.screenStatus = screenStatus;
    }

    public void paint(Graphics g){
        //TODO: draw white screen
        g.drawRect(0, 22, WINDOW_WIDTH, WINDOW_HEIGHT);

        if(screenStatus == 0){
            //TODO: show instructions image
            image = new ImageIcon("Resources/Instructions.png").getImage();
            g.drawImage(image, 0, 22, WINDOW_WIDTH, WINDOW_HEIGHT, this);

        }
        else if (screenStatus == 1) {
            //TODO: show playing screen
            image = new ImageIcon("Resources/Turn.png").getImage();
            g.drawImage(image, 0, 22, WINDOW_WIDTH, WINDOW_HEIGHT, this);
            d1.draw(g, d1X);
            d2.draw(g, d2X);

            g.setFont(new Font("Serif", Font.BOLD, 100));

            String turns = String.valueOf(p.getNumTurns());
            String total = String.valueOf(p.getPlayerScore());
            String thisTurn = String.valueOf(p.getTurnScore());

            g.drawString(turns, 350, 780);
            g.drawString(total, 600, 600);
            g.drawString(thisTurn, 160, 600);
        }
        else if (screenStatus == 2){
            //TODO: show winning screen
            image = new ImageIcon("Resources/Win.png").getImage();
            g.drawImage(image, 0, 22, WINDOW_WIDTH, WINDOW_HEIGHT, this);

            String turns = String.valueOf(p.getNumTurns());
            g.setFont(new Font("Serif", Font.BOLD, 100));
            g.drawString(turns, WIN_X, WIN_Y);
        }
    }
}
