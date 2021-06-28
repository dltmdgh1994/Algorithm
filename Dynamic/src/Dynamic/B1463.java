package Dynamic;

import java.io.*;

class B1463 { // 1�� �����
	
//	X�� 3���� ������ ��������, 3���� ������.
//	X�� 2�� ������ ��������, 2�� ������.
//	1�� ����
	
	BufferedReader br;
	BufferedWriter bw;
	
	int[] dp;
	int num;
	
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			num = Integer.parseInt(br.readLine());
			dp = new int[num+1];
			
			f(num, 0);
			
			bw.write(Integer.toString(dp[1]));

			br.close();
			bw.close();
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	// ó���� 1���� num���� �����ϴ� ������� ���� => �ð��ʰ�
	// num���� 1���� �����ϴ� ������� �����ϴ� �¾Ҵ�. => ���� �ܰ踦 �Ÿ� �� ����
	private void f(int n, int cnt) {
		if(n < 1) {
			return;
		}else{
			if(dp[n] == 0) {
				dp[n] = cnt;
			}else {
				if(dp[n] < cnt) {
					return;
				}else {
					dp[n] = cnt;
				}
			}
			
			cnt++;
			
			if(n%3 == 0) {
				f(n/3, cnt);
			}
			
			if(n%2 == 0) {
				f(n/2, cnt);
			}

			f(n-1, cnt);
		}
	}
}
