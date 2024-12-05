package mazeproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class MazeVisualiser {

    //attributes
    private final int x;
    private final int y;
    private int[][] maze;
    private int genTime;
    private int solveTime;
    private int frameSize;
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel sidePanel;
    private JPanel infoPanel;
    private JPanel genPanel;
    private JPanel solvePanel;
    private JPanel genTimePanel;
    private JPanel solveTimePanel;
    private JPanel returnPanel;
    private JLabel[][] labels;
    private JButton solveTimeSlowButton;
    private JButton solveTimeMediumButton;
    private JButton solveTimeFastButton;
    private JButton genTimeSlowButton;
    private JButton genTimeMediumButton;
    private JButton genTimeFastButton;
    private final MazeGenerator mazeGenerator;
    private PanelFunctions panelFunctions;
    private Pathfinder pathfinder;
    private FrmVisualiserInfo info;
    private int[][] solveMaze;
    private int[] endPoint;
    private boolean alreadyClicked;
    private Color red;
    private Color green;
    private Color blue;
    private Color grey;
    private String username;

    //constructor
    public MazeVisualiser(int x, int y, String username) {
        //assign values to attributes
        this.x = x;
        this.y = y;
        this.maze = new int[this.x + 1][this.y + 1];
        this.frameSize = 1000;
        //set times
        this.genTime = 1;
        this.solveTime = 5;
        this.username = username;
        //get instances of other classes
        this.mazeGenerator = new MazeGenerator(this.x, this.y, this.genTime);
        this.panelFunctions = new PanelFunctions();
        //create the pathfinder
        this.pathfinder = new Pathfinder(this.labels,
                this.solveTime);

        //set colours
        this.grey = new Color(41, 41, 41);
        this.red = new Color(102, 75, 75);
        this.green = new Color(75, 102, 75);
        this.blue = new Color(75, 75, 102);

        //intialise panel and info tab
        this.info = new FrmVisualiserInfo();
        initialisePanel(this.x + 1, this.y + 1);
        updateGenerator();
        updatePathfinder();
    }

    //initialise panel
    private void initialisePanel(int x, int y) {
        //initialise frame
        this.frame = new JFrame("Maze");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLayout(new BorderLayout());
        this.frame.setSize(this.frameSize + 50, this.frameSize - 50);
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
                //fill maze with walls to reduce start delay
                this.maze[i][j] = 1;
                //create and format labels for cells
                this.labels[i][j] = new JLabel();
                this.labels[i][j].setOpaque(true);
                this.mainPanel.add(this.labels[i][j]);
            }
        }

        //add buttons
        //create a JButton for maze generation and add an ActionListener to it
        JButton generateButton = new JButton("Generate Maze");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //disable other panels and all components
                solvePanel.setEnabled(false);
                solveTimePanel.setEnabled(false);
                genPanel.setEnabled(false);
                for (Component component : solvePanel.getComponents()) {
                    component.setEnabled(false);
                }
                for (Component component : solveTimePanel.getComponents()) {
                    component.setEnabled(false);
                }
                for (Component component : genPanel.getComponents()) {
                    component.setEnabled(false);
                }

                //create and execute a SwingWorker when the button is clicked
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        generateMaze();
                        return null;
                    }

                    @Override
                    protected void done() {
                        //enable all components when done
                        solvePanel.setEnabled(true);
                        solveTimePanel.setEnabled(true);
                        genPanel.setEnabled(true);
                        for (Component component : solvePanel.getComponents()) {
                            component.setEnabled(true);
                        }
                        for (Component component : solveTimePanel.
                                getComponents()) {
                            component.setEnabled(true);
                        }
                        for (Component component : genPanel.getComponents()) {
                            component.setEnabled(true);
                        }
                    }
                };
                //start worker
                worker.execute();
            }
        });

        //depth first search button
        JButton dfsButton = new JButton("Depth");
        dfsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //disable other panels and all components
                solvePanel.setEnabled(false);
                genTimePanel.setEnabled(false);
                genPanel.setEnabled(false);
                for (Component component : solvePanel.getComponents()) {
                    component.setEnabled(false);
                }
                for (Component component : genTimePanel.getComponents()) {
                    component.setEnabled(false);
                }
                for (Component component : genPanel.getComponents()) {
                    component.setEnabled(false);
                }
                //create and execute a SwingWorker when the button is clicked
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        solveMaze = pathfinder.deepCopy(maze);
                        pathfinder.solveDFS(solveMaze, 1, 1,
                                endPoint[0], endPoint[1]);
                        return null;
                    }

                    @Override
                    protected void done() {
                        //enable all components when done
                        solvePanel.setEnabled(true);
                        genTimePanel.setEnabled(true);
                        genPanel.setEnabled(true);
                        for (Component component : solvePanel.getComponents()) {
                            component.setEnabled(true);
                        }
                        for (Component component : genTimePanel.
                                getComponents()) {
                            component.setEnabled(true);
                        }
                        for (Component component : genPanel.getComponents()) {
                            component.setEnabled(true);
                        }
                    }
                };
                //start worker
                worker.execute();
            }
        });

        //depth first search button
        JButton bfsButton = new JButton("Breadth");
        bfsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //disable other panels and all components
                solvePanel.setEnabled(false);
                genTimePanel.setEnabled(false);
                genPanel.setEnabled(false);
                for (Component component : solvePanel.getComponents()) {
                    component.setEnabled(false);
                }
                for (Component component : genTimePanel.getComponents()) {
                    component.setEnabled(false);
                }
                for (Component component : genPanel.getComponents()) {
                    component.setEnabled(false);
                }
                //create and execute a SwingWorker when the button is clicked
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        solveMaze = pathfinder.deepCopy(maze);
                        pathfinder.solveBFS(solveMaze, 1, 1,
                                endPoint[0], endPoint[1]);
                        return null;
                    }

                    @Override
                    protected void done() {
                        //enable all components when done
                        solvePanel.setEnabled(true);
                        genTimePanel.setEnabled(true);
                        genPanel.setEnabled(true);
                        for (Component component : solvePanel.getComponents()) {
                            component.setEnabled(true);
                        }
                        for (Component component : genTimePanel.
                                getComponents()) {
                            component.setEnabled(true);
                        }
                        for (Component component : genPanel.getComponents()) {
                            component.setEnabled(true);
                        }
                    }
                };
                //start worker
                worker.execute();
            }
        });

        //depth first search button
        JButton aStarButton = new JButton("A Star");
        aStarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //disable other panels and all components
                solvePanel.setEnabled(false);
                genTimePanel.setEnabled(false);
                genPanel.setEnabled(false);
                for (Component component : solvePanel.getComponents()) {
                    component.setEnabled(false);
                }
                for (Component component : genTimePanel.getComponents()) {
                    component.setEnabled(false);
                }
                for (Component component : genPanel.getComponents()) {
                    component.setEnabled(false);
                }
                //create and execute a SwingWorker when the button is clicked
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        solveMaze = pathfinder.deepCopy(maze);
                        pathfinder.solveAStar(solveMaze, 1, 1,
                                endPoint[0], endPoint[1]);
                        return null;
                    }

                    @Override
                    protected void done() {
                        //enable all components when done
                        solvePanel.setEnabled(true);
                        genTimePanel.setEnabled(true);
                        genPanel.setEnabled(true);
                        for (Component component : solvePanel.getComponents()) {
                            component.setEnabled(true);
                        }
                        for (Component component : genTimePanel.
                                getComponents()) {
                            component.setEnabled(true);
                        }
                        for (Component component : genPanel.getComponents()) {
                            component.setEnabled(true);
                        }
                    }
                };
                //start worker
                worker.execute();
            }
        });

        //create buttons for generating time
        this.genTimeSlowButton = new JButton("Slow");
        this.genTimeSlowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //change button colours
                genTimeSlowButton.setBackground(red);
                genTimeMediumButton.setBackground(grey);
                genTimeFastButton.setBackground(grey);
                //slow generation time
                genTime = 20;
                updateGenerator();
            }
        });

        this.genTimeMediumButton = new JButton("Medium");
        this.genTimeMediumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //change button colours
                genTimeSlowButton.setBackground(grey);
                genTimeMediumButton.setBackground(red);
                genTimeFastButton.setBackground(grey);
                //slow generation time
                genTime = 10;
                updateGenerator();
            }
        });

        this.genTimeFastButton = new JButton("Fast");
        this.genTimeFastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //change button colours
                genTimeSlowButton.setBackground(grey);
                genTimeMediumButton.setBackground(grey);
                genTimeFastButton.setBackground(red);
                //fast generation time
                genTime = 1;
                updateGenerator();
            }
        });

        //create buttons for solving time
        this.solveTimeSlowButton = new JButton("Slow");
        this.solveTimeSlowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //change button colours
                solveTimeSlowButton.setBackground(red);
                solveTimeMediumButton.setBackground(grey);
                solveTimeFastButton.setBackground(grey);
                //slow solve time
                solveTime = 25;
                updatePathfinder();
            }
        });

        this.solveTimeMediumButton = new JButton("Medium");
        this.solveTimeMediumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //change button colours
                solveTimeSlowButton.setBackground(grey);
                solveTimeMediumButton.setBackground(red);
                solveTimeFastButton.setBackground(grey);
                //medium solve time
                solveTime = 5;
                updatePathfinder();
            }
        });

        this.solveTimeFastButton = new JButton("Fast");
        this.solveTimeFastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //change button colours
                solveTimeSlowButton.setBackground(grey);
                solveTimeMediumButton.setBackground(grey);
                solveTimeFastButton.setBackground(red);
                //fast solve time
                solveTime = 1;
                updatePathfinder();
            }
        });

        //return button
        JButton returnButton = new JButton("Return To Menu");
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnToMenu();
            }
        });

        //information button
        JButton infoButton = new JButton("How to Use");
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //show info tab
                info.setVisible(true);
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

        //grid panel for the generation times - set layout
        this.genTimePanel = new JPanel(new GridLayout(3, 1));
        this.panelFunctions.setPanelBorder(this.genTimePanel, "Generation "
                + "Time");
        //add buttons to panel
        this.genTimePanel.add(genTimeSlowButton);
        this.genTimePanel.add(genTimeMediumButton);
        this.genTimePanel.add(genTimeFastButton);

        //grid panel for the solve times
        this.solveTimePanel = new JPanel(new GridLayout(3, 1));
        this.panelFunctions.setPanelBorder(this.solveTimePanel, "Solving "
                + "Time");
        //add buttons to panel
        this.solveTimePanel.add(solveTimeSlowButton);
        this.solveTimePanel.add(solveTimeMediumButton);
        this.solveTimePanel.add(solveTimeFastButton);

        //grid panel for the generate button
        this.genPanel = new JPanel(new GridLayout(1, 1));
        this.panelFunctions.setPanelBorder(this.genPanel, "Generation");
        this.genPanel.add(generateButton);

        //grid panel for the generate button
        this.returnPanel = new JPanel(new GridLayout(2, 1));
        this.panelFunctions.setPanelBorder(this.returnPanel, "Options");
        this.returnPanel.add(returnButton);
        this.returnPanel.add(closeButton);

        //grid panel for the information button
        this.infoPanel = new JPanel(new GridLayout(1, 1));
        this.panelFunctions.setPanelBorder(this.infoPanel, "Information"
        );
        this.infoPanel.add(infoButton);

        //grid panel for the pathfinder functions
        this.solvePanel = new JPanel(new GridLayout(3, 1));
        this.panelFunctions.setPanelBorder(this.solvePanel, "Pathfinders"
        );
        this.solvePanel.add(dfsButton);
        this.solvePanel.add(bfsButton);
        this.solvePanel.add(aStarButton);

        //add panels together through box layout
        this.sidePanel = new JPanel();
        this.sidePanel.setLayout(new BoxLayout(this.sidePanel,
                BoxLayout.Y_AXIS));
        this.sidePanel.add(Box.createVerticalStrut(35));
        this.sidePanel.add(infoPanel);
        this.sidePanel.add(Box.createVerticalStrut(30));
        this.sidePanel.add(genTimePanel);
        this.sidePanel.add(Box.createVerticalStrut(10));
        this.sidePanel.add(genPanel);
        this.sidePanel.add(Box.createVerticalStrut(10));
        this.sidePanel.add(solveTimePanel);
        this.sidePanel.add(Box.createVerticalStrut(10));
        this.sidePanel.add(solvePanel);
        this.sidePanel.add(Box.createVerticalStrut(30));
        this.sidePanel.add(returnPanel);
        this.sidePanel.add(Box.createVerticalStrut(10));
        this.sidePanel.add(Box.createVerticalGlue());
        //update the panel intially
        this.panelFunctions.updatePanel(this.maze, 1, labels);

        //set panel colours
        this.mainPanel.setBackground(new Color(43, 43, 43));
        this.sidePanel.setBackground(new Color(43, 43, 43));
        this.infoPanel.setBackground(new Color(43, 43, 43));
        this.genPanel.setBackground(new Color(43, 43, 43));
        this.genTimePanel.setBackground(new Color(43, 43, 43));
        this.solvePanel.setBackground(new Color(43, 43, 43));
        this.solveTimePanel.setBackground(new Color(43, 43, 43));
        this.returnPanel.setBackground(new Color(43, 43, 43));

        //set button layouts
        this.panelFunctions.changeLayout(infoButton, grey);
        this.panelFunctions.changeLayout(generateButton, green);
        this.panelFunctions.changeLayout(dfsButton, green);
        this.panelFunctions.changeLayout(bfsButton, green);
        this.panelFunctions.changeLayout(aStarButton, green);
        this.panelFunctions.changeLayout(solveTimeSlowButton, grey);
        this.panelFunctions.changeLayout(solveTimeMediumButton, red);
        this.panelFunctions.changeLayout(solveTimeFastButton, grey);
        this.panelFunctions.changeLayout(genTimeSlowButton, grey);
        this.panelFunctions.changeLayout(genTimeMediumButton, grey);
        this.panelFunctions.changeLayout(genTimeFastButton, red);
        this.panelFunctions.changeLayout(returnButton, grey);
        this.panelFunctions.changeLayout(closeButton, new Color(128, 0,
                0));

        //tooltips
        generateButton.setToolTipText("This button generates a Maze using "
                + "Prim's algorithm");
        dfsButton.setToolTipText("This button applies the depth-first search"
                + " algorithm to the maze");
        bfsButton.setToolTipText("This button applies the breadth-first "
                + "search algorithm to the maze");
        aStarButton.setToolTipText("This button applies the A* search "
                + "algorithm to the maze");
        returnButton.setToolTipText("This button allows you to return to the"
                + " main menu");
        //add panels to the frame - set layout
        this.frame.add(this.mainPanel, BorderLayout.CENTER);
        this.frame.add(this.sidePanel, BorderLayout.WEST);
        this.frame.setVisible(true);

        //disable solve panel - cannot pathfind on an empty maze
        this.solvePanel.setEnabled(false);
        for (Component component : solvePanel.getComponents()) {
            component.setEnabled(false);
        }
        solveTimePanel.setEnabled(false);
        for (Component component : solveTimePanel.getComponents()) {
            component.setEnabled(false);
        }
    }

    private void generateMaze() {
        //generate the original maze
        if (this.alreadyClicked) {
            this.panelFunctions.updatePanel(this.maze, 20,
                        this.labels);
            this.panelFunctions.updatePanel(this.maze, 200,
                        this.labels);
            //fill wall with walls
            for (int i = 0; i < this.x + 1; i++) {
                for (int j = 0; j < this.y + 1; j++) {
                    this.maze[i][j] = 1;
                }
                //dynamic speed change - adds a wiper effect to new maze
                this.panelFunctions.updatePanel(this.maze, 20,
                        this.labels);
            }
        } else {
            this.alreadyClicked = true;
        }
        //create a maze
        this.mazeGenerator.generateMaze(this.labels);
        this.maze = this.mazeGenerator.getMaze();
        //generate end point for this maze
        this.endPoint = this.pathfinder.genEnd(this.maze);
    }

    private void updatePathfinder() {
        //update all values
        this.pathfinder.setLabels(this.labels);
        this.pathfinder.setTime(this.solveTime);
    }

    private void updateGenerator() {
        //update all values
        this.mazeGenerator.setTime(this.genTime);
    }

    private void returnToMenu() {
        //close current frame and return to main menu
        FrmMainMenu menu = new FrmMainMenu(this.username);
        menu.setVisible(true);
        this.info.dispose();
        this.frame.dispose();
    }
}
