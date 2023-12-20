import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the box that is locked and can be unlocked after using the key.
 * 
 * @author Jean 
 * @version Dec 2023
 */
public class Box extends Tile
{
    GameWorld1 gameWorld1;
    
    public Box()
    {
        super(new GreenfootImage("locked-box.png"));
    }
    
    public void addedToWorld(World world)
    {
        if(world instanceof GameWorld1)
        {
            gameWorld1 = (GameWorld1)world;
        }
    }
    
    public void unlock()
    {
        super.setTileImage(new GreenfootImage("unlocked-box.png"));
        gameWorld1.addObject(new Tile(37), 9*24+12, 400-9*24-12);
    }
}
