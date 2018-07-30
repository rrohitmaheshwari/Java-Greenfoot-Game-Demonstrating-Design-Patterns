import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OngoingGame here.
 * 
 * @author Rohit Maheshwari
 */
public class OngoingGame extends GameState
{
    
    public OngoingGame(MyWorld myWorld) {

        super(myWorld);

    }
    @Override
       public void doGameOver() {
                   my_world.setState(my_world.getGameOverState());
        }
    
    @Override
    public void doPause() {
        my_world.setState(my_world.getPauseState());
    }
}
