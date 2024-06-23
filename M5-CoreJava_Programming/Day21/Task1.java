/*Day-21 Task 1: 
The Knight’s Tour Problem
Create a function bool SolveKnightsTour(int[,] board, int moveX, int moveY, 
int moveCount, int[] xMove, int[] yMove) that attempts to solve the Knight's Tour
problem using backtracking. The function should return true if a solution exists
and false otherwise. The board represents the chessboard, moveX and moveY are the
current coordinates of the knight, moveCount is the current move count, and 
xMove[], yMove[] are the possible next moves for the knight. Fill the chessboard 
such that the knight visits every square exactly once. Keep the  chessboard size 
to 8x8.
*/

//Solution

public class KnightsTourProblem {

    // Function to check if the given position is valid on the chessboard
    public static boolean isValidMove(int x, int y, int[][] board) {
        int N = board.length;
        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
    }

    // Function to solve the Knight's Tour problem using backtracking
    public static boolean solveKnightsTour(int[][] board, int moveX, int moveY, int moveCount, int[] xMove, int[] yMove) {
        int N = board.length;

        // Base case: if all cells are visited, return true
        if (moveCount == N * N) {
            return true;
        }

        // Try all next moves from the current position
        for (int i = 0; i < 8; i++) {
            int nextX = moveX + xMove[i];
            int nextY = moveY + yMove[i];

            if (isValidMove(nextX, nextY, board)) {
                // Mark the next move
                board[nextX][nextY] = moveCount;

                // Recur for next moves
                if (solveKnightsTour(board, nextX, nextY, moveCount + 1, xMove, yMove)) {
                    return true;
                }

                // Backtrack
                board[nextX][nextY] = -1;
            }
        }

        // No solution found
        return false;
    }

    // Function to print the solution
    public static void printSolution(int[][] board) {
        int N = board.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        int N = 8; // Chessboard size
        int[][] board = new int[N][N];

        // Initialize the chessboard with -1 (unvisited)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = -1;
            }
        }

        // Possible moves for the knight
        int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};

        // Start from cell (0, 0) and move count 0
        board[0][0] = 0;

        // Try to solve the Knight's Tour problem
        if (solveKnightsTour(board, 0, 0, 1, xMove, yMove)) {
            System.out.println("Solution exists. Here's the tour:");
            printSolution(board);
        } else {
            System.out.println("No solution exists.");
        }
    }
}
