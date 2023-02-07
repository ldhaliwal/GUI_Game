import javax.swing.*;
import java.awt.*;

public class PigViewer extends JFrame{

    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 800;

    private Image image;

    private Pig p;

    private int screenStatus;

    private Die[] dice;

    public PigViewer(Pig p, Die d1, Die d2){
        this.p = p;

        dice = new Die[2];
        dice[0] = d1;
        dice[1] = d2;

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
        if(screenStatus == 0){
            //TODO: show instructions image
        }
        else if (screenStatus == 1) {
            //TODO: show playing screen

            for(Die d : dice){
                d.draw(g);
            }

        }
        else if (screenStatus == 2){
            //TODO: show winning screen
            image = new ImageIcon("Resources/Win.png").getImage();
            g.drawImage(image, 0, 22, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        }
    }
}
