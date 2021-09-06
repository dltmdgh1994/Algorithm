package Programmers;

public class P12900 { // 3 2 x n Ÿ�ϸ�

	public static void main(String[] args) {
		
		P12900 p = new P12900();
		
		System.out.println(p.solution(4));
	}
	
	public int solution(int n) {
        
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        
        for(int i = 2; i < n; i++) {
        	dp[i] = (dp[i-1]+dp[i-2])%1000000007;
        }
        
        return dp[n-1];
    }
}
