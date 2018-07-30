import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class ConcreteSubject here.
 * 
 * @author Ameya Nawale
 */
public class ConcreteSubject extends Actor
{
   private int score;
   private int speed;
   private List<Observer> listOfObservers;
   
   public ConcreteSubject(){
       listOfObservers = new ArrayList<Observer>();
   }
   
   
   public int getScore(){
       return ((MyWorld) getWorld()).getScore();
    }
    
    public int getSpeed(){
       return ((MyWorld)getWorld()).getSpeed();
    }
    
    public void setScore(int addScore){
        ((MyWorld) getWorld()).addScore(addScore);
        notifyObservers();
    }
    
    public void setSpeed(int addSpeed){
        ((MyWorld)getWorld()).addSpeed(40);
        notifyObservers();
    }   
    
    public void attach(Observer o){
        this.listOfObservers.add(o);
    }
    
    public void detach(Observer o){
         this.listOfObservers.remove(o);
    }
    
    public void notifyObservers(){
        for(Observer o: listOfObservers){
            o.update();
        }
    }
}
