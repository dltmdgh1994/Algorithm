package etc;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class DQ_39 { // 화성 탐사

	BufferedReader br;
	BufferedWriter bw;
	
	public static void main(String[] args) {
		
		DQ_39 dq = new DQ_39();
		
		dq.sol();
	}

	public void sol() {
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));

			int n = Integer.parseInt(br.readLine());
			int[] ans = new int[n];
			for(int i = 0; i < n; i++) {
				int len = Integer.parseInt(br.readLine());
				int[][] arr = new int[len][len];
				for(int j = 0; j < len; j++) {
					String[] s = br.readLine().split(" ");
					for(int k = 0; k < len; k++) {
						arr[j][k] = Integer.parseInt(s[k]);
					}
				}
				
				int[][] dist = new int[len][len];
				ans[i] = bfs(arr, dist, len);
			}
			
			for(int i = 0; i < n; i++) {
				bw.write(Integer.toString(ans[i]));
				bw.newLine();
			}

			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	int[] dx = {1,-1,0,0};
	int[] dy = {0,0,1,-1};
	
	// bfs를 통해 최단 경로 탐색
	private int bfs(int[][] arr, int[][] dist, int len) {
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0,arr[0][0]});
		dist[0][0] = arr[0][0];
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int x = tmp[0];
			int y = tmp[1];
			int d = tmp[2];
			
			for(int i = 0; i < 4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < len && ny < len) {
					if(dist[nx][ny] != 0) { // 방문한 적이 있는 경우
						if(dist[nx][ny] > d+arr[nx][ny]) { // 기존 값보다 작으면
							q.add(new int[] {nx,ny,d+arr[nx][ny]});
							dist[nx][ny] = d+arr[nx][ny];
						}
					}else { // 방문한 적이 없는 경우
						q.add(new int[] {nx,ny,d+arr[nx][ny]});
						dist[nx][ny] = d+arr[nx][ny];
					}
				}
			}
		}
		
		return dist[len-1][len-1];
	}
}
