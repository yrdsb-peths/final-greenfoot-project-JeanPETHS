import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the 2nd game world.
 * 
 * @author Jean 
 * @version Dec 2023
 */
public class GameWorld2 extends GameWorld
{
    //Store the tile map in numbers
    final private int[][] tileMap = {
            {34,34,35,34,35,-1,33,34,34,34,34,30,31,31,32,34,35,-1,33,34,33,34,30,31,31},
            {34,34,35,34,35,-1,33,34,34,34,34,20,24,24,22,34,35,-1,33,34,33,34,20,24,24},
            {34,34,35,34,35,-1,17,18,18,40,40,40,18,40,18,40,19,-1,33,34,33,34,34,33,34},
            {34,34,35,34,35,-1,-1,30,31,31,31,31,31,32,-1,-1,-1,-1,33,78,79,80,34,33,34},
            {40,40,19,34,35,-1,-1,20,24,21,21,24,24,22,-1,-1,-1,-1,17,18,33,34,34,33,34},
            {34,34,34,34,35,-1,-1,-1,-1,28,21,29,-1,-1,-1,-1,-1,-1,-1,-1,33,34,34,17,18},
            {34,34,34,14,15,16,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,33,34,34,34,34},
            {18,40,18,18,19,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,43,44,44,42,-1,33,34,34,34,34},
            {-1,68,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,17,18,18,40,18},
            {69,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,48,49,50,-1,-1,-1,-1,-1,-1,65,66},
            {70,-1,69,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1,-1,70,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,9},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
        };
        
    public GameWorld2(StartWorld startWorld)
    {    
        super(startWorld);
        
        //Create all things needed
        createGround();
        createLabels();
        createElements();
        
        //Set the time cut off
        timeCutOff = 300;
        //Set the least score for getting a gold medal
        goldMedalCutOff = 5500;
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
                addObject(new Tile("gameWorld2/tile", tileMap[row][col]), col*tileSize + halfSize, 400-(row*tileSize+halfSize));
            }
        }
    }

    /**
     * Create the necessary elements in the world.
     */
    private void createElements()
    {
        //Add the place where the character starts
        getBackground().drawImage(new GreenfootImage("right-arrow.png"),4*tileSize+halfSize-9,400-8*tileSize-18);

        //Add the character
        GreenCharacter greenCharacter = new GreenCharacter();
        startX = 3*tileSize+halfSize;
        startY = 400-8*tileSize-halfSize;
        addObject(greenCharacter,startX,startY);
        currentCharacter = greenCharacter;
        setPaintOrder(Label.class, Switch.class, GreenCharacter.class);
        
        //Add the stick decorations
        GreenfootImage stick = new GreenfootImage("gameWorld2/stick.png");
        stick.scale(24,24);
        getBackground().drawImage(stick,0,400-9*tileSize);
        getBackground().drawImage(stick,2*tileSize,400-9*tileSize);
        getBackground().drawImage(stick,2*tileSize,400-10*tileSize);
        getBackground().drawImage(stick,24*tileSize,400-11*tileSize);
        
        //Add the food objects in the sky
        addObject(new Food(63), 4*tileSize+12, 400-12*tileSize-12);
        addObject(new Food(55), 6*tileSize+12, 400-11*tileSize-12);
        addObject(new Food(71), 7*tileSize+12, 400-13*tileSize-12);
        
        //Add the ice cream
        addObject(new IceCream(), 10*tileSize+12, 400-6*tileSize-12);
        
        //Add the glass bottle
        addObject(new GlassBottle(51), 15*tileSize+12, 400-4*tileSize-12);
        addObject(new GlassBottle(53), 15*tileSize+12, 400-3*tileSize-12);
        
        //Add the glass
        addObject(new Glass(), 16*tileSize+12, 400-3*tileSize-12);
        
        //Add the candles
        GreenfootImage blueCandle0 = new GreenfootImage("gameWorld2/blue-candle-0.png");
        GreenfootImage blueCandle1 = new GreenfootImage("gameWorld2/blue-candle-1.png");
        blueCandle0.scale(24,24);
        blueCandle1.scale(24,24);
        getBackground().drawImage(blueCandle0, 8*tileSize, 400-7*tileSize);
        getBackground().drawImage(blueCandle1, 8*tileSize, 400-6*tileSize);
        getBackground().drawImage(blueCandle0, 12*tileSize, 400-7*tileSize);
        getBackground().drawImage(blueCandle1, 12*tileSize, 400-6*tileSize);
        
        //Add the flying cloud
        addObject(new Cloud("gameWorld2/cloud", 0),5*tileSize+halfSize,400-8*tileSize-halfSize);
        addObject(new Cloud("gameWorld2/cloud", 1),6*tileSize+halfSize,400-8*tileSize-halfSize);
        addObject(new Cloud("gameWorld2/cloud", 2),7*tileSize+halfSize,400-8*tileSize-halfSize);

        //Add the key
        Key key = new Key();
        addObject(key,7*tileSize+halfSize,400-14*tileSize-9);

        //Add the diamond
        addObject(new Diamond(),6*tileSize+halfSize,400-3*tileSize-9);

        //Add the flag
        addObject(new Flag(), 22*tileSize+halfSize, 400-9*tileSize-15);
    }
}
