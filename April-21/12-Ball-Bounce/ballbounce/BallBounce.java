package ballbounce;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

public class BallBounce {

    public static void main(String[] args) {
        new BallBounce();
    }

    public BallBounce() {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException
                    | IllegalAccessException | UnsupportedLookAndFeelException ignored) {
            }

            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.add(new Balls());
            frame.setTitle("Bouncing balls");
            frame.setSize(400, 400);
            frame.setVisible(true);
        });
    }

    public static class Balls extends JPanel {

        public Balls() {
            setLayout(null);
            add(new Ball(Color.RED, 10 - (int) Math.round((Math.random() * 20)), 10 - (int) Math.round((Math.random() * 20))));
            add(new Ball(Color.BLUE, 10 - (int) Math.round((Math.random() * 20)), 10 - (int) Math.round((Math.random() * 20))));
        }
    }

    public static class Ball extends JPanel implements Runnable {

        Color color;
        int diameter;
        long delay;
        private int vx;
        private int vy;

        public Ball(Color colour, int xVelocity, int yVelocity) {
            color = colour;

            diameter = 30;
            delay = 20;

            vx = xVelocity;
            vy = yVelocity;

            new Thread(this).start();

        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setColor(color);
            g.fillOval(0, 0, 30, 30);
            g.setColor(Color.black);
            g2.drawOval(0, 0, 30, 30);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(30, 30);
        }

        public void run() {

            try {
                SwingUtilities.invokeAndWait(() -> {
                    int x = (int) (Math.round(Math.random() * getParent().getWidth()));
                    int y = (int) (Math.round(Math.random() * getParent().getHeight()));

                    setLocation(x, y);
                });
            } catch (InterruptedException | InvocationTargetException exp) {
                exp.printStackTrace();
            }

            while (isVisible()) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                }

                try {
                    SwingUtilities.invokeAndWait(() -> {
                        move();
                        repaint();
                    });
                } catch (InterruptedException | InvocationTargetException exp) {
                    exp.printStackTrace();
                }
            }
        }

        public void move() {

            int x = getX();
            int y = getY();

            if (x + vx < 0 || x + diameter + vx > getParent().getWidth()) {
                vx *= -1;
            }
            if (y + vy < 0 || y + diameter + vy > getParent().getHeight()) {
                vy *= -1;
            }
            x += vx;
            y += vy;

            setSize(getPreferredSize());
            setLocation(x, y);

        }
    }
}