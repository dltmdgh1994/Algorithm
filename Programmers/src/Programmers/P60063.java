package Programmers;

import java.util.*;

public class P60063 { // 3 블록 이동하기
	
	public static void main(String[] args) {
		
		P60063 p = new P60063();
		
	}
	
    public int solution(int[][] board) {
        
        boolean[][] visited = new boolean[board.length][board.length];
        
        int answer = bfs(board, visited);
        
        return answer;
    }
    
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
     
    private int bfs(int[][] board, boolean[][] visited) {
    	
    	Queue<int[]> q = new LinkedList<>();
    	q.add(new int[] {0,0,0,1,0});
    	visited[0][0] = true;
    	visited[0][1] = true;
    	
    	while(!q.isEmpty()) {
    		int[] pos = q.peek();
    		
    		int y1 = pos[0];
    		int x1 = pos[1];
    		int y2 = pos[2];
    		int x2 = pos[3];
    		int dist = pos[4];
    		q.poll();
    		
    		// 이동, 회전
    	}
    	
    	return 0;
    }
}
