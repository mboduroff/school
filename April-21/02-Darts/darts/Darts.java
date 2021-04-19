package darts;

import javax.swing.*;
import java.awt.*;

class Darts extends JFrame {
    final Color mainColour = Color.decode("#b2ff59");
    final Color secondaryColour = Color.decode("#7ecb20");
    final Color tertiaryColour = Color.decode("#e7ff8c");

    public Darts() {
        class GraphicsPanel extends JPanel {
            final int circleCount = Integer.parseInt(JOptionPane.showInputDialog(new JFrame(),
                    "Circle count:"));

            public void paint(Graphics graphics) {
                Color currentColor = secondaryColour;
                int[] currentCoords = { 10, 10, this.getWidth() - 20, this.getWidth() - 20 };

                final int diff = ((currentCoords[2] - currentCoords[0]) / 2) / circleCount;
//                System.out.println(diff);

                Graphics2D g = (Graphics2D) graphics;

                g.setColor(mainColour);
                g.fillRect(0, 0, this.getWidth(), this.getHeight());

                for (int i = 0; i < circleCount; i++) {
                    if (currentColor == secondaryColour) {
                        currentColor = tertiaryColour;
                    } else {
                        currentColor = secondaryColour;
                    }

                    g.setColor(currentColor);
                    g.fillOval(currentCoords[0], currentCoords[1], currentCoords[2], currentCoords[3]);

                    currentCoords[0] += diff;
                    currentCoords[1] += diff;
                    currentCoords[2] -= 2* diff;
                    currentCoords[3] -= 2* diff;

                }

                g.setColor(Color.decode("#80deea"));
                g.fillRoundRect(10, 450, 365, 200, 10, 10);

                g.setColor(Color.BLACK);
                String txt = "";
                g.drawString(txt, 40, 550);
            }

        }

        this.setLayout(new GridLayout());
        GraphicsPanel gp = new GraphicsPanel();
        add(gp);
        setTitle("Darts");
        setSize(400, 700);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Darts();

    }
}

