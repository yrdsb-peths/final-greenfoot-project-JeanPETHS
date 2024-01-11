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
    
    //Set the HP value for the character
    GameWorld1 gameWorld1;
    HealthValue health;
    //Initial value is 6
    int hp = 6;
    //Keet track of the time, if too small, do not reduce HP.
    SimpleTimer timer1 = new SimpleTimer();
    //If is the first time it touches the trap, reduce HP immediately.
    boolean isFirstTouchingTrap = true;
    //If hp=0 and there is still diamonds, revive the character.
    int diamonds = 0;
    
    //Check the direction it is facing
    boolean isFacingRight = true;
    
    Ladder ladder;
        
    //Data to make it fall or jump
    boolean isFalling = false;
    boolean isJumping = false;
    final int initialSpeed = 12;
    int gravity = 2;
    int velocity = 0; 
    
    //Store the y value of the nearest tile under the character
    int yBelow;
    
    //Store the y value of the tile above the character to block it from bumping into the tile
    int yAbove;
    
    //For its animation
    SimpleTimer timer2 = new SimpleTimer();
    int imageIndex = 0;
    
    HintCharacter currentHintCharacter;
        
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
        
        if(isTouching(Ladder.class))
        {
            ladder = (Ladder) getOneIntersectingObject(Ladder.class);
        }
        
        //Check if the character can jump or fall
        if(Greenfoot.isKeyDown("w") && isOnGround() && !isFalling && !isJumping && !isTouching(Ladder.class))
        {
            isJumping = true;
            velocity = initialSpeed;
        }
        else if(!isOnGround() && !isJumping && !(isTouching(Ladder.class) && ladder.isUp))
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
        
        //Reduce HP if game is on & it touches traps, and is first touching or is staying on it for more than 0.5s.
        if(!gameWorld1.gameIsOver && isTouching(Trap.class) && (isFirstTouchingTrap || timer2.millisElapsed()>500))
        {
            isFirstTouchingTrap = false;
            timer2.mark();
            hp--;
            //Set the image of the health value based on HP
            HealthValue.setHealthValue(hp);
            //Update hp variable in the world
            gameWorld1.hp = this.hp;
            if(hp==0)
            {
                //If there is diamonds left, use them.
                if(diamonds>0)
                {
                    //Reset HP
                    hp = 6;
                    HealthValue.resetHealthValue();
                    //Reduce the number of diamonds left
                    diamonds--;
                    gameWorld1.updateDiamond(-1);
                }
                else 
                {
                    //If not, game over.
                    gameWorld1.gameOver();
                }
            }
        }
        //If leave the trap, next touch counts as the first touch.
        if(!isTouching(Trap.class))
        {
            isFirstTouchingTrap = true;
        }
        
        //If touch a hint character, a specific hint will pop up.
        if(isOnHintCharacter())
        {
            currentHintCharacter.turnOnHints();
        }
        else if(currentHintCharacter!=null)
        {
            //If leave the hint character, turn off the hint.
            currentHintCharacter.turnOffHints();
        }
        
        //If touch the key, take it, and remove it.
        if(isTouching(Key.class))
        {
            gameWorld1.updateKey(1);
            removeTouching(Key.class);
        }
        
        //If touch the diamond, take it, and remove it.
        if(isTouching(Diamond.class))
        {
            diamonds++;
            gameWorld1.updateDiamond(1);
            removeTouching(Diamond.class);
        }
        
        //If touches the flag, user wins & game over.
        if(!gameWorld1.gameIsOver && isTouching(Flag.class))
        {
            gameWorld1.gameOver();
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
        if(timer2.millisElapsed() < 100)
        {
            return;
        }
        
        timer2.mark();
        
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
     * Reset all the speed variables.
     */
    public void resetSpeed()
    {
        gravity = 2;
        velocity = 0;
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
    
    /**
     * Check if the character is on the hint character.
     */
    public boolean isOnHintCharacter()
    {   
        //If there is a hint character under the character from left 9 to right 9 cells, return true.
        for(int i=-9; i<=9; i++)
        {
            if(getOneObjectAtOffset(i, 12, HintCharacter.class)!=null)
            {
                currentHintCharacter = (HintCharacter) getOneObjectAtOffset(i, 12, HintCharacter.class);
                return true;
            }
        }
        return false;
    }
}