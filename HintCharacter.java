import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the class of hint character, which gives users some hints when using it.
 * 
 * @author Jean 
 * @version Dec 2023
 */
public class HintCharacter extends Tile
{
    GameWorld1 gameWorld1;
    SimpleTimer timer = new SimpleTimer();
    int hintIndex = 0;
    
    //Give each hint character a specific hint
    static int i = 0;
    Label hint;
    static String[] hints = {"1. Jump onto cloud\n & drop to get key.","2. Top of tree is stable!!","3. Get middle ladder &\nhold 'w' key to climb up."};
    
    public HintCharacter()
    {
        super(new GreenfootImage("hint-character-0.png"));
        
        //Give each hint character a specific transparent hint label
        hint = new Label(hints[i], 15, Label.transparent, Label.transparent);
        i++;
        i%=3;
    }
    
    public void act()
    {
        animateCharacter();
    }
    
    public void addedToWorld(World world)
    {
        if(world instanceof GameWorld1)
        {
            gameWorld1 = (GameWorld1)world;
            //Add each transparent hint label to the world
            gameWorld1.addObject(hint, this.getX()+15, this.getY()-48);
        }
    }
    
    public void animateCharacter()
    {
        //If the time is too short, do not animate.
        if(timer.millisElapsed() < 500)
        {
            return;
        }
        
        timer.mark();
        
        //Set the image
        GreenfootImage current = new GreenfootImage("hint-character-" + hintIndex + ".png");        
        setImage(current);
        hintIndex = (hintIndex + 1) % 3;
    }
}
