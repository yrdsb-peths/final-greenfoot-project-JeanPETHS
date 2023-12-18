import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the tile class.
 * 
 * @author Jean 
 * @version Dec 2023
 */
public class Tile extends Actor
{
    
    /**
     * Pass in the image index to create tiles.
     */
    public Tile(int type)
    {
        GreenfootImage temp = new GreenfootImage("mud" + type + ".png");
        temp.scale(24,24);
        setImage(temp);
    }
    
    /**
     * Pass in the image to create tiles.
     */
    public Tile(GreenfootImage image)
    {
        image.scale(24,24);
        setImage(image);
    }
}
