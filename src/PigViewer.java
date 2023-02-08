import javax.swing.*;
import java.awt.*;

public class PigViewer extends JFrame{

    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 800;

    private final int d1X = 160;
    private final int d2X = 480;

    private final int WIN_X = 240;
    private final int WIN_Y = 400;

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

            d1.draw(g, d1X);
            d2.draw(g, d2X);
        }
        else if (screenStatus == 2){
            //TODO: show winning screen
            image = new ImageIcon("Resources/Win.png").getImage();
            g.drawImage(image, 0, 22, WINDOW_WIDTH, WINDOW_HEIGHT, this);

            String turns = String.valueOf(p.getNumTurns());
            g.drawString(turns, WIN_X, WIN_Y);
        }
    }
}
