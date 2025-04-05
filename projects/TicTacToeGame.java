package projects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeGame extends JFrame implements ActionListener {

    private JButton[][] buttons = new JButton[3][3];
    private char currentPlayer = 'X';
    private boolean gameOver = false;

    public TicTacToeGame() {
        setTitle("Tic Tac Toe");
        setSize(400, 400);
        setLayout(new GridLayout(3, 3));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initializeButtons();

        setVisible(true);
    }

    private void initializeButtons() {
        Font font = new Font("Arial", Font.BOLD, 60);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(font);
                buttons[i][j].addActionListener(this);
                add(buttons[i][j]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver) return;

        JButton clicked = (JButton) e.getSource();

        if (!clicked.getText().equals("")) return;

        clicked.setText(String.valueOf(currentPlayer));

        if (checkForWin()) {
            JOptionPane.showMessageDialog(this, "Player " + currentPlayer + " wins!");
            gameOver = true;
            int option = JOptionPane.showConfirmDialog(this, "Play again?", "Game Over", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) resetGame();
            else System.exit(0);
            return;
        }

        if (checkForDraw()) {
            JOptionPane.showMessageDialog(this, "It's a draw!");
            gameOver = true;
            int option = JOptionPane.showConfirmDialog(this, "Play again?", "Game Over", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) resetGame();
            else System.exit(0);
            return;
        }

        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private boolean checkForWin() {
        // Rows and Columns
        for (int i = 0; i < 3; i++) {
            if (checkEqual(buttons[i][0], buttons[i][1], buttons[i][2])) return true;
            if (checkEqual(buttons[0][i], buttons[1][i], buttons[2][i])) return true;
        }

        // Diagonals
        if (checkEqual(buttons[0][0], buttons[1][1], buttons[2][2])) return true;
        if (checkEqual(buttons[0][2], buttons[1][1], buttons[2][0])) return true;

        return false;
    }

    private boolean checkEqual(JButton b1, JButton b2, JButton b3) {
        String t1 = b1.getText();
        String t2 = b2.getText();
        String t3 = b3.getText();

        return (!t1.equals("") && t1.equals(t2) && t2.equals(t3));
    }

    private boolean checkForDraw() {
        for (JButton[] row : buttons) {
            for (JButton b : row) {
                if (b.getText().equals("")) return false;
            }
        }
        return true;
    }

    private void resetGame() {
        for (JButton[] row : buttons) {
            for (JButton b : row) {
                b.setText("");
            }
        }
        currentPlayer = 'X';
        gameOver = false;
    }

    public static void main(String[] args) {
        new TicTacToeGame();
    }
}

