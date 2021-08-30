package Programmers;

public class P43105 { // 3 Á¤¼ö »ï°¢Çü

	public static void main(String[] args) {
		
		P43105 p = new P43105();
		
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(p.solution(triangle));
	}

	public int solution(int[][] triangle) {
        int answer = 0;
        
        int[][] dp = new int[triangle.length][];
        for(int i = 0; i < triangle.length; i++){
            dp[i] = new int[triangle[i].length];
        }
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i < dp.length; i++){
        	dp[i][0] = dp[i-1][0] + triangle[i][0];
        	dp[i][i] += dp[i-1][i-1] + triangle[i][i];
        	
            for(int j = 1; j < dp[i].length-1; j++) {
            	dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
        }
        
        for(int i = 0; i < dp[dp.length-1].length; i++) {
        	if(dp[dp.length-1][i] > answer) {
        		answer = dp[dp.length-1][i];
        	}
        }
        
        return answer;
    }
}
