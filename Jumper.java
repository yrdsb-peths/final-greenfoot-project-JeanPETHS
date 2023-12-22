import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the class Jumper. It can pump the character into the air if the character stands on it.
 * 
 * @author Jean
 * @version Dec 2023
 */
public class Jumper extends Tile
{
    //Store the character instance here
    GreenCharacter greenCharacter;
    
    public Jumper()
    {
        super(new GreenfootImage("jumper0.png"));
    }
    
    public void act()
    {
        // Add your action code here.
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
