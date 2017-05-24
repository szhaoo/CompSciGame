import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panel extends JPanel
{
  BufferedImage img;
  public Panel(){
    setBackground(new Color(25, 170, 200));
    try {
      img = ImageIO.read(new File("sugar.png"));
    }catch(IOException e){
      System.out.println("Bad Image");
      System.exit(1);
    }
  }
  
  
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(img, 250, 420, this); // Ha 420
  }

}