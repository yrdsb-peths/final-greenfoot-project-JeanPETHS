import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the 1st game world.
 * 
 * @author Jean 
 * @version Dec 2023
 */
public class GameWorld1 extends GameWorld
{
    //Store the tile map in numbers
    final private int[][] tileMap = {
            {10,16,10,16,11,10,17,11,11,11,11,11,10,16,11,10,17,10,10,10,10,16,11,17,10},
            {11,16,10,16,11,10,17,11,11,11,11,11,10,4,5,5,6,10,10,10,10,16,11,17,10},
            {10,16,10,1,2,2,3,11,15,2,2,2,14,11,11,15,5,5,5,14,10,16,11,17,11},
            {11,1,2,3,10,11,10,15,3,-1,-1,-1,1,2,5,6,-1,-1,-1,7,14,7,8,9,11},
            {11,10,10,10,11,10,15,3,-1,-1,-1,-1,-1,31,-1,-1,-1,-1,-1,-1,7,14,10,10,10},
            {2,2,14,10,10,10,17,-1,-1,-1,37,-1,-1,32,-1,-1,-1,-1,38,-1,-1,16,11,10,10},
            {-1,-1,1,2,2,2,3,-1,-1,-1,-1,-1,36,35,30,29,-1,-1,-1,-1,-1,16,10,15,8},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,32,-1,-1,-1,-1,-1,-1,-1,7,8,9,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,27,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,24,28,26,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
            {39,39,40,-1,-1,-1,-1,-1,-1,-1,24,25,26,22,24,25,26,-1,-1,-1,-1,-1,-1,-1,-1},
            {10,11,17,-1,-1,-1,-1,-1,-1,-1,18,19,20,22,21,22,23,-1,-1,-1,-1,-1,-1,-1,-1},
            {10,10,12,39,39,40,-1,-1,-1,-1,-1,18,22,22,18,19,20,-1,-1,-1,-1,-1,-1,-1,-1},
            {39,40,10,10,11,12,40,-1,-1,-1,-1,-1,18,19,20,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
            {10,17,10,10,10,11,17,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
            {10,17,11,10,10,10,17,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
            {10,17,10,10,10,10,17,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
        };
    
    public GameWorld1(StartWorld startWorld)
    {        
        super(startWorld);
        
        //Create all things needed
        createGround();
        createLabels();
        createElements();
        
        //Set the time cut off
        timeCutOff = 40;
        //Set the least score for getting a gold medal
        goldMedalCutOff = 4000;
    }

    /**
     * Create the ground that the character can land on through the integer tile map.
     */
    public void createGround()
    {
        for(int row=0; row<tileMap.length; row++)
        {
            for(int col=0; col<tileMap[0].length; col++)
            {
                int currentTile = tileMap[row][col];
                //If the image index is -1, it means no tile at that location.
                if(currentTile==-1)
                {
                    continue;
                }
                addObject(new Tile("mud", tileMap[row][col]), col*tileSize + halfSize, 400-(row*tileSize+halfSize));
            }
        }
    }

    /**
     * Create the necessary elements in the world.
     */
    private void createElements()
    {
        //Add the place where the character starts
        getBackground().drawImage(new GreenfootImage("right-arrow.png"),6*tileSize+halfSize-9,400-7*tileSize-18);

        //Add the character
        GreenCharacter greenCharacter = new GreenCharacter();
        startX = 5*tileSize+halfSize;
        startY = 400-7*tileSize-halfSize;
        addObject(greenCharacter,startX,startY);
        setPaintOrder(Label.class, Switch.class, GreenCharacter.class);
        
        //Add the ladder
        Ladder ladderDown = new Ladder(2);
        addObject(ladderDown,20*tileSize+halfSize,400-5*tileSize-halfSize);
        Ladder ladderUp = new Ladder(0);
        addObject(ladderUp,ladderDown.getX(),ladderDown.getY()-48);

        //Add the trap
        addObject(new Trap(),3*tileSize+halfSize,400-7*tileSize-9);
        addObject(new Trap(),11*tileSize+halfSize,400-3*tileSize-9);
        addObject(new Trap(),18*tileSize+halfSize,400-3*tileSize-9);

        //Add the hint characters
        addObject(new HintCharacter(),tileSize+halfSize,400-6*tileSize-halfSize);
        addObject(new HintCharacter(),12*tileSize+halfSize,400-4*tileSize-halfSize);
        addObject(new HintCharacter(),16*tileSize+halfSize,400-3*tileSize-halfSize);

        //Add the flying cloud
        addObject(new Cloud("cloud", 0),7*tileSize+halfSize,400-8*tileSize-halfSize);
        addObject(new Cloud("cloud", 1),8*tileSize+halfSize,400-8*tileSize-halfSize);
        addObject(new Cloud("cloud", 2),9*tileSize+halfSize,400-8*tileSize-halfSize);
        Jumper jumper = new Jumper();
        addObject(jumper,8*tileSize+halfSize,400-9*tileSize-halfSize);
        //Connect the jumper with the green character
        jumper.greenCharacter = greenCharacter;
        
        //Add the box
        Box box1 = new Box();
        addObject(box1,17*tileSize+halfSize,400-8*tileSize-halfSize);
        
        //Add the switch
        Switch switch1 = new Switch();
        addObject(switch1, box1.getX(), box1.getY()-21);
        switch1.boxConnected = box1;

        //Add the key
        Key key = new Key();
        addObject(key,10*tileSize+halfSize,400-6*tileSize-9);

        //Add the diamond
        addObject(new Diamond(),18*tileSize+halfSize,400-6*tileSize-9);

        //Add the flag
        addObject(new Flag(), 22*tileSize+halfSize, 400-8*tileSize-15);

        //Add the snowman
        addObject(new Snowman(),23*tileSize+halfSize,400-8*tileSize-9);
    }
}
