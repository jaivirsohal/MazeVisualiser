package mazeproject;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelFunctions {

    public void updatePanel(int[][] maze, int time, JLabel[][] labels) {
        //add a delay
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
        //loop through maze
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                //assign colours to squares
                //clear path
                switch (maze[i][j]) {
                    case 0:
                        labels[i][j].setBackground(Color.WHITE);
                        //wall
                        break;
                    case 1:
                        labels[i][j].setBackground(Color.BLACK);
                        //searched path
                        break;
                    case 2:
                        labels[i][j].setBackground(new Color(0, 128, 0));
                        //junction colour
                        break;
                    case 3:
                        labels[i][j].setBackground(Color.CYAN);
                        //end square
                        break;
                    case 4:
                        labels[i][j].setBackground(Color.RED);
                        //backtracker colour
                        break;
                    case 5:
                        labels[i][j].setBackground(new Color(128, 0, 0));
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void updatePath(int[][] maze, int time, JLabel[][] labels) {
        //add a delay
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
        //loop through maze
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                //assign colours to squares
                //clear path
                int current = maze[i][j];
                if (current == 0) {
                    //path
                    labels[i][j].setBackground(Color.WHITE);
                } else if (current == 1) {
                    //wall
                    labels[i][j].setBackground(Color.BLACK);
                } else if (current == -2) {
                    //final square
                    labels[i][j].setBackground(Color.RED);
                } else if (current % 2 == 1) {
                    //current square
                    labels[i][j].setBackground(new Color(128, 0, 0));
                } else if ((200 - current) > 0) {
                    //explored path - add a darkening filter if greater than 0
                    labels[i][j].setBackground(new Color(200 - current, 255,
                            200 - current));
                }else{
                    //darkest color
                    labels[i][j].setBackground(new Color(0, 255, 0));
                }
            }
        }
    }

    public void changeLayout(JButton btn, Color col) {
        //change layout of button
        btn.setBackground(col);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Courier New", Font.BOLD, 20));
    }

    public void setPanelBorder(JPanel pnl, String text) {
        //set panel border
        TitledBorder border = BorderFactory.createTitledBorder(text);
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitleColor(Color.WHITE);
        border.setTitleFont(new Font("Courier New", Font.BOLD, 12));
        pnl.setBorder(border);
    }

    public void setLabelLayout(JLabel lbl) {
        //set layout of the label
        Font font = new Font("Courier New", Font.BOLD, 50);
        lbl.setForeground(Color.WHITE);
        lbl.setFont(font);
    }
}
