import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the Ladder class.
 * 
 * @author Jean 
 * @version Dec 2023
 */
public class Ladder extends Actor
{
    SimpleTimer timer = new SimpleTimer();
    GreenCharacter greenCharacter;
    boolean isUp = false;
    
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
        if(isTouching(GreenCharacter.class))
        {
            if(Greenfoot.isKeyDown("w") && !isUp)
            {
                isUp = true;
            }
            if(isUp)
            {
                up();
            }
        }
        else
        {
            isUp = false;
        }
    }
    
    public void up()
    {
        if(timer.millisElapsed() < 40)
        {
            return;
        }
        
        timer.mark();
        
        greenCharacter = (GreenCharacter)getOneIntersectingObject(GreenCharacter.class);
        greenCharacter.setLocation(greenCharacter.getX(), greenCharacter.getY() - 1);
    }
}
