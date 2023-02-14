package graph;

import java.beans.Visibility;
import java.util.*;

import javax.swing.border.Border;

public class grp {

    static char[][] matrixInp(int r, int c) {
        Scanner sc = new Scanner(System.in);
        char[][] matrix = new char[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = sc.next().charAt(0);
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
        
        int[][] ansMat = new int[adj.length][adj[0].length];

        Queue<Pair> queue = new LinkedList<>(); 

        for(int i = 0 ; i < adj.length ; i++){
            for(int j = 0 ; j < adj[0].length ; j++){
                if(adj[i][j] == 1){
                    queue.add(new Pair(i, j, 0)) ;
                }
            }
        }


        int[] dx = {-1,0,1,0} ;
        int[] dy = {0,1,0,-1} ;

        while(!queue.isEmpty()){
            Pair front = queue.poll() ;
            int r = front.r ;
            int c = front.c ;
            int sum = front.dis ;

            for(int i = 0 ; i < 4 ; i++){
                int new_x = r + dx[i] ;
                int new_y = c + dy[i] ;

                
                if((new_x>=0 && new_x < adj.length && new_y >= 0 && new_y < adj[0].length) && adj[new_x][new_y] == 0 ){
                        adj[new_x][new_y] = 1 ;
                        int ns = sum+1 ;
                        ansMat[new_x][new_y] = ns ;
                        queue.add(new Pair(new_x, new_y, ns)) ;
                    }
                

            }
        }

        return ansMat ;

    }

    static boolean[][] dfsInO(int i , int j , boolean vis[][], char[][] xs){
        vis[i][j] = true ;

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        for(int k = 0 ; k < 4 ; k++){
            int nr = i+dr[k] ;
            int nc = j + dc[k] ;
            if((nr >= 0 && nr < vis.length && nc >= 0 && nc < vis[0].length) && !vis[nr][nc] && xs[nr][nc] == 'o'){
                dfsInO(nr, nc, vis ,xs) ;
            }
        }

        return vis; 
    }

    static char[][] replaceX(char[][] xs){
        boolean[][] vis = new boolean[xs.length][xs[0].length]; 

        for(int i = 0 ; i < vis.length ; i++){
            for(int j = 0 ; j < vis[0].length ; j++){
                vis[i][j] = false ; 
            }
        }

        for(int i = 0 ; i < xs[0].length ; i++){
            if(xs[0][i] == 'o' && !vis[0][i]) dfsInO(0, i, vis ,xs);
        }
        for(int i = 0 ; i < xs.length ; i++){
            if(xs[i][0] == 'o' && !vis[i][0]) dfsInO(i, 0, vis ,xs);
        }
        for(int i = 0 ; i < xs[0].length ; i++){
            if(xs[xs.length-1][i] == 'o' && !vis[xs.length-1][i]) dfsInO(xs.length-1, i, vis ,xs);
        }
        for(int i = 0 ; i < xs.length ; i++){
            if(xs[i][xs[0].length-1] == 'o' && !vis[i][xs[0].length-1]) dfsInO(i, xs[0].length-1, vis ,xs);
        }

        for(int i = 0 ; i < xs.length ; i++){
            for(int j = 0; j < xs[0].length ; j++){
                if(xs[i][j] == 'o' && vis[i][j] == false){
                    xs[i][j] = 'x' ;
                }
            }
        }

        return xs ;
    }



    static boolean[][] dfs0(int i , int j , boolean[][] vis , int[][] grid){
        vis[i][j]= true ;

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        for(int k = 0 ; k < 4 ; k++){
            int nr = i+dr[k] ;
            int nc = j + dc[k] ;
            if((nr >= 0 && nr < vis.length && nc >= 0 && nc < vis[0].length) && !vis[nr][nc] && grid[nr][nc] == 1){
                dfs0(nr, nc, vis ,grid) ;
            }
        }

        return vis ;
    }


    static int numberOfEnclave(int[][] grid){
        int r = grid.length ;
        int c = grid[0].length ; 
        boolean[][] vis = new boolean[r][c] ;
        
        for(int i = 0 ; i < r ; i++){
            for(int j= 0 ; j < c ; j++){
                vis[i][j] = false ; 
            }
        }

        for(int i = 0 ; i < c ; i++){
            if(grid[0][i] == 1){
                // dfs 
                dfs0(0,i,vis,grid);
            }
        }
        
        for(int i = 0 ; i < r ; i++){
            if(grid[i][c-1] == 1){
                // dfs
                dfs0(i,c-1,vis,grid);
                
            }
        }
        
        for(int i = 0 ; i < r ; i++){
            if(grid[i][0] == 1){
                // dfs
                dfs0(i,0,vis,grid);
            }
        }
        
        for(int i = 0 ; i < c ; i++){
            if(grid[r-1][i] == 1){
                //dfs
                dfs0(r-1,i,vis,grid);
            }
        }

        int s = 0 ; 
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0; j < grid[0].length ; j++){
                if(grid[i][j] == 1 && vis[i][j] == false){
                    s +=1 ;
                }
            }
        }

        return s ;
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();

        // char[][] matrix = matrixInp(r, c);
        // System.out.println(numberOfIsland(matrix));

        // int[][] ans = nearestDistance(matrix);
        // char[][] ans = replaceX(matrix);
        // int ans = numberOfEnclave(matrix) ;

        // for (int i = 0; i < r; i++) {
        //     for (int j = 0; j < c; j++) {
        //         System.out.print(ans[i][j] + " ");
        //     }
        //     System.out.println();
        // }


        sc.close();
    }
}
