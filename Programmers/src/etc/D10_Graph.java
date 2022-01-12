package etc;

import java.io.*;

public class D10_Graph { 

	BufferedReader br;
	BufferedWriter bw;

	public static void main(String[] args) {
		
		D10_Graph p = new D10_Graph();
		
		p.sol();
	}
	
	public void sol() { // 서로소 집합 알고리즘
		
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
			
			for(int i = 0; i < edgeN; i++) {
				s = br.readLine().split(" ");
				int a = Integer.parseInt(s[0])-1;
				int b = Integer.parseInt(s[1])-1;
				
				unionParent(parent, a, b);
			}
			
			bw.write("집합 : ");
			for(int i = 0; i < nodeN; i++) {
				bw.write(Integer.toString(findParent(parent, i)+1) + " ");
			}
			bw.newLine();
			
			bw.write("부모 : ");
			for(int i = 0; i < nodeN; i++) {
				bw.write(Integer.toString(parent[i]+1) + " ");
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	// 특정 원소가 속한 집합 찾기
	private int findParent(int[] parent, int c) {
		int p = parent[c];
		
		while(p != parent[p]) {
			p = parent[p];
		}
		
		return p;
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
