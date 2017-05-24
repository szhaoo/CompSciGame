import java.awt.*;
import javax.swing.JFrame;
public class Windoe
{

  public static void main(String[] args)
  {
    JFrame clifford = new JFrame("Clifford");
    clifford.setVisible(true);
    clifford.setSize(650,500);
    Panel back = new Panel();
    clifford.add(back);
    clifford.setDefaultCloseOperation(3);
  }

}
