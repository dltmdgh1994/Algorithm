package etc;

import java.io.*;
import java.util.*;

public class DQ_DFSBFS {
	
	BufferedReader br;
	BufferedWriter bw;

	public static void main(String[] args) {
		
		DQ_DFSBFS dq = new DQ_DFSBFS();
		
		dq.Q15();
	}
	
	public void Q15() { // 특정 거리의 도시 찾기
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));

			String[] s = br.readLine().split(" ");
			int num = Integer.parseInt(s[0]); // 도시 개수
			int m = Integer.parseInt(s[1]); // 도로 개수
			int k = Integer.parseInt(s[2]); // 필요 거리
			int x = Integer.parseInt(s[3]); // 출발 도시 번호
			
			int[][] graph = new int[num][num];
			for(int i = 0; i < m; i++) {
				s = br.readLine().split(" ");
				graph[Integer.parseInt(s[0])-1][Integer.parseInt(s[1])-1] = 1;
			}
			
			// 거리 순으로 자동 정렬
			PriorityQueue<Node> pq = new PriorityQueue<>();
			int[] distance = new int[num];
			for(int i = 0; i < num; i++) {
				distance[i] = Integer.MAX_VALUE;
			}
			
			pq.add(new Node(x-1, 0));
			while(!pq.isEmpty()) {
				Node node = pq.poll();
				int n = node.getN();
				int d = node.getDist();
				
				if(distance[n] > d) {
					distance[n] = d;
					
					for(int i = 0; i < num; i++) {
						if(graph[n][i] != 0 && distance[i] > graph[n][i]+d) {
							pq.add(new Node(i, graph[n][i]+d));
						}
					}
				}
			}
			
			boolean pass = false;
			for(int i = 0; i < num; i++) {
				if(distance[i] == k) {
					bw.write(Integer.toString(i+1));
					bw.newLine();
					pass = true;
				}
			}
			
			if(!pass) bw.write("-1");
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
