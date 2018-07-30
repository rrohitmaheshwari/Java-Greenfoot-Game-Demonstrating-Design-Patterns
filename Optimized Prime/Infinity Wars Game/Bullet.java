import greenfoot.*;
import java.util.*;

/**
 * Write a description of class Bullet here.
 * 
 * @author Suhas Hunsimar
 */
public class Bullet extends Ammunation
{
   private GreenfootImage image1;
    private GreenfootImage image2;
    private Actor collidedVehicle;
    private ConcreteSubject subject;


    public Bullet()
    {
        GreenfootImage image=getImage();
        image.scale(20,40);
       image1 = new GreenfootImage("button-blue.png");
       image2 = new GreenfootImage("button-blue.png");
    }
   
    public void act() 
    {
       Actor blocker = getOneObjectAtOffset(0, 0, Blocker.class);
        if(this != null && blocker != null)
        {
            ArrayList<ConcreteSubject> listOfSubs = (ArrayList<ConcreteSubject>)(((MyWorld)getWorld()).getObjects(ConcreteSubject.class));
               if(listOfSubs.size()>0){
                   subject = listOfSubs.get(0);
                   subject.setScore(20);
                }
            ((MyWorld)getWorld()).removeObject(blocker);
            ((MyWorld)getWorld()).removeObject(this);
            return;
        }
   
       moveUp();
       check();
    }    
    public void moveUp()
    {
   
          setLocation(getX(), getY()-8);
     
    }
    public void check()
    {
       
       if(getY() == 0)
       {
         
          if(collidedVehicle != null)
          {
             getWorld().removeObject(collidedVehicle);
          }
        
            getWorld().removeObject(this);
       }
    }
}
