import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Ball extends SmoothMover
{
    private double xSpeed = 4;
    private double ySpeed = 4;
    public static int ballX, ballY;
    private boolean up=false ;
    public int enemyScore = 0;
    public int myScore = 0;
    private int gameLevel = 1;
    private int timeHitPaddle = 0;
    private int setBounceDelay = 20;
    public void act()
    {
        setLocation(getX()+ xSpeed, getY()+ySpeed);
        if(up = true){
            setBounceDelay = 20;
            
        }
        else{
            setBounceDelay = 0;
        }
        bouncePaddles();
        bounceWalls();
        ballX = getX();
        ballY = getY();
        score();
        increaseLevel();
    }
    public void bouncePaddles(){
        Actor paddles = getOneIntersectingObject(Paddles.class);
        Actor enemyPaddle = getOneIntersectingObject(EnemyPaddle.class);
        
        if (paddles != null){
            if(setBounceDelay == 20){
            Greenfoot.playSound("ball.mp3");
            ySpeed = ySpeed * -1;
            up=!up;
            timeHitPaddle++;
        }
        }
        if (enemyPaddle != null && up){
            if(setBounceDelay == 0){
            timeHitPaddle++;
            ySpeed = ySpeed * -1;
            up=!up;
        }
        }
    }
    public void bounceWalls(){
        this.setLocation(this.getX() +xSpeed, this.getY() + ySpeed);
        if(this.getX()<10 || this.getX()>495){
            Greenfoot.playSound("ball.mp3");
            xSpeed = xSpeed * -1;
            
        }
        if(this.getY()<10 || this.getY()>695){
            if(up){
            Greenfoot.playSound("ball.mp3");
            up=!up;
            }
            ySpeed = ySpeed * -1;
        }
        
        bouncePaddles();
    }
    public void score(){
        if(getY()<10){
            myScore = myScore + 1;
            PongTable.myScore.add(1);
        }
        if(getY()>695){
            enemyScore = enemyScore + 1;
            PongTable w = (PongTable)getWorld();
            w.addEnemyScore(1);
        }
    }
    public void increaseLevel(){
        if(timeHitPaddle>10)
        {
           gameLevel = gameLevel + 1;
           PongTable.gameLevel.add(1);
            xSpeed = xSpeed + 1; 
           ySpeed = ySpeed + 1;
           timeHitPaddle = 0;
           
        }
    }
    public int getTimeHitPaddle(){
        return timeHitPaddle;
    }
}
    
