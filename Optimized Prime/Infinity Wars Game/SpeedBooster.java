import greenfoot.*;

/**
 * Write a description of class SpeedBooster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpeedBooster extends Actor
{
    public SpeedBooster(){
        GreenfootImage image=getImage();
        image.scale(30,30);  
    }
    
    public void act() 
    {
        this.removeTouching(SpeedBooster.class);
        moveDown();
        check();
    }
   
    public void moveDown()
    {
          if(((MyWorld) getWorld()).getState() instanceof OngoingGame)
       {         
             setLocation(getX(), getY()+4);
       }
    } 
    public void moveFaster()
    {
          if(((MyWorld) getWorld()).getState() instanceof OngoingGame)
       {
          setLocation(getX(), getY()+ 8);
       }
    }
    public void check()
    {
  
       // collided = getOneIntersectingObject(Coin.class);
        if (getY()>=(getWorld().getHeight()-1))
        {
           getWorld().removeObject(this);
        }
 
    }  
}
