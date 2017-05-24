import java.awt.*;
import javax.swing.JFrame;
public class Window
{

  public static void main(String[] args)
  {
    JFrame clifford = new JFrame("Clifford");
    clifford.setSize(750,600);
    Panel back = new Panel();
    clifford.add(back);
    clifford.setDefaultCloseOperation(3);
    clifford.setVisible(true);
  }

}
