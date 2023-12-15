import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the green character the user uses to play.
 * 
 * @author Jean 
 * @version Dec 2023
 */
public class GreenCharacter extends Actor
{
    final static private int tileSize = 24;
    
    //Check the direction it is facing
    boolean isFacingRight = true;
    
    //Data to make it fall or jump
    boolean isFalling = false;
    boolean isJumping = false;
    static final private int initialSpeed = 10;
    static final private int gravity = 2;
    int velocity = 0; 
    
    //Store the y value of the nearest tile under the character
    int y;
    
    public void act()
    {
        //move left & right
        if(Greenfoot.isKeyDown("a"))
        {
            //if no wall on the left: move
            isFacingRight = false;
            if(!isAgainstWall())
            {
                move(-1);
            }
        }
        else if(Greenfoot.isKeyDown("d"))
        {
            //if no wall on the right: move
            isFacingRight = true;
            if(!isAgainstWall())
            {
                move(1);
            }
        }
        
        //Check if the character can jump or fall
        if(Greenfoot.isKeyDown("w") && isOnGround() && !isFalling && !isJumping)
        {
            isJumping = true;
            velocity = initialSpeed;
        }
        else if(!isOnGround() && !isJumping)
        {
            isFalling = true;
        }
        
        //Make the character jump
        if(isJumping) {
            jump();
        }
        
        //Make the character fall
        if(isFalling) {
            fall();
        }
    }
    
    /**
     * Check if the character is on the ground.
     */
    public boolean isOnGround()
    {   
        //If there is tile under the character from left 9 to right 9 cells, return true.
        for(int i=-9; i<=9; i++)
        {
            if(getOneObjectAtOffset(i, 12, Tile.class)!=null)
            {
                //Get the y value of the tile under it & store it -- for later character location adjustment.
                y = getOneObjectAtOffset(i, 12, Tile.class).getY();
                return true;
            }
        }
        return false;
    }
    
    /**
     * Check if the character is against the wall in a specific direction.
     */
    public boolean isAgainstWall()
    {
        //Check according to the direction the character is facing.
        if(isFacingRight)
        {
            //If the character is facing right, check if there is a wall on the right
            if(getOneObjectAtOffset(12, 0, Tile.class)!=null)
            {
                return true;
            }
            return false;
        }
        else
        {
            //If the character is facing left, check if there is a wall on the left
            if(getOneObjectAtOffset(-12, 0, Tile.class)!=null)
            {
                return true;
            }
            return false;
        }
    }
    
    /**
     * Make the object fall if it is not on the ground.
     */
    public void fall()
    {
        setLocation(getX(), getY() + velocity);
        velocity += gravity;
        //If it reaches the ground, stop falling, and reset its y location.
        if(isOnGround()) {
            velocity = 0;
            isFalling = false;
            setLocation(getX(), y-24);
        }
    }
    
    /**
     * Make the object jump.
     */
    public void jump()
    {
        setLocation(getX(), getY()-velocity);
        velocity -= gravity;
        //If it reaches the ground, stop jumping, and reset its y location.
        if(isOnGround()) {
            velocity = 0;
            isJumping = false;
            setLocation(getX(), y-24);
        }
    }
}
