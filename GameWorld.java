import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    StartWorld startWorld;
    boolean gameIsOver = false;
    boolean win = false;
    
    //Store tile data
    final protected int tileSize = 24;
    final protected int halfSize = tileSize/2;
    
    //Store hp data
    int hp;

    //Store key data
    boolean hasKey = false;
    protected int numOfKeys = 0;
    protected Label numKeys;
    
    //Store diamond data
    protected int numOfDiamonds = 0;
    protected Label numDiamonds;
    
    Label quit;
    Label instructions;
    
    Label gameOver;
    SimpleTimer timer;
    double timeInSecs;
    Label timeUsed;
    
    /**
     * Constructor for objects of class gameWorld.
     */
    public GameWorld(StartWorld startWorld)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, true);
        
        //Set the start world
        this.startWorld = startWorld;
        
        //Start the timer
        timer = new SimpleTimer();
        timer.mark();
        
        //Quit label:
        createColoredImage(50, 20, new Color(254,231,170), 30, 380);
        quit = new Label("\u2190quit", 20, Color.BLACK, null);
        addObject(quit, 30, 380);
        
        //instructions Label:
        createColoredImage(110, 20, new Color(254,231,170), 540, 380);
        instructions = new Label("instructions\u2192", 20, Color.BLACK, null);
        addObject(instructions, 541, 380);
    }
    
    public void act()
    {
        //Animate the options while hovering on them
        if(Greenfoot.mouseMoved(quit)) 
        {
            hoverAnimation(quit, 22);
        }
        else if(Greenfoot.mouseMoved(instructions)) 
        {
            hoverAnimation(instructions, 22);
        } 
        
        //Return to normal if not hovering on them
        if(Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(quit) && !Greenfoot.mouseMoved(instructions)) 
        {
            hoverAnimation(quit, 20);
            hoverAnimation(instructions, 20);
        }
        
        //Go to each world if pressed
        if(Greenfoot.mousePressed(quit))
        {
            Greenfoot.setWorld(startWorld);
        }
        if(Greenfoot.mousePressed(instructions))
        {
            Instructions instructions = new Instructions(this);
            Greenfoot.setWorld(instructions);
        }
    }

    public void hoverAnimation(Label label, int fontSize) {
        label.setFont(fontSize);
    }
    
    /**
     * Create health value, key, diamond labels at the top right corner.
     */
    public void createLabels()
    {
        //Add the health value
        Label hp = new Label("HP : ", 20);
        HealthValue health0 = new HealthValue();
        HealthValue health1 = new HealthValue();
        HealthValue health2 = new HealthValue();
        addObject(hp, 507, 23);
        addObject(health0, 535, 23);
        addObject(health1, 555, 23);
        addObject(health2, 575, 23);
        
        //Add the key label
        getBackground().drawImage(new GreenfootImage("key.png"), 493, 37);
        numKeys = new Label(numOfKeys, 20);
        addObject(numKeys, 520, 45);
        
        //Add the diamond label
        getBackground().drawImage(new GreenfootImage("diamond.png"), 543, 36);
        numDiamonds = new Label(numOfDiamonds, 20);
        addObject(numDiamonds, 570, 45);
    }
    
    /**
     * Draw a background image using only one color. Pass in width, height, color, x, and y value to draw.
     */
    public void createColoredImage(int width, int height, Color color, int x, int y)
    {
        GreenfootImage bgdImage = new GreenfootImage(width, height);
        bgdImage.setColor(color);
        bgdImage.fill();
        Label bgd = new Label("", 0);
        bgd.setImage(bgdImage);
        addObject(bgd, x, y);
    }
    
    /**
     * Draw a background image using only one color and return the label. Pass in width, height, color, x, and y value to draw.
     */
    public Label createColoredImage(int width, int height, Color color, int x, int y, boolean store)
    {
        GreenfootImage bgdImage = new GreenfootImage(width, height);
        bgdImage.setColor(color);
        bgdImage.fill();
        Label bgd = new Label("", 0);
        bgd.setImage(bgdImage);
        addObject(bgd, x, y);
        return bgd;
    }
    
    /**
     * Update the number of keys that the user got and are left unused in the current world, and update the label.
     */
    public void updateKey(int changeInKey)
    {
        //Update the number of keys remained
        numOfKeys += changeInKey;
        
        //Check if there is still keys remained
        if(numOfKeys>0)
        {
            hasKey = true;
        }
        else
        {
            hasKey = false;
        }
        
        //Update the label
        numKeys.setValue(numOfKeys);
    }
    
    /**
     * Update the number of diamonds that the user got, and update the label.
     */
    public void updateDiamond(int changeInDiamond)
    {
        //Update the number of keys remained
        numOfDiamonds += changeInDiamond;
        
        //Update the label
        numDiamonds.setValue(numOfDiamonds);
    }
    
    /**
     * To end the current game world.
     */
    public void gameOver(GameWorld current)
    {
        gameIsOver = true;
        
        //Draw a background image at the back using light purple color
        createColoredImage(320, 150, new Color(233, 219, 232), getWidth()/2, getHeight()/2);
        
        //Game over label & show
        gameOver = new Label("Game Over", 40, Color.BLACK, null);
        addObject(gameOver, getWidth()/2, getHeight()/2-40);
        
        //Take the time data & show
        timeInSecs = timer.millisElapsed()/1000.0;
        double timeInMins = timeInSecs/60.0;
        double timeRounded = (int)(timeInMins * 10) / 10.0;
        timeUsed = new Label(timeRounded + "mins", 30, Color.BLACK, null);
        addObject(timeUsed, gameOver.getX()-26, gameOver.getY()+40);
        timer.mark();
        
        //Take the diamond data & show
        Label numDiamonds = new Label(numOfDiamonds+"x", 30, Color.BLACK, null);
        addObject(numDiamonds, timeUsed.getX()+68, timeUsed.getY());
        //Add the diamond image & show
        Label diamondLabel = new Label("", 30);
        diamondLabel.setImage(new GreenfootImage("diamond.png"));
        addObject(diamondLabel, numDiamonds.getX()+22, numDiamonds.getY()+2);
        
        //Take the total score & show
        int score = getTotalScore(win, timeInSecs, hp, numOfDiamonds);
        Label totalScore = new Label("Your Score: " + score, 40, Color.BLACK, null);
        addObject(totalScore, gameOver.getX()-14, timeUsed.getY()+40);
        
        //Show the medal beside the total score
        Label medal = new Label("", 0);
        GreenfootImage medalImage;
        //Set medal image based on total score
        if(score>=4000)
        {
            medalImage = new GreenfootImage("medals/flatshadow_medal1.png");
        }
        else if(score>=3000)
        {
            medalImage = new GreenfootImage("medals/flatshadow_medal9.png");
        }
        else if(score==0)
        {
            //If the user loses, give a snowman image
            medalImage = new GreenfootImage("snowman.png");
        }
        else
        {
            medalImage = new GreenfootImage("medals/flatshadow_medal2.png");
        }
        //Scale the image
        if(score==0)
        {
            medalImage.scale(25,25);
        }
        else
        {
            medalImage.scale(20,40);
        }
        //Set the image to the label
        medal.setImage(medalImage);
        //Add the label to the world
        addObject(medal, totalScore.getX()+totalScore.getImage().getWidth()/2+22, totalScore.getY());
    }
    
    /**
     * Calculate the total score for the user.
     */
    public int getTotalScore(boolean win, double timeInSecs, int hp, int numOfDiamonds)
    {
        //If does not touch the flag (win), return score equals 0.
        if(!win)
        {
            return 0;
        }
        
        int total = 0;
        //Add score based on time used
        total+=(int)(5000.0 - (timeInSecs-20.0)*40.0);
        //Add score based on HP left
        total-=(6-hp)*10;
        //Add score based on number of diamonds left
        total+=numOfDiamonds*60;
        return total<0 ? 0 : total;
    }
}
