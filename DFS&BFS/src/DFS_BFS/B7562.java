package DFS_BFS;

import java.io.*;
import java.util.*;

class B7562 { // 나이트의 이동
	BufferedReader br;
	BufferedWriter bw;
	
	// 나이트가 움직일 수 있는 좌표
	int dx[] = {1,2,2,1,-1,-2,-2,-1};
    int dy[] = {2,1,-1,-2,-2,-1,1,2};
	
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < num; i++) {
				int size = Integer.parseInt(br.readLine());
				boolean[][] visited = new boolean[size][size];
				String[] start = br.readLine().split(" ");
				String[] end = br.readLine().split(" ");
				
				int cnt = bfs(start, end, size, visited);
				
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
	
	private int bfs(String[] start, String[] end, int size, boolean[][] visited) {
		
		int startX = Integer.parseInt(start[0]);
		int startY = Integer.parseInt(start[1]);
		int endX = Integer.parseInt(end[0]);
		int endY = Integer.parseInt(end[1]);
		
		if(startX == endX && startY == endY) {
			return 0;
		}

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{startX,startY,0});
        visited[startX][startY] = true;

        while(!que.isEmpty()){
        	
        	int q[] = que.peek();
            int curX = q[0];
            int curY = q[1];
            int dist = q[2];
            que.poll();

            for(int i=0; i<8; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                if(nx == endX && ny == endY) {
                	return dist+1;
                }

                if(nx >= 0 && ny >= 0 && nx < size && ny < size){
                    if(!visited[nx][ny]){
                        que.add(new int[]{nx,ny,dist+1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return 0;
	}
}
