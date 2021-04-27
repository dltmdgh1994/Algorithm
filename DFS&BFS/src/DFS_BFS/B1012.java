package DFS_BFS;

import java.io.*;
import java.util.*;

class B1012 { // 유기농 배추
	BufferedReader br;
	BufferedWriter bw;
	
	int[][] arr;
	boolean[][] visited;
	
	int dx[] = {0,0,1,-1};
    int dy[] = {1,-1,0,0};
	
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int totalNum = Integer.parseInt(br.readLine()); // 전체 반복 횟수
			
			for(int k = 0; k < totalNum; k++) {
				String s[] = br.readLine().split(" ");
				int w = Integer.parseInt(s[0]);
				int h = Integer.parseInt(s[1]);
				int n = Integer.parseInt(s[2]);
				
				arr = new int[h][w];
				visited = new boolean[h][w];
				for(int i = 0; i < n; i++) {
					s = br.readLine().split(" ");
					arr[Integer.parseInt(s[1])][Integer.parseInt(s[0])] = 1;
				}
				
				int cnt = 0; // 지렁이 수
				for(int i = 0; i < h; i++) {
					for(int j = 0; j < w; j++) {
						// 방문한 적이 없으면 dfs를 통해 visited 접근
						if(arr[i][j] != 0 && !visited[i][j]) {
							dfs(i, j, w, h);
							cnt++;
						}
					}
				}
				
				bw.write(Integer.toString(cnt));
				bw.newLine();
			}
			
			
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private void dfs(int row, int col, int w, int h) {
		
		Stack<int[]> stack = new Stack<>();
		stack.add(new int[] {row, col});
		visited[row][col] = true;
        
        while(!stack.isEmpty()) {
        	int curX = stack.peek()[0];
        	int curY = stack.peek()[1];
        	stack.pop();
        	
        	for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx >=0 && ny >=0 && nx < h && ny < w){
                    if(arr[nx][ny] == 1 && !visited[nx][ny]){
                        stack.add(new int[] {nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
	}
}
