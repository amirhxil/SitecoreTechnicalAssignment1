package Minefield;

public class MinefieldNavigation {

    static char[][] minefield = {
        /* 2nd example can try
        {' ', 'X', 'X', ' ', ' '},
        {'X', 'X', ' ', 'X', ' '},
        {' ', 'X', 'X', ' ', 'X'},
        {'X', ' ', 'X', ' ', 'X'},
        {' ', 'X', ' ', 'X', 'X'}
         */
        {' ', ' ', 'X', 'X', ' '},
        {'X', 'X', ' ', 'X', ' '},
        {' ', 'X', 'X', ' ', 'X'},
        {'X', ' ', 'X', ' ', 'X'},
        {' ', 'X', ' ', 'X', 'X'}
    };

    public static void main(String[] args) {
        // Initial position of Totoshka (starting at -1, -1 as it hasn't moved yet)
        int totoRow = -1, totoCol = -1;
        int allyRow = -1, allyCol = -1;

        // Step 1: Find a valid start for Totoshka in the first row
        for (int col = 0; col < minefield[0].length; col++) {
            if (minefield[0][col] == ' ') {  // Check the first row for a valid start point
                if (isValidMove(1, col) || isValidMove(1, col - 1) || isValidMove(1, col + 1)) {
                totoRow = 0;
                totoCol = col;
                minefield[totoRow][totoCol] = '√';  // Mark the initial position of Totoshka
                System.out.println("Step 1: Totoshka at (" + totoRow + ", " + totoCol + ")");
                break;
            }
        }
        }

        // Simulate the movement of Totoshka and Ally
        int stepCount = 2;  // Start counting from step 2
        int lastTotoRow = totoRow, lastTotoCol = totoCol;  // To track the last position of Totoshka

        while (totoRow < minefield.length) {
            // Totoshka will look for the next valid field to move to (empty space)
            boolean moved = false;

            // Look ahead and find the best move (consider 1 row ahead)
            for (int colOffset = -1; colOffset <= 1; colOffset++) {
                int newRow = totoRow + 1;  // Move one row ahead
                int newCol = totoCol + colOffset;

                // Ensure the new position is within bounds and is safe (not a bomb)
                if (newCol >= 0 && newCol < minefield[0].length && newRow < minefield.length && minefield[newRow][newCol] == ' ') {

                    
                    // Move Totoshka
                    lastTotoRow = totoRow;
                    lastTotoCol = totoCol;
                    totoRow = newRow;
                    totoCol = newCol;
                    minefield[totoRow][totoCol] = '√'; // Mark the new position as part of the path
                    moved = true;

                    //Ally move to the previous position of Totoshka
                    allyRow = lastTotoRow;
                    allyCol = lastTotoCol;
                    
                    break;
                }
            }

            // If no valid moves for Totoshka, exit the loop
            if (!moved) {
                break;
            }

            // Step 2: Totoshka moves to a new position
            System.out.println("Step " + stepCount + ": Totoshka at (" + totoRow + ", " + totoCol + ")");
            System.out.println("Ally moved to (" + allyRow + ", " + allyCol + ")");

            // Track the last position of Totoshka
            lastTotoRow = totoRow;
            lastTotoCol = totoCol;

            stepCount++;
        }

        // If no valid moves are left for Totoshka, update step 6 and step 7
        if (totoRow >= 0 && totoRow < minefield.length) {
            System.out.println("Step 6: Totoshka has exited the field.");
            allyRow = lastTotoRow;
            allyCol = lastTotoCol;
            System.out.println("Ally moved to (" + allyRow + ", " + allyCol + ")");
            System.out.println("Step 7: Ally has exited the field.");

        }

        // Final positions
        System.out.println("\nFinal Grid:");
        printMinefield();


    }

    // Helper method to print the minefield
    private static void printMinefield() {
        for (int i = 0; i < minefield.length; i++) {
            for (int j = 0; j < minefield[i].length; j++) {
                System.out.print(minefield[i][j] + " ");
            }
            System.out.println();        }
    }

    // Helper method to check if a move is valid (i.e., the cell is empty)
    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < minefield.length && col >= 0 && col < minefield[row].length && minefield[row][col] == ' ';
    }
}
