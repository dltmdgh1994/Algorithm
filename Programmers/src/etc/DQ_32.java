package etc;

import java.io.*;

public class DQ_32 { // Á¤¼ö »ï°¢Çü

	BufferedReader br;
	BufferedWriter bw;
	
	public static void main(String[] args) {
		
		DQ_32 dq = new DQ_32();
		
		dq.sol();
	}

	public void sol() {
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));

			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][];
			int[][] dp = new int[n][];
			for(int i = 0; i < n; i++) {
				arr[i] = new int[i+1];
				dp[i] = new int[i+1];
				
				String[] s = br.readLine().split(" ");
				for(int j = 0; j < i+1; j++) {
					arr[i][j] = Integer.parseInt(s[j]);
				}
			}
			
			dp[0][0] = arr[0][0];
			for(int i = 1; i < n; i++) {
				dp[i][0] = dp[i-1][0] + arr[i][0];
				dp[i][i] = dp[i-1][i-1] + arr[i][i-1];
				
				for(int j = 1; j < i; j++) {
					dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
				}
			}
			
			int max = 0;
			for(int i = 0; i < n; i++) {
				if(dp[n-1][i] > max) {
					max = dp[n-1][i];
				}
			}
			
			bw.write(Integer.toString(max));
			

			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
