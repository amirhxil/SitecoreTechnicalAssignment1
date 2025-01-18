package Minefield;

public class Minefield {
    private final int[][] field;
    private final int rows, cols;
    private final int[] dx = {0, 1, 0, -1};
    private final int[] dy = {1, 0, -1, 0};

    public Minefield(int rows, int cols, int[][] bombs) {
        this.rows = rows;
        this.cols = cols;
        this.field = new int[rows][cols];

        for (int[] bomb : bombs) {
            field[bomb[0]][bomb[1]] = -1; // Mark bomb locations.
        }
    }

    public boolean isSafe(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols && field[x][y] != -1;
    }

    public boolean navigate() {
        return dfs(0, 0, new boolean[rows][cols]);
    }

    private boolean dfs(int x, int y, boolean[][] visited) {
        if (!isSafe(x, y) || visited[x][y]) {
            return false;
        }

        visited[x][y] = true;

        if (x == rows - 1 && y == cols - 1) {
            return true;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (dfs(nx, ny, visited)) {
                return true;
            }
        }

        visited[x][y] = false; // Backtrack.
        return false;
    }

    public static void main(String[] args) {
        int[][] bombs = {{0, 2}, {1, 1}, {1, 3}, {2, 2}};
        Minefield minefield = new Minefield(5, 5, bombs);
        System.out.println(minefield.navigate()); // Example usage
    }
}
