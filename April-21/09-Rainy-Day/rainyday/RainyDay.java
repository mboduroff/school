package rainyday;

import javax.swing.*;
import java.awt.*;

public class RainyDay extends JFrame {
    public RainyDay() {
        class GraphicsPanel extends JPanel {
//            private final Color color = Color.decode("");

            public void paint(Graphics graphics) {
                Graphics2D g = (Graphics2D) graphics;

                g.setColor(Color.BLUE);
                g.fillRect(0, 0, this.getWidth(), this.getHeight());
                g.setStroke(new BasicStroke(5));
                g.setColor(Color.WHITE);

                paintRaindrop(g, 30, 50);
                paintRaindrop(g, 60, 40);
                paintRaindrop(g, 80, 120);
                paintRaindrop(g, 92, 200);
                paintRaindrop(g, 180, 140);
                paintRaindrop(g, 128, 110);
                paintRaindrop(g, 220, 180);
                paintRaindrop(g, 260, 25);
                paintRaindrop(g, 280, 80);
                paintRaindrop(g, 240, 60);

                paintBrolly(g, 250, 260);
            }

            private void paintRaindrop(Graphics2D g, int x, int y) {
                g.setColor(Color.WHITE);
                g.drawLine(x, y, x - 6, y);
                g.drawLine(x, y, x - 3, y - 10);
                g.drawLine(x - 4, y - 10, x - 6, y);
                g.fillArc(x - 8, y - 4, 10, 12, 0, -180);
            }

            private void paintBrolly(Graphics2D g, int x, int y) {
                g.setColor(Color.BLACK);
                g.drawArc(x, y + 34, 20 / 2, 20, 0, -180);
                g.drawLine(x, y, x, y + 40);
                g.setColor(Color.RED);
                g.fillArc(x - 35, y - 20, 70, 40, 0, 180);
            }
        }

        GraphicsPanel gp = new GraphicsPanel();
        add(gp);
        setTitle("Rainy Day");
        setSize(400, 400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new RainyDay();
    }
}
