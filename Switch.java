import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the switch class. Will be on after using keys.
 * 
 * @author Jean 
 * @version Dec 2023
 */
public class Switch extends Actor
{
    GameWorld gameWorld;
    
    //If this has already been opened
    boolean isOpened = false;
    
    //For opening animation
    int imageIndex = 0;
    boolean isOpening = false;
    
    Box boxConnected;
    
    public Switch()
    {
        setImage("switch0.png");
    }
    
    public void act()
    {
        //Check if the user want to and are able to open it
        if(isTouching(GreenCharacter.class) && Greenfoot.isKeyDown("space") && !isOpened && gameWorld.hasKey)
        {
            //For animation
            isOpening = true;
            //If is opened, it cannot be opened again.
            isOpened = true;
            //1 key is used, update the number of keys in the world
            gameWorld.updateKey(-1);
            //Unlock the box that is connected with this switch object
            boxConnected.unlock();
        }
        
        //Animate
        if(isOpening)
        {
            openAnimation();
        }
    }
    
    public void addedToWorld(World world)
    {
        if(world instanceof GameWorld)
        {
            gameWorld = (GameWorld)world;
        }
    }
    
    /**
     * Animate the switch if the user is successfully opening it.
     */
    public void openAnimation()
    {
        setImage(new GreenfootImage("switch" + imageIndex + ".png"));
        imageIndex++;
        //If the box is opened, stop animating.
        if(imageIndex==3)
        {
            isOpening = false;
        }
    }
}
