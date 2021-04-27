package tictactoe;

import java.awt.*;
import java.net.URL;
import javax.swing.*;
import java.util.Random;

public class TicTacToe extends JFrame {
    public static final int ROWS = 3;
    public static final int COLS = 3;
    public static final int IMAGE_SIZE = 50;
    public static final int PADDING = 20;
    public static final int CELL_SIZE = IMAGE_SIZE + 2 * PADDING;
    public static final int CANVAS_SIZE = CELL_SIZE * ROWS;

    private final Random random = new Random();

    private final Image imgCross;
    private final Image imgNought;

    public TicTacToe() {
        ImageIcon iconCross = null;
        ImageIcon iconNought = null;
        String imgCrossFilename = "images/cross.gif";
        URL imgURL = getClass().getClassLoader().getResource(imgCrossFilename);
        if (imgURL != null) {
            iconCross = new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + imgCrossFilename);
        }
        assert iconCross != null;
        imgCross = iconCross.getImage();

        String imgNoughtFilename = "images/nought.gif";
        imgURL = getClass().getClassLoader().getResource(imgNoughtFilename);
        if (imgURL != null) {
            iconNought = new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + imgNoughtFilename);
        }
        assert iconNought != null;
        imgNought = iconNought.getImage();

        DrawCanvas canvas = new DrawCanvas();
        canvas.setPreferredSize(new Dimension(CANVAS_SIZE, CANVAS_SIZE));
        setContentPane(canvas);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setTitle("TicTacToe Test");
        setVisible(true);
        setResizable(false);
    }

    private class DrawCanvas extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.WHITE);
            for (int row = 0; row < ROWS; ++row) {
                for (int col = 0; col < COLS; ++col) {
                    boolean useCross = random.nextBoolean();
                    Image img = useCross ? imgCross : imgNought;
                    g.drawImage(img,
                            CELL_SIZE * col + PADDING, CELL_SIZE * row + PADDING,
                            IMAGE_SIZE, IMAGE_SIZE, null);
                }
            }
            g.fill3DRect(CELL_SIZE - 2, 0, 4, CELL_SIZE * 3, true);
            g.fill3DRect(CELL_SIZE * 2 - 2, 0, 4, CELL_SIZE * 3, true);
            g.fill3DRect(0, CELL_SIZE - 2, CELL_SIZE * 3, 4, true);
            g.fill3DRect(0, CELL_SIZE * 2 - 2, CELL_SIZE * 3, 4, true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TicTacToe::new);
    }
}