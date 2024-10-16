import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener {
    public int panelHorizontal = 360;
    public int panelVertical = 640;
    private Image birdImage;
    private Image bottomPipe;
    private Image topPipe;
    private Image background;

    public GamePanel(){
        setPreferredSize(new Dimension(panelHorizontal,panelVertical));
        setFocusable(true);
        addKeyListener(this);

        //set up the images
        try{
            birdImage = new ImageIcon(getClass().getResource("flappybird.png")).getImage();
            background = new ImageIcon(getClass().getResource("flappybirdbg.png")).getImage();
            bottomPipe = new ImageIcon(getClass().getResource("bottompipe.png")).getImage();
            topPipe = new ImageIcon(getClass().getResource("toppipe.png")).getImage();
        }catch(NullPointerException e){
            e.printStackTrace();
        }

    }

    private void draw(Graphics g) {

    }


    @Override
    public void paint(Graphics g){
        super.paintComponent(g);
        draw(g);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
