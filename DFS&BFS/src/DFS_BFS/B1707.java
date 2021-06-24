package DFS_BFS;

import java.io.*;
import java.util.*;

class B1707 { // �̺� �׷���
	//������ �������� ���� �ٸ� ������ ĥ�ؼ� ��� ������ �� ���� �����θ� ĥ�� �� �ִ� �׷���
	
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
				int size = Integer.parseInt(s[0]); // ��� ����
				int n = Integer.parseInt(s[1]); // ���� ����
				
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
		
		// �׷����� ��� ��尡 ����� �� �ƴ϶� ��� ��带 Ȯ���� ������ �ݺ�
		// visited 0: �湮 x; 1: ����1; 2: ����2;
		while(true) {
			boolean flag = true;
			List<Integer> node;
			
			for(int i = 0; i < visited.length; i++) {
				if(visited[i] == 0) { // �湮���� ���� ���
					visited[i] = 1;
					flag = false;
					node = arr.get(i);
					
					for(int j = 0; j < node.size(); j++) {
						que.add(node.get(j));
						visited[node.get(j)] = 2; // �ֺ� ��带 �ٸ� ������
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
	    				
	    				// �ֺ� ��带 �ٸ� ������
	    				if(color == 1) {
	    					visited[dNode] = 2;
	    				}else {
	    					visited[dNode] = 1;	
	    				}
	    			}else { // �ֺ� ���� ���� ���̸� �̺� �׷����� �ƴϹǷ� �ߴ�
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
