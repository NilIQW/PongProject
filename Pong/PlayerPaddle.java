import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerPaddle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerPaddle extends Paddles
{
    private int speed = 5;
    public void act()
    {
        checkMovementKeys();
    }
    public void checkMovementKeys(){
        if(Greenfoot.isKeyDown("left")){
            move(-speed);
        }
        if(Greenfoot.isKeyDown("right")){
            move(speed);
        }
    }
}
