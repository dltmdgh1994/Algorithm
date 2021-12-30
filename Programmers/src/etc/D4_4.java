package etc;

import java.io.*;
import java.util.*;

public class D4_4 {
	
	BufferedReader br;
	BufferedWriter bw;
	
	// ºÏ,µ¿,³²,¼­
	int[] dx = {0,1,0,-1}; 
	int[] dy = {-1,0,1,0};

	public static void main(String[] args) {
		
		D4_4 p = new D4_4();
		
		p.sol();
	}
	
	public void sol() {
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String s[] = br.readLine().split(" ");
			int row = Integer.parseInt(s[0]);
			int col = Integer.parseInt(s[1]);
			
			s = br.readLine().split(" ");
			int r = Integer.parseInt(s[0]);
			int c = Integer.parseInt(s[1]);
			int d = Integer.parseInt(s[2]);
			
			int[][] map = new int[row][col];
			boolean[][] visited = new boolean[row][col];
			for(int i = 0; i < row; i++) {
				s = br.readLine().split(" ");
				
				for(int j = 0; j < col; j++) {
					map[i][j] = Integer.parseInt(s[j]);
				}
			}
			
			int answer = dfs(map, visited, r, c, d);
			
			bw.write(Integer.toString(answer));

			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private int turn(int d) {
		int direction;
		
		if(d == 3) {
			direction = 0;
		}else {
			direction = d+1;
		}
		
		return direction;
	}
	
	private int dfs(int[][] map, boolean[][] visited, int r, int c, int d) {
		
		Stack<int[]> stack = new Stack<>();
		stack.add(new int[] {r,c});
		visited[r][c] = true;
		int direction = d;
		int cnt = 1;
		
		while(!stack.isEmpty()) {
			
			int[] tmp = stack.peek();
			int curR = tmp[0];
			int curC = tmp[1];
			stack.pop();
			
			for(int i = 0; i < 4; i++) {
				direction = turn(direction);
				int nR = curR + dy[direction];
				int nC = curC + dx[direction];
				
				if(nR >=0 && nC >=0 && nR < map.length && nC < map[0].length){
					if(map[nR][nC] == 0 && !visited[nR][nC]) {
						stack.push(new int[] {nR, nC});
						visited[nR][nC] = true;
						cnt++;
					}
				}
			}
		}
		
		return cnt;
	}
}
