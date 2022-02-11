package etc;

import java.io.*;

public class DQ_20 { // ���� ���ϱ�
	
	BufferedReader br;
	BufferedWriter bw;
	
	int n;
	int[][] map; // ���� �迭
	int[][] tmp; // ��ֹ� ��ġ �� �迭
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
	
	// ���� 3������ ��ġ �����ϹǷ� ��� ��츦 ���
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
	
	// �л� Ȯ��
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
		
		return true; // ���ÿ� �� �ɸ�
	}
}
