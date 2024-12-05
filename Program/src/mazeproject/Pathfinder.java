package mazeproject;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import javax.swing.JLabel;

public class Pathfinder {

    //attributes
    private JLabel[][] labels;
    private int solveTime;
    private int backTrackTime;
    private final PanelFunctions panelFunctions;

    //constructor
    public Pathfinder(JLabel[][] labels, int solveTime) {
        //assgn values to attributes
        this.labels = labels;
        this.solveTime = solveTime;
        this.panelFunctions = new PanelFunctions();

        //scale backtracker
        this.backTrackTime = (int) (this.solveTime / scalar(this.solveTime));
    }

    //setters
    public void setLabels(JLabel[][] labels) {
        this.labels = labels;
    }

    public void setTime(int time) {
        this.solveTime = time;
    }

    public int[][] deepCopy(int[][] original) {
        //return null if non existent
        if (original == null) {
            return null;
        }
        //copy array
        int[][] result = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        //return copied 2D array
        return result;
    }

    public int[] genEnd(int[][] maze) {
        //set limits
        int x = maze.length;
        int y = maze[0].length;

        //calculate the boundaries for the last octant
        int lastOctantXStart = 3 * x / 4;
        int lastOctantYStart = 3 * y / 4;

        Random random = new Random();
        //generate a random final square (4) in the last octant
        int endX, endY;
        do {
            endX = lastOctantXStart + random.nextInt(x - lastOctantXStart);
            endY = lastOctantYStart + random.nextInt(y - lastOctantYStart);
        } while (maze[endX][endY] != 0);
        return new int[]{endX, endY};
    }

    public void solveDFS(int[][] maze, int startX, int startY, int endX,
            int endY) {
        //mark the ending square
        maze[endX][endY] = 4;
        this.panelFunctions.updatePanel(maze, 1, this.labels);
        this.panelFunctions.updatePanel(maze, 1200, this.labels);
        //initialize the visited stack - add start point
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{startX, startY});

        //directions for moving up, down, left, and right
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        //2D array to store the shortest path
        int[][] previous = new int[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            Arrays.fill(previous[i], -1);
        }

        //repeat until stack is empty
        while (!stack.isEmpty()) {
            //pop and retrieve cell from the stack
            int[] current = stack.pop();
            int x = current[0];
            int y = current[1];

            //break out if final square reached
            if (x == endX && y == endY) {
                //mark as found
                maze[endX][endY] = 5;
                this.panelFunctions.updatePanel(maze, this.solveTime,
                        this.labels);
                break;
            }

            //mark the current cell as part of the path
            maze[x][y] = 2;
            //update the visualiser
            this.panelFunctions.updatePanel(maze, this.solveTime,
                    this.labels);
            //try move in all four directions
            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                //check if new position is within the maze and is an empty cell
                if (newX >= 0 && newX < maze.length && newY >= 0 && newY
                        < maze[0].length && maze[newX][newY] == 0
                        || maze[newX][newY] == 4) {
                    //highlight junctions
                    maze[newX][newY] = 3;
                    this.panelFunctions.updatePanel(maze,
                            this.solveTime, this.labels);
                    stack.push(new int[]{newX, newY});
                    //store the path for shortest path
                    previous[newX][newY] = x * maze[0].length + y;
                }
            }
        }
        //fill maze with shortest path
        for (int i = 0; i < previous.length; i++) {
            for (int j = 0; j < previous[i].length; j++) {
                if (previous[i][j] == 1) {
                    //mark as completed path and update
                    maze[i][j] = 5;
                    this.panelFunctions.updatePanel(maze,
                            this.solveTime, this.labels);
                }
            }
        }
        //highlight the shortest path using 5s
        int x = endX;
        int y = endY;
        //find shortest path
        while (previous[x][y] != -1) {
            int prevX = previous[x][y] / maze[0].length;
            int prevY = previous[x][y] % maze[0].length;
            //mark the shortest path on the grid
            maze[prevX][prevY] = 5;
            this.panelFunctions.updatePanel(maze,
                    this.backTrackTime, this.labels);
            //backtrack
            x = prevX;
            y = prevY;
        }
    }

    public void solveBFS(int[][] maze, int startX, int startY, int endX,
            int endY) {
        //mark the ending square
        maze[endX][endY] = 4;
        this.panelFunctions.updatePanel(maze, 1, this.labels);
        this.panelFunctions.updatePanel(maze, 1200, this.labels);

        //initialize the visited stack - add start point
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});

        //directions for moving up, down, left, and right
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        //2D array to store the shortest path
        int[][] previous = new int[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            Arrays.fill(previous[i], -1);
        }

        //repeat until queue is empty
        while (!queue.isEmpty()) {
            //pop and retrieve cell from the queue
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            //break out if final square reached
            if (x == endX && y == endY) {
                //mark as found
                maze[endX][endY] = 5;
                this.panelFunctions.updatePanel(maze,
                        this.solveTime, this.labels);
                break;
            }

            //mark the current cell as part of the path
            maze[x][y] = 2;
            //update the visualiser
            this.panelFunctions.updatePanel(maze, this.solveTime,
                    this.labels);
            //try move in all four directions
            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                //check if new position is within the maze and is an empty cell
                if (newX >= 0 && newX < maze.length && newY >= 0 && newY
                        < maze[0].length && maze[newX][newY] == 0
                        || maze[newX][newY] == 4) {
                    //highlight junctions
                    maze[newX][newY] = 3;
                    this.panelFunctions.updatePanel(maze,
                            this.solveTime, this.labels);
                    queue.offer(new int[]{newX, newY});
                    //store the path for shortest path
                    previous[newX][newY] = x * maze[0].length + y;
                }
            }
        }
        //highlight the shortest path using 5s
        int x = endX;
        int y = endY;
        //find shortest path
        while (previous[x][y] != -1) {
            int prevX = previous[x][y] / maze[0].length;
            int prevY = previous[x][y] % maze[0].length;
            //mark the shortest path on the grid
            maze[prevX][prevY] = 5;
            this.panelFunctions.updatePanel(maze,
                    this.backTrackTime, this.labels);
            //backtrack
            x = prevX;
            y = prevY;
        }
    }

    public void solveAStar(int[][] maze, int startX, int startY, int endX,
            int endY) {
        //mark the ending square
        maze[endX][endY] = 4;
        this.panelFunctions.updatePanel(maze, 1, this.labels);
        this.panelFunctions.updatePanel(maze, 1200, this.labels);

        //priority queue for A*
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)
                -> Integer.compare(a[2], b[2]));
        queue.offer(new int[]{startX, startY, 0});

        //directions for moving up, down, left, and right
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        //2D array to store the shortest path
        int[][] previous = new int[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            Arrays.fill(previous[i], -1);
        }

        //repeat until the queue is empty
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            //break out if final square reached
            if (x == endX && y == endY) {
                //mark as found
                maze[endX][endY] = 5;
                this.panelFunctions.updatePanel(maze,
                        this.solveTime, this.labels);
                break;
            }

            //mark the current cell as part of the path
            maze[x][y] = 2;
            //update the visualiser
            this.panelFunctions.updatePanel(maze, this.solveTime,
                    this.labels);
            //try move in all four directions
            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                //check if new position is within the maze and is an empty cell
                if (newX >= 0 && newX < maze.length && newY >= 0 && newY
                        < maze[0].length && maze[newX][newY] == 0
                        || maze[newX][newY] == 4) {
                    //highlight junctions only if not end
                    if (newX != endX && newY != endY) {
                        maze[newX][newY] = 3;
                    }
                    //calculate the cost (distance from start + heuristic)
                    //manhattan distance
                    int cost = current[2] + 1 + Math.abs(newX - endX)
                            + Math.abs(newY - endY);
                    queue.offer(new int[]{newX, newY, cost});
                    //store the path for shortest path
                    previous[newX][newY] = x * maze[0].length + y;
                }
            }
        }
        //highlight the shortest path using 5s
        int x = endX;
        int y = endY;
        //find shortest path
        while (previous[x][y] != -1) {
            int prevX = previous[x][y] / maze[0].length;
            int prevY = previous[x][y] % maze[0].length;
            //mark the shortest path on the grid
            maze[prevX][prevY] = 5;
            this.panelFunctions.updatePanel(maze,
                    this.backTrackTime, this.labels);
            //backtrack
            x = prevX;
            y = prevY;
        }
    }

    public double scalar(int x) {
        //return log base of a number
        return (Math.log((double) x) / Math.log(500));
    }
}
