import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the box that is locked and can be unlocked after using the key.
 * 
 * @author Jean 
 * @version Dec 2023
 */
public class Box extends Tile
{
    public Box()
    {
        super(new GreenfootImage("locked-box.png"));
    }
    
    public void unlock()
    {
        super.setTileImage(new GreenfootImage("unlocked-box.png"));
    }
}
