package Programmers;

import java.util.*;

public class P1844 { // 게임 맵 최단거리

	public static void main(String[] args) {
		P1844 p = new P1844();
		
		
	}
	
	public int solution(int[][] maps) {
        
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        int answer = bfs(maps, visited, maps.length, maps[0].length);
        
        return answer;
    }
    
    private int bfs(int[][] maps, boolean[][] visited, int m, int n){
        Queue<int[]> q = new LinkedList<>();
        
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        
        q.add(new int[] {0,0,1});
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
        	
        	int curX = q.peek()[0];
        	int curY = q.peek()[1];
        	int dist = q.peek()[2];
        	q.poll();
        	
        	for(int i = 0; i < 4; i++) {
        		
        		int nx = curX + dx[i];
        		int ny = curY + dy[i];
        		
        		if(nx == m-1 && ny == n-1 && maps[nx][ny] == 1) {
        			return dist+1;
        		}
        		
        		if(nx >= 0 && ny >= 0 && nx < m && ny < n) {
        			if(!visited[nx][ny] && maps[nx][ny] == 1) {
        				q.add(new int[] {nx, ny, dist+1});
        				visited[nx][ny] = true;
        			}
        		}
        	}
        }
        
        return -1;
    }
}
