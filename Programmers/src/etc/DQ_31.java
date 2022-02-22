package etc;

import java.io.*;

public class DQ_31 { // ±Ý±¤

	BufferedReader br;
	BufferedWriter bw;
	
	public static void main(String[] args) {
		
		DQ_31 dq = new DQ_31();
		
		dq.sol();
	}

	public void sol() {
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));

			int n = Integer.parseInt(br.readLine());
			int[] ans = new int[n];
			for(int i = 0; i < n; i++) {
				String[] s = br.readLine().split(" ");
				int col = Integer.parseInt(s[0]);
				int row = Integer.parseInt(s[1]);
				
				s = br.readLine().split(" ");
				int idx = 0;
				int[][] mine = new int[col][row];
				for(int j = 0; j < col; j++) {
					for(int k = 0; k < row; k++) {
						mine[j][k] = Integer.parseInt(s[idx++]);
					}
				}
				
				int[][] dp = new int[col][row];
				for(int j = 0; j < col; j++) {
					dp[j][0] = mine[j][0];
				}
				
				for(int j = 1; j < row; j++) {
					dp[0][j] = Math.max(dp[0][j-1], dp[1][j-1]) + mine[0][j];
					dp[col-1][j] = Math.max(dp[col-1][j-1], dp[col-2][j-1]) + mine[col-1][j];
					
					for(int k = 1; k < col-1; k++) {
						int tmp = Math.max(dp[k-1][j-1], dp[k][j-1]);
						dp[k][j] = Math.max(dp[k+1][j-1], tmp) + mine[k][j];  
					}
				}
				
				int max = 0;
				for(int j = 0; j < col; j++) {
					if(dp[j][row-1] > max) {
						max = dp[j][row-1];
					}
				}
				
				ans[i] = max;
			}
			
			for(int i = 0; i < n; i++) {
				bw.write(Integer.toString(ans[i]));
				bw.newLine();
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
