package etc;

import java.io.*;

public class DQ_33 { // 퇴사

	BufferedReader br;
	BufferedWriter bw;
	
	public static void main(String[] args) {
		
		DQ_33 dq = new DQ_33();
		
		dq.sol();
	}

	public void sol() {
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));

			int n = Integer.parseInt(br.readLine());
			int[] tArr = new int[n];
			int[] pArr = new int[n];
			
			for(int i = 0; i < n; i++) {
				String[] s = br.readLine().split(" ");
				tArr[i] = Integer.parseInt(s[0]);
				pArr[i] = Integer.parseInt(s[1]);
			}
			
			int[] dp = new int[n+1];
			dp[tArr[0]] = pArr[0];
			for(int i = 1; i < n; i++) {
				int t = tArr[i];
				int p = pArr[i];
				
				int nt = i+t;
				if(nt <= n) {
					if(dp[i]+p > dp[nt]) {
						// 상담 가능 일수부터 값 채우기
						for(int j = nt; j <= n; j++) {
							dp[j] = dp[i]+p;
						}
					}
				}
			}
			
			int max = 0;
			for(int i = 1; i <= n; i++) {
				if(dp[i] > max) {
					max = dp[i];
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
