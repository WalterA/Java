import java.util.*;

public class Main {
	public static void solveNQueens(int n) {
		int[] board = new int[n];
		List<int[]> solutions = new ArrayList<>();
		placeQueen(board, 0, n, solutions);
		printSolutions(solutions, n);
	}

	private static void placeQueen(int[] board, int row, int n, List<int[]> solutions) {
		if (row == n) {
			solutions.add(board.clone());
			return;
		}

		for (int col = 0; col < n; col++) {
			if (isSafe(board, row, col)) {
				board[row] = col;
				placeQueen(board, row + 1, n, solutions);
			}
		}
	}

	private static boolean isSafe(int[] board, int row, int col) {
		for (int i = 0; i < row; i++) {
			if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
				return false;
			}
		}
		return true;
	}

	private static void printSolutions(List<int[]> solutions, int n) {
		for (int[] solution : solutions) {
			for (int row = 0; row < n; row++) {
				for (int col = 0; col < n; col++) {
					if (solution[row] == col) {
						System.out.print("Q ");
					} else {
						System.out.print(". ");
					}
				}
				System.out.println();
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int n = 4; // Cambia il valore di N per testare
		solveNQueens(n);
	}
}
