import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final int SIZE = 8;
        final int ROOKS = 5;
        byte[][] board = new byte[SIZE][SIZE];
        Random random = new Random();

        int placed = 0;
        while (placed < ROOKS) {
            int row = random.nextInt(SIZE);
            int col = random.nextInt(SIZE);
            if (board[row][col] == 0) {
                board[row][col] = 1;
                placed++;
            }
        }

        // print the board
        System.out.println("Board:");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        boolean conflict = false;

        // conflicts in rows
        for (int i = 0; i < SIZE; i++) {
            int count = 0;
            StringBuilder cols = new StringBuilder();
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 1) {
                    if (count > 0) cols.append(", ");
                    cols.append(j + 1);
                    count++;
                }
            }
            if (count >= 2) {
                conflict = true;
                System.out.println("Conflict in row " + (i + 1) + ": columns " + cols);
            }
        }

        // conflicts in columns
        for (int j = 0; j < SIZE; j++) {
            int count = 0;
            StringBuilder rows = new StringBuilder();
            for (int i = 0; i < SIZE; i++) {
                if (board[i][j] == 1) {
                    if (count > 0) rows.append(", ");
                    rows.append(i + 1);
                    count++;
                }
            }
            if (count >= 2) {
                conflict = true;
                System.out.println("Conflict in column " + (j + 1) + ": rows " + rows);
            }
        }

        if (!conflict) {
            System.out.println("No conflict: the rooks are not threatened.");
        }
    }
}