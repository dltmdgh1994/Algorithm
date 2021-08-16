package Programmers;

import java.util.*;

public class P49189 { // 3 가장 먼 노드

	public static void main(String[] args) {
		
		P49189 p = new P49189();
		
		int[][] vertex = {{3,6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2}};
		
		p.solution(6, vertex);
	}

	public int solution(int n, int[][] edge) {

        int[] visited = new int[n];
        // 길이 있으면 1, 없으면 0
        ArrayList<HashSet<Integer>> roads = new ArrayList<>();
        for(int i = 0; i < edge.length; i++) {
        	roads.add(new HashSet<Integer>());
        }
        
        for(int i = 0; i < edge.length; i++) {
        	int from = edge[i][0]-1;
        	int to = edge[i][1]-1;
        	
        	roads.get(from).add(to);
        	roads.get(to).add(from);
        }
        
        int answer = bfs(roads, visited, n);
        
        return answer;
    }
	
	private int bfs(ArrayList<HashSet<Integer>> roads, int[] visited, int n) {
		
		Queue<int[]> q = new LinkedList<>();
		int max = 0;
		int cnt = 0;

		q.add(new int[] {0,0});
		
		while(!q.isEmpty()) {
			
			int node = q.peek()[0];
			int dist = q.peek()[1];
			q.poll();
			
			if(node != 0) {
				if(max < dist) {
					max = dist;
					cnt = 1;
					
				}else if(max == dist) {
					cnt++;
				}
			}
			
			for(int i = 0; i < n; i++) {
				
				if(roads.get(i).contains(node)) { // 길이 있는 경우
					
					int d = dist+1;
					
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
		
		return cnt;
	}
}
