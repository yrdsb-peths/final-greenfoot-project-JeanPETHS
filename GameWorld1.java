import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the 1st-level world.
 * 
 * @author Jean 
 * @version Dec 2023
 */
public class GameWorld1 extends World
{
    boolean gameIsOver = false;
    
    final private int tileSize = 24;
    final private int halfSize = tileSize/2;
    final private int[][] tileMap = {
            {10,16,10,16,11,10,17,11,11,11,11,11,10,16,11,10,17,10,10,10,10,16,11,17,10},
            {11,16,10,16,11,10,17,11,11,11,11,11,10,4,5,5,6,10,10,10,10,16,11,17,10},
            {10,16,10,1,2,2,3,11,15,2,2,2,14,11,11,15,5,5,5,14,10,16,11,17,11},
            {11,1,2,3,10,11,10,15,3,-1,-1,-1,1,2,5,6,-1,-1,-1,7,14,7,8,9,11},
            {11,10,10,10,11,10,15,3,-1,-1,-1,-1,-1,31,-1,-1,-1,-1,-1,-1,16,10,10,10,10},
            {2,2,14,10,10,10,17,-1,-1,-1,37,-1,-1,32,-1,-1,-1,-1,38,-1,7,14,11,10,10},
            {-1,-1,1,2,2,2,3,-1,-1,-1,-1,-1,36,35,30,29,-1,-1,-1,-1,-1,16,10,15,8},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,32,-1,-1,-1,-1,-1,-1,-1,7,8,9,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,27,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,24,28,26,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,24,25,26,22,24,25,26,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,18,19,20,22,21,22,23,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,18,22,22,18,19,20,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,18,19,20,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
        };

    Label gameOver;
    
    public GameWorld1(StartWorld startWorld)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, true); 

        //Create all things needed
        createGround();
        createElements();

        //Quit label:
        //instructions Label:
        
    }
    
    /**
     * To end the current game world.
     */
    public void gameOver()
    {
        gameIsOver = true;
        gameOver = new Label("Game Over", 40);
        addObject(gameOver, getWidth()/2, getHeight()/2);
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
                addObject(new Tile(tileMap[row][col]), col*tileSize + halfSize, 400-(row*tileSize+halfSize));
            }
        }
    }

    /**
     * Create the necessary elements in the world.
     */
    private void createElements()
    {
        //Add the huge rock at the top left corner
        addObject(new Rock1(),90,80);

        //Add the place where the character starts
        RightArrow rightArrow = new RightArrow();
        addObject(rightArrow,6*tileSize+halfSize,400-7*tileSize-9);

        //Add the character
        GreenCharacter greenCharacter = new GreenCharacter();
        addObject(greenCharacter,5*tileSize+halfSize,400-7*tileSize-halfSize);

        //Add the ladder
        LadderDown ladderDown = new LadderDown();
        addObject(ladderDown,600-4*tileSize-halfSize,400-6*tileSize-9);
        LadderUp ladderUp = new LadderUp();
        addObject(ladderUp,ladderDown.getX(),ladderDown.getY()-54);

        //Add the trap        
        addObject(new Trap(),11*tileSize+halfSize,400-3*tileSize-9);
        addObject(new Trap(),14*tileSize+halfSize,400-4*tileSize-9);
        addObject(new Trap(),18*tileSize+halfSize,400-3*tileSize-9);

        //Add the hint characters
        addObject(new HintCharacter(),tileSize+halfSize,400-6*tileSize-halfSize);
        addObject(new HintCharacter(),12*tileSize+halfSize,400-4*tileSize-halfSize);
        addObject(new HintCharacter(),16*tileSize+halfSize,400-3*tileSize-halfSize);

        //Add the flying cloud
        addObject(new Fly(),17*tileSize+halfSize,200);

        //Add the box
        addObject(new Box(),8*tileSize+halfSize,400-8*tileSize-halfSize);

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
