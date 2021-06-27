package Dynamic;

import java.io.*;

class B1463 { // 1로 만들기
	
//	X가 3으로 나누어 떨어지면, 3으로 나눈다.
//	X가 2로 나누어 떨어지면, 2로 나눈다.
//	1을 뺀다
	
	BufferedReader br;
	BufferedWriter bw;
	
	int[] dp;
	boolean[] visited;
	int num;
	boolean flag = false;
	
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			num = Integer.parseInt(br.readLine());
			dp = new int[num+1];
			visited = new boolean[num+1];
			
			f(1, 0);
			
			bw.write(Integer.toString(dp[num]));

			br.close();
			bw.close();
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private void f(int n, int cnt) {
		if(n > num) {
			return;
		}else if(visited[n]) {
			return;
		}else if(n == num){
			flag = true;
			dp[n] = cnt;
			visited[n] = true;
		}else if(!flag){
			dp[n] = cnt;
			visited[n] = true;
			cnt++;
			
			f(n*3, cnt);
			f(n*2, cnt);
			f(n+1, cnt);
		}
	}
}
