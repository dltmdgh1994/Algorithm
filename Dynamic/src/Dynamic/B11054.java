package Dynamic;

import java.io.*;

class B11054 {
	BufferedReader br;
	BufferedWriter bw;
	
	public void sol() { // ���� �� ������� �κ� ����
		
		// ���� S�� � �� Sk�� �������� S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN�� �����Ѵٸ�, 
		// �� ������ ������� �����̶�� �Ѵ�.
		
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
			
			// 0���� i���� �����ϴ� �κ� ������ ũ�� ����
			for(int i = 1; i < num; i++) {
				for(int j = i-1; j >= 0; j--) {
					// �ڽź��� ���� �� �� ���� ũ���� �ִ��� ã�´�.
					if(dp[i][0] > dp[j][0] && dp[i][1] < dp[j][1]) {
						dp[i][1] = dp[j][1];
					}
				}
				// ã�� �� �ڽŵ� �����ؾ� �ϹǷ� +1
				dp[i][1]++;	
			}
			
			// �Ųٷ� i���� 0���� �����ϴ� �κ� ������ ũ�� ����
			for(int i = num-2; i >= 0; i--) {
				for(int j = i+1; j <= num-1; j++) {
					if(dp[i][0] > dp[j][0] && dp[i][2] < dp[j][2]) {
						dp[i][2] = dp[j][2];
					}
				}
				dp[i][2]++;
			}
			
			// �����ϴ� �κ� ������ �����ϴ� �κ� ������ �� �� �ִ밪 ã��
			int max = 1;
			for(int i = 0; i < num; i++) {
				// ��ġ�� �����̹Ƿ� 1 ���ش�.
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
