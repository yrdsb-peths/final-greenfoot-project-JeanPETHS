import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This will be the instructions page.
 * 
 * @author Jean 
 * @version Dec 2023
 */
public class Instructions extends World
{
    World previousWorld;
    Label title;
    Label back;
    
    public Instructions(World previousWorld)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        this.previousWorld = previousWorld;
        
        //Create title label at the top
        title = new Label("Instructions", 45, Color.WHITE);
        addObject(title, getWidth()/2, 30);
        
        //Add in instructions
        createInstructions();
        
        //Create back label at the left bottom corner
        back = new Label("Back", 25, Color.WHITE);
        addObject(back, 52, 368);
    }
    
    public void act()
    {
        //Animate the back option while hovering on it
        if (Greenfoot.mouseMoved(back)) 
        {
            hoverAnimation(back, 30);
        }
        
        //Return to normal if not hovering on it
        if(Greenfoot.mouseMoved(this)) 
        {
            hoverAnimation(back, 25);
        }
        
        //Go to the previous world if pressed
        if(Greenfoot.mousePressed(back))
        {
            Greenfoot.setWorld(previousWorld);
        }
    }
    
    public void hoverAnimation(Label label, int fontSize) {
        label.setFont(fontSize);
    }
    
    public void createInstructions()
    {
        //General rule
        addObject(new Label("You will start with a green character. Your goal is to get to the red flag\nas fast as possible! Use <a> to move left, <d> to right, <w> to jump.", 21, Color.BLACK, null), getWidth()/2, 80);
        
        //Green Character
        getBackground().drawImage(new GreenfootImage("green-character-0.png"), 90, 107);
        createSentence("Green Character: the one that you can control", 254, 120);
        
        //Health Value
        getBackground().drawImage(new GreenfootImage("health2.png"),94, 132);
        createSentence("Health Value: represents how much HP is left; if HP=0, game over", 310, 140);
        
        //Trap
        getBackground().drawImage(new GreenfootImage("trap.png"), 94, 148);
        createSentence("Trap: reduce HP if touching & don't stay on it!!!", 255, 160);
        
        //Key
        getBackground().drawImage(new GreenfootImage("key.png"), 94, 172);
        createSentence("Key: use this to open locked boxes", 224, 180);
        
        //Diamond
        getBackground().drawImage(new GreenfootImage("diamond.png"), 94, 192);
        createSentence("Diamond: obtained by touching, can be used to revive or added to final score", 340, 200);
        
        //Switch
        getBackground().drawImage(new GreenfootImage("switch0.png"), 94, 210);
        createSentence("Switch: touch this & press <space> to unlock the box under it with a key", 330, 220);
        
        //Locked Box
        getBackground().drawImage(new GreenfootImage("locked-box.png"), 94, 232);
        createSentence("Locked Box: has something in it", 217, 240);
        
        //Unlocked Box
        getBackground().drawImage(new GreenfootImage("unlocked-box.png"), 94, 252);
        createSentence("Unlocked Box: already opened", 212, 260);
        
        //Cloud
        getBackground().drawImage(new GreenfootImage("cloud1.png"), 94, 272);
        createSentence("Cloud: moving at a constant speed & can carry characters", 291, 280);
        
        //Jumper
        getBackground().drawImage(new GreenfootImage("jumper0.png"), 94, 292);
        createSentence("Jumper: pump character into the sky if stand on it", 267, 300);
        
        //Ladder
        getBackground().drawImage(new GreenfootImage("ladder1.png"), 94, 312);
        createSentence("Ladder: hold <w> to climb & adjust your position by <a>/<d>", 295, 320);
        
        //Flag
        getBackground().drawImage(new GreenfootImage("flag2.png"), 94, 332);
        createSentence("Flag: touch & win!!!", 180, 340);
        
        //Hint Character
        getBackground().drawImage(new GreenfootImage("hint-character-0.png"), 90, 352);
        createSentence("Hint Character: gives you a hint if stand on this", 257, 360);
    }
    
    /**
     * Create a sentence at the specified place with a black font color, no line color, and white background color.
     */
    public void createSentence(String sentence, int x, int y)
    {
        Label sentenceLabel = new Label(sentence, 16, Color.BLACK, null);
        createColoredImage(sentenceLabel.getImage().getWidth()+6, sentenceLabel.getImage().getHeight()+2, x, y);
        addObject(sentenceLabel, x, y);
    }
    
    /**
     * Draw a background image using only one color. Pass in width, height, color, x, and y value to draw.
     */
    public void createColoredImage(int width, int height, int x, int y)
    {
        GreenfootImage bgdImage = new GreenfootImage(width, height);
        bgdImage.setColor(Color.WHITE);
        bgdImage.fill();
        Label bgd = new Label("", 0);
        bgd.setImage(bgdImage);
        addObject(bgd, x, y);
    }
}
