package Dynamic;

import java.io.*;

class B11054 {
	BufferedReader br;
	BufferedWriter bw;
	
	public void sol() { // 가장 긴 바이토닉 부분 수열
		
		// 수열 S가 어떤 수 Sk를 기준으로 S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN을 만족한다면, 
		// 그 수열을 바이토닉 수열이라고 한다.
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			
			int[][] dp = new int[num][3];
			for(int i = 0; i < num; i++) {
				dp[i][0] = Integer.parseInt(s[i]);
				
			}
			dp[0][1] = 1;
			dp[num-1][2] = 1;
			
			// 0부터 i까지 증가하는 부분 수열의 크기 측정
			for(int i = 1; i < num; i++) {
				for(int j = i-1; j >= 0; j--) {
					// 자신보다 낮은 수 중 수열 크기의 최댓값을 찾는다.
					if(dp[i][0] > dp[j][0] && dp[i][1] < dp[j][1]) {
						dp[i][1] = dp[j][1];
					}
				}
				// 찾은 뒤 자신도 포함해야 하므로 +1
				dp[i][1]++;	
			}
			
			// 거꾸로 i부터 0까지 증가하는 부분 수열의 크기 측정
			for(int i = num-2; i >= 0; i--) {
				for(int j = i+1; j <= num-1; j++) {
					if(dp[i][0] > dp[j][0] && dp[i][2] < dp[j][2]) {
						dp[i][2] = dp[j][2];
					}
				}
				dp[i][2]++;
			}
			
			// 증가하는 부분 수열과 감소하는 부분 수열의 합 중 최대값 찾기
			int max = 1;
			for(int i = 0; i < num; i++) {
				// 겹치는 지점이므로 1 빼준다.
				int sum = dp[i][1] + dp[i][2] - 1;
				if(sum > max) {
					max = sum;
				}
			}
			
			bw.write(Integer.toString(max));
						
			br.close();
			bw.close();
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
