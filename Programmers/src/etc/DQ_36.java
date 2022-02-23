package etc;

import java.io.*;

public class DQ_36 { // 편집 거리

	BufferedReader br;
	BufferedWriter bw;
	
	public static void main(String[] args) {
		
		DQ_36 dq = new DQ_36();
		
		dq.sol();
	}

	public void sol() {
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));

			char[] start = br.readLine().toCharArray();
			char[] end = br.readLine().toCharArray();
			
			int[][] dp = new int[start.length+1][end.length+1];
			
			for(int i = 0; i < start.length+1; i++) {
				dp[i][0] = i;
			}
			
			for(int i = 1; i < end.length+1; i++) {
				dp[0][i] = i;
			}
			
			for(int i = 1; i < start.length+1; i++) {
				for(int j = 1; j < end.length+1; j++) {
					if(start[i-1] == end[j-1]) {
						dp[i][j] = dp[i-1][j-1];
					}else {
						dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1;
					}
				}
			}
			
			bw.write(Integer.toString(dp[start.length][end.length]));

			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private int min(int a, int b, int c) {
		int min = Math.min(a, b);
		min = Math.min(min, c);
		
		return min;
	}
}
