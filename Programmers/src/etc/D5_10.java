package etc;

import java.io.*;
import java.util.*;

public class D5_10 { // DFS/BFS 음료수 얼려 먹기
	
	BufferedReader br;
	BufferedWriter bw;

	int[] dx = {0,1,0,-1}; 
	int[] dy = {-1,0,1,0};

	public static void main(String[] args) {
		
		D5_10 p = new D5_10();
		
		p.sol();
	}
	
	public void sol() {
		int answer = 0;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String s[] = br.readLine().split(" ");
			int row = Integer.parseInt(s[0]);
			int col = Integer.parseInt(s[1]);
			
			int[][] map = new int[row][col];
			boolean[][] visited = new boolean[row][col];
			for(int i = 0; i < row; i++) {
				s = br.readLine().split("");
				
				for(int j = 0; j < col; j++) {
					map[i][j] = Integer.parseInt(s[j]);
				}
			}
			
			for(int i = 0; i < row; i++) {
				for(int j = 0; j < col; j++) {
					if(!visited[i][j] && map[i][j] == 0) {
						bfs(visited, map, i, j);
						answer++;
					}
				}
			}
			
			bw.write(Integer.toString(answer));

			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private void bfs(boolean[][] visited, int[][] map, int r, int c) {
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r, c});
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			
			int[] tmp = q.peek();
			int curX = tmp[0];
			int curY = tmp[1];
			q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nX = curX + dx[i];
				int nY = curY + dy[i];
				
				if(nX >= 0 && nY >= 0 && nX < map.length && nY < map[0].length) {
					if(!visited[nX][nY] && map[nX][nY] == 0) {
						q.add(new int[] {nX, nY});
						visited[nX][nY] = true;
					}
				}
			}
		}
	}
}
