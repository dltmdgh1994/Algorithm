package DFS_BFS;

import java.io.*;
import java.util.*;

class B1697 { // 숨바꼭질
	BufferedReader br;
	BufferedWriter bw;
	
	boolean[] visited;
	
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String s[] = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]); // 술래 위치
			int b = Integer.parseInt(s[1]); // 범인 위치
			
			visited = new boolean[100001];
			
			int day = bfs(a, b);
			
			bw.write(Integer.toString(day));

			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	// 처음에 방문처리를 하지 않아서 계속 같은 곳을 방문 => 메모리 초과
	private int bfs(int a, int b) {
		
		Queue<int[]> que = new LinkedList<>();
		visited[a] = true;
		que.add(new int[] {a, 0});
        
        int day = 0;
        int[] x = new int[2];
    	int x1;

        while(!que.isEmpty()){
        	
        	x = que.poll();
        	x1 = x[0];
        	day = x[1];
        	
        	visited[x1] = true;
        	
        	if(x1 == b) {
        		return day;
        	}
        	
        	if(x1+1 <= 100000) {
        		if(!visited[x1+1]) {
            		que.add(new int[] {x1+1, day+1});
            	}
        	}
        	
        	if(x1-1 >= 0) {
        		if(!visited[x1-1]) {
        			que.add(new int[] {x1-1, day+1});
            	}
        	}
        	
        	if(x1*2 <= 100000) {
        		if(!visited[x1*2]) {
        			que.add(new int[] {x1*2, day+1});
            	}
        	}
        }
		
		return 0;
	}
}
