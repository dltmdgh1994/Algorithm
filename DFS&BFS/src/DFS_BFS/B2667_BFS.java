package DFS_BFS;

import java.io.*;
import java.util.*;

class B2667_BFS {
	BufferedReader br;
	BufferedWriter bw;
	
	int n;
	int[][] arr;
	boolean[][] visited;
	int bulidingNum;
	int[] budlings;
	
	int dx[] = {0,0,1,-1};
    int dy[] = {1,-1,0,0};
	
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			n = Integer.parseInt(br.readLine());
			
			arr = new int[n][n];
			visited = new boolean[n][n];
			for(int i = 0; i < n; i++) {
				String str[] = br.readLine().split("");
				for(int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(str[j]);
				}
			}
			
			List<Integer> ans = new ArrayList<>();
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(arr[i][j] != 0 && !visited[i][j]) {
						bulidingNum++;
						bfs(i, j);
					}
				}
			}
			
			ans.sort(null);
			
			bw.write(Integer.toString(ans.size()));
			bw.newLine();
			for(int i = 0; i < ans.size(); i++) {
				bw.write(Integer.toString(ans.get(i)));
				bw.newLine();
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private void bfs(int row, int col) {
		//2차원 LinkedList를 가진 큐 선언
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{row,col});
        visited[row][col] = true;
        budlings[bulidingNum]++;

        while(!que.isEmpty()){

            //x, y 값을 받아오기 위한 방법
            int curX = que.peek()[0];
            int curY = que.peek()[1];
            que.poll();

            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                    if(arr[nx][ny] == 1 && !visited[nx][ny]){
                        que.add(new int[]{nx,ny});
                        visited[nx][ny] = true;
                        budlings[bulidingNum]++;
                    }
                }
            }
        }
	}
}
