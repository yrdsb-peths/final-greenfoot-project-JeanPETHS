import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Flag here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flag extends Actor
{
    GameWorld1 gameWorld1;    
    SimpleTimer timer;
    int flagIndex = 0;
    
    /*public void addedToWorld()
    {
        if(this.getWorld() instanceof GameWorld1)
        {
            gameWorld1 = (GameWorld1)this.getWorld();
        }
    }*/
    
    public Flag()
    {
        timer = new SimpleTimer();
        timer.mark();
    }
    
    public void act()
    {
        animateFlag();
    }
    
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
