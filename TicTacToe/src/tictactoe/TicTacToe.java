package tictactoe;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Random;

public class TicTacToe {

    private String player1 = "";
    private String player2 = "";
    private final int[][] board = new int[3][3];

    public TicTacToe() {
        choosePlayer();
        initJFrame();
    }

    private void choosePlayer() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(9);

        if (randomNumber % 2 == 0){
            setPlayer1("O");
            setPlayer2("X");

        } else {
            setPlayer1("X");
            setPlayer2("O");
        }
    }

    public void initJFrame() {
        // Creating the main frame: Title and dimensions.
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Creating the border.
        Border whiteBorder = BorderFactory.createLineBorder(Color.WHITE);

        // Creating the main panel: Color, dimensions and border.
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.PINK);
        mainPanel.setBorder(whiteBorder);
        mainPanel.setBounds(0, 0, 800, 80);

        // Creating the main label: Font, size and color.
        JLabel mainLabel = new JLabel("TIC TAC TOE GAME");
        mainLabel.setFont(new Font("Comic Sans MS", Font.BOLD,60 ));
        mainLabel.setForeground(Color.WHITE);

        // Inserting the main label into main panel;
        mainPanel.add(mainLabel);

        // Creating the left panel: Color, dimensions and border.
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.PINK);
        leftPanel.setBorder(whiteBorder);

        // Creating the right panel: Color, dimensions and border.
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.PINK);
        rightPanel.setBorder(whiteBorder);

        // Creating JSplitPane
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setDividerLocation(400);
        splitPane.setBounds(0, 80, 800, 450);

        // Creating the end panel: Color, dimensions and border.
        JPanel endPanel = new JPanel();
        endPanel.setBackground(Color.PINK);
        endPanel.setBorder(whiteBorder);
        endPanel.setBounds(0, 522, 800, 40);

        // Creating the end Label: Font, size and color.
        String text = "[\"" + getPlayer1() + "\"] starts the game!";
        JLabel endLabel = new JLabel(text);
        endLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,25 ));
        endLabel.setForeground(Color.BLACK);

        // Inserting end label into end panel;
        endPanel.add(endLabel);

        // Inserting the panels into frame.
        frame.add(mainPanel);
        frame.add(endPanel);

        // Inserting the JSplitPane into frame.
        frame.add(splitPane);

        // Turning visible
        frame.setVisible(true);
    }

    public String getPlayer1() { return player1; }

    public void setPlayer1(String player1) { this.player1 = player1; }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }
}
