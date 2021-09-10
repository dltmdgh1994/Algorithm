package Programmers;

public class P72413 { // 3 합승 택시 요금

	public static void main(String[] args) {
		
		P72413 p = new P72413();

		int[][] fares = {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};
		
		System.out.println(p.solution(7, 3, 4, 1, fares));
	}
	
	// 지점의 개수 n, 출발지점을 나타내는 s, A의 도착지점을 나타내는 a, 
	// B의 도착지점을 나타내는 b, 지점 사이의 예상 택시요금을 나타내는 fares
	public int solution(int n, int s, int a, int b, int[][] fares) {
        
		int[][] roads = new int[n][n];
        
        for(int i = 0; i < fares.length; i++) {
        	roads[fares[i][0]-1][fares[i][1]-1] = fares[i][2];
        	roads[fares[i][1]-1][fares[i][0]-1] = fares[i][2];
        }
        
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		if(roads[i][j] == 0 && i != j) {
        			roads[i][j] = 10000000;
        		}
        	}
        }
        
        // 플로이드 와셜 알고리즘으로 모든 정점에서 다른 모든 정점으로 가는 최단거리 계산
        for(int k = 0; k < n; k++) {
        	for(int i = 0; i < n; i++) {
            	for(int j = 0; j < n; j++) {
            		if(roads[i][k] + roads[k][j] < roads[i][j]) {
            			roads[i][j] = roads[i][k] + roads[k][j];
            		}
            	}
            }
        }
        
        // 각자 따로 택시 타는 거리
        int min = roads[s-1][a-1] + roads[s-1][b-1];
        
        // 어느 한 지점까지 합승했을 때, 따로 탔을 때보다 적은지 확인
        for(int i = 0; i < n; i++) {
      	
      	    int tmp = roads[s-1][i] + roads[i][a-1] + roads[i][b-1];
      	
      	    if(tmp < min)  min = tmp;
        }
        
        return min;
    }
}
