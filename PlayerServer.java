import java.io.Serializable;

public class PlayerServer implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private int	x, y;
    private int ballx, bally;
    private int scoreS = 0;
    private int scoreP = 0;
    private String inputMessage ="";
    private String outputMessage ="";
    private boolean restart = false;
    public boolean isRestart() {
        return restart;
    }

    public void setRestart(boolean restart) {
        this.restart = restart;
    }

    public PlayerServer(){
        x = 50;
        y = 200;
        ballx = 380;
        bally = 230;
    }
    public String getName() {
        return name;
    }

    public String getInputMessage() {
        return inputMessage;
    }

    public void setInputMessage(String inputMessage) {
        this.inputMessage = inputMessage;
    }

    public String getOutputMessage() {
        return outputMessage;
    }

    public void setOutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getBallx() {
        return ballx;
    }
    public void setBallx(int ballx) {
        this.ballx = ballx;
    }
    public int getBally() {
        return bally;
    }
    public void setBally(int bally) {
        this.bally = bally;
    }

    public int getScoreS() {
        return scoreS;
    }

    public void setScoreS(int scoreS) {
        this.scoreS = scoreS;
    }

    public int getScoreP() {
        return scoreP;
    }

    public void setScoreP(int scoreP) {
        this.scoreP = scoreP;
    }
}
