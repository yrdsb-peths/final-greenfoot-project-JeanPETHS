import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the class Jumper. It can pump the character into the air if the character stands on it.
 * 
 * @author Jean
 * @version Dec 2023
 */
public class Jumper extends Tile
{
    SimpleTimer timer = new SimpleTimer();
    
    //Store the character instance here
    GreenCharacter greenCharacter;
    
    //If the jumper is pumping
    boolean isPumping = false;
    //If speed variables of the character are changed
    boolean isChanged = false;
    
    /**
     * Set the image of the Jumper object.
     */
    public Jumper()
    {
        super(new GreenfootImage("jumper0.png"));
    }
    
    public void act()
    {
        if(aboveJumper())
        {
            if(!greenCharacter.isJumping && !greenCharacter.isFalling)
            {
                //Set the velocity to a higher value than normal
                greenCharacter.velocity = 16;
                //Set the gravity to a lower value than normal
                greenCharacter.gravity = 1;
                
                greenCharacter.isJumping = true;
                isPumping = true;
                isChanged = true;
                
                //Animate the jumper
                setTileImage(new GreenfootImage("jumper1.png"));
            }
        }
        else if(isChanged)
        {
            //If is not on jumper & speed variables are changed, reset them.
            greenCharacter.resetSpeed();
            
            greenCharacter.isJumping = false;
            isPumping = false;
            isChanged = false;
            
            //Animate
            setTileImage(new GreenfootImage("jumper0.png"));
        }
        
        //If too fast, do not jump.
        if(timer.millisElapsed()<200)
        {
            return;
        }
        
        timer.mark();
        
        if(isPumping)
        {
            //Animate
            setTileImage(new GreenfootImage("jumper0.png"));
            
            //Jump
            greenCharacter.jump();
        }
    }
    
    /**
     * Check if the character is above the jumper.
     */
    public boolean aboveJumper()
    {
        //Is valid if the character is at 20 units left or right about the jumper.
        for(int i=-20; i<=20; i++)
        {
            //Check the x & y value
            if(((this.getX()+i)==greenCharacter.getX()) && (this.getY()>greenCharacter.getY()))
            {
                return true;
            }
        }
        return false;
    }
}
