package Programmers;

import java.util.Stack;

public class P1829 { // 카카오프렌즈 컬러링북
	
	public static void main(String[] args) {
		P1829 p = new P1829();
		
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		
		int[] ans = p.solution(6, 4, picture);
		
		System.out.println(ans[0]);
		System.out.println(ans[1]);
	}
	
	int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    int[][] p;
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        // 왜 그런지는 모르겠는데 picture의 원본을 바꾸면 정답이 아님..
        p = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
            	p[i][j] = picture[i][j];	
            }   
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(p[i][j] != 0) {
                	int size = dfs(i, j, m, n);
                	
                	if(size > maxSizeOfOneArea) {
                		maxSizeOfOneArea = size;
                	}
                	
                	numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    private int dfs(int x, int y, int m, int n){
        
    	Stack<int[]> stack = new Stack<>();
    	int cnt = 0;
    	int val = p[x][y];
    			
    	stack.push(new int[] {x,y});
    	p[x][y] = 0;
    	cnt++;
    	
    	while(!stack.isEmpty()) {
    		
    		int curX = stack.peek()[0];
    		int curY = stack.peek()[1];
    		stack.pop();
    		
    		for(int i = 0; i < 4; i++) {
    			int nx = curX + dx[i];
    			int ny = curY + dy[i];
    			
    			if(nx >= 0 && ny >= 0 && nx < m && ny < n) {
    				if(p[nx][ny] == val) {
    					stack.push(new int[] {nx, ny});
    					p[nx][ny] = 0;
    					cnt++;
    				}
    			}
    		}
    	}
    	
    	return cnt;
    }
}
