import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Component here.
 * 
 * @author Saket Relan
 */
public abstract class Component extends Actor
{    
    public abstract void addChild(Component c);
    public abstract void removeChild(Component c);
    public abstract Component getChild(int i);
    public abstract List<Component> getAllChild();
    public abstract void setFasterFlag();
    public abstract void unsetFasterFlag();
    public abstract void addCoinScore();
}
