package Minefield;

public class MinefieldTest {
    public static void main(String[] args) {
        // Define the minefield size and bomb positions
        int rows = 5, cols = 5;
        int[][] bombs = {{0, 2}, {1, 1}, {1, 3}, {2, 2}};
        
        Minefield minefield = new Minefield(rows, cols, bombs);
        boolean result = minefield.navigate();
        System.out.println(result ? "Path exists!" : "No safe path available.");
    }
}
