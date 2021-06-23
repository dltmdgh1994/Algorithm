package Dynamic;

import java.io.*;

class B9461 { // 파도반 수열
	BufferedReader br;
	BufferedWriter bw;
	
	// int형으로 선언하면 범위를 초과한다.
	long[] memo = new long[100];
	
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			memo[0] = 1;
			memo[1] = 1;
			memo[2] = 1;
			memo[3] = 2;
			memo[4] = 2;
			
			for(int i = 5; i < 100; i++) {
				f(i);
			}
			
			int num = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < num; i++) {
				int n = Integer.parseInt(br.readLine());
				bw.write(Long.toString(memo[n-1]));
				bw.newLine();
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private void f(int n) {
		memo[n] = memo[n-1] + memo[n-5];
	}
}
