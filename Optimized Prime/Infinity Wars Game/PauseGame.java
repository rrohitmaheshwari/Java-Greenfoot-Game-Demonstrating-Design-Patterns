import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PauseGame here.
 * 
 * @author Rohit Maheshwari
 */
public class PauseGame extends GameState
{

    public PauseGame(MyWorld myWorld) {
        super(myWorld);
    }

    @Override
    public void doOngoingGame() {
        my_world.setState(my_world.getOngoingState());
    }
}
