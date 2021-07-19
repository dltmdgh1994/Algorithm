package Programmers;

public class P81302 { // 거리두기 확인하기
	
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) {
		P81302 p = new P81302();
		
	}
	
	// P : 사람, O : 빈 테이블, X : 칸막이
	// 1 : 거리두기o, 0: 거리두기 x
	public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i = 0; i < places.length; i++) {
        	
        	int[][] map = new int[5][5];
        	for(int j = 0; j < 5; j++) {
        		String[] s = places[i][j].split("");
        		for(int k = 0; k < 5; k++) {
        			if(s[k].equals("P")) {
        				map[j][k] = 1; // 사람
        			}else if(s[k].equals("O")) {
        				map[j][k] = 0; // 빔
        			}else {
        				map[j][k] = 2; // 칸막이
        			}
        		}
        	}
        	
        	answer[i] = check(map);
        }
        
        return answer;
    }
	
	private int check(int[][] map) {
		
		for(int j = 0; j < 5; j++) {
    		for(int k = 0; k < 5; k++) {
    			int n = map[j][k];
    			
    			// 현재 자리가 사람일 경우
    			if(n == 1) {
    				for(int l = 0; l < 4; l++) {
        				int nx = j + dx[l];
        				int ny = k + dy[l];
        				
        				if(nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
        					// 한명이라도 있으면 거리두기 x
        					if(map[nx][ny] == 1) {
        						return 0;
        					}
        				}
        			}
    			}else if(n == 0) { // 현재 자리가 빈 자리
    				int cnt = 0;
    				
    				for(int l = 0; l < 4; l++) {
        				int nx = j + dx[l];
        				int ny = k + dy[l];
        				
        				if(nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
        					if(map[nx][ny] == 1) {
        						cnt++;
        					}
        				}
        			}
    				// 근처에 2명 이상 있으면 거리두기 x
    				if(cnt >= 2) {
    					return 0;
    				}
    			}
    		}
    	}
		
		return 1;
	}
}
