package etc;

import java.io.*;

public class DQ_16 {

	BufferedReader br;
	BufferedWriter bw;
	
	int n; // ���� ����
	int m; // ���� ����
	int[][] map; // ���� �迭
	int[][] tmp; // ���̷��� ���� �� �迭
	int ans = 0;
	
	public static void main(String[] args) {
		
		DQ_16 dq = new DQ_16();
		
		dq.sol();
	}
	
	public void sol() { // ������
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));

			String[] s = br.readLine().split(" ");
			n = Integer.parseInt(s[0]);
			m = Integer.parseInt(s[1]);
			
			map = new int[n][m];
			tmp = new int[n][m];
			for(int i = 0; i < n; i++) {
				s = br.readLine().split(" ");
				for(int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(s[j]);
				}
			}
			
			dfs(0);
			bw.write(Integer.toString(ans));
			
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
				for(int j = 0; j < m; j++) {
					tmp[i][j] = map[i][j];
				}
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(tmp[i][j] == 2) {
						virus(i,j);
					}
				}
			}
			 
			int safeCnt = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(tmp[i][j] == 0) {
						safeCnt++;
					}
				}
			}
			
			if(ans < safeCnt) ans = safeCnt;
			
			return;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					cnt++;
					dfs(cnt);
					cnt--;
					map[i][j] = 0;
				}
			}
		}
	}
	
	int[] dx = {1,-1,0,0};
	int[] dy = {0,0,1,-1};
	
	// ���̷��� �۶߸���
	private void virus(int i, int j) {
		
		for(int k = 0; k < 4; k++) {
			int nx = i+dx[k];
			int ny = j+dy[k];
			
			if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
				if(tmp[nx][ny] == 0) {
					tmp[nx][ny] = 2;
					virus(nx,ny);
				}
			}
		}
	}
}
