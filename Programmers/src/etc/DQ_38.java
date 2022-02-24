package etc;

import java.io.*;

public class DQ_38 { // 정확한 순위
	
	BufferedReader br;
	BufferedWriter bw;
	
	public static void main(String[] args) {
		
		DQ_38 dq = new DQ_38();
		
		dq.sol();
	}

	public void sol() {
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));

			String[] s = br.readLine().split(" ");
			int sNum = Integer.parseInt(s[0]);
			int n = Integer.parseInt(s[1]);
			int[][] graph = new int[sNum][sNum];
			
			for(int i = 0; i < n; i++) {
				s = br.readLine().split(" ");
				int s1 = Integer.parseInt(s[0])-1;
				int s2 = Integer.parseInt(s[1])-1;
				
				graph[s1][s2] = -1;
				graph[s2][s1] = 1;
			}
			
			for(int k = 0; k < sNum; k++) {
				for(int i = 0; i < sNum; i++) {
					for(int j = 0; j < sNum; j++) {
						if(i != j) {
							if(graph[i][j] == 0) {
								if(graph[i][k] == 1 && graph[k][j] == 1) {
									graph[i][j] = 1;
								}else if(graph[i][k] == -1 && graph[k][j] == -1) {
									graph[i][j] = -1;
								}
							}
						}
					}
				}
			}
			
			int answer = 0;
			for(int i = 0; i < sNum; i++) {
				int cnt = 0;
				for(int j = 0; j < sNum; j++) {
					if(graph[i][j] != 0) cnt++;
				}
				
				if(cnt == sNum-1) answer++;
			}
			
			bw.write(Integer.toString(answer));

			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
