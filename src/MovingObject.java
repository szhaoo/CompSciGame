import java.awt.image.BufferedImage;

public abstract class MovingObject
{
  BufferedImage img;
  public  int x;
  public int y = 0;
  public static final int SPEED = 3;
  public int type;
  public MovingObject(int type)
  {
    this.type = type;
  }
  public void update(){
    y += SPEED;
  };
  public boolean detectHit(int x, int y)
  {
    return (this.x - x <= 70 && this.x - x > 0 && this.y - y >= -35 && this.y - y < 0);
    
  }
}
