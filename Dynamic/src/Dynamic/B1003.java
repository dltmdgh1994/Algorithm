package Dynamic;

import java.io.*;

class B1003 { // 피보나치 수열
	BufferedReader br;
	BufferedWriter bw;
	
	int[] memo = new int[41];
	
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			memo[0] = 1;
			memo[1] = 1;
			
			for(int i = 2; i < 41; i++) {
				fibo(i);
			}
			
			int n = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < n; i++) {
				int a = Integer.parseInt(br.readLine());
				
				if(a == 0) {
					bw.write(Integer.toString(1)+" "+Integer.toString(0));
				}else if(a == 1) {
					bw.write(Integer.toString(0)+" "+Integer.toString(1));
				}else {
					bw.write(Integer.toString(memo[a-2])+" "+Integer.toString(memo[a-1]));
				}
				bw.newLine();
			}

			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private void fibo(int num) {
		memo[num] = memo[num-1] + memo[num-2];
	}
}