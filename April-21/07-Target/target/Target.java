package target;

import java.awt.EventQueue;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Target extends JFrame {

    private final JTextField fieldMargin;
    private final JTextField fieldIndent;
    private final JTextField fieldMinDiameter;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Target frame = new Target();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public Target() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 665, 469);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("Target");
        setResizable(false);

        JPanel controlsPanel = new JPanel();
        controlsPanel.setBackground(Color.LIGHT_GRAY);
        controlsPanel.setBounds(10, 10, 252, 412);
        contentPane.add(controlsPanel);
        controlsPanel.setLayout(null);

        JLabel lblMargin = new JLabel("Поле");
        lblMargin.setBounds(10, 10, 45, 13);
        controlsPanel.add(lblMargin);

        fieldMargin = new JTextField();
        fieldMargin.setBounds(10, 33, 96, 19);
        controlsPanel.add(fieldMargin);
        fieldMargin.setColumns(10);

        JLabel lblIndent = new JLabel("Отстояние");
        lblIndent.setBounds(10, 73, 96, 13);
        controlsPanel.add(lblIndent);

        fieldIndent = new JTextField();
        fieldIndent.setBounds(10, 96, 96, 19);
        controlsPanel.add(fieldIndent);
        fieldIndent.setColumns(10);

        JLabel lblMinDiameter = new JLabel("Минимален диаметър");
        lblMinDiameter.setBounds(10, 136, 182, 13);
        controlsPanel.add(lblMinDiameter);

        fieldMinDiameter = new JTextField();
        fieldMinDiameter.setBounds(10, 159, 96, 19);
        controlsPanel.add(fieldMinDiameter);
        fieldMinDiameter.setColumns(10);

        JPanel activePanel = new JPanel();
        activePanel.setBackground(Color.ORANGE);
        activePanel.setBounds(262, 10, 379, 412);
        contentPane.add(activePanel);

        JButton btnClear = new JButton("Изчисти");
        btnClear.setBounds(10, 326, 96, 21);
        btnClear.addActionListener(e -> activePanel.repaint());
        controlsPanel.add(btnClear);

        JButton btnExit = new JButton("Изход");
        btnExit.setBounds(10, 357, 96, 21);
        btnExit.addActionListener(e -> System.exit(0));
        controlsPanel.add(btnExit);


        JButton btnDraw = new JButton("Начертай");
        btnDraw.addActionListener(e -> {
            Graphics2D g = (Graphics2D) activePanel.getGraphics();
            int field = Integer.parseInt(fieldMargin.getText());
            int minDiam = Integer.parseInt(fieldIndent.getText());
            int indent = Integer.parseInt(fieldMinDiameter.getText());
            int d = minDiam + field * indent;
            int i = field;
            int x = (activePanel.getWidth() / 2) - d / 2,
                    y = (activePanel.getHeight() / 2) - d / 2;

            for (boolean b = true; i >= 0; b = !b, i--) {
                g.setColor(b ? Color.green : Color.blue);
                g.fillOval(x, y, d, d);
                d -= indent;
                x += indent / 2;
                y += indent / 2;
            }
        });
        btnDraw.setBounds(10, 295, 96, 21);
        controlsPanel.add(btnDraw);

    }
}
