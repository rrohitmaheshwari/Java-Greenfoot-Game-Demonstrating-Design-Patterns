import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreBoard here.
 * 
 * @author Rohit Maheshwari
 * @author Ameya Nawale
 */
public class ScoreBoard extends Actor
{
    public static final float FONT_SIZE = 24.0f;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    
   
    public ScoreBoard(int score, int lives)
    {
        if(lives==6)
        makeImage("Thanos Won!!!", "Score: ", "Infinity Stones: ", score, lives);
        else
         makeImage("Game Over", "Score: ", "Infinity Stones: ", score, lives);
    }

    /**
     * Make the score board image.
     */
    private void makeImage(String title, String prefix1, String prefix2, int score, int lives)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);

        image.setColor(new Color(0, 0, 0, 160));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(255, 255, 255, 100));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(title, 60, 100);
        image.drawString(prefix1 + score, 60, 175);
        image.drawString(prefix2 + lives, 60, 250);
        setImage(image);
    }
    public void act()
    {
        if(((MyWorld) getWorld()).getState() instanceof GameOver)
          {
              
              //((MyWorld) getWorld()).setState(((MyWorld) getWorld()).getOngoingState());
              //((CarWorld) getWorld()).pauseGame();
              //getWorld().removeObject(this);
              MyWorld world=(MyWorld) getWorld();
              Greenfoot.stop();
              getWorld().addObject(new ScoreBoard(world.getScore(),world.getLives()),400,300);
          }
    }
}
