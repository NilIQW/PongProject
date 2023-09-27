import greenfoot.*; 


public class PongTable extends World
{   
    private Counter enemyScore = new Counter("Enemy Score: ");
    public static Counter myScore = new Counter("My Score: ");
    public static Counter gameLevel = new Counter("Game Level: ");
    public int x =Greenfoot.getRandomNumber(500);
    public PongTable()
    {    
        super(500, 700, 1);
        placeObjects();
        
        
    }
    public void placeObjects(){
        PlayerPaddle player = new PlayerPaddle();
        addObject(player, 255, 650);
        EnemyPaddle enemy = new EnemyPaddle();
        addObject(enemy, x, 40);
        Ball ball = new Ball();
        addObject(ball, 250, 250);
        addObject(enemyScore, 80, 15);
        addObject(myScore, 430, 680);
        
        addObject(gameLevel, 430, 15);
        addEnemyScore(2);
    }
    
    public void addEnemyScore(int x){
        enemyScore.add(x);
        
    }
    
}
