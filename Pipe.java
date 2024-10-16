public class Pipe {
    public int pipePositionX ;
    public int pipePositionY = 0 ;
    public int PipeHeight = 512;
    public int PipeWidth = 64;

    Pipe(){
        GamePanel panel = new GamePanel();
        pipePositionX = panel.panelHorizontal;
    }
}
