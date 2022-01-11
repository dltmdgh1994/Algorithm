package etc;

import java.io.*;
import java.util.*;

public class D9_Dijkstra {

	BufferedReader br;
	BufferedWriter bw;

	public static void main(String[] args) {
		
		D9_Dijkstra p = new D9_Dijkstra();
		
		p.sol();
	}
	
	public void sol() {
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] s = br.readLine().split(" ");
			int nodeN = Integer.parseInt(s[0]);
			int edgeN = Integer.parseInt(s[1]);
			int start = Integer.parseInt(br.readLine());
			
			int[][] graph = new int[nodeN][nodeN];
			for(int i = 0; i < edgeN; i++) {
				s = br.readLine().split(" ");
				int n1 = Integer.parseInt(s[0]);
				int n2 = Integer.parseInt(s[1]);
				int dist = Integer.parseInt(s[2]);
				
				graph[n1-1][n2-1] = dist;
				graph[n2-1][n1-1] = dist;
			}
			
			// 거리 순으로 자동 정렬
			PriorityQueue<Node> pq = new PriorityQueue<>();
			int[] distance = new int[nodeN];
			for(int i = 0; i < nodeN; i++) {
				distance[i] = Integer.MAX_VALUE;
			}
			
			pq.add(new Node(start-1, 0));
			while(!pq.isEmpty()) {
				Node node = pq.poll();
				int n = node.getN();
				int d = node.getDist();
				
				if(distance[n] > d) {
					distance[n] = d;
					
					for(int i = 0; i < nodeN; i++) {
						if(graph[n][i] != 0 && distance[i] > graph[n][i]+d) {
							pq.add(new Node(i, graph[n][i]+d));
						}
					}
				}
			}
			
			for(int i = 0; i < nodeN; i++) {
				bw.write(Integer.toString(distance[i]) + " ");
			}

			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}

class Node implements Comparable<Node>{
	
	private int n;
	private int dist;
	
	public Node(int n, int dist) {
		this.n = n;
		this.dist = dist;
	}
	
	public int getN() {
		return n;
	}


	public int getDist() {
		return dist;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		if(this.dist > o.getDist()) {
			return 1;
		}else if(this.dist < o.getDist()) {
			return -1;
		}else {
			if(this.n > o.getN()) {
				return 1;
			}else if(this.n < o.getN()) {
				return -1;
			}else {
				return 0;
			}
		}
	}
}
