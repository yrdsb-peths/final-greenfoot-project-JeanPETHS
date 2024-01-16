import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the flag class. Once the character touches the flag, the user wins.
 * 
 * @author Jean 
 * @version Jan 2024
 */
public class Flag extends Actor
{
    GameWorld1 gameWorld1;
    SimpleTimer timer;
    int flagIndex = 0;
    
    public Flag()
    {
        timer = new SimpleTimer();
        timer.mark();
    }
    
    public void act()
    {
        animateFlag();
    }
    
    /**
     * Animate the flag.
     */
    public void animateFlag()
    {
        //If the time is too short, do not animate.
        if(timer.millisElapsed() < 500)
        {
            return;
        }
        
        timer.mark();
        
        //Set the image
        GreenfootImage current = new GreenfootImage("flag" + flagIndex + ".png");        
        setImage(current);
        flagIndex = (flagIndex + 1) % 2;
    }
}
