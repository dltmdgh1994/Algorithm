package Programmers;

public class P12913 { // 2 땅따먹기

	public static void main(String[] args) {
		
		P12913 p = new P12913();

		int[][] land = {{1,1,1,1}, {2,2,2,3}, {3,3,3,6}, {4,4,4,7}};
		
		System.out.println(p.solution(land));
	}
	
	// DFS/BFS 등 완전탐색에서는 효율성이 떨어지기 떄문에 DP 사용
	int solution(int[][] land) {
		
		int[][] dp = new int[land.length][land[0].length];
		
		for(int i = 0; i < 4; i++) {
			dp[0][i] = land[0][i];
		}
		
		for(int i = 1; i < land.length; i++) {
			for(int j = 0; j < 4; j++) {
				dp[i][j] = land[i][j] + findMax(dp, i-1, j);
			}
		}
		
		int max = 0;
		
		for(int i = 0; i < 4; i++) {
			if(dp[land.length-1][i] > max) {
				max = dp[land.length-1][i];
			}
		}
		
		return max;
    }
	
	private int findMax(int[][] dp, int row, int col) {
		
		int max = 0;
		
		for(int i = 0; i < 4; i++) {
			if(i != col) {
				if(dp[row][i] > max) {
					max = dp[row][i];
				}
			}
		}
		
		return max;
	}
	
	// dfs로 하니 시간 초과
//	int max = 0;
//	
//	private void dfs(int[][] land, int depth, int sum, int col) {
//		
//		if(depth == land.length) {
//			
//			if(sum > max) {
//				max = sum;
//			}
//			
//			return;
//		}
//		for(int i = 0; i < 4; i++) {
//			if(i != col) {
//				dfs(land, depth+1, sum+land[depth][i], i);
//			}
//		}
//	}
}
