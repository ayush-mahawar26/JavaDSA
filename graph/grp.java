package graph;

import java.util.*;

import javafx.scene.input.RotateEvent;

public class grp {

    private static class Rotten {
        int x;
        int y;
        int time;

        Rotten(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static int[][] orangesInput(int n) {
        Scanner sc = new Scanner(System.in);
        int[][] oranges = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                oranges[i][j] = sc.nextInt();
            }
        }

        sc.close();
        return oranges;
    }

    static int orangesTime(int[][] oranges) {
        Queue<Rotten> queue = new LinkedList<>();
        int row = oranges.length;
        int col = oranges[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (oranges[i][j] == 2) {
                    Rotten r = new Rotten(i, j, 0);
                    queue.add(r);
                }
            }
        }
        Rotten front = queue.peek();
        // performing bfs
        while (!queue.isEmpty()) {
            front = queue.poll();
            int x = front.x;
            int y = front.y;
            int time = front.time;

            // iterate over four directions to rotten
            int[] dx = { -1, 0, +1, 0 };
            int[] dy = { 0, +1, 0, -1 };

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX >= 0 && newY >= 0 && newX < row && newY < col && oranges[newX][newY] == 1) {
                    oranges[newX][newY] = 2;
                    time++;
                    queue.add(new Rotten(newX, newY, time));
                }
            }
        }

        if (front.time == 0)
            return -1;
        return front.time;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] matrix = orangesInput(n);
        int ans = orangesTime(matrix);

        System.out.println(ans);

        sc.close();
    }
}
