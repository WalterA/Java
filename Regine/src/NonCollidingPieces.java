public class NonCollidingPieces {
    static final int SIZE = 8; // Dimensione della matrice
    static final int PIECES = 8; // Numero di pedine da posizionare
    static int solutionCount = 0; // Contatore delle soluzioni

    public static void main(String[] args) {
        int[][] board = new int[SIZE][SIZE];
        solve(board, 0, 0);
        System.out.println("Numero totale di soluzioni: " + solutionCount);
    }

    // Funzione per risolvere il problema
    public static void solve(int[][] board, int placed, int row) {
        // Se sono state posizionate tutte le pedine, stampa la matrice
        if (placed == PIECES) {
            solutionCount++;
            System.out.println("Soluzione #" + solutionCount);
            printBoard(board);
            return;
        }

        for (int r = row; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (isSafe(board, r, c)) {
                    // Posiziona la pedina
                    board[r][c] = 1;

                    // Passa alla prossima pedina
                    solve(board, placed + 1, r + 1);

                    // Backtrack
                    board[r][c] = 0;
                }
            }
        }
    }

    // Controlla se è sicuro posizionare la pedina in (row, col)
    public static boolean isSafe(int[][] board, int row, int col) {
        // Controlla la colonna
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // Controlla le diagonali
        for (int i = 1; i <= row; i++) {
            if (col - i >= 0 && board[row - i][col - i] == 1) {
                return false;
            }
            if (col + i < SIZE && board[row - i][col + i] == 1) {
                return false;
            }
        }

        return true;
    }

    // Stampa la matrice
    public static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print((cell == 1 ? "P " : ". ") + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
