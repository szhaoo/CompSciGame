import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

public class Panel extends JPanel implements ActionListener, KeyListener
{
  int x = 350;
  private static final int Y = 475;
  private int speed = 0;
  private BufferedImage img;
  private BufferedImage imgWin;
  public EnemySpawn spawner;
  private JLabel score;
  private JLabel win;
  private JButton replay;
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
    setLayout(new BorderLayout());
    score = new JLabel("Points: " + spawner.points, SwingConstants.CENTER);
    add(score, BorderLayout.NORTH);
    win = new JLabel("",  SwingConstants.CENTER);
    add(win, BorderLayout.CENTER );
  }
  
  
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    if(!spawner.gameover)
    {
      replay = null;
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
      if(spawner.points >= 25)
      {
        win.setText("You win!");
        try {
          imgWin = ImageIO.read(new File("goodJob.jpg"));
        }catch(IOException e){
          System.out.println("Bad Image");
          System.exit(1);
        }
        g.drawImage(imgWin, 350, 490, this);
      }else {
        win.setText("You Lose :(");
        try {
          imgWin = ImageIO.read(new File("badJob.jpg"));
        } catch (IOException e) {
          System.out.println("Bad Image");
          System.exit(1);
        }
        g.drawImage(imgWin, 350, 490, this);
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
