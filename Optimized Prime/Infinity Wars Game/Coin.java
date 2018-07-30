import greenfoot.*;
import java.util.*;

/**
 * Write a description of class Coin here.
 * 
 * @author Saket Relan
 */
public class Coin extends Component
{
    
   private boolean moveFasterFlag = false;
    /**
     * Act - do whatever the Coin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Coin()
    {
     GreenfootImage image=getImage();
        image.scale(40,40);  
    }
    
   public void act() 
    {
        
       this.removeTouching(Blocker.class);

       this.removeTouching(Coin.class);
         
       if(moveFasterFlag)
            moveFaster();
        else
            moveDown();
            
        check();
    }
   
    public void moveDown()
    {
        if(((MyWorld) getWorld()).getState() instanceof OngoingGame)
       {
         
             setLocation(getX(), getY()+ 4);
 
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
           if (getY()>=(getWorld().getHeight()-1))
            {
               getWorld().removeObject(this);
    
            }
            
    }
    
    public void setFasterFlag(){
        moveFasterFlag = true;
    }
    
    public void addChild(Component c) {}
    public void removeChild(Component c) {}
    public Component getChild(int i) {
        return null;
    }
    public List<Component> getAllChild(){
        return null;
    }
    public void unsetFasterFlag() {
        moveFasterFlag = false;
    }
    public void addCoinScore() {}
}

