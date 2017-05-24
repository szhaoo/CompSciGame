import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panel extends JPanel
{
  public Panel(){
    setBackground(new Color(25, 170, 200));
  }
  
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    
  }

}