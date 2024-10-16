import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    public int panelHorizontal = 360;
    public int panelVertical = 640;
    private Image birdImage;
    private Image background;
    private Gamelogic gamelogic;
    private Bird bird;



    public GamePanel(){
        setPreferredSize(new Dimension(panelHorizontal,panelVertical));
        setFocusable(true);

        //set Bird
        bird = new Bird();
        gamelogic = new Gamelogic(this);

        //set up the images
        try{
            birdImage = new ImageIcon(getClass().getResource("flappybird.png")).getImage();
            background = new ImageIcon(getClass().getResource("flappybirdbg.png")).getImage();


        }catch(NullPointerException e){
            e.printStackTrace();
        }

    }

    private void draw(Graphics g) {
        g.drawImage(birdImage,bird.birdPositionX, bird.birdPositionY,bird.birdWidth,bird.birdHeight,null);
        g.drawImage(background,0,0,360,640,null);
        for(Pipe pipe: gamelogic.pipes){
            g.drawImage(pipe.image,pipe.pipePositionX, pipe.pipePositionY,pipe.PipeWidth, pipe.PipeHeight, null);
        }
        if(gamelogic.gameOver){
            g.setColor(Color.red);
            g.setFont(new Font("Bodoni MT Black", Font.BOLD, 35));
            g.drawString("G A M E  O V E R ",17,300);
            g.drawString(String.valueOf(gamelogic.score),180,355);
        }else {
            g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("SCORE : " + gamelogic.score,10,20);
        }

    }


    @Override
    public void paint(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
}
