import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Thanos here.
 * 
 * @author Rohit Maheshwari
 * @author Suhas Hunsimar
 * @author Ameya Nawale
 */
public class Thanos extends Actor {
    public Thanos() {
        GreenfootImage image = getImage();
        image.scale(90, 90);

    }

    /**
     * Act - do whatever the Thanos wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int counter = 0;
    private Actor collidedVehicle;
    private Actor collidedCoin;
    private Actor collidedGems;
    private Actor collidedBooster;
    private ConcreteSubject subject;
    public void act() {
        // Add your action code here.
        if (((MyWorld) getWorld()).getState() instanceof OngoingGame) {
            keymove();
            createBomb();
            checkCollision();
            click();
        }
        /*
        Actor coin = getOneObjectAtOffset(0, 0, Coin.class);
        if(coin != null)
        {
            ((MyWorld)getWorld()).removeObject(coin);
        }
        */
    }
    public void keymove() {

        if (Greenfoot.isKeyDown("left")) {
            this.setLocation(getX() - 6, getY());
            this.setRotation(-10);
        } else if (Greenfoot.isKeyDown("right")) {
            this.setLocation(getX() + 6, getY());
            this.setRotation(10);
        } else if (Greenfoot.isKeyDown("up")) {

            this.setLocation(getX(), getY() - 6);

        } else if (Greenfoot.isKeyDown("down")) {

            this.setLocation(getX(), getY() + 6);

        }


    }

    public void createBomb() {

        AmmoFactory ammoFactory = new AmmoFactory();
        int currentScore = 0;
        if (counter == 0) {
            if (Greenfoot.isKeyDown("x")) {
                Ammunation bullet = ammoFactory.getAmmunition("Bullet");
                getWorld().addObject(bullet, getX(), getY() - 80);
                counter = 50;
            }
            if (Greenfoot.isKeyDown("space")) {
                ArrayList < ConcreteSubject > listOfSubs = (ArrayList < ConcreteSubject > )(((MyWorld) getWorld()).getObjects(ConcreteSubject.class));
                if (listOfSubs.size() > 0) {
                    subject = listOfSubs.get(0);
                    currentScore = subject.getScore();
                }
                if (currentScore >= 100) {
                    Ammunation bullet = ammoFactory.getAmmunition("Laser");
                    getWorld().addObject(bullet, getWorld().getWidth() / 2, getY() - 80);
                    counter = 50;
                    subject.setScore(-100);
                }
            }


        } else {
            counter--;
        }

    }

    public void checkCollision() {
        if (this.isTouching(Blocker.class)) {
            ArrayList < Blocker > list = (ArrayList < Blocker > ) getObjectsAtOffset(5, 5, Blocker.class);
            if (list.size() > 0)
                collidedVehicle = list.get(0);
            else
                collidedVehicle = null;

            if (collidedVehicle != null) {
                getWorld().removeObject(collidedVehicle);
                ((MyWorld) getWorld()).collided();
                 ((MyWorld)getWorld()).unsetMoveFastFlag();
                //Greenfoot.playSound("Explosion.wav");
            }
        }
        if (this.isTouching(Coin.class)) {
            ArrayList < Coin > coins = (ArrayList < Coin > ) getObjectsAtOffset(5, 5, Coin.class);
            if (coins.size() > 0)
                collidedCoin = coins.get(0);
            else
                collidedCoin = null;

            if (collidedCoin != null) {
                getWorld().removeObject(collidedCoin);
                ArrayList < ConcreteSubject > listOfSubs = (ArrayList < ConcreteSubject > )(((MyWorld) getWorld()).getObjects(ConcreteSubject.class));
                if (listOfSubs.size() > 0) {
                    subject = listOfSubs.get(0);
                    subject.setScore(10);
                }

                // ((CarWorld) getWorld()).addScore(10);
                // Greenfoot.playSound("Coin.mp3");
            }
        }
        if (this.isTouching(Gems.class)) {
            ArrayList < Gems > allLife = (ArrayList < Gems > ) getObjectsAtOffset(5, 5, Gems.class);
            if (allLife.size() > 0)
                collidedGems = allLife.get(0);
            else
                collidedGems = null;

            if (collidedGems != null) {
                getWorld().removeObject(collidedGems);
                ((MyWorld) getWorld()).incLives();

            }
        }
        
        if(this.isTouching(SpeedBooster.class)){
                ArrayList<SpeedBooster> boosters = (ArrayList<SpeedBooster>)getObjectsAtOffset(5, 5,SpeedBooster.class);
               
                if(boosters.size()>0)
                    collidedBooster = boosters.get(0);
                else
                    collidedBooster = null;
                    
               if (collidedBooster != null)
                {
            
                   ((MyWorld)getWorld()).removeObject(collidedBooster);
                   Component component;
                   
                   ArrayList<ConcreteSubject> listOfSubs = (ArrayList<ConcreteSubject>)(((MyWorld)getWorld()).getObjects(ConcreteSubject.class));
                   if(listOfSubs.size()>0){
                       subject = listOfSubs.get(0);
                       subject.setSpeed(40);
                    }
                
                   //((CarWorld)getWorld()).getSubject().setSpeed(40);
                  // ((CarWorld)getWorld()).addSpeed(40);
                   component = ((MyWorld)getWorld()).getComponent();
                  
                   
                   try{
                      //  long start = System.currentTimeMillis( );
                        ((MyWorld)getWorld()).setMoveFastFlag();
                        component.setFasterFlag();
                        
                      /* if((System.currentTimeMillis( ) - start) == 5000){
                            ((CarWorld)getWorld()).unsetMoveFastFlag();
                           
                            component.unsetFasterFlag();
                        } */
                    }catch (Exception e) {
                            System.out.println("Got an exception!");
                        }
            
                }
             
            }
    }
    public void click() {
        if (Greenfoot.mouseClicked(null)) {
            if (((MyWorld) getWorld()).getState() instanceof OngoingGame) {
                ((MyWorld) getWorld()).doPause();
                getWorld().addObject(new Information(), 400, 300);
            }
        }
    }
}