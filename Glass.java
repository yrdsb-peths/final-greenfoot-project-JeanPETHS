import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the Glass class. If it is full of water, the character could be sent to another glass through this.
 * 
 * @author Jean
 * @version Jan 2024
 */
public class Glass extends Actor
{
    //Store the glass object
    static Glass glass;
    
    /**
     * Set the image of the empty glass.
     */
    public Glass()
    {
        GreenfootImage emptyGlass = new GreenfootImage("gameWorld2/glass0.png");
        emptyGlass.scale(24,24);
        setImage(emptyGlass);
        
        //Store this glass
        glass = this;
    }
    
    /**
     * Update the image to a glass full of water.
     */
    public static void pourInWater()
    {
        GreenfootImage fullGlass = new GreenfootImage("gameWorld2/glass1.png");
        fullGlass.scale(24,24);
        glass.setImage(fullGlass);
    }
}
