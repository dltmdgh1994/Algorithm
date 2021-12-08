package Programmers;

import java.util.Arrays;

public class P42884 { // 3 단속카메라
	
	public static void main(String[] args) {
		
		P42884 p = new P42884();
		
		int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
		System.out.println(p.solution(routes));
	}
	
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        boolean[] visited = new boolean[routes.length];
        
        for(int i = 0; i < routes.length; i++) {
        	if(!visited[i]) {
        		int base = routes[i][1];
        		
        		for(int j = i; j < routes.length; j++) {
        			if(routes[j][0] <= base && routes[j][1] >= base) {
        				visited[j] = true;
        			}else {
        				i = j;
        				break;
        			}
        		}
        		
        		answer++;
        	}
        }
        
        return answer;
    }
}
