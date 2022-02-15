package Programmers;

import java.util.*;

public class P60063 { // 3 블록 이동하기
	
	public static void main(String[] args) {
		
		P60063 p = new P60063();
		
		int[][] board = {{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}};
		
		System.out.println(p.solution(board));
	}
	
    public int solution(int[][] board) {
        
    	HashSet<String> set = new HashSet<>();
        
        int answer = bfs(board, set, board.length);
        
        return answer;
    }
    
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
     
    private int bfs(int[][] board, HashSet<String> set, int n) {
    	
    	Queue<int[]> q = new LinkedList<>();
    	q.add(new int[] {0,0,0,1,0});
    	set.add("0001");
    	set.add("0100");
    	
    	while(!q.isEmpty()) {
    		int[] pos = q.peek();
    		
    		int x1 = pos[0];
    		int y1 = pos[1];
    		int x2 = pos[2];
    		int y2 = pos[3];
    		int dist = pos[4];
    		q.poll();
    		
    		System.out.println(x1+ ","+y1+" "+x2+","+y2+" "+dist);
    		
    		if(x2 == n-1 && y2 == n-1) {
    			return dist;
    		}
    		
    		if(x1 == n-1 && y1 == n-1) {
    			return dist;
    		}
    		
    		// 이동
    		for(int i = 0; i < 4; i++) {
    			int nx1 = x1+dx[i];
    			int ny1 = y1+dy[i];
    			int nx2 = x2+dx[i];
    			int ny2 = y2+dy[i];
    			
    			if(nx1 >= 0 && ny1 >= 0 && nx2 >= 0 && ny2 >= 0 
    					&& nx1 < n && ny1 < n && nx2 < n && ny2 < n) {
    				if(board[nx1][ny1] == 0 && board[nx2][ny2] == 0) {
        				String s1 = Integer.toString(nx1) + Integer.toString(ny1) +
        						Integer.toString(nx2) + Integer.toString(ny2);
        				String s2 = Integer.toString(nx2) + Integer.toString(ny2) +
        						Integer.toString(nx1) + Integer.toString(ny1);
        				if(!set.contains(s1) || !set.contains(s2)) {
        					q.add(new int[] {nx1,ny1,nx2,ny2,dist+1});
        					set.add(s1);
        					set.add(s2);
        				}
    				}
    			}
    		}
    		
    		// 회전
        	int diffX = x1-x2;
        	
        	if(diffX == 0) { // 가로
        		
        		// 9->12
        		int nx1 = x2-1;
        		int ny1 = y2;
        		
        		if(nx1 >= 0 && y2-1 >= 0) {
        			if(board[x2-1][y2-1] == 0 && board[nx1][ny1] == 0) {
        				String s1 = Integer.toString(nx1) + Integer.toString(ny1) +
        						Integer.toString(x2) + Integer.toString(y2);
        				String s2 = Integer.toString(x2) + Integer.toString(y2) +
        						Integer.toString(nx1) + Integer.toString(ny1);
        				if(!set.contains(s1) || !set.contains(s2)) {
        					q.add(new int[] {nx1,ny1,x2,y2,dist+1});
        					set.add(s1);
        					set.add(s2);
        				}
        			}
        		}
        			
        		// 9->6
        		nx1 = x2+1;
        		ny1 = y2;
        		
        		if(nx1 < n && y2-1 >= 0) {
        			if(board[x2+1][y2-1] == 0 && board[nx1][ny1] == 0) {
        				String s1 = Integer.toString(x2) + Integer.toString(y2) +
        						Integer.toString(nx1) + Integer.toString(ny1);
        				String s2 = Integer.toString(nx1) + Integer.toString(ny1) +
        						Integer.toString(x2) + Integer.toString(y2);
        				if(!set.contains(s1) || !set.contains(s2)) {
        					q.add(new int[] {x2,y2,nx1,ny1,dist+1});
        					set.add(s1);
        					set.add(s2);
        				}
        			}
        		}
        		
        		// 3->6
        		int nx2 = x1+1;
        		int ny2 = y1;
        		
        		if(nx2 < n && y1+1 < n) {
        			if(board[x1+1][y1+1] == 0 && board[nx2][ny2] == 0) {
        				String s1 = Integer.toString(x1) + Integer.toString(y1) +
        						Integer.toString(nx2) + Integer.toString(ny2);
        				String s2 = Integer.toString(nx2) + Integer.toString(ny2) +
        						Integer.toString(x1) + Integer.toString(y1);
        				if(!set.contains(s1) || !set.contains(s2)) {
        					q.add(new int[] {x1,y1,nx2,ny2,dist+1});
        					set.add(s1);
        					set.add(s2);
        				}
        			}
        		}
        		
        		// 3->12
        		nx2 = x1-1;
        		ny2 = y1;
        		
        		if(nx2 >= 0 && y1+1 < n) {
        			if(board[x1-1][y1+1] == 0 && board[nx2][ny2] == 0) {
        				String s1 = Integer.toString(nx2) + Integer.toString(ny2) +
        						Integer.toString(x1) + Integer.toString(y1);
        				String s2 = Integer.toString(x1) + Integer.toString(y1) +
        						Integer.toString(nx2) + Integer.toString(ny2);
        				if(!set.contains(s1) || !set.contains(s2)) {
        					q.add(new int[] {nx2,ny2,x1,y1,dist+1});
        					set.add(s1);
        					set.add(s2);
        				}
        			}
        		}
        	}else { // 세로
        		
        		// 6->9
        		int nx2 = x1;
        		int ny2 = y1-1;
        		
        		if(ny2 >= 0 && x1+1 < n) {
        			if(board[nx2][ny2] == 0 && board[x1+1][y1-1] == 0) {
        				String s1 = Integer.toString(nx2) + Integer.toString(ny2) +
        						Integer.toString(x1) + Integer.toString(y1);
        				String s2 = Integer.toString(x1) + Integer.toString(y1) +
        						Integer.toString(nx2) + Integer.toString(ny2);
        				if(!set.contains(s1) || !set.contains(s2)) {
        					q.add(new int[] {nx2,ny2,x1,y1,dist+1});
        					set.add(s1);
        					set.add(s2);
        				}
        			}
        		}
        		
        		// 12->9
        		int nx1 = x2;
        		int ny1 = y2-1;
        		
        		if(ny1 >= 0 && x2-1 >= 0) {
        			if(board[nx1][ny1] == 0 && board[x2-1][y2-1] == 0) {
        				String s1 = Integer.toString(nx1) + Integer.toString(ny1) +
        						Integer.toString(x2) + Integer.toString(y2);
        				String s2 = Integer.toString(x2) + Integer.toString(y2) +
        						Integer.toString(nx1) + Integer.toString(ny1);
        				if(!set.contains(s1) || !set.contains(s2)) {
        					q.add(new int[] {nx1,ny1,x2,y2,dist+1});
        					set.add(s1);
        					set.add(s2);
        				}
        			}
        		}
        		
        		// 12->3
        		nx1 = x2;
        		ny1 = y2+1;
        		
        		if(ny1 < n && x2-1 >= 0) {
        			if(board[nx1][ny1] == 0 && board[x2-1][y2+1] == 0) {
        				String s1 = Integer.toString(x2) + Integer.toString(y2) +
        						Integer.toString(nx1) + Integer.toString(ny1);
        				String s2 = Integer.toString(nx1) + Integer.toString(ny1) +
        						Integer.toString(x2) + Integer.toString(y2);
        				if(!set.contains(s1) || !set.contains(s2)) {
        					q.add(new int[] {x2,y2,nx1,ny1,dist+1});
        					set.add(s1);
        					set.add(s2);
        				}
        			}
        		}
        		
        		// 6->3
        		nx2 = x1;
        		ny2 = y1+1;
        		
        		if(ny2 < n && x1+1 < n) {
        			if(board[nx2][ny2] == 0 && board[x1+1][y1+1] == 0) {
        				String s1 = Integer.toString(x1) + Integer.toString(y1) +
        						Integer.toString(nx2) + Integer.toString(ny2);
        				String s2 = Integer.toString(nx2) + Integer.toString(ny2) +
        						Integer.toString(x1) + Integer.toString(y1);
        				if(!set.contains(s1) || !set.contains(s2)) {
        					q.add(new int[] {x1,y1,nx2,ny2,dist+1});
        					set.add(s1);
        					set.add(s2);
        				}
        			}
        		}
        	}
    	}
    	
    	return 0;
    }
}
