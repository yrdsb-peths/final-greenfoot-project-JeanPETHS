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
    public Tile(String prefix, int type)
    {
        GreenfootImage temp = new GreenfootImage(prefix + type + ".png");
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
    
    /**
     * Pass in the image to set image.
     */
    public void setTileImage(GreenfootImage image)
    {
        image.scale(24,24);
        setImage(image);
    }
}
