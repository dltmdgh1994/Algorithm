package Dynamic;

import java.io.*;

class B1904 { // 01타일
	BufferedReader br;
	BufferedWriter bw;
	
	int[] memo = new int[1000000];
	
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			memo[0] = 1;
			memo[1] = 2;
			
			for(int i = 2; i < 1000000; i++) {
				fibo(i);
			}
			
			int n = Integer.parseInt(br.readLine());
			
			bw.write(Integer.toString(memo[n-1]));

			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private void fibo(int num) {
		// 결과마다 15746의 나머지 값으로 계산하지 않으면 오버플로우가 발생한다.
		memo[num] = (memo[num-1] + memo[num-2])%15746;
	}
}
