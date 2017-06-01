import java.io.File;
import java.io.IOException;

public class Wave extends MovingObject
{
  public Wave(String imgLoc){
    super.x = (int)(Math.random() * 750);
    try{
      img = javax.imageio.ImageIO.read(new File(imgLoc));
    }catch (IOException e){
      System.exit(1);
    }
  }
  
}
