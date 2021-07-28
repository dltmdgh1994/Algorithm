package Programmers;

import java.util.*;

public class P12978 { // 배달
	
	public static void main(String[] args) {
		P12978 p = new P12978();

		int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		
		System.out.println(p.solution(5, road, 3));
	}
	
	HashSet<Integer> set;
	
	public int solution(int N, int[][] road, int K) {
        int answer = 0;

        set = new HashSet<>();
        
        int[][] roads = new int[N][N];
        int[] visited = new int[N];
        
        for(int i = 0; i < road.length; i++) {
        	
        	int b1 = road[i][0]-1;
        	int b2 = road[i][1]-1;
        	int dist = road[i][2];
        	
        	// 마을에서 마을로 길이 여러 개인 경우가 존재해서
        	// 최단거리만 배열에 저장(역방향도)
        	if(roads[b1][b2] == 0 || roads[b1][b2] > dist) {
        		roads[b1][b2] = roads[b2][b1] = dist;
        	}
        	
        	// 정방향, 역방향, 현재거리 3개를 비교하려해서 길어짐
        	// 애초에 최단거리일 때만 저장하면 이럴 필요가 없다.
//        	if(roads[b1][b2] != 0 && roads[b2][b1] != 0) {
//        		if(roads[b1][b2] < roads[b2][b1]) {
//        			if(roads[b1][b2] < dist) {
//        				roads[b2][b1] = roads[b1][b2];
//        			}else {
//        				roads[b1][b2] = dist;
//        				roads[b2][b1] = dist;
//        			}
//        		}else if(roads[b1][b2] > roads[b2][b1]) {
//        			if(roads[b2][b1] < dist) {
//        				roads[b1][b2] = roads[b2][b1];
//        			}else {
//        				roads[b1][b2] = dist;
//        				roads[b2][b1] = dist;
//        			}
//        		}else {
//        			if(roads[b1][b2] > dist) {
//        				roads[b1][b2] = dist;
//        				roads[b2][b1] = dist;
//        			}
//        		}
//        	}else if(roads[b1][b2] != 0 && roads[b2][b1] == 0) {
//        		if(roads[b1][b2] < dist) {
//    				roads[b2][b1] = roads[b1][b2];
//    			}else {
//    				roads[b1][b2] = dist;
//    				roads[b2][b1] = dist;
//    			}
//        	}else if(roads[b2][b1] != 0 && roads[b1][b2] == 0) {
//        		if(roads[b2][b1] < dist) {
//    				roads[b1][b2] = roads[b2][b1];
//    			}else {
//    				roads[b1][b2] = dist;
//    				roads[b2][b1] = dist;
//    			}
//        	}else {
//        		roads[b1][b2] = dist;
//				roads[b2][b1] = dist;
//        	}
        }
        
        bfs(roads, visited, N, K);
        
        answer = set.size();

        return answer;
    }
	
	private void bfs(int[][] roads, int[] visited, int N, int k) {
		
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] {0,0});
		
		while(!q.isEmpty()) {
			
			int viliage = q.peek()[0];
			int dist = q.peek()[1];
			q.poll();
			
			if(dist <= k) {
				set.add(viliage+1);
				
				for(int i = 0; i < N; i++) {
					
					if(roads[viliage][i] != 0) { // 길이 있는 경우
						
						int d = dist+roads[viliage][i];
						
						if(visited[i] == 0) { // 처음 방문한 경우
							visited[i] = d;
							q.add(new int[] {i, d});
						}else if(d < visited[i]) { // 방문한 적 있는데 최단거리가 아님
							visited[i] = d;
							q.add(new int[] {i, d});
						}
					}
				}
			}
		}
	}
}
