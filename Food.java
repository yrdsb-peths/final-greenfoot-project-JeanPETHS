import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the Food class.
 * 
 * @author Jean 
 * @version Jan 2024
 */
public class Food extends Tile
{    
    GameWorld gameWorld;
    
    //If speed variables of the character are changed
    boolean isChanged = false;
    
    /**
     * Set the image of the Food object.
     */
    public Food(int type)
    {
        super("gameWorld2/tile", type);
    }
    
    public void act()
    {
        if(aboveFood())
        {
            if(Greenfoot.isKeyDown("w") && !gameWorld.currentCharacter.isJumping && !gameWorld.currentCharacter.isFalling)
            {
                //Set the jumping velocity of the green character
                gameWorld.currentCharacter.velocity = 11;
                //Set the gravity to a lower value than normal
                gameWorld.currentCharacter.gravity = 1;
                
                gameWorld.currentCharacter.isJumping = true;
                isChanged = true;
            }
        }
        else if(isChanged)
        {
            //If is not on food & speed variables are changed, reset them.
            gameWorld.currentCharacter.resetSpeed();
            
            gameWorld.currentCharacter.isJumping = false;
            isChanged = false;
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
     * Check if the character is right above the food.
     */
    public boolean aboveFood()
    {
        //Is valid if the character is on the food or right above the food.
        if(Math.abs(this.getX()-gameWorld.currentCharacter.getX())<=24 && this.getY()>gameWorld.currentCharacter.getY())
        {
            return true;
        }
        return false;
    }
}
