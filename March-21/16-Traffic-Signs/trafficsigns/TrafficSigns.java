package trafficsigns;

import javax.swing.*;
import java.awt.*;

class TrafficSigns extends JFrame {
    public TrafficSigns() {
        class GraphicsPanel extends JPanel {
            public void paint(Graphics graphics) {
                Graphics2D g = (Graphics2D) graphics;

                g.setColor(Color.decode("#00cbfe"));
                g.fillRect(0, 0, this.getWidth(), this.getHeight());

                g.setColor(Color.decode("#ef1c25"));
                g.fillOval(30, 20, 420, 420);
                g.setColor(Color.WHITE);
                g.fillOval(65, 55, 350, 350);
                g.setColor(Color.WHITE);
                g.setFont(new Font("Montserrat", Font.PLAIN, 26));
                g.drawString("Б2", 445, 450);
            }
        }

        setBackground(Color.decode("#e7ff8c"));
        GraphicsPanel gp = new GraphicsPanel();
        add(gp);
        setTitle("Б2: Забранено е влизането на ППС в двете посоки");
        setSize(500, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new TrafficSigns();
    }
}

