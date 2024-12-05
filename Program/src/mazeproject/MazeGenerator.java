package mazeproject;

import java.util.LinkedList;
import java.util.Random;
import javax.swing.JLabel;

public class MazeGenerator {

    //attributes - final
    private final int x;
    private final int y;
    private final int[][] maze;
    private final PanelFunctions panelFunctions;
    private int genTime;

    //constructor
    public MazeGenerator(int x, int y, int time) {
        //assign values to attributes
        this.x = x;
        this.y = y;
        this.maze = new int[this.x + 1][this.y + 1];
        this.genTime = genTime;
        this.panelFunctions = new PanelFunctions();
    }

    //setters
    public void setTime(int time) {
        this.genTime = time;
    }

    //maze subroutines
    public void generateMaze() {
        //implemntation of Prim's algorithm
        //initialise with all walls
        for (int i = 0; i < this.x + 1; i++) {
            for (int j = 0; j < this.y + 1; j++) {
                this.maze[i][j] = 1;
            }
        }
        //randomized Prim's algorithm with linked list
        LinkedList<int[]> potentialPaths = new LinkedList<>();
        //random co-ordinates to start prims maze
        Random random = new Random();
        int x_start = this.x - 1;
        int y_start = this.y - 1;
        potentialPaths.add(new int[]{x_start, y_start, x_start, y_start});

        //iterate until all potential paths are gone
        while (!potentialPaths.isEmpty()) {
            //remove random path from the list - mark as current
            int[] path = potentialPaths.remove(random
                    .nextInt(potentialPaths.size()));
            //assign co ordinates from current removed path
            int x1 = path[0];
            int y1 = path[1];
            int x2 = path[2];
            int y2 = path[3];

            //if the cell is a wall, carve a path and add new potential paths
            if (this.maze[x2][y2] == 1) {
                //carve a path - 0 is a path
                this.maze[x1][y1] = this.maze[x2][y2] = 0;
                //check the four directions around cell
                //if north is a wall, add to a potential path
                if (x2 >= 2 && this.maze[x2 - 2][y2] == 1) {
                    potentialPaths.add(new int[]{x2 - 1, y2, x2 - 2, y2});
                }
                //if west is a wall, add to a potential path
                if (y2 >= 2 && this.maze[x2][y2 - 2] == 1) {
                    potentialPaths.add(new int[]{x2, y2 - 1, x2, y2 - 2});
                }
                //if south is a wall, add to a potential path
                if (x2 < this.x - 2 && this.maze[x2 + 2][y2] == 1) {
                    potentialPaths.add(new int[]{x2 + 1, y2, x2 + 2, y2});
                }
                //if east is a wall, add to a potential path
                if (y2 < this.y - 2 && this.maze[x2][y2 + 2] == 1) {
                    potentialPaths.add(new int[]{x2, y2 + 1, x2, y2 + 2});
                }
            }
        }
        //maze fully generated after no potential paths remain
    }

    public void generateMaze(JLabel[][] labels) {
        //implemntation of Prim's algorithm
        //initialise with all walls
        for (int i = 0; i < this.x + 1; i++) {
            for (int j = 0; j < this.y + 1; j++) {
                this.maze[i][j] = 1;
            }
        }

        //randomized Prim's algorithm with linked list
        LinkedList<int[]> potentialPaths = new LinkedList<>();
        //random co-ordinates to start prims maze
        Random random = new Random();
        int x_start = 1;
        int y_start = 1;
        potentialPaths.add(new int[]{x_start, y_start, x_start, y_start});

        //iterate until all potential paths are gone
        while (!potentialPaths.isEmpty()) {
            //remove random path from the list - mark as current
            int[] path = potentialPaths.remove(random
                    .nextInt(potentialPaths.size()));
            //assign co ordinates from current removed path
            int x1 = path[0];
            int y1 = path[1];
            int x2 = path[2];
            int y2 = path[3];

            //if the cell is a wall, carve a path and add new potential paths
            if (this.maze[x2][y2] == 1) {
                //carve a path - 0 is a path
                this.maze[x1][y1] = this.maze[x2][y2] = 0;
                //check the four directions around cell
                //if north is a wall, add to a potential path
                if (x2 >= 2 && this.maze[x2 - 2][y2] == 1) {
                    potentialPaths.add(new int[]{x2 - 1, y2, x2 - 2, y2});
                }
                //if west is a wall, add to a potential path
                if (y2 >= 2 && this.maze[x2][y2 - 2] == 1) {
                    potentialPaths.add(new int[]{x2, y2 - 1, x2, y2 - 2});
                }
                //if south is a wall, add to a potential path
                if (x2 < this.x - 2 && this.maze[x2 + 2][y2] == 1) {
                    potentialPaths.add(new int[]{x2 + 1, y2, x2 + 2, y2});
                }
                //if east is a wall, add to a potential path
                if (y2 < this.y - 2 && this.maze[x2][y2 + 2] == 1) {
                    potentialPaths.add(new int[]{x2, y2 + 1, x2, y2 + 2});
                }
            }
            //update the panel after each cycle
            this.panelFunctions.updatePanel(this.maze, this.genTime, labels);
        }
        //maze fully generated after no potential paths remain
    }

    //getters
    public int[][] getMaze() {
        //return the maze
        return this.maze;
    }

    public void printMaze() {
        //iterate through the maze and print the values.
        for (int i = 0; i < this.x + 1; i++) {
            for (int j = 0; j < this.y + 1; j++) {
                System.out.print(this.maze[i][j] + " ");
            }
            System.out.println();
        }
    }
}
