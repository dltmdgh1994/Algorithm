package Programmers;

public class P43162 { // 3 네트워크

	public static void main(String[] args) {
		
		P43162 p = new P43162();
		
		int[][] net = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		System.out.println(p.solution(3, net));
	}
	
	public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
        	if(!visited[i]) {
        		visited[i] = true;
    			dfs(n, computers, visited, i);
    			answer++;
    		}
        }
        
        return answer;
    }
	
	private void dfs(int n, int[][] computers, boolean[] visited, int row) {

		for(int i = 0; i < n; i++) {
			if(!visited[i] && computers[row][i] == 1) {
				visited[i] = true;
				
				dfs(n, computers, visited, i);
			}
		}
	}
}
