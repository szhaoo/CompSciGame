import java.util.ArrayList;

public class EnemySpawn
{
  private int health = 92;
  public int points = 0;
  public int playerSpeed = 5;
  public boolean gameover = false;
  public ArrayList<MovingObject> enemyList;
  public EnemySpawn()
  {
    enemyList = new ArrayList<MovingObject>();
  }
  public void update(){
    int random = (int)(Math.random()*200);
    if (random == 1 || random == 2 || random == 7)
    {
       enemyList.add(new Seaweed("seaweed.png"));
    }
    else if (random == 3)
    {
       enemyList.add(new Fishstick("fishstick.png"));
    }
    else if (random == 4 || random == 5 || random == 6)
    {
       enemyList.add(new Wave("wave.png"));
    }
  }
  
  public void draw(java.awt.Graphics g, int x, int y){
    for(int i = 0; i < enemyList.size(); i++){
      enemyList.get(i).update();
      g.drawImage(enemyList.get(i).img, enemyList.get(i).x, enemyList.get(i).y, null);
      if(enemyList.get(i).y > 600){
        enemyList.remove(i);
        if(i > 0){
          i--;
        }
      }
      if (enemyList.get(i).detectHit(x, y))
      {
        if (enemyList.get(i).type == 1)
        {
          points++;
          playerSpeed = 5;//speed return to normal
          if(points == 25){
            gameover = true;
          }
        }
        if (enemyList.get(i).type == 2)
        {
          health -= 9;
          if (health <= 0)
          {
            gameover = true;
          }
        }
        if (enemyList.get(i).type == 3)
        {
          playerSpeed = 3;
        }
        enemyList.remove(i);
        i--;
      }
    }
    
  }
  public int getHealth()
  {
    return health;
  }
  public void setHealth(int health)
  {
    this.health = health;
  }
}
