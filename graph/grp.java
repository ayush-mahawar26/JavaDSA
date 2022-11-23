package graph;

import java.util.*;

public class grp {

    static int[][] matrixInp(int r, int c) {
        Scanner sc = new Scanner(System.in);
        int[][] oranges = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                oranges[i][j] = sc.nextInt();
            }
        }

        sc.close();
        return oranges;
    }

    static void dfs(int[][] grid, boolean[][] vis, int r, int c) {
        vis[r][c] = true;
        int row = grid.length;
        int col = grid[0].length;

        int dx[] = { -1, 0, 1, 0 };
        int dy[] = { 0, 1, 0, -1 };
        for (int i = 0; i < 4; i++) {
            int newx = r + dx[i];
            int newy = c + dy[i];

            if (newx >= 0 && newx < row && newy >= 0 && newy < col && grid[newx][newy] == 1
                    && vis[newx][newy] == false) {
                dfs(grid, vis, newx, newy);
            }
        }
    }

    static int numberOfIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] vis = new boolean[r][c];
        int count = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                vis[i][j] = false;
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    dfs(grid, vis, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int r = sc.nextInt();
        // int c = sc.nextInt();

        // int[][] matrix = matrixInp(r, c);
        // System.out.println(numberOfIsland(matrix));
        sc.close();
    }
}
