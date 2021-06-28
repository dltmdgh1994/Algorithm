package Dynamic;

import java.io.*;

class B1463 { // 1로 만들기
	
//	X가 3으로 나누어 떨어지면, 3으로 나눈다.
//	X가 2로 나누어 떨어지면, 2로 나눈다.
//	1을 뺀다
	
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
	
	// 처음에 1부터 num까지 증가하는 방식으로 진행 => 시간초과
	// num에서 1까지 감소하는 방식으로 진행하니 맞았다. => 일정 단계를 거를 수 있음
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
