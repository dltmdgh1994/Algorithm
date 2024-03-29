package etc;

import java.io.*;
import java.util.Arrays;

public class DQ_43 { // 어두운 길

	BufferedReader br;
	BufferedWriter bw;
	
	public static void main(String[] args) {
		
		DQ_43 dq = new DQ_43();
		
		dq.sol();
	}

	// 크루스칼 알고리즘
	public void sol() {
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] s = br.readLine().split(" ");
			int nodeN = Integer.parseInt(s[0]);
			int edgeN = Integer.parseInt(s[1]);
			
			int[] parent = new int[nodeN];
			for(int i = 0; i < nodeN; i++) {
				parent[i] = i;
			}
			
			int[][] edges = new int[edgeN][3];
			int sum = 0;
			for(int i = 0; i < edgeN; i++) {
				s = br.readLine().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
				sum += edges[i][2];
			}
			
			// 거리에 따라 내림차순 정렬
			Arrays.sort(edges, (o1, o2) ->{
				return Integer.compare(o1[2], o2[2]);
			});
			
			int result = 0;
			for(int i = 0; i < edgeN; i++) {
				int dist = edges[i][2];
				int a = edges[i][0];
				int b = edges[i][1];
				
				// 사이클이 없는 경우에만 집합에 포함
				if(findParent(parent, a) != findParent(parent, b)) {
					unionParent(parent, a, b);
					result += dist;
				}
			}
			
			bw.write(Integer.toString(sum-result));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	// 특정 원소가 속한 집합 찾기
	private int findParent(int[] parent, int p) {
		// 루트 노드를 찾을 때까지 재귀적으로 호출
		if(p != parent[p]) {
			parent[p] = findParent(parent, parent[p]);
		}
		
		return parent[p];
	}
	
	// 두 원소가 속한 집합 합치기
	private void unionParent(int[] parent, int a, int b) {
		a = findParent(parent, a);
		b = findParent(parent, b);
		
		if(a <= b) {
			parent[b] = a;
		}else {
			parent[a] = b;
		}
	}
}
