import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameState here.
 * 
 * @author Rohit Maheshwari
 */
public class GameState implements GameStateInterface
{
    
    MyWorld my_world;
    
    public GameState(MyWorld myWorld) {
       this.my_world = myWorld;
    }
    
      /**
     * Act - do whatever the GameOverState wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   public void act()  {}
    
   public void doOngoingGame() {}
   public void doPause() {}
   public void doGameOver() {}
}
