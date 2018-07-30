import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author Rohit Maheshwari
 */
public class MyWorld extends World {
    private boolean fastFlag = false;
    private Component component;
    private GameState st;
    private GameState og;
    private GameState pg;
    private GameState go;
    private int counter;
    private int lives;
    private int score;
    private int speed;
    private int laser;
    private ConcreteSubject subject;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);

        setPaintOrder(Information.class, StartScreen.class, Score.class, ScoreBoard.class, Thanos.class, Blocker.class, Lives.class);

        addObject(new StartScreen(), 400, 300);

        lives = 1;
        laser = 2;
        speed = 48;
        
        og = new OngoingGame(this);
        pg = new PauseGame(this);
        go = new GameOver(this);

        st = og;
        component = new Composite();

        subject = new ConcreteSubject();
        
        addObject(new StartScreen(), 400, 300);
        addObject(subject, 0, 0);
        addObject(new Thanos(), 400, 550);

        Score score = new Score("Power: ");
        subject.attach(score);
        
        addObject(score, 85, 580);
        addObject(new Lives(), 50, 50);
        Component vehicle = new Blocker();

    }
    public void act() {
        if (st instanceof OngoingGame) {
            chanceToVehicle();
            chanceBackground();
            chanceToBonus();
        }

    }
    public Component getComponent(){
       // System.out.println("World component is of size "+ component.getAllChild().size());
        return component;
    }
    public void chanceToBonus() {
        Component coin = new Coin();
        Component gems = new Gems();
        if(fastFlag) {
             coin.setFasterFlag();
          
       }

        if (Greenfoot.getRandomNumber(100) < 1) {
            addObject(coin, 170 + Greenfoot.getRandomNumber(500), 0);
            component.addChild(coin);
        }


        if ((Greenfoot.getRandomNumber(200) == 3) ) {
            addObject(gems, 170 + Greenfoot.getRandomNumber(500), 0);
            component.addChild(gems);
        }
        if((Greenfoot.getRandomNumber(150)<1) && (!fastFlag))
       {
          addObject(new SpeedBooster(), 170+Greenfoot.getRandomNumber(500), 0);
       }

    }
    public void chanceBackground() {

    }
    public GameState getState() {
        return st;
    }
    public void setState(GameState state) {
        this.st = state;
    }
    public GameState getOngoingState() {
        return this.og;
    }

    public GameState getPauseState() {
        return this.pg;
    }

    public GameState getGameOverState() {
        return this.go;
    }

    public int getScore() {
        return score;
    }
    public void addScore(int scoreToAdd) {
        score += scoreToAdd;
    }

    public int getSpeed() {
        return speed;
    }
    public void addSpeed(int newSpeed) {
        speed += newSpeed;
    }
    public void setSpeed(int finalSpeed) {
        speed = finalSpeed;
    }
    public void setLives() {
        lives--;
    }
    public int getLives() {
        return lives;
    }
 public void setMoveFastFlag(){
        fastFlag = true;
        counter = 0;
    }

    public void unsetMoveFastFlag(){
        fastFlag = false;
        counter = 0;
    }
    public void collided() {

        lives--;
        List remove = getObjects(Lives.class);

        removeObject((Actor) remove.get(remove.size() - 1));
        if (lives == 0) {
              Greenfoot.stop();
              this.addObject(new ScoreBoard(this.getScore(),this.getLives()),400,300);            
            this.doGameOver();
            return;
        }
    }
    public void chanceToVehicle() {
        Component vehicle = new Blocker();
        
        if(fastFlag) {
             vehicle.setFasterFlag();
       }
       
        if (Greenfoot.getRandomNumber(50) < 1) {
            addObject(vehicle, 175 + Greenfoot.getRandomNumber(500), 0);
            component.addChild(vehicle);
        }


    }
    public void incLives() {

        lives++;
        addObject(new Lives(), 50 * lives, 50);
        if (lives == 6) {
              Greenfoot.stop();
              this.addObject(new ScoreBoard(this.getScore(),this.getLives()),400,300);            
            this.doGameOver();
            return;
        }

    }
    
   public void doOngoingGame() {
       this.st.doOngoingGame();
   }
   public void doPause() {
       this.st.doPause(); 
   }
   public void doGameOver() {
       this.st.doGameOver();
    }

}