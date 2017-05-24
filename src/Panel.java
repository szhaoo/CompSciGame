import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panel extends JPanel
{
  BufferedImage img;
  public Panel(){
    setBackground(new Color(25, 170, 200));
    img = ImageIO.read(new File("/Users/serena/Downloads/sugar.tif"));
  }
  
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(img, 500, 250, this);
    
  }

}