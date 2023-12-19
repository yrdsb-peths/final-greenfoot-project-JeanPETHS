import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the class of HealthValue, which determines the health value of the character.
 * 
 * @author Jean 
 * @version Dec 2023
 */
public class HealthValue extends Actor
{   
    //Store the 3 heart objects
    static int count = 0;
    static HealthValue[] healthValue = new HealthValue[3];
    
    public HealthValue()
    {
        //Initial image is a full heart
        setImage(new GreenfootImage("health2.png"));
        //Store the heart object into the array
        healthValue[count] = this;
        count++;
        //count is static -- will not be reset even if the scenario is reset -- needs to %3 to get the current position in array
        count%=3;
    }
    
    /**
     * Set the heart image based on the health value of the character.
     */
    public static void setHealthValue(int value)
    {
        //The number of heart that is full
        int num = value/2;
        //Set the other heart to half or empty based on the value
        healthValue[value/2].setImage(new GreenfootImage("health" + (value-num*2) + ".png"));
    }
}
