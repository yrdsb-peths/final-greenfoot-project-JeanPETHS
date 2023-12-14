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
        //Add the huge rock at the top left corner
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
        
        //Add the hint characters
        HintCharacter hintCharacter = new HintCharacter();
        addObject(hintCharacter,36,251);
        HintCharacter hintCharacter2 = new HintCharacter();
        addObject(hintCharacter2,291,297);
        HintCharacter hintCharacter3 = new HintCharacter();
        addObject(hintCharacter3,429,320);

        //Add the flying cloud
        Fly fly = new Fly();
        addObject(fly,403,200);

        //Add the locked box
        LockedBox lockedBox = new LockedBox();
        addObject(lockedBox,197,204);

        //Add the key
        Key key = new Key();
        addObject(key,243,246);
        //Add the rock under the key
        Rock rock = new Rock();
        addObject(rock,key.getX(),263);
        
        //Add the flag
        Flag flag = new Flag();
        addObject(flag, 522, 200);
        
        //Add the snowman
        Snowman snowman = new Snowman();
        addObject(snowman,544,207);
        
        //Add the diamond
        Diamond diamond = new Diamond();
        addObject(diamond,430,256);
        //Add the shelf under the diamond
        Shelf shelf = new Shelf();
        addObject(shelf,diamond.getX(),272);
    }
}
