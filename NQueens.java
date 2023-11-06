import java.util.Scanner;

public class NQueens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N for n-queens: ");
        int n = sc.nextInt();
        long startTime = System.currentTimeMillis();
        int[][] board = new int[n][n];
        if (solveNQueens(board, 0, n)) {
        	long endTime = System.currentTimeMillis();
        	System.out.println("TIME TAKEN BY ABOVE FUNCTION TO CALCULATE N-QUEEN : "+(endTime-startTime));
            printBoard(board);
        } else {
            System.out.println("No solution found.");
        }
    }

    public static boolean isSafe(int[][] board, int row, int col, int n) {
        // Check if there is a Queen in the same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // Check upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check upper right diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public static boolean solveNQueens(int[][] board, int row, int n) {
        if (row == n) {
            return true;  // All Queens have been placed successfully
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 1;

                if (solveNQueens(board, row + 1, n)) {
                    return true;
                }

                board[row][col] = 0;
            }
            //printBoard(board);System.out.println();
        }

        return false;
    }

    public static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}

/*
 
Let's analyze the time and space complexities of the provided Java code for the N-Queens problem function by function:

1)isSafe Function:

Time Complexity: O(n)
This function checks the current column, upper-left diagonal, and upper-right diagonal for a potential Queen placement. It performs a constant amount of work for each row (up to n rows) and checks three directions, giving a time complexity of O(n).
Space Complexity: O(1)
The function uses a constant amount of extra space for variables, regardless of the input size.

2)solveNQueens Function (recursive):

Time Complexity:
The time complexity of the solveNQueens function is influenced by the recursive calls and the backtracking involved. In the worst case, it explores all possible positions for each Queen, which results in a time complexity of O(n^n). However, this is an overestimate of the actual complexity because not all positions are explored due to backtracking. The exact time complexity is hard to compute, but it is significantly less than O(n^n) due to pruning and backtracking.
Space Complexity: O(n^2)
The space complexity of the solveNQueens function mainly depends on the board 2D array, which has a size of n x n. The recursion stack also contributes to space complexity, but it is limited to n levels deep in the worst case, resulting in O(n).
*/
