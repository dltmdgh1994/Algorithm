package Dynamic;

import java.io.*;

class B10844 { // ���� ��� ��
	BufferedReader br;
	BufferedWriter bw;

	
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine());
			// j�� �����ϴ� i�ڸ� ��� ����
			int[][] dp = new int[num+1][10];
			for(int i = 0; i < 10; i++) {
				dp[1][i] = 1;
			}
			
			// ���ڰ� �ʹ� Ŀ�� % ����
			for(int i = 2; i <= num; i++) {
				dp[i][0] = (dp[i-1][1])%1000000000;
				
				for(int j = 1; j < 9; j++) {
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%1000000000;
				}
				
				dp[i][9] = (dp[i-1][8])%1000000000;
			}
			
			int ans = 0;
			for(int i = 1; i < 10; i++) {
				ans = (dp[num][i] + ans)%1000000000;
			}
			
			bw.write(Integer.toString(ans));

			br.close();
			bw.close();
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	// �ð� �ʰ�...
	// ��� ���� �߿��Ѱ� �ƴ϶� ������ ����
//	private void f(int[] dp, int pos) {
//		
//		if(pos == num) {
//			cnt++;
//			return;
//		}
//		
//		int a = dp[pos-1];
//		if(a == 9) {
//			dp[pos] = a-1;
//			f(dp, pos+1);
//		}else if(a == 0) {
//			dp[pos] = a+1;
//			f(dp, pos+1);
//		}else {
//			dp[pos] = a+1;
//			f(dp, pos+1);
//			
//			dp[pos] = a-1;
//			f(dp, pos+1);
//		}
//	}
}
