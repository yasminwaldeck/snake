import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel implements ActionListener {

    private Image ball;
    private Image food;
    private Image head;

    private final int BACKGROUND_WIDTH = 450;
    private final int BACKGROUND_HEIGHT = 450;
    private final int RAND_POS = 29;

    private int DOT_SIZE = 15;
    private int TOTAL_DOTS = (450*450)/(15*15);
    private int dots;


    private int food_x;
    private int food_y;

    private Timer timer;
    private int DELAY = 100;

    /*
    private boolean leftDirection = false;
    private boolean rightDirection = false;
    private boolean upDirection = false;
    private boolean downDirection = false;
    */

    private String direction;

    private final int x[] = new int[TOTAL_DOTS];
    private final int y[] = new int[TOTAL_DOTS];


    public Board(){
        initBoard();
    }

    private void initBoard(){


        setBackground(Color.darkGray);
        setFocusable(true);
        setPreferredSize(new Dimension(BACKGROUND_WIDTH, BACKGROUND_HEIGHT));
        addKeyListener(new WSADAdapter());
        loadImages();
        initGame();

        }




    private void loadImages() {

        ImageIcon iid = new ImageIcon("src/resources/dot.png");
        ball = iid.getImage();

        ImageIcon iia = new ImageIcon("src/resources/food.png");
        food = iia.getImage();

        ImageIcon iih = new ImageIcon("src/resources/head.png");
        head = iih.getImage();
    }

    private void initGame(){
        dots = 3;

        for (int z = dots; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        timer = new Timer(DELAY, this);
        timer.start();

        locateApple();
    }

    private void locateApple(){

        int r = (int) (Math.random() * RAND_POS);
        food_x = ((r * DOT_SIZE));

        r = (int) (Math.random() * RAND_POS);
        food_y = ((r * DOT_SIZE));

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private class WSADAdapter implements KeyListener {


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if ((key == KeyEvent.VK_A) && (!direction.equals("right"))) {
            direction = "left";
            /*
            leftDirection = true;
            upDirection = false;
            downDirection = false;
            */

        }

        if ((key == KeyEvent.VK_D) && (!direction.equals("left"))) {
            direction = "right";
            /*
            rightDirection = true;
            upDirection = false;
            downDirection = false;
            */
        }

        if ((key == KeyEvent.VK_W) && (!direction.equals("down"))) {
            direction = "up";
            /*
            upDirection = true;
            rightDirection = false;
            leftDirection = false;
             */
        }

        if ((key == KeyEvent.VK_S) && (!direction.equals("up"))) {
            direction = "down";
            /*
            downDirection = true;
            rightDirection = false;
            leftDirection = false;

             */
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
}


