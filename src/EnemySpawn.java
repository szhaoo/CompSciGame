import java.util.ArrayList;

public class EnemySpawn
{
  public ArrayList<MovingObject> enemyList;
  public EnemySpawn()
  {
    enemyList = new ArrayList<MovingObject>();
  }
  public void update(){
    if ((int)(Math.random() * 60) == 1)
    {
       enemyList.add(new Seaweed("seaweed.png"));
    }
    else if ((int)(Math.random() * 60) == 2)
    {
       enemyList.add(new Fishstick("fishstick.png"));
    }
    else if ((int)(Math.random() * 60) == 3)
    {
       enemyList.add(new Wave("wave.png"));
    }
  }
  public void draw(java.awt.Graphics g){
    for(MovingObject object : enemyList){
      g.drawImage(object.img, object.x, object.y, null);
    }
  }
}
