import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Padd here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Paddles extends Actor
{
    public int speed = 7;
    public void act()
    {
        
    }
    public void playback(){
        if(getX() > Ball.ballX){
            setLocation(getX() - speed, getY());
        }
        if(getX() < Ball.ballX){
            setLocation(getX() + speed, getY());
        }
    }
}
