import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author Rohit Maheshwari
 */
public class GameOver extends GameState
{
       public void act()  {}
    
    public GameOver(MyWorld myWorld) {
        super(myWorld);
    }
    
    @Override
    public void doGameOver() {
        my_world.setState(this);
    }
}
