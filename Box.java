import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the box that is locked and can be unlocked after using the key.
 * 
 * @author Jean 
 * @version Dec 2023
 */
public class Box extends Tile
{
    GameWorld gameWorld;
    
    public Box()
    {
        super(new GreenfootImage("locked-box.png"));
    }
    
    public void addedToWorld(World world)
    {
        if(world instanceof GameWorld)
        {
            gameWorld = (GameWorld)world;
        }
    }
    
    public void unlock()
    {
        super.setTileImage(new GreenfootImage("unlocked-box.png"));
        gameWorld.addObject(new Ladder(1), 20*24+12, 400-6*24-12);
    }
}
