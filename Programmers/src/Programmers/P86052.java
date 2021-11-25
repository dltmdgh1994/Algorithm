package Programmers;

import java.util.*;

public class P86052 { // 2 빛의 경로 사이클

	public static void main(String[] args) {
		
		P86052 p = new P86052();
		
		
	}
	
	public int[] solution(String[] grid) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        int row = grid.length;
        int col = grid[0].length();
        
        int[][] light = new int[row][col];
        for(int i = 0; i < row; i++){
            
            String s = grid[i];
            for(int j = 0; j < col; j++){
                char c = s.charAt(j);
                
                if(c == 'S'){
                    light[i][j] = 0;
                }else if(c == 'L'){
                    light[i][j] = 1;
                }else{
                    light[i][j] = 2;
                }
            }
        }
        
        boolean[][][] visited = new boolean[row][col][4];
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                for(int k = 0; k < 4; k++){
                    //방문 안한 곳 사이클 확인
                    if(!visited[i][j][k]){
                        int tmp = dfs();
                        ans.add(tmp);
                    }
                }
            }
        }
        
        ans.sort(null);
        
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
    
    private int dfs(int r, int c, int d, int row, int col, int[][] light, boolean[][][] visited){
        
    	int curX = c;
    	int curY = r;
    	int direct = d;
    	int n = 0;
    	
    	while(!visited[curY][curX][direct]) {
    		visited[curY][curX][direct] = true;
    		
    		if(light[curY][curX] == 0) {
    			if(direct == 0) {
    				curX++;
    				if(curX == col) curX = 0; 
    			}else if(direct == 1) {
    				curY++;
    				if(curY == row) curY = 0; 
    			}else if(direct == 2) {
    				curX--;
    				if(curX == col) curX = col-1; 
    			}else {
    				curY--;
    				if(curY == row) curY = row-1; 
    			}
    		}else if(light[curY][curX] == 1) {
    			if(direct == 0) {
    				 
    			}else if(direct == 1) {
    				
    			}else if(direct == 2) {
    				
    			}else {
    				
    			}
    		}else {
    			
    		}
    	}
        
        return 0;
    }
}
