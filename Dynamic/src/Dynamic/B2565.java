package Dynamic;

import java.io.*;

class B2565 { // ภüฑ๊มู
	BufferedReader br;
	BufferedWriter bw;
	
	public void sol() {  
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int ans = 0;
			
			int num = Integer.parseInt(br.readLine());
			int[][] dp = new int[num][3];
			for(int i = 0; i < num; i++) {
				String[] s = br.readLine().split(" ");
				dp[i][0] = Integer.parseInt(s[0]);
				dp[i][1] = Integer.parseInt(s[1]);
				dp[i][2] = 0;
			}
			
			for(int i = 0; i < num; i++) {
				int cnt = 0;
				for(int j = 0; j < num; j++) {
					if(i != j) {
						if(dp[i][0] < dp[j][0] && dp[i][1] > dp[j][1]) {
							cnt++;
						}else if(dp[i][0] > dp[j][0] && dp[i][1] < dp[j][1]) {
							cnt++;
						}
					}
				}
				dp[i][2] = cnt;
			}
			
			while(ans < 10) {
				int cnt = 0;
				int maxIdx = 0;
				int max = 0;
				for(int i = 0; i < num; i++) {
					if(dp[i][2] == 0) {
						cnt++;
					}
					
					if(dp[i][2] > max) {
						max = dp[i][2];
						maxIdx = i;
					}
				}
				
				if(cnt == num) {
					break;
				}
				
				dp[maxIdx][0] = -1;
				
				for(int i = 0; i < num; i++) {
					if((i != maxIdx) && (dp[i][0] != -1) && (dp[i][2] > 0)) {
						if(dp[i][0] < dp[maxIdx][0] && dp[i][1] > dp[maxIdx][1]) {
							dp[i][2]--;
						}else if(dp[i][0] > dp[maxIdx][0] && dp[i][1] < dp[maxIdx][1]) {
							dp[i][2]--;
						}
					}
				}
				
				dp[maxIdx][2] = 0;
				ans++;
				
				for(int i = 0; i < num; i++) {
					bw.write(Integer.toString(dp[i][2]) + " ");
				}
				bw.newLine();
			}
			
			bw.write(Integer.toString(ans));
			
						
			br.close();
			bw.close();
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
