package DFS_BFS;

import java.io.*;

class B2667 { // 단지 번호 붙이기
	BufferedReader br;
	BufferedWriter bw;
	
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[n][n];
			for(int i = 0; i < n; i++) {
				String str[] = br.readLine().split("");
				for(int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(str[j]);
				}
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(arr[i][j] != 0) {
						dfs(arr, i, j);
					}
				}
			}
			
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private void dfs(int[][] arr, int row, int col) {
		
	}
}
