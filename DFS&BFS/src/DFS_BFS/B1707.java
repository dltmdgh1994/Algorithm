package DFS_BFS;

import java.io.*;
import java.util.*;

class B1707 { // 이분 그래프
	//인접한 정점끼리 서로 다른 색으로 칠해서 모든 정점을 두 가지 색으로만 칠할 수 있는 그래프
	
	BufferedReader br;
	BufferedWriter bw;
	
	List<Integer> ansDfs;
	List<Integer> ansBfs;
	
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < num; i++) {
				String[] s = br.readLine().split(" ");
				int size = Integer.parseInt(s[0]); // 노드 개수
				int n = Integer.parseInt(s[1]); // 간선 개수
				
				List<List<Integer>> arr = new ArrayList<>();
				for(int j = 0; j < size; j++) {
					List<Integer> list = new ArrayList<>();
					arr.add(list);
				}
				
				int[] visited = new int[size];
				for(int j = 0; j < size; j++) {
					visited[j] = 0;
				}
				
				for(int j = 0; j < n; j++) {
					String[] str = br.readLine().split(" ");
					arr.get(Integer.parseInt(str[0])-1).add(Integer.parseInt(str[1])-1);
					arr.get(Integer.parseInt(str[1])-1).add(Integer.parseInt(str[0])-1);
				}
				
				boolean ans = bfs(arr, visited);
				
				if(ans) {
					bw.write("YES");
				}else {
					bw.write("NO");
				}
				bw.newLine();
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private boolean bfs(List<List<Integer>> arr, int[] visited) {
		
		Queue<Integer> que = new LinkedList<>();
		
		// 그래프의 모든 노드가 연결된 게 아니라서 모든 노드를 확인할 때까지 반복
		// visited 0: 방문 x; 1: 색깔1; 2: 색깔2;
		while(true) {
			boolean flag = true;
			List<Integer> node;
			
			for(int i = 0; i < visited.length; i++) {
				if(visited[i] == 0) { // 방문하지 않은 노드
					visited[i] = 1;
					flag = false;
					node = arr.get(i);
					
					for(int j = 0; j < node.size(); j++) {
						que.add(node.get(j));
						visited[node.get(j)] = 2; // 주변 노드를 다른 색으로
					}
					
					break;
				}
			}

			
			while(!que.isEmpty()) {
				
	            int curNode = que.peek();
	            int color = visited[curNode];
	            que.poll();
	            
	            List<Integer> n1 = arr.get(curNode);
	            for(int i = 0; i < n1.size(); i++) {
	            	int dNode = n1.get(i);
	            	
	    			if(visited[dNode] == 0) {
	    				que.add(dNode);
	    				
	    				// 주변 노드를 다른 색으로
	    				if(color == 1) {
	    					visited[dNode] = 2;
	    				}else {
	    					visited[dNode] = 1;	
	    				}
	    			}else { // 주변 노드와 같은 색이면 이분 그래프가 아니므로 중단
	    				if(color == visited[dNode]) {
	    					return false;
	    				}
	    			}
	    		}
			}
			
			if(flag) {
				break;
			}
		}

		return true;
	}
}
