import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class Gamelogic implements KeyListener {
    private Bird bird;
    private ArrayList<Pipe> pipes;
    private int score;
    private boolean gameOver =false;
    private  int birdVelocityY = -10;
    private  int pipeVelocityX = -4;
    private final int gravity = 1;
    private Timer gameLoop;
    private Timer pipeLoop;

    Gamelogic(){
        GamePanel panel = new GamePanel();
        gameLoop = new Timer(1000 / 60, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                move();
                panel.repaint();
                if(gameOver){
                    gameLoop.stop();
                    pipeLoop.stop();
                }
            }
        });
        gameLoop.start();
        pipeLoop = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placePipe();
            }
        });
        pipeLoop.start();

    }

    private void placePipe() {
        Pipe topPipe = new Pipe();
        topPipe.pipePositionY= (int)(topPipe.pipePositionY - topPipe.PipeHeight/4 - Math.random()*topPipe.PipeHeight/2);
        pipes.add(topPipe);

        Pipe bottomPipe = new Pipe();
        bottomPipe.pipePositionY = (int)(topPipe.pipePositionY + bottomPipe.PipeHeight/Math.min(Math.random()*10,4) + bottomPipe.PipeHeight);
        pipes.add(bottomPipe);
    }

    private void move() {
        //moving the bird
        birdVelocityY += gravity;
        bird.birdPositionY += birdVelocityY;
        bird.birdPositionY= Math.max(bird.birdPositionY,1);

        //For Pipe
        for(Pipe pipe : pipes){
            pipe.pipePositionX += pipeVelocityX;
            if(collision(bird, pipe)){
                gameOver =true;
            }
            if( !pipe.isBirdMoved &&bird.birdPositionX > pipe.pipePositionX + pipe.PipeWidth){
                pipe.isBirdMoved = true;
                score++;
            }
        }
        if(bird.birdPositionY>640){
            gameOver = true;
        }

    }
    private boolean collision(Bird bird, Pipe pipe) {
        return bird.birdPositionX< pipe.pipePositionX + pipe.PipeWidth &&
                bird.birdPositionX + bird.birdWidth > pipe.pipePositionX &&
                bird.birdPositionY < pipe.pipePositionY + pipe.PipeHeight &&
                bird.birdPositionY + bird.birdHeight >pipe.pipePositionY;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            birdVelocityY = -10;

        }
        if(e.getKeyCode() == KeyEvent.VK_R){
            reset();
        }
    }

    private void reset() {
        gameOver = false;
        birdVelocityY = -10;
        pipes.clear();
        pipeVelocityX =-4;
        score =0;
        bird.birdPositionY = 320;
        gameLoop.start();
        pipeLoop.start();

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}



