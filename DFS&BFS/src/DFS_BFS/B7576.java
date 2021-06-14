package DFS_BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class B7576 { // 토마토
	BufferedReader br;
	BufferedWriter bw;
	
	int[][] arr;
	
	int dx[] = {0,0,1,-1};
    int dy[] = {1,-1,0,0};
	
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String s[] = br.readLine().split(" ");
			int w = Integer.parseInt(s[0]);
			int h = Integer.parseInt(s[1]);
			
			arr = new int[h][w];
			
			Queue<int[]> q = new LinkedList<>();
			
			for(int i = 0; i < h; i++) {
				s = br.readLine().split(" ");
				for(int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(s[j]);
					
					// 1인 지점이 여러 곳
					if(arr[i][j] == 1) {
						q.add(new int[]{i,j,0});
					}
				}
			}
			
			// 동시다발적으로 BFS를 진행하기 때문에 Queue를 넘겨준다.
			int ans = bfs(q, w, h);
			
			boolean flag = false;
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(arr[i][j] == 0) {
						flag = true;
					}
				}
			}
			
			if(flag) {
				bw.write(Integer.toString(-1));
			}else {
				bw.write(Integer.toString(ans));
			}

			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private int bfs(Queue<int[]> q, int w, int h) {
		
        Queue<int[]> que = q;
        
        int day = 0;

        while(!que.isEmpty()){
        	
        	int xy[] = que.peek();
            int curX = xy[0];
            int curY = xy[1];
            day = xy[2];
            que.poll();

            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx >= 0 && ny >= 0 && nx < h && ny < w){
                    if(arr[nx][ny] == 0){
                        que.add(new int[]{nx,ny,day+1});
                        arr[nx][ny] = 1;
                    }
                }
            }
        }
        
        return day;
	}
}
