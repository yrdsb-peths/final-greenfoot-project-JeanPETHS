import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the Glass class. If it is full of water, the character could be sent to another glass through this.
 * 
 * @author Jean
 * @version Jan 2024
 */
public class Glass extends Actor
{
    /**
     * Set the image of the empty glass.
     */
    public Glass()
    {
        GreenfootImage emptyGlass = new GreenfootImage("gameWorld2/glass0.png");
        emptyGlass.scale(24,24);
        setImage(emptyGlass);
    }
}
