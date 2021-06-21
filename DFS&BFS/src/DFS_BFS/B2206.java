package DFS_BFS;

import java.io.*;
import java.util.*;

class B2206 {
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
			
			int cnt = bfs(0, 0, w, h);
			
			bw.write(Integer.toString(cnt));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private int bfs(int row, int col, int w, int h) {
		
		boolean flag = false;

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{row,col,1,1});
        visited[row][col] = true;

        while(!que.isEmpty()){
        	
        	int q[] = que.peek();
            int curX = q[0];
            int curY = q[1];
            int dist = q[2];
            int op = q[3];
            que.poll();
            

            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                if(nx == h-1 && ny == w-1) {
                	flag = true;
                	break;
                }

                if(nx >= 0 && ny >= 0 && nx < h && ny < w){
                    if(arr[nx][ny] == 0 && !visited[nx][ny]){
                        que.add(new int[]{nx,ny,dist+1,op});
                        visited[nx][ny] = true;
                    }else if(arr[nx][ny] == 1 && !visited[nx][ny] && op == 1) {
                    	que.add(new int[]{nx,ny,dist+1,0});
                        visited[nx][ny] = true;
                    }
                }
            }
            
            if(flag) {
            	return dist+1;
            }
        }
        
        return 0;
	}
}
