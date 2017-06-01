import java.util.ArrayList;

public class EnemySpawn
{
  private int health = 92;
  public int points = 0;
  public ArrayList<MovingObject> enemyList;
  public EnemySpawn()
  {
    enemyList = new ArrayList<MovingObject>();
  }
  public void update(){
    if ((int)(Math.random() * 100) == 1)
    {
       enemyList.add(new Seaweed("seaweed.png"));
    }
    else if ((int)(Math.random() * 100) == 2)
    {
       enemyList.add(new Fishstick("fishstick.png"));
    }
    else if ((int)(Math.random() * 100) == 3)
    {
       enemyList.add(new Wave("wave.png"));
    }
  }
  
  public void draw(java.awt.Graphics g, int x, int y){
    for(int i = 0; i < enemyList.size(); i++){
      enemyList.get(i).update();
      g.drawImage(enemyList.get(i).img, enemyList.get(i).x, enemyList.get(i).y, null);
      if(enemyList.get(i).y > 600){
        enemyList.remove(enemyList.get(i));
        i--;
      }
      if (enemyList.get(i).detectHit(x, y))
      {
        if (enemyList.get(i).type == 1)
        {
          points++;
          //speed return to normal
          
        }
        if (enemyList.get(i).type == 2)
        {
          health -= 9;
        }
        if (enemyList.get(i).type == 3)
        {
          speed = speed / 2;
        }
        enemyList.remove(enemyList.get(i));
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
