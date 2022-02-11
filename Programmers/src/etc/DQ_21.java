package etc;

import java.io.*;
import java.util.*;

public class DQ_21 { // 인구 이동

	BufferedReader br;
	BufferedWriter bw;
	
	int n;
	int l;
	int r;
	
	public static void main(String[] args) {
		
		DQ_21 dq = new DQ_21();
		
		dq.sol();
	}
	
	public void sol() {
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));

			String[] s = br.readLine().split(" ");
			n = Integer.parseInt(s[0]);
			l = Integer.parseInt(s[1]);
			r = Integer.parseInt(s[2]);
			
			int[][] map = new int[n][n];
			for(int i = 0; i < n; i++) {
				s = br.readLine().split(" ");
				for(int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(s[j]);
				}
			}
			
			int ans = 0;
			while(true) { // 인구 이동할 필요가 없을 때까지 진행
				boolean[][] visited = new boolean[n][n];
				boolean pass = false;
				
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < n; j++) {
						if(!visited[i][j]) {
							if(dfs(map, visited, i, j)) {
								pass = true;
							}
						}
					}
				}
				
				if(!pass) {
					break;
				}else {
					ans++;
				}
			}
			
			bw.write(Integer.toString(ans));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	int[] dx = {1,-1,0,0};
	int[] dy = {0,0,1,-1};
	
	private boolean dfs(int[][] map, boolean[][] visited, int x, int y) {
		
		int cnt = 0;
		
		Queue<int[]> q = new LinkedList<>();
		ArrayList<int[]> arr = new ArrayList<>(); // 연합국 리스트
		
		q.add(new int[] {x,y,map[x][y]});
		arr.add(new int[] {x,y});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] data = q.poll();
			int curX = data[0];
			int curY = data[1];
			int p = data[2];
			
			for(int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
					if(!visited[nx][ny]) {
						int diff = Math.abs(p-map[nx][ny]);
						
						if(diff >= l && diff <= r) {
							q.add(new int[] {nx,ny,map[nx][ny]});
							arr.add(new int[] {nx,ny});
							visited[nx][ny] = true;
							cnt++;
						}
					}
				}
			}
		}
		
		// 연합한 나라가 있다면 인구 토합
		if(cnt > 0) {
			int sum = 0;
			for(int[] xy : arr) {
				sum += map[xy[0]][xy[1]];
			}
			
			int result = sum / arr.size();
			for(int[] xy : arr) {
				map[xy[0]][xy[1]] = result;
			}
			
			return true;
		}else {
			return false;
		}
	}
}
