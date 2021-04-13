package diagonals;

import javax.swing.*;
import java.awt.*;

class Diagonals extends JFrame {
    private final int diagonalsCount = Integer.parseInt(JOptionPane.showInputDialog(new JFrame(),
            "Diagonals count:")) + 1;

    public Diagonals() {
        class GraphicsPanel extends JPanel {
            public void paint(Graphics graphics) {
                Graphics2D g = (Graphics2D) graphics;

                g.setColor(Color.BLACK);
                int curx = 5, cury = this.getHeight() + 5;

                for (int i = diagonalsCount; i > 0; i--) {
                    curx += this.getWidth() / diagonalsCount;
                    cury -= this.getWidth() / diagonalsCount;
                    g.drawLine(0, 0, curx, cury);
                    g.drawLine(curx, cury, this.getWidth(), this.getHeight());
                }
            }
        }

        setBackground(Color.decode("#e7ff8c"));
        GraphicsPanel gp = new GraphicsPanel();
        add(gp);
        setTitle("Diagonals");
        setSize(300, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new Diagonals();
    }
}

