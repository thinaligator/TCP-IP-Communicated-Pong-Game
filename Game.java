import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Game extends JFrame implements KeyListener, Runnable{
    private static final long serialVersionUID = 1L;
    private static Image  image;
    private Graphics g;
    private static final String TITLE  = "Pong Game";
    private static final int    WIDTH  = 974;		  // - Width  size for window - //
    private static final int    HEIGHT = 620;		  // - Height size for window - //
    private String servername = "servername" , clientname = "clientname";
    public Game(){
    }
    @Override
    public void run() {
        this.setVisible(true);
        this.setTitle(TITLE);
        this.setSize(WIDTH,HEIGHT);
        this.setResizable(false);
        this.addKeyListener(this);
    }
    public static void main(String[] args){
        Toolkit tk = Toolkit.getDefaultToolkit();
        image = tk.getImage("D:\\PongGame\\PongGame\\src\\background.png");
        Game newT = new Game();
        newT.run();
    }
    private Image createImage(){
        BufferedImage bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = bufferedImage.createGraphics();
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.drawImage(image,0, 0, this);
        return bufferedImage;
    }
    @Override
    public void paint(Graphics g){
        g.drawImage(createImage(), 0, 20, this);
    }
    @Override
    public void keyPressed(KeyEvent arg0) {
        int    keyCode = arg0.getKeyCode();
        String portAdd = null;
        String ipAdd   = null;
        // - Create a Server - //
        if(keyCode==KeyEvent.VK_S){
            // - Input Dialog for get a port address - //
            portAdd = JOptionPane.showInputDialog(null, "ex. 1024", "Enter server port:", 1);
            // - Alert Message - //
            if(portAdd!=null){
                if(!isPort(portAdd)){
                    JOptionPane.showMessageDialog(null, "Enter port number as a right format!", "Error!", 1);
                }
                else{
                    // - Input Dialog for get a nick name for server player - //
                    servername = JOptionPane.showInputDialog(null, "Nick name:", "Enter server name:", 1);
                    servername+="";
                    // - Alert Message - //
                    if(servername.length()>10 || servername.length()<3 || servername.startsWith("null")){
                        JOptionPane.showMessageDialog(null, "Enter name as a right format!", "Error!", 1);
                    }
                    // - Create a server - //
                    else{
                        PongServer myServer = new PongServer(servername,portAdd);
                        Thread myServerT = new Thread(myServer);
                        myServerT.start();
                        this.setVisible(false);
                    }
                }
            }
        }
        // - Create a Client - //
        if(keyCode==KeyEvent.VK_C){
            // - Input Dialog [IP Address] - //
            ipAdd = JOptionPane.showInputDialog(null, "ex. 127.0.0.1", "Enter server ip:", 1);
            if(ipAdd!=null){
                // - Alert Message - //
                if(!isIPAddress(ipAdd)){
                    JOptionPane.showMessageDialog(null, "Enter ip number as a right format!", "Enter server ip:", 1);
                }
                else{
                    // - Input Dialog [Port Number] - //
                    portAdd = JOptionPane.showInputDialog(null, "ex. 1024", "Enter server port number:", 1);
                    // - Alert Message - //
                    if(portAdd!=null){
                        if(!isPort(portAdd)){
                            JOptionPane.showMessageDialog(null, "Enter port number as a right format!", "Error!:", 1);
                        }
                        // - Input Dialog for get a nick name for client player - //
                        else{
                            clientname = JOptionPane.showInputDialog(null, "Nick name:", "Enter server name:", 1);
                            clientname += "";
                            if(clientname.length()>10 || clientname.length()<3 || clientname.startsWith("null")){
                                JOptionPane.showMessageDialog(null, "Enter name as a right format!", "Error!", 1);
                            }
                            // - Start a Client - //
                            else{
                                PongClient myClient = new PongClient(clientname, portAdd, ipAdd);
                                Thread myClientT = new Thread(myClient);
                                myClientT.start();
                                this.setVisible(false);
                            }
                        }
                    }
                }
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent arg0) {
    }
    @Override
    public void keyTyped(KeyEvent arg0) {
    }
    // - Check PORT number type- //
    private boolean isPort(String str) {
        Pattern pPattern = Pattern.compile("\\d{1,4}");
        return pPattern.matcher(str).matches();
    }
    // - Check IP address type- //
    private boolean isIPAddress(String str) {
        Pattern ipPattern = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
        return ipPattern.matcher(str).matches();
    }
}
