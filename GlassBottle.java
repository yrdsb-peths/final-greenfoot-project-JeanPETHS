import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the Glass Bottle class. It can be turned to pour water out.
 * 
 * @author Jean
 * @version Jan 2024
 */
public class GlassBottle extends Tile
{
    GameWorld gameWorld;
    
    //Store the two glass bottle objects
    static int index = 0;
    static GlassBottle[] glassBottles = new GlassBottle[2];
    
    //Check if the glass bottle is already turned
    boolean turned = false;
    
    public GlassBottle(int type)
    {
        super("gameWorld2/tile", type);
        glassBottles[index] = this;
        index++;
        index%=2;
    }
    
    public void act()
    {
        if(!turned && nearGlassBottle() && gameWorld.hasKey && Greenfoot.isKeyDown("space"))
        {
            glassBottles[0].turned = true;
            glassBottles[1].turned = true;
            
            //Update the key
            gameWorld.updateKey(-1);
            
            //Change the image
            GreenfootImage bottle0 = new GreenfootImage("gameWorld2/tile52.png");
            bottle0.scale(24,24);
            glassBottles[0].setImage(bottle0);
            GreenfootImage bottle1 = new GreenfootImage("gameWorld2/tile54.png");
            bottle1.scale(24,24);
            glassBottles[1].setImage(bottle1);
            
            //Pour water into the glass & create a path to the sky
            Glass.pourInWater();
            createPath();
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
     * Create a path for the user to go to the sky.
     */
    public void createPath()
    {
        //Foods
        gameWorld.addObject(new Food(62), 9*24+12, 400-12*24-12);
        gameWorld.addObject(new Food(58), 11*24+12, 400-14*24-12);
        gameWorld.addObject(new Food(74), 13*24+12, 400-11*24-12);
        gameWorld.addObject(new Food(75), 15*24+12, 400-14*24-12);
        
        //A sausage
        gameWorld.addObject(new Food(43), 17*24+12, 400-11*24-12);
        gameWorld.addObject(new Food(44), 18*24+12, 400-11*24-12);
        gameWorld.addObject(new Food(45), 19*24+12, 400-11*24-12);
    }
    
    /**
     * Check if the character is near the glass bottle.
     */
    public boolean nearGlassBottle()
    {
        //Give a square area of 50x50 where counts as "near" the glass bottle.
        if(Math.abs(this.getX()-gameWorld.currentCharacter.getX())<=25 && Math.abs(this.getY()-gameWorld.currentCharacter.getY())<=25)
        {
            return true;
        }
        return false;
    }
}
