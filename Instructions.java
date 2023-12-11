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
        addObject(title, getWidth()/2, 20);
        
        //Add in instructions: 
        
        //Create back label at the left bottom corner
        back = new Label("Back", 30, Color.WHITE);
        addObject(back, 60, 355);
    }
    
    public void act()
    {
        //Animate the back option while hovering on it
        if (Greenfoot.mouseMoved(back)) 
        {
            hoverAnimation(back, 35);
        }
        
        //Return to normal if not hovering on it
        if(Greenfoot.mouseMoved(this)) 
        {
            hoverAnimation(back, 30);
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
}
