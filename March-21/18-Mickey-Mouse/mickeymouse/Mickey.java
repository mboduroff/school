package mickeymouse;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JFrame;


public class Mickey extends Canvas {

    public void boxOval(Graphics g, Rectangle bb) {
        g.fillOval(bb.x, bb.y, bb.width, bb.height);
    }

    public void mickey(Graphics g, Rectangle bb) {
        boxOval(g, bb);
        if (bb.width < 3) {
            return;
        }

        int dx = bb.width/2;
        int dy = bb.height/2;
        Rectangle half = new Rectangle(bb.x, bb.y, dx, dy);

        half.translate(-dx/2, -dx/2);
        mickey(g, half);

        half.translate(dx*2, 0);
        mickey(g, half);
    }

    public void paint(Graphics g) {
        Rectangle bb = new Rectangle(100, 100, 200, 200);
        g.setColor(Color.gray);
        mickey(g, bb);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Mickey Mouse");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Mickey();
        canvas.setSize(400, 400);
        canvas.setBackground(Color.white);
        frame.getContentPane().add(canvas);

        frame.pack();
        frame.setVisible(true);
    }
}