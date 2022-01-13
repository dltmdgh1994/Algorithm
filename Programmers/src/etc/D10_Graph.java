package etc;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class D10_Graph { 

	BufferedReader br;
	BufferedWriter bw;

	public static void main(String[] args) {
		
		D10_Graph p = new D10_Graph();
		
		// p.D10_1();
		// p.D10_2();
		p.D10_Kruscal();
	}
	
	public void D10_1() { // ���μ� ���� �˰���
		
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
			
			bw.write("���� : ");
			for(int i = 0; i < nodeN; i++) {
				bw.write(Integer.toString(findParent(parent, i)+1) + " ");
			}
			bw.newLine();
			
			bw.write("�θ� : ");
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
	
	public void D10_2() { // ���μ� ������ Ȱ���� ����Ŭ �Ǻ�
		
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
			
			boolean cycle = false;
			
			for(int i = 0; i < edgeN; i++) {
				s = br.readLine().split(" ");
				int a = Integer.parseInt(s[0])-1;
				int b = Integer.parseInt(s[1])-1;
				
				if(findParent(parent, a) == findParent(parent, b)) {
					cycle = true;
					break;
				}else {
					unionParent(parent, a, b);
				}
			}
			
			if(cycle) {
				bw.write("����Ŭ �߻�");
			}else {
				bw.write("����Ŭ ����");
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private void D10_Kruscal() { // ũ�罺Į �˰���
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
			for(int i = 0; i < edgeN; i++) {
				s = br.readLine().split(" ");
				edges[i][0] = Integer.parseInt(s[0])-1;
				edges[i][1] = Integer.parseInt(s[1])-1;
				edges[i][2] = Integer.parseInt(s[2]);
			}
			
			// �Ÿ��� ���� �������� ����
			Arrays.sort(edges, (o1, o2) ->{
				return Integer.compare(o1[2], o2[2]);
			});
			
			int result = 0;
			for(int i = 0; i < edgeN; i++) {
				int dist = edges[i][2];
				int a = edges[i][0];
				int b = edges[i][1];
				
				// ����Ŭ�� ���� ��쿡�� ���տ� ����
				if(findParent(parent, a) != findParent(parent, b)) {
					unionParent(parent, a, b);
					result += dist;
				}
			}
			
			bw.write(Integer.toString(result));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	// Ư�� ���Ұ� ���� ���� ã��
	private int findParent(int[] parent, int p) {
		// ��Ʈ ��带 ã�� ������ ��������� ȣ��
		if(p != parent[p]) {
			parent[p] = findParent(parent, parent[p]);
		}
		
		return parent[p];
	}
	
	// �� ���Ұ� ���� ���� ��ġ��
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
