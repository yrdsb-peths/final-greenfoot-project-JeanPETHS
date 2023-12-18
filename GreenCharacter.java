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
    
    GameWorld1 gameWorld1;
    
    //Check the direction it is facing
    boolean isFacingRight = true;
        
    //Data to make it fall or jump
    boolean isFalling = false;
    boolean isJumping = false;
    static final private int initialSpeed = 10;
    static final private int gravity = 2;
    int velocity = 0; 
    
    //Store the y value of the nearest tile under the character
    int yBelow;
    
    //Store the y value of the tile above the character to block it from bumping into the tile
    int yAbove;
    
    SimpleTimer timer = new SimpleTimer();
    int imageIndex = 0;
    
    public void act()
    {
        //move left & right
        if(Greenfoot.isKeyDown("a"))
        {
            animateCharacter();
            //if no wall on the left: move
            isFacingRight = false;
            if(!isAgainstWall())
            {
                move(-1);
            }
        }
        else if(Greenfoot.isKeyDown("d"))
        {
            animateCharacter();
            //if no wall on the right: move
            isFacingRight = true;
            if(!isAgainstWall())
            {
                move(1);
            }
        }
        else
        {
            //If is not moving left or right, set the image to "standing".
            GreenfootImage standing = new GreenfootImage("green-character-0.png");
            //Set its image based on which direction it is facing.
            if(!isFacingRight)
            {
                standing.mirrorHorizontally();
            }
            setImage(standing);
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
    
    public void addedToWorld(World world)
    {
        if(world instanceof GameWorld1)
        {
            gameWorld1 = (GameWorld1)world;
        }
    }
    
    /**
     * Animate the character.
     */
    public void animateCharacter()
    {
        //If the time is too short, do not animate.
        if(timer.millisElapsed() < 100)
        {
            return;
        }
        
        timer.mark();
        
        //Set the image
        GreenfootImage current = new GreenfootImage("green-character-" + imageIndex + ".png");
        if(!isFacingRight)
        {
            current.mirrorHorizontally();
        }
        setImage(current);
        imageIndex = (imageIndex + 1) % 2;
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
                yBelow = getOneObjectAtOffset(i, 12, Tile.class).getY();
                return true;
            }
        }
        return false;
    }
    
    /**
     * Check if there is tiles above the character to block the character from bumping into it.
     */
    public boolean isBlockedAbove()
    {   
        //If there is tile above the character from left 9 to right 9 cells, return true.
        for(int i=-9; i<=9; i++)
        {
            if(getOneObjectAtOffset(i, -20, Tile.class)!=null)
            {
                //Get the y value of the tile above it & store it -- for later character jumping adjustment.
                yAbove = getOneObjectAtOffset(i, -20, Tile.class).getY();
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
            setLocation(getX(), yBelow-24);
        }
    }
    
    /**
     * Make the object jump.
     */
    public void jump()
    {
        //If there is tiles above the character, stop jumping, start falling.
        if(isBlockedAbove())
        {
            //If the character will jump above the tile, set the location to maximum below the tile, and start to fall.
            if((getY()-velocity) < (yAbove+24))
            {
                setLocation(getX(), yAbove+24);
                velocity=0;
                isFalling = true;
                isJumping = false;
            }
        }
        
        setLocation(getX(), getY()-velocity);
        velocity -= gravity;       
        //If it reaches the ground, stop jumping, and reset its y location.
        if(isOnGround()) {
            velocity = 0;
            isJumping = false;
            setLocation(getX(), yBelow-24);
        }
    }
}