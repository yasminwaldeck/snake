import javax.swing.*;
import java.awt.*;

public class Board {

    private Image ball;
    private Image food;
    private Image head;

    public Board(){
        initBoard();
    }

    private void initBoard(){

    }

    private void loadImages() {

        ImageIcon iid = new ImageIcon("src/resources/dot.png");
        ball = iid.getImage();

        ImageIcon iia = new ImageIcon("src/resources/food.png");
        food = iia.getImage();

        ImageIcon iih = new ImageIcon("src/resources/head.png");
        head = iih.getImage();
    }
}
