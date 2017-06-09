import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JLabel;

public class Panel extends JPanel implements ActionListener, KeyListener
{
  int x = 350;
  private static final int Y = 475;
  private int speed = 0;
  BufferedImage img;
  public EnemySpawn spawner;
  private JLabel score;
  private JLabel win;
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
    spawner = new EnemySpawn();
    score = new JLabel("Points: " + spawner.points);
    add(score);
    win = new JLabel();
    add(win);
  }
  
  
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    if(!spawner.gameover)
    {
      g.setColor(Color.BLACK);
      g.fillRect(2, 2, 100, 50);
      g.setColor(Color.white);
      g.fillRect(6, 6, 92, 42);
      g.setColor(Color.GREEN);
      g.fillRect(6, 6, spawner.getHealth(), 42);
      g.drawImage(img, x, Y, this);
      spawner.draw(g, x, Y);
      score.setText("Points: " + spawner.points);
    }
    else
    {
      score.setText("");
      setBackground(Color.WHITE);
      if(spawner.points >= 1)
      {
        win.setText("You win!");
      }else{
        win.setText("You Lose :(");
      }
      win.setFont(new Font("Monotype Corsiva",1,40));
    }
  }
  
  public void actionPerformed(ActionEvent e){
    step();
  }

  public void step(){
      x += speed;
    if( x > 750) {
        x = 0;
    }
    if(x < 0){
        x = 750;
    }
    spawner.update();
    repaint();
  }
  public void keyTyped(KeyEvent e) {
  }
  public void keyPressed(KeyEvent e) {
      if(e.getKeyCode() == 39){ // Right Arrow
          speed = spawner.playerSpeed;
      }else if(e.getKeyCode() == 37){ // Left Arrow
          speed = -spawner.playerSpeed;
      }
  }
  public void keyReleased(KeyEvent e) {
      if(e.getKeyCode() == 39 && speed == spawner.playerSpeed){ // Right Arrow
          speed = 0;
      }else if(e.getKeyCode() == 37 && speed == -spawner.playerSpeed){ // Left Arrow
          speed = 0;
      }
  }
}
