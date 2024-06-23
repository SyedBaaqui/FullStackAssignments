/*Day22 Task 3: 
N Queen Problem
Write a function bool SolveNQueen(int[,] board, int col) in Java
that places N queens on an N x N chessboard so that no two 
queens attack each other using backtracking. 
Place N queens on the board such that no two queens can attack each other.
Use a standard 8x8 chessboard.
*/

//Solution

public class NQueensProblem {

    // Function to check if it's safe to place a queen at board[row][col]
    public static boolean isSafe(int[][] board, int row, int col, int N) {
        // Check left side of the row
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check upper diagonal on the left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal on the left side
        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    // Function to solve the N-Queens problem using backtracking
    public static boolean solveNQueens(int[][] board, int col, int N) {
        if (col >= N) {
            return true; // All queens are placed
        }

        // Try placing queen in each row of this column
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col, N)) {
                board[i][col] = 1; // Place queen at (i, col)

                // Recur to place queens in the next columns
                if (solveNQueens(board, col + 1, N)) {
                    return true;
                }

                // If placing queen at (i, col) doesn't lead to a solution, backtrack
                board[i][col] = 0;
            }
        }

        return false; // No solution found
    }

    // Function to print the solution
    public static void printSolution(int[][] board, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        int N = 8; // Size of the chessboard
        int[][] board = new int[N][N];

        // Initialize the board with all 0s (empty)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = 0;
            }
        }

        // Solve the N-Queens problem
        if (solveNQueens(board, 0, N)) {
            System.out.println("Solution for the N-Queens problem:");
            printSolution(board, N);
        } else {
            System.out.println("No solution exists.");
        }
    }
}


