package Programmers;

import java.util.*;

public class P60063 { // 3 블록 이동하기
	
	public static void main(String[] args) {
		
		P60063 p = new P60063();
		
		int[][] board = {{0,0,1,1,0,0,0},{0,0,1,1,0,0,0},{0,1,1,1,0,1,0},
				{0,0,1,0,0,1,0},{0,0,0,0,0,1,0},{1,1,1,1,1,1,0},{1,1,1,1,1,1,0}};
		
		System.out.println(p.solution(board));
	}
	
    public int solution(int[][] board) {
        
    	HashMap<Points,Integer> map = new HashMap<>();
        
        int answer = bfs(board, map, board.length);
        
        return answer;
    }
    
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
     
    private int bfs(int[][] board, HashMap<Points,Integer> map, int n) {
    	
    	Queue<Points> q = new LinkedList<>();
    	Points p = new Points(0,0,0,1,0);
    	q.add(p);
    	map.put(p,0);
    	
    	while(!q.isEmpty()) {
    		Points curP = q.peek();
    		
    		int x1 = curP.x1;
    		int y1 = curP.y1;
    		int x2 = curP.x2;
    		int y2 = curP.y2;
    		int dist = curP.d;
    		q.poll();
    		
    		System.out.println(x1+ ","+y1+" "+x2+","+y2+" "+dist);
    		
    		if(x2 == n-1 && y2 == n-1) {
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
    					Points nP = new Points(nx1,ny1,nx2,ny2,dist+1);
        				if(map.containsKey(nP)) { // 해당 위치를 가본 경우
        					if(map.get(nP) > dist+1) { // 거리가 더 적게 간 경우
        						q.add(nP);
        						map.put(nP, dist+1);
        					}
        				}else { // 해당 위치를 가보지 않은 경우
        					q.add(nP);
    						map.put(nP, dist+1);
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
        				Points nP = new Points(nx1,ny1,x2,y2,dist+1);
        				if(map.containsKey(nP)) {
        					if(map.get(nP) > dist+1) {
        						q.add(nP);
        						map.put(nP, dist+1);
        					}
        				}else {
        					q.add(nP);
    						map.put(nP, dist+1);
        				}
        			}
        		}
        			
        		// 9->6
        		nx1 = x2+1;
        		ny1 = y2;
        		
        		if(nx1 < n && y2-1 >= 0) {
        			if(board[x2+1][y2-1] == 0 && board[nx1][ny1] == 0) {
        				Points nP = new Points(x2,y2,nx1,ny1,dist+1);
        				if(map.containsKey(nP)) {
        					if(map.get(nP) > dist+1) {
        						q.add(nP);
        						map.put(nP, dist+1);
        					}
        				}else {
        					q.add(nP);
    						map.put(nP, dist+1);
        				}
        			}
        		}
        		
        		// 3->6
        		int nx2 = x1+1;
        		int ny2 = y1;
        		
        		if(nx2 < n && y1+1 < n) {
        			if(board[x1+1][y1+1] == 0 && board[nx2][ny2] == 0) {
        				Points nP = new Points(x1,y1,nx2,ny2,dist+1);
        				if(map.containsKey(nP)) {
        					if(map.get(nP) > dist+1) {
        						q.add(nP);
        						map.put(nP, dist+1);
        					}
        				}else {
        					q.add(nP);
    						map.put(nP, dist+1);
        				}
        			}
        		}
        		
        		// 3->12
        		nx2 = x1-1;
        		ny2 = y1;
        		
        		if(nx2 >= 0 && y1+1 < n) {
        			if(board[x1-1][y1+1] == 0 && board[nx2][ny2] == 0) {
        				Points nP = new Points(nx2,ny2,x1,y1,dist+1);
        				if(map.containsKey(nP)) {
        					if(map.get(nP) > dist+1) {
        						q.add(nP);
        						map.put(nP, dist+1);
        					}
        				}else {
        					q.add(nP);
    						map.put(nP, dist+1);
        				}
        			}
        		}
        	}else { // 세로
        		
        		// 6->9
        		int nx2 = x1;
        		int ny2 = y1-1;
        		
        		if(ny2 >= 0 && x1+1 < n) {
        			if(board[nx2][ny2] == 0 && board[x1+1][y1-1] == 0) {
        				Points nP = new Points(nx2,ny2,x1,y1,dist+1);
        				if(map.containsKey(nP)) {
        					if(map.get(nP) > dist+1) {
        						q.add(nP);
        						map.put(nP, dist+1);
        					}
        				}else {
        					q.add(nP);
    						map.put(nP, dist+1);
        				}
        			}
        		}
        		
        		// 12->9
        		int nx1 = x2;
        		int ny1 = y2-1;
        		
        		if(ny1 >= 0 && x2-1 >= 0) {
        			if(board[nx1][ny1] == 0 && board[x2-1][y2-1] == 0) {
        				Points nP = new Points(nx1,ny1,x2,y2,dist+1);
        				if(map.containsKey(nP)) {
        					if(map.get(nP) > dist+1) {
        						q.add(nP);
        						map.put(nP, dist+1);
        					}
        				}else {
        					q.add(nP);
    						map.put(nP, dist+1);
        				}
        			}
        		}
        		
        		// 12->3
        		nx1 = x2;
        		ny1 = y2+1;
        		
        		if(ny1 < n && x2-1 >= 0) {
        			if(board[nx1][ny1] == 0 && board[x2-1][y2+1] == 0) {
        				Points nP = new Points(x2,y2,nx1,ny1,dist+1);
        				if(map.containsKey(nP)) {
        					if(map.get(nP) > dist+1) {
        						q.add(nP);
        						map.put(nP, dist+1);
        					}
        				}else {
        					q.add(nP);
    						map.put(nP, dist+1);
        				}
        			}
        		}
        		
        		// 6->3
        		nx2 = x1;
        		ny2 = y1+1;
        		
        		if(ny2 < n && x1+1 < n) {
        			if(board[nx2][ny2] == 0 && board[x1+1][y1+1] == 0) {
        				Points nP = new Points(x1,y1,nx2,ny2,dist+1);
        				if(map.containsKey(nP)) {
        					if(map.get(nP) > dist+1) {
        						q.add(nP);
        						map.put(nP, dist+1);
        					}
        				}else {
        					q.add(nP);
    						map.put(nP, dist+1);
        				}
        			}
        		}
        	}
    	}
    	
    	return 0;
    }
}

// 두 점의 동일 여부를 파악하기 위한 클래스.
// String으로 비교하니 에러가 발생(두쌍이라)
class Points {
	int x1, y1, x2, y2, d;

	public Points(int x1, int y1, int x2, int y2, int d) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.d = d;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x1;
		result = prime * result + x2;
		result = prime * result + y1;
		result = prime * result + y2;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Points other = (Points) obj;
		if(this.x1 == other.x1 && this.y1 == other.y1 && this.x2 == other.x2 && this.y2 == other.y2) return true;
		if(this.x1 == other.x2 && this.y1 == other.y2 && this.x2 == other.x1 && this.y2 == other.y1) return true;
		return false;
	}
}
