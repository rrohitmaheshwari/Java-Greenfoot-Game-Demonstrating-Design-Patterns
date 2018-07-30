import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.*;

/**
 * Write a description of class Observer here.
 * 
 * @author Ameya Nawale
 */
public class Score extends Observer
{
   public static int value = 0;
    public static int target = 0;
    public static String text;
    public static int stringLength;
    private ConcreteSubject subject;
   public Score()
    {
        this("");
    }
    public Score(String prefix)
    {
        value = 0;
        target = 0;
        text = prefix;
        stringLength = (text.length() + 2) * 16;    //length

        setImage(new GreenfootImage(stringLength, 24));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        image.setFont(font.deriveFont(24.0F));  // to use larger font
        
        updateImage();
    }
    public void act()
    {
       //nothing
    }
    
    public int getValue()
    {
        return value;
    }
  
    public void updateImage()
    {
        GreenfootImage image = getImage();
        image.clear();
        
        image.setColor(Color.WHITE);
        
            
        image.drawString(text + target, 1, 18);
    }
    
    //this will help us to show updated score
    public void update(){
         ArrayList<ConcreteSubject> listOfSubs = (ArrayList<ConcreteSubject>)(((MyWorld)getWorld()).getObjects(ConcreteSubject.class));
        if(listOfSubs.size()>0){
              subject = listOfSubs.get(0);
               
        }
        
        if(text.equalsIgnoreCase("Power: ")){
            if (subject != null)
            target = subject.getScore();
        
        }
      
       if(value > target)
       {
          value = 0;
         // updateImage();
       }
       updateImage();
      
    }  
}
