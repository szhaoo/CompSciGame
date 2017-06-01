import java.io.File;
import java.io.IOException;

public class Fishstick extends MovingObject
{
  public Fishstick(String imgLoc){
    super(1);
    super.x = (int)(Math.random() * 750);
    try{
      img = javax.imageio.ImageIO.read(new File(imgLoc));
    }catch (IOException e){
      System.exit(1);
    }
  }
  
}
