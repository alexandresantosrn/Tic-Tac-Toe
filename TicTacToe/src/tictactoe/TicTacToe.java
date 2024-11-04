package tictactoe;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe {

    private String player1 = "";
    private String player2 = "";
    private final String[][] board = new String[3][3];
    private String nextPlay = "";

    public TicTacToe() {
        choosePlayer();
        initBoard();
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

    private void initBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = "Z";
            }
        }
    }

    public void initJFrame() {

        // Creating the main frame: Title and dimensions.
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setSize(800, 550);
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
        splitPane.setBounds(0, 80, 800, 385);

        // Creating the end panel: Color, dimensions and border.
        JPanel endPanel = new JPanel();
        endPanel.setBackground(Color.PINK);
        endPanel.setBorder(whiteBorder);
        endPanel.setBounds(0, 463, 800, 50);

        // Creating the end Label: Font, size and color.
        String text = "[\"" + getPlayer1() + "\"] starts the game!";
        JLabel endLabel = new JLabel(text);
        endLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,30 ));
        endLabel.setForeground(Color.BLACK);

        // Inserting end label into end panel.
        endPanel.add(endLabel);

        // Creating Fonts for JButtons.
        Font buttonFont = new Font("Comic Sans MS", Font.BOLD, 100);

        // Creating buttons.
        JButton btnOne = new JButton();
        btnOne.setPreferredSize(new Dimension(120, 120));
        btnOne.setFont(buttonFont);
        JButton btnTwo = new JButton();
        btnTwo.setPreferredSize(new Dimension(120, 120));
        btnTwo.setFont(buttonFont);
        JButton btnThree = new JButton();
        btnThree.setPreferredSize(new Dimension(120, 120));
        btnThree.setFont(buttonFont);
        JButton btnFour = new JButton();
        btnFour.setPreferredSize(new Dimension(120, 120));
        btnFour.setFont(buttonFont);
        JButton btnFive = new JButton();
        btnFive.setPreferredSize(new Dimension(120, 120));
        btnFive.setFont(buttonFont);
        JButton btnSix = new JButton();
        btnSix.setPreferredSize(new Dimension(120, 120));
        btnSix.setFont(buttonFont);
        JButton btnSeven = new JButton();
        btnSeven.setPreferredSize(new Dimension(120, 120));
        btnSeven.setFont(buttonFont);
        JButton btnEight = new JButton();
        btnEight.setPreferredSize(new Dimension(120, 120));
        btnEight.setFont(buttonFont);
        JButton btnNine = new JButton();
        btnNine.setPreferredSize(new Dimension(120, 120));
        btnNine.setFont(buttonFont);

        // Inserting buttons into left panel.
        leftPanel.add(btnOne);
        leftPanel.add(btnTwo);
        leftPanel.add(btnThree);
        leftPanel.add(btnFour);
        leftPanel.add(btnFive);
        leftPanel.add(btnSix);
        leftPanel.add(btnSeven);
        leftPanel.add(btnEight);
        leftPanel.add(btnNine);

        // Button one action
        btnOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if (btnOne.getText().isEmpty()) {
                   if (nextPlay.isEmpty()) {
                       btnOne.setText(getPlayer1());
                       board[0][0] = getPlayer1();

                       setNextPlay(getPlayer2());
                       endLabel.setText("It's [\""+ getPlayer2() + "\"] turn!");
                   } else {
                       btnOne.setText(nextPlay);
                       board[0][0] = nextPlay;

                       // Updating the variable nextPlay
                       if (getNextPlay().equals("O")) {
                           setNextPlay("X");
                       } else {
                           setNextPlay("O");
                       }

                       // Showing the player's turn.
                       endLabel.setText("It's [\""+ getNextPlay() + "\"] turn!");
                   }

                   if (checkWinner(btnOne.getText())) {
                        endLabel.setText("[" + btnOne.getText() + "] won the game.");
                   }
               }
            }
        });

        // Button two action
        btnTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnTwo.getText().isEmpty()) {
                    if (nextPlay.isEmpty()) {
                        btnTwo.setText(getPlayer1());
                        board[0][1] = getPlayer1();

                        setNextPlay(getPlayer2());
                        endLabel.setText("It's [\""+ getPlayer2() + "\"] turn!");
                    } else {
                        btnTwo.setText(nextPlay);
                        board[0][1] = nextPlay;

                        // Updating the variable nextPlay
                        if (getNextPlay().equals("O")) {
                            setNextPlay("X");
                        } else {
                            setNextPlay("O");
                        }

                        // Showing the player's turn.
                        endLabel.setText("It's [\""+ getNextPlay() + "\"] turn!");
                    }

                    if (checkWinner(btnTwo.getText())) {
                        endLabel.setText("[" + btnTwo.getText() + "] won the game.");
                    }
                }
            }
        });

        // Button three action
        btnThree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnThree.getText().isEmpty()) {
                    if (nextPlay.isEmpty()) {
                        btnThree.setText(getPlayer1());
                        board[0][2] = getPlayer1();

                        setNextPlay(getPlayer2());
                        endLabel.setText("It's [\""+ getPlayer2() + "\"] turn!");
                    } else {
                        btnThree.setText(nextPlay);
                        board[0][2] = nextPlay;

                        // Updating the variable nextPlay
                        if (getNextPlay().equals("O")) {
                            setNextPlay("X");
                        } else {
                            setNextPlay("O");
                        }

                        // Showing the player's turn.
                        endLabel.setText("It's [\""+ getNextPlay() + "\"] turn!");
                    }

                    if (checkWinner(btnThree.getText())) {
                        endLabel.setText("[" + btnThree.getText() + "] won the game.");
                    }
                }
            }
        });

        // Button four action
        btnFour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnFour.getText().isEmpty()) {
                    if (nextPlay.isEmpty()) {
                        btnFour.setText(getPlayer1());
                        board[1][0] = getPlayer1();

                        setNextPlay(getPlayer2());
                        endLabel.setText("It's [\""+ getPlayer2() + "\"] turn!");
                    } else {
                        btnFour.setText(nextPlay);
                        board[1][0] = nextPlay;

                        // Updating the variable nextPlay
                        if (getNextPlay().equals("O")) {
                            setNextPlay("X");
                        } else {
                            setNextPlay("O");
                        }

                        // Showing the player's turn.
                        endLabel.setText("It's [\""+ getNextPlay() + "\"] turn!");
                    }

                    if (checkWinner(btnFour.getText())) {
                        endLabel.setText("[" + btnFour.getText() + "] won the game.");
                    }
                }
            }
        });

        // Button five action
        btnFive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnFive.getText().isEmpty()) {
                    if (nextPlay.isEmpty()) {
                        btnFive.setText(getPlayer1());
                        board[1][1] = getPlayer1();

                        setNextPlay(getPlayer2());
                        endLabel.setText("It's [\""+ getPlayer2() + "\"] turn!");
                    } else {
                        btnFive.setText(nextPlay);
                        board[1][1] = nextPlay;

                        // Updating the variable nextPlay
                        if (getNextPlay().equals("O")) {
                            setNextPlay("X");
                        } else {
                            setNextPlay("O");
                        }

                        // Showing the player's turn.
                        endLabel.setText("It's [\""+ getNextPlay() + "\"] turn!");
                    }

                    if (checkWinner(btnFive.getText())) {
                        endLabel.setText("[\"" + btnFive.getText() + "\"] won the game.");
                    }
                }
            }
        });

        // Button six action
        btnSix.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnSix.getText().isEmpty()) {
                    if (nextPlay.isEmpty()) {
                        btnSix.setText(getPlayer1());
                        board[1][2] = getPlayer1();

                        setNextPlay(getPlayer2());
                        endLabel.setText("It's [\""+ getPlayer2() + "\"] turn!");
                    } else {
                        btnSix.setText(nextPlay);
                        board[1][2] = nextPlay;

                        // Updating the variable nextPlay
                        if (getNextPlay().equals("O")) {
                            setNextPlay("X");
                        } else {
                            setNextPlay("O");
                        }

                        // Showing the player's turn.
                        endLabel.setText("It's [\""+ getNextPlay() + "\"] turn!");
                    }

                    if (checkWinner(btnSix.getText())) {
                        endLabel.setText("[" + btnSix.getText() + "] won the game.");
                    }
                }
            }
        });

        // Button seven action
        btnSeven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnSeven.getText().isEmpty()) {
                    if (nextPlay.isEmpty()) {
                        btnSeven.setText(getPlayer1());
                        board[2][0] = getPlayer1();

                        setNextPlay(getPlayer2());
                        endLabel.setText("It's [\""+ getPlayer2() + "\"] turn!");
                    } else {
                        btnSeven.setText(nextPlay);
                        board[2][0] = nextPlay;

                        // Updating the variable nextPlay
                        if (getNextPlay().equals("O")) {
                            setNextPlay("X");
                        } else {
                            setNextPlay("O");
                        }

                        // Showing the player's turn.
                        endLabel.setText("It's [\""+ getNextPlay() + "\"] turn!");
                    }

                    if (checkWinner(btnSeven.getText())) {
                        endLabel.setText("[" + btnSeven.getText() + "] won the game.");
                    }
                }
            }
        });

        // Button eight action
        btnEight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnEight.getText().isEmpty()) {
                    if (nextPlay.isEmpty()) {
                        btnEight.setText(getPlayer1());
                        board[2][1] = getPlayer1();

                        setNextPlay(getPlayer2());
                        endLabel.setText("It's [\""+ getPlayer2() + "\"] turn!");
                    } else {
                        btnEight.setText(nextPlay);
                        board[2][1] = nextPlay;

                        // Updating the variable nextPlay
                        if (getNextPlay().equals("O")) {
                            setNextPlay("X");
                        } else {
                            setNextPlay("O");
                        }

                        // Showing the player's turn.
                        endLabel.setText("It's [\""+ getNextPlay() + "\"] turn!");
                    }

                    if (checkWinner(btnEight.getText())) {
                        endLabel.setText("[" + btnEight.getText() + "] won the game.");
                    }
                }
            }
        });

        // Button nine action
        btnNine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnNine.getText().isEmpty()) {
                    if (nextPlay.isEmpty()) {
                        btnNine.setText(getPlayer1());
                        board[2][2] = getPlayer1();

                        setNextPlay(getPlayer2());
                        endLabel.setText("It's [\""+ getPlayer2() + "\"] turn!");
                    } else {
                        btnNine.setText(nextPlay);
                        board[2][2] = nextPlay;

                        // Updating the variable nextPlay
                        if (getNextPlay().equals("O")) {
                            setNextPlay("X");
                        } else {
                            setNextPlay("O");
                        }

                        // Showing the player's turn.
                        endLabel.setText("It's [\""+ getNextPlay() + "\"] turn!");
                    }

                    if (checkWinner(btnNine.getText())) {
                        endLabel.setText("[" + btnNine.getText() + "] won the game.");
                    }
                }
            }
        });

        // Inserting the panels into frame.
        frame.add(mainPanel);
        frame.add(endPanel);

        // Inserting the JSplitPane into frame.
        frame.add(splitPane);

        // Turning visible
        frame.setVisible(true);
    }

    private boolean checkWinner(String text) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                // Checking diagonals
                if (i == j) {
                    if (board[0][0].equals(text) && board[1][1].equals(text) && board[2][2].equals(text)) {

                        return true;
                    }
                }

                if (board[0][2].equals(text) && board[1][1].equals(text) && board[2][0].equals(text)) {

                    return true;
                }

                // Checking columns
                if (board[0][j].equals(text) && board[1][j].equals(text) && board[2][j].equals(text)) {

                    return true;
                }

                // Checking lines
                if (board[i][0].equals(text) && board[i][1].equals(text) && board[i][2].equals(text)) {

                    return true;
                }

            }
        }

        return false;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getNextPlay() {
        return nextPlay;
    }

    public void setNextPlay(String nextPlay) {
        this.nextPlay = nextPlay;
    }

}
