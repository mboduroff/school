package tictactoe;

import java.awt.*;

import javax.swing.*;


public class TicTacToe extends JPanel {
    Icon imgCross;
    Icon imgNought;
    char player = 'x';
    JButton[] buttons = new JButton[9];

    public TicTacToe() {
        imgCross = new ImageIcon(getClass().getResource("/images/cross.gif"));
        imgNought = new ImageIcon(getClass().getResource("/images/nought.gif"));

        setLayout(new GridLayout(3,3));
        initButtons();
    }

    public void initButtons() {
        for (int i = 0; i <= 8; i++) {
            buttons[i] = new JButton();
            buttons[i].setBackground(Color.white);
            buttons[i].addActionListener(e -> {
                JButton buttonClicked = (JButton) e.getSource();

                if(player == 'x') {
                    player = 'o';
                } else {
                    player ='x';
                }
                buttonClicked.setIcon((player == ('x') ? imgNought : imgCross));
                showWinner();
            });
            add(buttons[i]);
        }
    }


    public void showWinner() {
        if (checkForWinner()) {
            if (player == 'x')
                player = 'o';
            else player = 'x';

            JOptionPane pane = new JOptionPane();
            int dialogResult = JOptionPane.showConfirmDialog(pane,
                    player + " wins. Would you like to play again?","Game over.",
                    JOptionPane.YES_NO_OPTION);

            if (dialogResult == JOptionPane.YES_OPTION)
                resetTheButtons();
            else System.exit(0);
        }

        else if(checkDraw()) {
            JOptionPane pane = new JOptionPane();
            int dialogResult = JOptionPane.showConfirmDialog(pane,
                    "Draw. Play again?","Game over.", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION)
                resetTheButtons();
            else System.exit(0);
        }
    }


    private void resetTheButtons() {
        player = 'x';
        for (int i = 0; i < 9; i++) {
            buttons[i].setText("");
            buttons[i].setBackground(Color.white);
        }
    }

    public boolean checkDraw() {
        boolean full = true;
        for(int i = 0; i < 9; i++) {
            if(buttons[i].getIcon() != null) {
                full = false;
            }
        }
        return full;
    }

    public boolean checkForWinner() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    public boolean checkRows() {
        int i = 0;
        for (int j = 0;j<3;j++) {
            if (buttons[i].getIcon() == buttons[i+1].getIcon()
                    && buttons[i].getIcon() == buttons[i+2].getIcon()
                    && buttons[i].getIcon() != null) {
                return true;
            }

            i = i+3;

        }
        return false;
    }

    public boolean checkColumns() {
        int i = 0;
        for (int j = 0; j < 3; j++) {
            if (buttons[i].getIcon() == buttons[i+3].getIcon()
                    && buttons[i].getIcon() == buttons[i+6].getIcon()
                    && buttons[i].getIcon() != null) {
                return true;
            }
            i++;
        }
        return false;
    }

    public boolean checkDiagonals() {
        if (buttons[0].getIcon() == buttons[4].getIcon()
                && buttons[0].getIcon() == buttons[8].getIcon()
                && buttons[0].getIcon() != null)
            return true;

        else return buttons[2].getIcon() == buttons[4].getIcon()
                && buttons[2].getIcon() == buttons[6].getIcon()
                && buttons[2].getIcon() != null;
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Tic Tac Toe");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new TicTacToe());
        window.setBounds(500,500,500,500);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
    }

}