package Programmers;

import java.util.*;

public class P42898 { // 3 등굣길
	
	public static void main(String[] args) {
		
		P42898 p = new P42898();

		int[][] puddles = {{2,2}};
		
		System.out.println(p.solution(4, 3, puddles));
	}

	public int solution(int m, int n, int[][] puddles) {
        
        int[][] dp = new int[n][m];
        for(int i = 0; i < puddles.length; i++) {
        	int[] puddle = puddles[i];
        	
        	dp[puddle[1]-1][puddle[0]-1] = -1;
        }
        
        dp[0][0] = 1;
        
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < m; j++) {
        		if(dp[i][j] != -1)  {
        			
        			if(i!=0 && j==0) { // 첫번째 행
        				if(dp[i-1][j] == -1) {
            				dp[i][j] = 0;
            			}else {
            				dp[i][j] = dp[i-1][j];
            			}
        			}else if(i == 0 && j != 0) { // 첫번째 열
        				if(dp[i][j-1] == -1) {
            				dp[i][j] = 0;
            			}else {
            				dp[i][j] = dp[i][j-1];
            			}
        			}else if(i != 0 && j != 0) {
        				if(dp[i-1][j] == -1 && dp[i][j-1] != -1) {
            				dp[i][j] = dp[i][j-1] % 1000000007;
            			}else if(dp[i-1][j] != -1 && dp[i][j-1] == -1) {
            				dp[i][j] = dp[i-1][j] % 1000000007;
            			}else if(dp[i-1][j] != -1 && dp[i][j-1] != -1) {
            				dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
            			}
        			}
        		}
        	}
        }
        
        return dp[n-1][m-1];
    }
	
	int[] dx = {0,1};
	int[] dy = {1,0};
	
	// 완전 탐색 => 시간 초과
	private int bfs(int[][] visited, int m, int n) {

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0});
		
		while(!q.isEmpty()) {
			
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
					
			for(int i = 0; i < 2; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < n && ny < m && visited[nx][ny] != -1) {
					visited[nx][ny] += 1;
					q.add(new int[] {nx, ny});
				}
			}
		}
		
		return visited[n-1][m-1];
	}
}