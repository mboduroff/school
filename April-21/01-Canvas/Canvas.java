import javax.swing.*;
import java.awt.*;

class Canvas extends JFrame {
    public Canvas() {
        class GraphicsPanelTest extends JPanel {
            public void paint(Graphics graphics) {
                Graphics2D g = (Graphics2D) graphics;

                g.setColor(Color.BLUE);
                g.fillRect(0, 0, this.getWidth(), this.getHeight());
                g.setStroke(new BasicStroke(5));
                g.setColor(Color.WHITE);
//        g.drawRoundRect(10, 10, 650, 630, 60, 60);
//        g.setColor(Color.YELLOW);
//        g.drawLine(50, 50, 600, 600);
//        g.setColor(Color.PINK);
//        g.fillOval(200, 250, 200, 200);
//        g.setColor(Color.BLACK);
//        g.fillArc(200, 250, 200, 200, 0, 180);
//        g.setColor(Color.GREEN);
//        int[] x = { 60, 200, 200 };
//        int[] y = { 590, 590, 500 };
//        g.drawPolygon(x, y, 3);
//        g.setColor(Color.WHITE);
                g.setFont(new Font("Montserrat", Font.PLAIN, 45));
//        g.drawString("Today I am a painter!", 250, 50);
                g.setColor(Color.BLACK);
                g.drawString("/", 368, 310);
                g.setColor(Color.RED);
                g.fillOval(300, 300, 80, 100);
                g.fillOval(360, 300, 80, 100);
            }

        }


        GraphicsPanelTest gp = new GraphicsPanelTest();
        add(gp);
        setTitle("Today I am a painter");
        setSize(700, 760);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public static void main(String[] args) {
        Canvas canvas = new Canvas();
    }
}

