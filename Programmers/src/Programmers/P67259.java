package Programmers;

import java.util.*;

public class P67259 { // 3 경주로 건설

	public static void main(String[] args) {
		
		P67259 p = new P67259();
		
		int[][] board = {{0,0,0},{0,0,0},{0,0,0}};
		
		System.out.println(p.solution(board));
	}
	
	// 오른 아래 왼 위
	int dx[] = {0,1,0,-1};
    int dy[] = {1,0,-1,0};
	
    public int solution(int[][] board) {
        
        int[][][] visited = new int[board.length][board.length][4];
        
        bfs(board.length, board, visited);
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++) {
        	if(visited[board.length-1][board.length-1][i] < min && visited[board.length-1][board.length-1][i] != 0) {
        		min = visited[board.length-1][board.length-1][i];
        	}
        }
        
        return min;
    }
    
    private void bfs(int n, int[][] board, int[][][] visited) {
		
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {0,0,0,0});
		q.add(new int[] {0,0,0,1});
		q.add(new int[] {0,0,0,2});
		q.add(new int[] {0,0,0,3});

		while(!q.isEmpty()){
        	
        	int xy[] = q.peek();
            int curX = xy[0];
            int curY = xy[1];
            int cost  = xy[2];
            int direction = xy[3];
            q.poll();
            
            visited[curX][curY][direction] = cost;

            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                	
                	if(board[nx][ny] == 1) { // 벽인 경우
                		continue;
                	}
                	
                	if((int)Math.abs(i-direction) == 2) { // 온 방향인 경우
                		continue;
                	}
                	
                	int c = cost;
                	if(i == direction) {
                		c += 100; // 직진
                	}else {
                		c += 600; // 코너
                	}
                	
                	if(visited[nx][ny][i] == 0) {
                		visited[nx][ny][i] = c;
                		q.add(new int[] {nx,ny,c,i});
                	}else if(visited[nx][ny][i] > c) {
                		visited[nx][ny][i] = c;
                		q.add(new int[] {nx,ny,c,i});
                	}
                }
            }
        }
	}
}
