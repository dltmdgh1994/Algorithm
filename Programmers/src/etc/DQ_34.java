package etc;

import java.io.*;

public class DQ_34 { // 병사 배치하기

	BufferedReader br;
	BufferedWriter bw;
	
	public static void main(String[] args) {
		
		DQ_34 dq = new DQ_34();
		
		dq.sol();
	}

	public void sol() {
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));

			int n = Integer.parseInt(br.readLine());
			int[] att = new int[n];
			int[] dp = new int[n];
			
			String[] s = br.readLine().split(" ");
			for(int i = 0; i < n; i++) {
				att[i] = Integer.parseInt(s[n-i-1]);
				dp[i] = 1;
			}
			
			// 가장 긴 증가하는 부분 수열의 길이
			for(int i = 1; i < n; i++) {
				for(int j = 0; j < i; j++) {
					if(att[i] > att[j]) {
						dp[i] = Math.max(dp[i], dp[j]+1);
					}
				}
			}
			
			int max = 0;
			for(int i = 0; i < n; i++) {
				if(dp[i] > max) {
					max = dp[i];
				}
			}
			
			bw.write(Integer.toString(n-max));

			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
