import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the Ladder class.
 * 
 * @author Jean 
 * @version Dec 2023
 */
public class Ladder extends Actor
{
    /**
     * Set the ladder image based on the type that gets passed into this constructor.
     */
    public Ladder(int type)
    {
        GreenfootImage ladder = new GreenfootImage("ladder" + type + ".png");
        ladder.scale(24,24);
        setImage(ladder);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
