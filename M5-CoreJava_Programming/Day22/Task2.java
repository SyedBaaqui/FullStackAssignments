/*Day 22 Task 2: 
Rat in a Maze
Implement a function bool SolveMaze(int[,] maze) that uses backtracking to find 
a path from the top left corner to the bottom right corner of a maze. The maze 
is represented by a 2D array where 1s are paths and 0s are walls. Find a rat's
path through the maze. The maze size is 6x6.
*/

//Solution

public class MazeSolver {

    // Function to check if the given position is a valid move in the maze
    public static boolean isValidMove(int x, int y, int[][] maze) {
        int N = maze.length;
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }

    // Function to solve the maze using backtracking
    public static boolean solveMaze(int[][] maze) {
        int N = maze.length;
        int[][] sol = new int[N][N];

        // Initialize the solution matrix
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sol[i][j] = 0;
            }
        }

        // Start from the top-left corner
        if (solveMazeUtil(maze, 0, 0, sol) == false) {
            System.out.println("No solution exists.");
            return false;
        }

        // Print the solution path
        printSolution(sol);
        return true;
    }

    // Function to recursively solve the maze using backtracking
    public static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol) {
        int N = maze.length;

        // If the current position is the bottom-right corner, return true
        if (x == N - 1 && y == N - 1) {
            sol[x][y] = 1;
            return true;
        }

        // Check if the current position is a valid move
        if (isValidMove(x, y, maze)) {
            // Mark the current position as part of the solution path
            sol[x][y] = 1;

            // Move right
            if (solveMazeUtil(maze, x, y + 1, sol)) {
                return true;
            }

            // Move down
            if (solveMazeUtil(maze, x + 1, y, sol)) {
                return true;
            }

            // If moving right or down doesn't lead to the solution, backtrack
            sol[x][y] = 0;
            return false;
        }

        return false;
    }

    // Function to print the solution path
    public static void printSolution(int[][] sol) {
        int N = sol.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0, 0, 0},
            {1, 1, 0, 1, 0, 0},
            {0, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 1}
        };

        System.out.println("Solution for the maze:");
        solveMaze(maze);
    }
}
