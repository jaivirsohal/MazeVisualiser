package mazeproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MazePlayer {

    //attributes
    private final int x;
    private final int y;
    private int[][] maze;
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel sidePanel;
    private JPanel timerPanel;
    private JPanel returnPanel;
    private JLabel[][] labels;
    private JLabel timerLabel;
    private final MazeGenerator mazeGenerator;
    private final PanelFunctions panelFunctions;
    private final StandardFunctions standardFunctions;
    private int[] currentCell;
    private int timerValue;
    private final Color green;
    private final Color grey;
    private Timer timer;
    private String username;
    private String fileName;
    private KeyAdapter keyAdapter;

    //constructor
    public MazePlayer(int x, int y, String username) {
        //assign values to attributes
        this.x = x;
        this.y = y;
        this.maze = new int[this.x + 1][this.y + 1];
        this.timerValue = -300;
        this.fileName = "src/mazeproject/textfiles/scores.txt";
        this.username = username;

        //get instances of other classes
        this.mazeGenerator = new MazeGenerator(this.x, this.y, 1);
        this.panelFunctions = new PanelFunctions();
        this.standardFunctions = new StandardFunctions();

        //set colours
        this.grey = new Color(41, 41, 41);
        this.green = new Color(75, 102, 75);

        //set current player square
        this.currentCell = new int[]{1, 1};

        //intialise panel and info tab
        initialisePanel(this.x + 1, this.y + 1);
    }

    //initialise panel
    private void initialisePanel(int x, int y) {
        //initialise frame
        this.frame = new JFrame("Maze");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLayout(new BorderLayout());
        this.frame.setSize(825, 1000);
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);
        this.frame.setUndecorated(true);
        //create a new JPanel for labels
        this.mainPanel = new JPanel();
        //grid layout (to view maze grid)
        this.mainPanel.setLayout(new GridLayout(x, y));
        //create labels for grid
        this.labels = new JLabel[x][y];

        //loop through maze
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                //create and format labels for cells
                this.labels[i][j] = new JLabel();
                this.labels[i][j].setOpaque(true);
                this.mainPanel.add(this.labels[i][j]);
            }
        }

        //generate the maze
        generateMaze();

        //mark square current
        this.maze[1][1] = 5;
        this.panelFunctions.updatePanel(maze, 1, labels);

        //update current cell
        //add key listeners - test with output
        keyAdapter = (new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int i;
                int j;

                //check if player has reached the final square
                if (currentCell[0] != x - 2 || currentCell[1] != y - 2) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_UP:
                            //move player up
                            //get current cell co-ordinates
                            i = currentCell[0];
                            j = currentCell[1];
                            if (maze[i - 1][j] != 1) {
                                //mark previous square visited - ecen
                                maze[i][j] += 17;
                                //mark square current - odd
                                maze[i - 1][j] += 3;
                                //adding 1 to the num of times traversed
                                panelFunctions.updatePath(maze, 1, labels);
                                //update current cell
                                currentCell = new int[]{i - 1, j};
                            }
                            break;
                        case KeyEvent.VK_DOWN:
                            //move player down
                            //get current cell co-ordinates
                            i = currentCell[0];
                            j = currentCell[1];
                            if (maze[i + 1][j] != 1) {
                                //mark previous square visited - ecen
                                maze[i][j] += 17;
                                //mark square current - odd
                                maze[i + 1][j] += 3;
                                panelFunctions.updatePath(maze, 1, labels);
                                //update current cell
                                currentCell = new int[]{i + 1, j};
                            }
                            break;
                        case KeyEvent.VK_LEFT:
                            //move player left
                            //get current cell co-ordinates
                            i = currentCell[0];
                            j = currentCell[1];
                            if (maze[i][j - 1] != 1) {
                                //mark previous square visited - ecen
                                maze[i][j] += 17;
                                //mark square current - odd
                                maze[i][j - 1] += 3;
                                panelFunctions.updatePath(maze, 1, labels);
                                //update current cell
                                currentCell = new int[]{i, j - 1};
                            }
                            break;
                        case KeyEvent.VK_RIGHT:
                            //move player right
                            //get current cell co-ordinates
                            i = currentCell[0];
                            j = currentCell[1];
                            if (maze[i][j + 1] != 1) {
                                //mark previous square visited - ecen
                                maze[i][j] += 17;
                                //mark square current - odd
                                maze[i][j + 1] += 3;
                                panelFunctions.updatePath(maze, 1, labels);
                                //update current cell
                                currentCell = new int[]{i, j + 1};
                            }
                            break;
                    }
                }
                //perform end check each time
                if (currentCell[0] == x - 2 && currentCell[1] == y - 2) {
                    //stop timer - store the formatted value
                    timer.stop();
                    //6000 centiseconds in a minute
                    int minutes = timerValue / 6000;
                    int remainder = timerValue % 6000;
                    //100 centiseconds in a second
                    int seconds = remainder / 100;
                    int centiseconds = remainder % 100;

                    //update time on the screen - get maze type
                    String time = String.format("%02d:%02d:%02d",
                            minutes, seconds, centiseconds);
                    String xType = String.valueOf(x - 1);
                    String type = xType + "x" + xType;
                    String output = username + "," + time + "," + type;
                    //remove key listeners
                    frame.removeKeyListener(this);

                    try {
                        //write to file
                        standardFunctions.writeToFile(output, fileName);
                    } catch (IOException ex) {
                        Logger.getLogger(MazePlayer.class.getName()).log(
                                Level.SEVERE, null, ex);
                    }
                    //open up the win menu
                    frame.dispose();
                    FrmWinMenu winMenu = new FrmWinMenu(time, type, username);
                }
            }
        });
        this.frame.addKeyListener(keyAdapter);
        this.frame.addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                frame.requestFocusInWindow();
            }
        });

        //add timer action listner:
        this.timer = new Timer(1, null);
        this.timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //increment timer
                timerValue++;
                //account for delay
                if (timerValue >= 0) {
                    //add key listener once
                    if (timerValue == 0) {
                        frame.addKeyListener(keyAdapter);
                    }
                    //6000 centiseconds in a minute
                    int minutes = timerValue / 6000;
                    int remainder = timerValue % 6000;
                    //100 centiseconds in a second
                    int seconds = remainder / 100;
                    int centiseconds = remainder % 100;

                    //update time on the screen
                    String time = String.format("Time - %02d:%02d:%02d",
                            minutes, seconds, centiseconds);
                    timerLabel.setText(time);
                } else {
                    frame.removeKeyListener(keyAdapter);
                    //count down to 0
                    timerLabel.setText("Start in - "
                            + String.valueOf(((0 - timerValue) / 100) + 1));
                }

            }
        });

        //new game button
        JButton newGameButton = new JButton("New Game");
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //close menu and open player
                frame.dispose();
                timer.stop();
                FrmNewGame newGame = new FrmNewGame(username);
            }
        });

        //close button
        JButton closeButton = new JButton("Close Program");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //close entire program
                System.exit(0);
            }
        });

        //return button
        JButton returnButton = new JButton("Return To Menu");
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //return to menu subroutine
                returnToMenu();
            }
        });

        //creating a new timer label
        this.timerLabel = new JLabel();
        this.timerLabel.setText(String.valueOf(this.timerValue));
        this.panelFunctions.setLabelLayout(this.timerLabel);

        //grid panel for the generate button
        this.returnPanel = new JPanel(new GridLayout(1, 3));
        this.panelFunctions.setPanelBorder(this.returnPanel, "Options");
        this.returnPanel.add(newGameButton);
        this.returnPanel.add(returnButton);
        this.returnPanel.add(closeButton);

        //add panels together through box layout
        this.sidePanel = new JPanel();
        this.sidePanel.setLayout(new BoxLayout(this.sidePanel,
                BoxLayout.X_AXIS));
        this.sidePanel.add(returnPanel);
        this.sidePanel.add(Box.createVerticalGlue());
        //update the panel intially
        this.panelFunctions.updatePanel(this.maze, 1, labels);

        //create timer panel
        //add panels together through box layout
        this.timerPanel = new JPanel();
        this.timerPanel.setLayout(new BoxLayout(this.timerPanel,
                BoxLayout.X_AXIS));
        this.panelFunctions.setPanelBorder(this.timerPanel,
                "Solve Time");
        this.timerPanel.add(Box.createVerticalStrut(10));
        this.timerPanel.add(Box.createHorizontalStrut(50));
        this.timerPanel.add(timerLabel);
        this.timerPanel.add(Box.createHorizontalGlue());

        //set panel colours
        this.mainPanel.setBackground(new Color(43, 43, 43));
        this.sidePanel.setBackground(new Color(43, 43, 43));
        this.returnPanel.setBackground(new Color(43, 43, 43));
        this.timerPanel.setBackground(new Color(43, 43, 43));

        //set button layouts
        this.panelFunctions.changeLayout(returnButton, grey);
        this.panelFunctions.changeLayout(closeButton, new Color(128, 0,
                0));
        this.panelFunctions.changeLayout(newGameButton, green);

        //set sizes
        this.mainPanel.setPreferredSize(new Dimension(825, 875));
        this.timerPanel.setPreferredSize(new Dimension(850, 75));
        this.sidePanel.setPreferredSize(new Dimension(850, 75));

        //add panels to the frame - set layout
        this.frame.add(this.sidePanel, BorderLayout.SOUTH);
        this.frame.add(this.timerPanel, BorderLayout.NORTH);
        this.frame.add(this.mainPanel, BorderLayout.EAST);
        this.frame.setVisible(true);

        //start the delay and timer 
        this.timer.start();

    }

    private void generateMaze() {
        //create a maze
        this.mazeGenerator.generateMaze(this.labels);
        this.maze = this.mazeGenerator.getMaze();
        //mark endpoint
        this.maze[this.x - 1][this.y - 1] = -2;
        this.panelFunctions.updatePath(this.maze, 1,
                this.labels);
    }

    private void returnToMenu() {
        //close all processes and return to main menu
        FrmMainMenu menu = new FrmMainMenu(this.username);
        menu.setVisible(true);
        this.frame.dispose();
        this.timer.stop();
    }

    private void timeDelay() {

    }
}
