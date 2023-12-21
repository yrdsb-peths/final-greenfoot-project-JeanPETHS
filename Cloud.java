import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the class Cloud here.
 * 
 * @author Jean 
 * @version Dec 2023
 */
public class Cloud extends Tile
{
    SimpleTimer timer = new SimpleTimer();
    //The number of moves left
    int moveCount = 48;
    
    /**
     * Set the cloud image based on the type that gets passed into this constructor.
     */
    public Cloud(int type)
    {
        super(new GreenfootImage("cloud" + type + ".png"));
    }
    
    public void act()
    {
        //If too fast, do not move
        if(timer.millisElapsed()<70)
        {
            return;
        }
        
        timer.mark();
        
        //If >0 move right, if <=0 move left.
        if(moveCount>0)
        {
            move(1);
            moveCount--;
        }
        else
        {
            move(-1);
            moveCount--;
        }
        
        //If to the leftmost, reset.
        if(moveCount==-48)
        {
            moveCount = 48;
        }
    }
}
