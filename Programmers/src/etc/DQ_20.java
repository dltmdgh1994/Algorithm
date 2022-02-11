package etc;

import java.io.*;

public class DQ_20 { // 감시 피하기
	
	BufferedReader br;
	BufferedWriter bw;
	
	int n;
	int[][] map; // 원본 배열
	int[][] tmp; // 장애물 배치 후 배열
	boolean ans = false;

	public static void main(String[] args) {
		
		DQ_20 dq = new DQ_20();
		
		dq.sol();
	}
	
	public void sol() {
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));

			n = Integer.parseInt(br.readLine());
			
			map = new int[n][n];
			tmp = new int[n][n];

			for(int i = 0; i < n; i++) {
				String[] s = br.readLine().split(" ");
				for(int j = 0; j < n; j++) {
					if(s[j].equals("X")) {
						map[i][j] = 0;
					}else if(s[j].equals("S")) {
						map[i][j] = 1;
					}else {
						map[i][j] = 2;
					}
				}
			}
			
			dfs(0);
			
			if(ans) {
				bw.write("YES");
			}else {
				bw.write("NO");
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	// 벽을 3개까지 설치 가능하므로 모든 경우를 고려
	private void dfs(int cnt) {
		
		if(cnt == 3) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					tmp[i][j] = map[i][j];
				}
			}
			
			boolean isStudent = false;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(tmp[i][j] == 2) {
						if(!check(i,j)) {
							isStudent = true;
						}
					}
				}
			}
			
			if(!isStudent) ans = true;
			
			return;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 3;
					cnt++;
					dfs(cnt);
					cnt--;
					map[i][j] = 0;
				}
			}
		}
	}
	
	// 학생 확인
	private boolean check(int x, int y) {
		
		for(int i = x+1; i < n; i++) {
			if(tmp[i][y] == 1) {
				return false;
			}else if(tmp[i][y] == 3) {
				break;
			}
		}
		
		for(int i = x-1; i >= 0; i--) {
			if(tmp[i][y] == 1) {
				return false;
			}else if(tmp[i][y] == 3) {
				break;
			}
		}
		
		for(int i = y+1; i < n; i++) {
			if(tmp[x][i] == 1) {
				return false;
			}else if(tmp[x][i] == 3) {
				break;
			}
		}
		
		for(int i = y-1; i >= 0; i--) {
			if(tmp[x][i] == 1) {
				return false;
			}else if(tmp[x][i] == 3) {
				break;
			}
		}
		
		return true; // 감시에 안 걸림
	}
}
