package graph;

import java.util.*;

public class grp {

    static int[][] matrixInp(int r, int c) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        sc.close();
        return matrix;
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

    // nearest distance from 1

    static class Pair {
        int r;
        int c;
        int dis;

        Pair(int x, int y, int dis) {
            r = x;
            c = y;
            this.dis = dis;
        }
    }

    static int[][] nearestDistance(int[][] adj) {
        Queue<Pair> queue = new LinkedList<>();
        boolean vis[][] = new boolean[adj.length][adj.length];
        int[][] dist = new int[adj.length][adj.length];

        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj.length; j++) {
                if (adj[i][j] == 1) {
                    queue.add(new Pair(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair front = queue.poll();
            int row = adj.length;
            int col = adj[0].length;
            int x = front.r;
            int y = front.c;
            int dis = front.dis;
            dist[x][y] = dis;

            int[] dx = { -1, 0, 1, 0 };
            int[] dy = { 0, 1, 0, -1 };

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
                    if (adj[nx][ny] == 0 && vis[nx][ny] == false) {
                        int nd = dis + 1;
                        queue.add(new Pair(nx, ny, nd));
                        vis[nx][ny] = true;
                    }
                }
            }
        }

        return dist;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] matrix = matrixInp(r, c);
        // System.out.println(numberOfIsland(matrix));

        int[][] ans = nearestDistance(matrix);

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
