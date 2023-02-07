import javax.swing.*;
import java.awt.*;

public class Die
{
    //Instance variable
    private int sides;
    private int value;

    private Image image;

    //Defult constructor
    public Die()
    {
        sides = 6;
        value = 0;
    }

    public Die(int numSides)
    {
        sides = numSides;
    }

    //Returns the number of sides
    //of the die it is called on
    public int getSides()
    {
        return sides;
    }

    //Returns a random int between 1 and
    //the number of sides on the Die
    public int roll() {
        int num = (int)(Math.random()*sides) + 1;
        value = num;
        return num;
    }

    //Rolls the dice the numRolls times
    //and returns the max value of the rolls
    public int getMaxRoll(int numRolls)
    {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<numRolls; i++)
        {
            int num = roll();
            max = Math.max(max, num);
        }

        return max;
    }

    //Rolls the die numRolls times and returns the
    //min value of the rolls
    public int getMinRoll(int numRolls)
    {
        int min = Integer.MIN_VALUE;
        for(int i=0; i<numRolls; i++)
        {
            int num = roll();
            min = Math.min(min, num);
        }

        return min;
    }

    public void draw(Graphics g){
        image = new ImageIcon("Resources/" + this.value + ".png").getImage();
    }

    public String toString()
    {
        return "This is a " + sides + " sided die.";
    }

    public void easterEgg()
    {
        System.out.println("You found the easter egg!");
    }
}