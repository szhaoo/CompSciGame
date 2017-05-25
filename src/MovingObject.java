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
  
  
}
