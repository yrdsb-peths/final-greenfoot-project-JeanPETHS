import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the ice-cream class. It can be turned to generate a diamond.
 * 
 * @author Jean
 * @version Jan 2024
 */
public class IceCream extends Tile
{
    GameWorld gameWorld;
    
    //Check if the ice-cream is already turned
    boolean turned = false;
    
    /**
     * Set the image of the ice-cream.
     */
    public IceCream()
    {
        super("gameWorld2/tile", 64);
    }
    
    public void act()
    {
        //Update the ice-cream image
        if(!turned && nearIceCream() && Greenfoot.isKeyDown("space"))
        {
            turned = true;
            
            //Change the image
            GreenfootImage newIceCream = new  GreenfootImage("gameWorld2/tile72.png");
            newIceCream.scale(24,24);
            setImage(newIceCream);
            
            //Create a diamond
            gameWorld.addObject(new Diamond(), 17*24+12, 400-8*24-9);
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
     * Check if the character is near the ice-cream.
     */
    public boolean nearIceCream()
    {
        //Give a square area of 50x50 where counts as "near" the ice-cream.
        if(Math.abs(this.getX()-gameWorld.currentCharacter.getX())<=25 && Math.abs(this.getY()-gameWorld.currentCharacter.getY())<=25)
        {
            return true;
        }
        return false;
    }
}
