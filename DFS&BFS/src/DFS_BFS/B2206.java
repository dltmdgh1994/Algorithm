package DFS_BFS;

import java.io.*;
import java.util.*;

class B2206 { // �� �μ��� �̵��ϱ�
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
			int h = Integer.parseInt(s[0]);
			int w = Integer.parseInt(s[1]);
			
			arr = new int[h][w];
			
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
		
		if(w == 1 && h == 1) {
			if(arr[0][0] == 0) {
				return 1;
			}else {
				return -1;
			}
		}
		
		boolean flag = false;
		// ���� �ո� �� Ȯ���ϱ� ���� 3���� �迭 ����
		boolean[][][] visited = new boolean[h][w][2];

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{row,col,1,1});
        visited[row][col][1] = true;

        while(!que.isEmpty()){
        	
        	int q[] = que.peek();
            int curX = q[0];
            int curY = q[1];
            int dist = q[2];
            int op = q[3]; // ������ ���� �� �ִ� ���� ��ȸ
            que.poll();
            

            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                if(nx == h-1 && ny == w-1) {
                	flag = true;
                	break;
                }

                if(nx >= 0 && ny >= 0 && nx < h && ny < w){
                    if(arr[nx][ny] == 0 && !visited[nx][ny][op]){
                        que.add(new int[]{nx,ny,dist+1,op});
                        visited[nx][ny][op] = true;
                    }else if(arr[nx][ny] == 1 && !visited[nx][ny][0] && op == 1) {
                    	que.add(new int[]{nx,ny,dist+1,0});
                        visited[nx][ny][0] = true;
                    }
                }
            }
            
            if(flag) {
            	return dist+1;
            }
        }
        
        return -1;
	}
}

// ���� �Ѱ� �� 0���� �ٲٸ� �����ϴ� ���
// ���� ������ �ð� �ʰ�
//class B2206 {
//	BufferedReader br;
//	BufferedWriter bw;
//	
//	int[][] arr;
//	
//	int dx[] = {0,0,1,-1};
//    int dy[] = {1,-1,0,0};
//	
//	public void sol() {
//		try {
//			br = new BufferedReader(new InputStreamReader(System.in));
//			bw = new BufferedWriter(new OutputStreamWriter(System.out));
//			
//			String s[] = br.readLine().split(" ");
//			int h = Integer.parseInt(s[0]);
//			int w = Integer.parseInt(s[1]);
//			
//			arr = new int[h][w];
//			Queue<int[]> q = new LinkedList<>();
//			
//			for(int i = 0; i < h; i++) {
//				s = br.readLine().split("");
//				for(int j = 0; j < w; j++) {
//					arr[i][j] = Integer.parseInt(s[j]);
//					if(arr[i][j] == 1) {
//						q.add(new int[] {i,j});
//					}
//				}
//			}
//			
//			int cnt = 0;
//			int ans = w + h -1 ;
//			int min = 1000000;
//			
//			while(!q.isEmpty()) {
//				int xy[] = q.peek();
//				int curX = xy[0];
//	            int curY = xy[1];
//				q.poll();
//				
//	            arr[curX][curY] = 0;
//				cnt = bfs(0, 0, w, h);
//				arr[curX][curY] = 1;
//				
//				
//				if(cnt == ans) {
//					min = cnt;
//					break;
//				}
//				
//				if(cnt == -1) {
//					continue;
//				}
//				
//				if(cnt < min) {
//					min = cnt;
//				}
//			}
//			
//			if(min == 1000000) {
//				bw.write(Integer.toString(-1));
//			}else {
//				bw.write(Integer.toString(min));
//			}
//			
//			
//			br.close();
//			bw.close();
//		}catch(IOException e) {
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
//	}
//	
//	private int bfs(int row, int col, int w, int h) {
//		
//		boolean flag = false;
//		boolean[][] visited = new boolean[h][w];
//
//        Queue<int[]> que = new LinkedList<>();
//        que.add(new int[]{row,col,1});
//        visited[row][col] = true;
//
//        while(!que.isEmpty()){
//        	
//        	int q[] = que.peek();
//            int curX = q[0];
//            int curY = q[1];
//            int dist = q[2];
//            que.poll();
//            
//
//            for(int i=0; i<4; i++){
//                int nx = curX + dx[i];
//                int ny = curY + dy[i];
//                
//                if(nx == h-1 && ny == w-1) {
//                	flag = true;
//                	break;
//                }
//
//                if(nx >= 0 && ny >= 0 && nx < h && ny < w){
//                    if(arr[nx][ny] == 0 && !visited[nx][ny]){
//                        que.add(new int[]{nx,ny,dist+1});
//                        visited[nx][ny] = true;
//                    }
//                }
//            }
//            
//            if(flag) {
//            	return dist+1;
//            }
//        }
//        
//        return -1;
//	}
//}
