package Dynamic;

import java.io.*;

class B1463 { // 1�� �����
	
//	X�� 3���� ������ ��������, 3���� ������.
//	X�� 2�� ������ ��������, 2�� ������.
//	1�� ����
	
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
