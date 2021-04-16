package spiral;

import javax.swing.*;
import java.awt.*;

class Spiral extends JFrame {
    public Spiral() {
        class GraphicsPanel extends JPanel {
            public void paint(Graphics graphics) {
                Graphics2D g = (Graphics2D) graphics;

                g.setColor(Color.black);

                int x = getSize().width / 2 - 10;
                int y = getSize().height/ 2 - 10;
                int width = 20;
                int height = 20;
                int startAngle = 0;
                int arcAngle = 180;
                int depth = 10;

                for (int i = 0; i < 10; i++) {
                    if (i % 2 == 0) {
                        y = y - depth;
                        width = width + 2 * depth;
                        height = height + 2 * depth;
                        g.drawArc(x, y, width, height, startAngle, -arcAngle);
                    } else {
                        x = x - 2 * depth;
                        y = y - depth;
                        width = width + 2 * depth;
                        height = height + 2 * depth;
                        g.drawArc(x, y, width, height, startAngle, arcAngle);
                    }
                }

            }
        }

        GraphicsPanel gp = new GraphicsPanel();
        add(gp);
        setTitle("Spiral");
        setSize(500, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new Spiral();
    }
}

