import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panel extends JPanel implements ActionListener, KeyListener
{
  int x = 350;
  private static final int Y = 500;
  BufferedImage img;
  public Panel(){
    setBackground(new Color(25, 170, 200));
    try {
      img = ImageIO.read(new File("sugar.png"));
    }catch(IOException e){
      System.out.println("Bad Image");
      System.exit(1);
    }
    addKeyListener(this);
    Timer timer = new Timer(1000/60, this);
    timer.start();
    requestFocus();
  }
  
  
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(img, x, Y, this); // Ha 420
  }
  
  public void actionPerformed(ActionEvent e){
    step();
  }
  public void step(){
    repaint();
  }
  public void keyTyped(KeyEvent e) {
  }
  public void keyPressed(KeyEvent e) {
    System.out.println(e.getKeyCode());
  }
  public void keyReleased(KeyEvent e) {
  }
}