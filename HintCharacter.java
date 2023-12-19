import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the class of hint character, which gives users some hints when using it.
 * 
 * @author Jean 
 * @version Dec 2023
 */
public class HintCharacter extends Tile
{
    GameWorld1 gameWorld1;
    SimpleTimer timer = new SimpleTimer();
    int hintIndex = 0;
    
    public HintCharacter()
    {
        super(new GreenfootImage("hint-character-0.png"));
    }
    
    public void act()
    {
        animateCharacter();
    }
    
    public void addedToWorld(World world)
    {
        if(world instanceof GameWorld1)
        {
            gameWorld1 = (GameWorld1)world;
        }
    }
    
    public void animateCharacter()
    {
        //If the time is too short, do not animate.
        if(timer.millisElapsed() < 500)
        {
            return;
        }
        
        timer.mark();
        
        //Set the image
        GreenfootImage current = new GreenfootImage("hint-character-" + hintIndex + ".png");        
        setImage(current);
        hintIndex = (hintIndex + 1) % 3;
    }
}
