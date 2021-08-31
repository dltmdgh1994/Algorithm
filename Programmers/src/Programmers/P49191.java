package Programmers;

public class P49191 { // 3 순위

	public static void main(String[] args) {
		
		P49191 p = new P49191();
		
		int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		
		System.out.println(p.solution(5, results));
	}

	public int solution(int n, int[][] results) {
	    int answer = 0;
	    
	    int[][] player = new int[n][n];
 
	    for(int i = 0; i < results.length; i++) {
	    	player[results[i][0]-1][results[i][1]-1] = 1;
	    	player[results[i][1]-1][results[i][0]-1] = -1;
	    }
	    
	    // 다익스트라(Dijkstra) 알고리즘
	    // 하나의 정점에서 다른 모든 정점으로의 최단 경로를 구할 때 사용
	    
	    // 플로이드 와샬(Floyd Warshall) 알고리즘
	    // 모든 정점에서 모든 정점으로의 최단 경로를 구할 때 사용
	    
	    // k = 거쳐가는 노드
	    for(int k = 0; k < n; k++) {
	    	// i = 시작노드
	    	for(int i = 0; i < n; i++) {
	    		// j = 도착노드
	    		for(int j = 0; j < n; j++) {
	    			if(player[i][j] == 0) {
	    				if(player[i][k] == 1 && player[k][j] == 1) {
	    					player[i][j] = 1;
	    					player[j][i] = -1;
	    				}else if(player[i][k] == -1 && player[k][j] == -1) {
	    					player[i][j] = -1;
	    					player[j][i] = 1;
	    				}
	    			}
	    		}
	    	}
	    }
	    
	    for(int i = 0; i < n; i++) {
	    	int cnt = 0;
	    	
	    	for(int j = 0; j < n; j++) {
	    		if(player[i][j] != 0) cnt++;
	    	}
	    	
	    	if(cnt == n-1) answer++;
	    }
	    
	    return answer;
	}
}
