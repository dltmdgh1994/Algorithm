package DFS_BFS;

import java.util.*;
import java.io.*;

class B2178 {
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
	
	// 처음에는 전역변수 cnt로 최단거리를 재려고 했음 => poll하면서 제대로 측정안됨
	// Queue에 row, col뿐만 아니라 dist도 넣어서 최단거리 측정 
	private int bfs(int row, int col, int w, int h) {

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{row,col,1});
        visited[row][col] = true;
        boolean flag = false;

        while(!que.isEmpty()){
        	
        	int q[] = que.peek();
            int curX = q[0];
            int curY = q[1];
            int dist = q[2];
            que.poll();
//          cnt++;

            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                if(nx == h-1 && ny == w-1) {
//                	cnt++;
//                	return;
                	flag = true;
                	break;
                }

                if(nx >= 0 && ny >= 0 && nx < h && ny < w){
                    if(arr[nx][ny] == 1 && !visited[nx][ny]){
                        que.add(new int[]{nx,ny,dist+1});
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
