import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the switch class. Will open after using keys.
 * 
 * @author Jean 
 * @version Dec 2023
 */
public class Switch extends Actor
{
    //For opening animation
    int imageIndex = 0;
    boolean isOpening = false;
    
    public Switch()
    {
        setImage("switch0.png");
    }
    
    public void act()
    {
        if(isOpening)
        {
            openAnimation();
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
