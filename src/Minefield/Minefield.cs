using System;
using System.Collections.Generic;

class Minefield
{
    private int[,] field;
    private int rows, cols;
    private int[] dx = { 0, 1, 0, -1 };
    private int[] dy = { 1, 0, -1, 0 };

    public Minefield(int rows, int cols, List<Tuple<int, int>> bombs)
    {
        this.rows = rows;
        this.cols = cols;
        field = new int[rows, cols];

        foreach (var bomb in bombs)
        {
            field[bomb.Item1, bomb.Item2] = -1; // Mark bomb locations.
        }
    }

    private bool IsSafe(int x, int y)
    {
        return x >= 0 && x < rows && y >= 0 && y < cols && field[x, y] != -1;
    }

    public bool NavigateWithAlly()
    {
        bool[,] visited = new bool[rows, cols];
        Queue<Tuple<int, int>> totoshkaPath = new Queue<Tuple<int, int>>(); // For Ally tracking

        return Dfs(0, 0, visited, totoshkaPath);
    }

    private bool Dfs(int x, int y, bool[,] visited, Queue<Tuple<int, int>> totoshkaPath)
    {
        if (!IsSafe(x, y) || visited[x, y])
        {
            return false;
        }

        // Totoshka moves here
        visited[x, y] = true;
        totoshkaPath.Enqueue(Tuple.Create(x, y));

        // Ally moves to the previous position of Totoshka (if possible)
        if (totoshkaPath.Count > 1)
        {
            totoshkaPath.Dequeue(); // Ally moves from the old Totoshka position
        }

        // Check if both Totoshka and Ally are at the goal
        if (x == rows - 1 && y == cols - 1 && totoshkaPath.Count == 1 && totoshkaPath.Peek().Item1 == rows - 1 && totoshkaPath.Peek().Item2 == cols - 1)
        {
            return true;
        }

        // Explore all 4 directions
        for (int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (Dfs(nx, ny, visited, totoshkaPath))
            {
                return true;
            }
        }

        // Backtrack: Totoshka moves back, Ally returns to the previous position
        visited[x, y] = false;
        totoshkaPath.Dequeue();

        return false;
    }

    public static void Main(string[] args)
    {
        // Define the minefield size and bomb positions
        int rows = 5, cols = 5;
        List<Tuple<int, int>> bombs = new List<Tuple<int, int>>()
        {
            Tuple.Create(0, 2),
            Tuple.Create(1, 1),
            Tuple.Create(1, 3),
            Tuple.Create(2, 2)
        };

        Minefield minefield = new Minefield(rows, cols, bombs);
        bool result = minefield.NavigateWithAlly();

        Console.WriteLine(result ? "Path exists for Totoshka and Ally!" : "No safe path available.");
    }
}
