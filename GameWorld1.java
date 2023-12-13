import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the 1st-level world.
 * 
 * @author Jean 
 * @version Dec 2023
 */
public class GameWorld1 extends World
{
    GreenfootImage environment = new GreenfootImage("GameWorld1-Background-transparent.png");
    
    private final int tileSize = 18;

    public GameWorld1(StartWorld startWorld)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, true); 

        //Set environment image
        this.getBackground().drawImage(environment, 0, this.getHeight()-337);

        
        //Set background image
        //Quit label:
        //instructions Label:
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     */
    private void prepare()
    {
        Rock1 rock1 = new Rock1();
        addObject(rock1,100,83);
    }
}
