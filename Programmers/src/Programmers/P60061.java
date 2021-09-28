package Programmers;

import java.util.*;

public class P60061 { // 3 기둥과 보 설치
	
	public static void main(String[] args) {
		
		P60061 p = new P60061();
		
		int[][] build_frame = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},
				{5,1,0,1},{4,2,1,1},{3,2,1,1}};
		
		int[][] ans = p.solution(5, build_frame);
		for(int i = 0; i < ans.length; i++) {
			System.out.println(ans[i][0] + " " + ans[i][1] + " " + ans[i][2]);
		}
	}
	
	// build_frame의 원소는 [x, y, a, b]형태
	// a => 기둥 : 0, 보 : 1
	// b => 삭제 : 0, 설치 : 1
    public int[][] solution(int n, int[][] build_frame) {
        
        int[][] map = new int[n+1][n+1]; // 무언가 설치되면 1
        int[][] pillar = new int[n+1][n+1]; // 기둥
        int[][] bridge = new int[n+1][n+1]; // 보
        
        for(int i = 0; i < build_frame.length; i++) {
        	int x = build_frame[i][0];
        	int y = build_frame[i][1];
        	int a = build_frame[i][2];
        	int b = build_frame[i][3];
        	
        	if(b == 1) { // 설치
        		
        		if(a == 0) { // 기둥
        			if(y == 0) { // 바닥
        				map[y][x] = 1;
        				pillar[y][x] = 1;
        			}else { // 바닥 아닌 경우
        				if(pillar[y-1][x] == 1) { // 기둥 위
        					map[y][x] = 1;
            				pillar[y][x] = 1;
        				}else { // 보 위
        					if(x == 0) {
        						if(bridge[y][x] == 1) {
        							map[y][x] = 1;
        	        				pillar[y][x] = 1;
        						}
        					}else if(x == n) {
        						if(bridge[y][x-1] == 1) {
        							map[y][x] = 1;
        	        				pillar[y][x] = 1;
        						}
        					}else {
        						if(bridge[y][x] == 1 && bridge[y][x-1] == 0) {
        							map[y][x] = 1;
        	        				pillar[y][x] = 1;
        						}else if(bridge[y][x] == 0 && bridge[y][x-1] == 1) {
        							map[y][x] = 1;
        	        				pillar[y][x] = 1;
        						}
        					}
        				}
        			}
    			}else { // 보
    				if(pillar[y-1][x] == 1) {
    					map[y][x] = 1;
        				bridge[y][x] = 1;
    				}else if(pillar[y-1][x+1] == 1) {
    					map[y][x] = 1;
        				bridge[y][x] = 1;
    				}else { // 양 끝 보
    					if(x > 0 && x < n) {
    						if(bridge[y][x-1] == 1 && bridge[y][x+1] == 1) {
    							map[y][x] = 1;
    	        				bridge[y][x] = 1;
    						}
    					}
    				}
    			}
        	}else if(b == 0) { // 삭제
        		
        		if(a == 0) { // 기둥
        			if(x == 0) {
        				if(map[y+1][x] == 0) {
        					map[y][x] = 0;
        					pillar[y][x] = 0;
        				}else {
        					if(bridge[y+1][x] == 1) {
        						if(bridge[y+1][x+1] == 1) {
        							if(pillar[y][x+1] == 1 || pillar[y][x+2] == 1) {
        								map[y][x] = 0;
        	        					pillar[y][x] = 0;
        							}
        						}else {
        							if(pillar[y][x+1] == 1) {
        								map[y][x] = 0;
        	        					pillar[y][x] = 0;
        							}
        						}
        					}
        				}
        			}else if(x == n) {
        				
        			}else {
        				if(pillar[y+1][x] == 0) {
        					if(bridge[y+1][x] == 1 && bridge[y+1][x-1] == 1 && bridge[y+1][x+1] == 1) {
        						map[y][x] = 0;
	        					pillar[y][x] = 0;
        					}
        				}
        			}
        		}else { // 보
        			if(pillar[y-1][x] == 1 && pillar[y-1][x+1] == 1) {
        				map[y][x] = 0;
    					bridge[y][x] = 0;
        			}else if(pillar[y-1][x] == 1 && pillar[y-1][x+1] == 0){
        				if(x == n-1) {
        					map[y][x] = 0;
        					bridge[y][x] = 0;
        				}else {
        					if(bridge[y][x+1] == 1 && pillar[y-1][x+2] == 1) {
        						map[y][x] = 0;
            					bridge[y][x] = 0;
        					}
        				}
        			}else if(pillar[y-1][x] == 0 && pillar[y-1][x+1] == 1) {
        				if(x == 0) {
        					map[y][x] = 0;
        					bridge[y][x] = 0;
        				}else {
        					if(bridge[y][x-1] == 1 && pillar[y-1][x-1] == 1) {
        						map[y][x] = 0;
            					bridge[y][x] = 0;
        					}
        				}
        			}
        		}
        	}
        }
        
        ArrayList<int[]> ans = new ArrayList<>();
        for(int j = 0; j < n+1; j++) {
        	for(int i = 0; i < n+1; i++) {
        		if(pillar[i][j] == 1) {
        			ans.add(new int[] {j,i,0});
        		}
        		if(bridge[i][j] == 1) {
        			ans.add(new int[] {j,i,1});
        		}
        	}
        }
        
        int[][] answer = new int[ans.size()][];
        for(int i = 0; i < ans.size(); i++) {
        	answer[i] = ans.get(i);
        }
        
        return answer;
    }
}
