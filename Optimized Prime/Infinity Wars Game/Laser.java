import greenfoot.*;
import java.util.*;

/**
 * Write a description of class Laser here.
 * 
 * @author Suhas Hunsimar
 */
public class Laser extends Ammunation
{
   private GreenfootImage image1;
    private GreenfootImage image2;
    private Actor collidedVehicle;
  
    
    public Laser()
    {
        GreenfootImage image=getImage();
        image.scale(1000,5);
     
    }
   
    public void act() 
    {

        //Actor blocker = getOneObjectAtOffset(0, 0, Blocker.class);
        Actor blocker = getOneIntersectingObject(Blocker.class);


        if(this != null && blocker != null)
        {
            ((MyWorld)getWorld()).removeObject(blocker);
            return;
        }
        
        
         
       moveUp();
       check();
    }    
    public void moveUp()
    {
     
          setLocation(getX(), getY()-5);
       
    }
    public void check()
    {
      
       if( getY() == 0)
       {
        
          if(collidedVehicle != null)
          {
             
             getWorld().removeObject(collidedVehicle);
          }
         
          if(this.getY()==0)
            getWorld().removeObject(this);
       }
    }    
}
