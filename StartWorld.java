import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is StartWorld class. Users start with this world.
 * 
 * @author Jean 
 * @version Dec 2023
 */
public class StartWorld extends World
{
    Instructions instructionsWorld;
    GameWorld1 gWorld1;
    GameWorld2 gWorld2;
    
    private final String gameName = "Flag Seeker";
    Label gameTitle;

    Label instructions;
    Label gameWorld1;
    Label gameWorld2;
    

    public StartWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, true);
        
        //Add game name
        gameTitle = new Label(gameName, 60, new Color(150,100,120));
        gameTitle.setLineColor(new Color(100,100,100));
        addObject(gameTitle, 180, 80);

        //Add instuctions label
        instructions = new Label("Instructions", 40);
        addObject(instructions, gameTitle.getX(), gameTitle.getY()+85);

        //Add game world label
        gameWorld1 = new Label("Game World 1", 40);
        addObject(gameWorld1, instructions.getX()+13, instructions.getY()+75);

        gameWorld2 = new Label("Game World 2", 40);
        addObject(gameWorld2, gameWorld1.getX(), gameWorld1.getY()+75);
    
    }
    
    public void act() {
        //Animate the options while hovering on them
        if(Greenfoot.mouseMoved(instructions)) 
        {
            hoverAnimation(instructions, 50);
        } 
        else if (Greenfoot.mouseMoved(gameWorld1)) 
        {
            hoverAnimation(gameWorld1, 50);
        }
        else if (Greenfoot.mouseMoved(gameWorld2)) 
        {
            hoverAnimation(gameWorld2, 50);
        }
        
        //Return to normal if not hovering on them
        if(Greenfoot.mouseMoved(this)) 
        {
            hoverAnimation(instructions, 40);
            hoverAnimation(gameWorld1, 40);
            hoverAnimation(gameWorld2, 40);
        } 
        
        //Go to each world if pressed
        if(Greenfoot.mousePressed(instructions))
        {
            instructionsWorld = new Instructions(this);
            Greenfoot.setWorld(instructionsWorld);
        }
        if(Greenfoot.mousePressed(gameWorld1))
        {
            gWorld1 = new GameWorld1(this);
            Greenfoot.setWorld(gWorld1);
        }
        if(Greenfoot.mousePressed(gameWorld2))
        {
            gWorld2 = new GameWorld2(this);
            Greenfoot.setWorld(gWorld2);
        }
    }
    
    public void hoverAnimation(Label label, int fontSize) {
        label.setFont(fontSize);
    }

}
