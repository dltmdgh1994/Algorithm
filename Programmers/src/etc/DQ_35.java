package etc;

import java.io.*;

public class DQ_35 { // 못 생긴 수
	
	BufferedReader br;
	BufferedWriter bw;
	
	public static void main(String[] args) {
		
		DQ_35 dq = new DQ_35();
		
		dq.sol();
	}

	public void sol() {
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));

			int n = Integer.parseInt(br.readLine());
			int[] dp = new int[1000];
			int i2 = 0;
			int i3 = 0;
			int i5 = 0;
			int next2 = 2;
			int next3 = 3;
			int next5 = 5;
			
			dp[0] = 1;
			for(int i = 1; i < 1000; i++) {
				dp[i] = min(next2, next3, next5);
				
				if(dp[i] == next2) {
					i2++;
					next2 = dp[i2]*2;
				}
				if(dp[i] == next3) {
					i3++;
					next3 = dp[i3]*3;
				}
				if(dp[i] == next5) {
					i5++;
					next5 = dp[i5]*5;
				}
			}
			
			bw.write(Integer.toString(dp[n-1]));

			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private int min(int a, int b, int c) {
		int min = Math.min(a, b);
		min = Math.min(min, c);
		
		return min;
	}
}
