import java.io.File;
import java.io.IOException;

public class Seaweed extends MovingObject
{
  public Seaweed(String imgLoc){
    super.x = (int)(Math.random() * 750);
    try{
      img = javax.imageio.ImageIO.read(new File(imgLoc));
    }catch (IOException e){
      System.exit(1);
    }
  }
  
  
}
