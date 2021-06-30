package Dynamic;

import java.io.*;

class B11053 { //���� �� �����ϴ� �κ� ����
	
	BufferedReader br;
	BufferedWriter bw;
	
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			
			int[][] dp = new int[num][2];
			for(int i = 0; i < num; i++) {
				dp[i][0] = Integer.parseInt(s[i]);
			}
			dp[0][1] = 1;
			
			int max = 1;
			for(int i = 1; i < num; i++) {
				for(int j = i-1; j >= 0; j--) {
					// �ڽź��� ���� �� �� ���� ũ���� �ִ��� ã�´�.
					if(dp[i][0] > dp[j][0] && dp[i][1] < dp[j][1]) {
						dp[i][1] = dp[j][1];
					}
				}
				// ã�� �� �ڽŵ� �����ؾ� �ϹǷ� +1
				dp[i][1]++;
				
				if(dp[i][1] > max) {
					max = dp[i][1];
				}
			}
			
			bw.write(Integer.toString(max));
			
//			int[][] dp = new int[num][2];
//			dp[0][0] = Integer.parseInt(s[0]);
//			dp[0][1] = 1;
//
//			int[] max = new int[] {0, 0};
//			int[] min = new int[] {dp[0][0], 0};
//			
//			for(int i = 1; i < num; i++) {
//				dp[i][0] = Integer.parseInt(s[i]);
//				
//				// �ּ��� ���
//				if(dp[i][0] <= min[0]) {
//					min[0] = dp[i][0];
//					min[1] = i;
//					dp[i][1] = 1;
//					continue;
//				}
//				
//				// �ִ��� ���
//				if(dp[i][0] > max[0]) {
//					if(max[1] == i-1) {
//						dp[i][1] = dp[i-1][1] + 1;
//					}else {
//						if(dp[max[1]][1] < dp[i-1][1]) {
//							dp[i][1] = dp[i-1][1] + 1;
//						}else if(dp[max[1]][1] > dp[i-1][1]){
//							dp[i][1] = dp[max[1]][1] + 1;
//						}else {
//							dp[i][1] = dp[i-1][1];
//						}
//					}		
//					
//					max[0] = dp[i][0];
//					max[1] = i;
//					continue;
//				}
//				
//				// �ִ�, �ּҰ� �ƴѰ��
//				if(dp[i][0] > dp[i-1][0]) {
//					dp[i][1] = dp[i-1][1] + 1;
//				}else if(dp[i][0] < dp[i-1][0]) {
//					int localmax = 0;
//					int idx = 0;
//					for(int j = i-1; j >= 0; j--) {
//						if(dp[j][0] < dp[i][0]) {
//							if(dp[j][1] > localmax) {
//								localmax = dp[j][1];
//								idx = j;
//							}
//						}
//					}
//					dp[i][1] = dp[idx][1] + 1;
//					
//				}else {
//					dp[i][1] = dp[i-1][1];
//				}	
//			}
//			
//			int ans = 0;
//			for(int i = 0; i < num; i++) {
//				if(dp[i][1] > ans) {
//					ans = dp[i][1];
//				}
//			}
//			
//			bw.write(Integer.toString(ans));
			
			
			br.close();
			bw.close();
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
