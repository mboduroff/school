package trafficlights;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;

public class TrafficLights extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                TrafficLights frame = new TrafficLights();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public TrafficLights() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 556, 454);
        setTitle("Traffic Lights");
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel trafficLightGifLabel = new JLabel("");
        trafficLightGifLabel.setHorizontalAlignment(SwingConstants.CENTER);
        trafficLightGifLabel.setIcon(new ImageIcon("\\trafficlight.gif"));
        trafficLightGifLabel.setBounds(0, 10, 542, 407);
        contentPane.add(trafficLightGifLabel);

    }
}
