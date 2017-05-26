import java.awt.image.BufferedImage;

public abstract class MovingObject
{
  BufferedImage img;
  public  int x;
  public int y = 0;
  public static final int SPEED = 3; 
  public void update(){
    y += SPEED;
  };
  public boolean DetectHit(int x, int y)
  {
    return (Math.abs(this.x - x) <= 10 && Math.abs(this.y - y) <= 10);
    
  }
}
