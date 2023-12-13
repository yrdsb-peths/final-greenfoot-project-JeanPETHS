import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the 1st-level world.
 * 
 * @author Jean 
 * @version Dec 2023
 */
public class GameWorld1 extends World
{
    GreenfootImage environment = new GreenfootImage("background/GameWorld1-Background-transparent.png");
    
    private final int tileSize = 18;

    public GameWorld1(StartWorld startWorld)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, true); 

        //Set environment image
        this.getBackground().drawImage(environment, 0, this.getHeight()-337);

        //Prepare all needed elements to the world
        prepare();
        
        //Quit label:
        //instructions Label:
        
    }

    /**
     * Prepare the world for the start of the program.
     */
    private void prepare()
    {
        Rock1 rock1 = new Rock1();
        addObject(rock1,100,83);

        //Add the place where the character starts
        RightArrow rightArrow = new RightArrow();
        addObject(rightArrow,151,231);

        //Add the character
        GreenCharacter greenCharacter = new GreenCharacter();
        addObject(greenCharacter,127,227);

        //Add the ladder
        LadderDown ladderDown = new LadderDown();
        addObject(ladderDown,476,258);
        LadderUp ladderUp = new LadderUp();
        addObject(ladderUp,ladderDown.getX(),207);

        //Add the trap        
        Trap trap = new Trap();
        addObject(trap,266,323);
        Trap trap2 = new Trap();
        addObject(trap2,404,323);
        Trap trap3 = new Trap();
        addObject(trap3,335,300);

        //Add the flying cloud
        Fly fly = new Fly();
        addObject(fly,403,200);

        //Add the locked box
        LockedBox lockedBox = new LockedBox();
        addObject(lockedBox,197,204);
        
        //Add the key
        Key key = new Key();
        addObject(key,243,246);
    }
}
