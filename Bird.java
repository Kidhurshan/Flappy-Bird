public class Bird {
    public int birdPositionX ;
    public int birdPositionY ;
    public int birdHeight = 24;
    public int birdWidth = 34;

    Bird(){
        GamePanel panel = new GamePanel();
        birdPositionX = panel.panelHorizontal/8;
        birdPositionY = panel.panelVertical/2;
    }
}
