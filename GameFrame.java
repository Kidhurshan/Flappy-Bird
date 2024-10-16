import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private JFrame frame;
    private int frameHorizontal = 400 ;
    private int frameVertical = 600;
    GameFrame(){
        frame = new JFrame("Flappy bird Game");
        frame.setSize(frameHorizontal,frameVertical);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.gray);
        //frame.add();
        frame.setVisible(true);
    }


}
