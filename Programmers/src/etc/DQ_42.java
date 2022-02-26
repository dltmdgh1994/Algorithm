package etc;

import java.io.*;

public class DQ_42 { // 탑승구

	BufferedReader br;
	BufferedWriter bw;
	
	public static void main(String[] args) {
		
		DQ_42 dq = new DQ_42();
		
		dq.sol();
	}

	// 서로소 집합 알고리즘
	public void sol() {
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int gateN = Integer.parseInt(br.readLine());
			int planeN = Integer.parseInt(br.readLine());
			
			int[] parent = new int[gateN+1];
			for(int i = 0; i < gateN+1; i++) {
				parent[i] = i;
			}
			
			int ans = 0;
			for(int i = 0; i < planeN; i++) {
				int n = Integer.parseInt(br.readLine());
				boolean flag = false;
				
				for(int j = n; j >= 1; j--) {
					// 어느 집합에도 속해 있지 않으면 집합에 연결
					if(parent[j] == j) {
						unionParent(parent, 0, j);
						flag = true;
						break;
					}
				}
				
				if(!flag) { // 비행기가 갈 수 있는 모든 게이트가 막힘
					bw.write(Integer.toString(ans));
					break;
				}else {
					ans++;
				}
			}
			
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
