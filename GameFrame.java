import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private JFrame frame;
    private GamePanel panel;
    private int frameHorizontal = 330 ;
    private int frameVertical = 640;
    GameFrame(){
        frame = new JFrame("Flappy bird Game");
        frame.setSize(frameHorizontal,frameVertical);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.gray);

        panel = new GamePanel();
        frame.add(panel);
        frame.pack();
        panel.requestFocus();
        frame.setVisible(true);
    }


}
