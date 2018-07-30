import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lives here.
 * 
 * @author Suhas Hunsimar
 */
public class Lives extends Actor
{
    /**
     * Act - do whatever the Lives wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static int valueLives;
    
     public Lives() {
        GreenfootImage image = getImage();
        image.scale(30, 40);

    }
  
    public void act()
    {
       valueLives = ((MyWorld) getWorld()).getLives();
       decLives();
     
    }
    public void decLives()
    {
        
    
          
    } 
    
    
}
