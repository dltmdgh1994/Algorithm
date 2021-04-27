package DFS_BFS;

import java.util.*;
import java.io.*;

class B2178 {
	BufferedReader br;
	BufferedWriter bw;
	
	int[][] arr;
	boolean[][] visited;
	int cnt = 0;
	
	int dx[] = {0,0,1,-1};
    int dy[] = {1,-1,0,0};
	
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String s[] = br.readLine().split(" ");
			int h = Integer.parseInt(s[0]);
			int w = Integer.parseInt(s[1]);
			
			arr = new int[h][w];
			visited = new boolean[h][w];
			for(int i = 0; i < h; i++) {
				s = br.readLine().split("");
				for(int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(s[j]);
				}
			}
			
			bfs(0, 0, w, h);
			
			bw.write(Integer.toString(cnt));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private void bfs(int row, int col, int w, int h) {

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{row,col});
        visited[row][col] = true;

        while(!que.isEmpty()){

            int curX = que.peek()[0];
            int curY = que.peek()[1];
            que.poll();
            
            cnt++;

            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                if(nx == h-1 && ny == w-1) {
                	cnt++;
                	return;
                }

                if(nx >= 0 && ny >= 0 && nx < h && ny < w){
                    if(arr[nx][ny] == 1 && !visited[nx][ny]){
                        que.add(new int[]{nx,ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            
        }
	}
}
