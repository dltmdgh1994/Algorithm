package etc;

import java.io.*;

// �÷��̵� ���� �˰���
// ��� ��忡 ���Ͽ� �ٸ� ��� �������� �ִܰŸ� => O(N^3)
public class D9_FloydWarshall {
	
	BufferedReader br;
	BufferedWriter bw;

	public static void main(String[] args) {
		
		D9_FloydWarshall p = new D9_FloydWarshall();
		
		p.sol();
	}
	
	public void sol() {
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] s = br.readLine().split(" ");
			int nodeN = Integer.parseInt(s[0]);
			int edgeN = Integer.parseInt(s[1]);
			
			int[][] graph = new int[nodeN][nodeN];
			for(int i = 0; i < nodeN; i++) {
				for(int j = 0; j < nodeN; j++) {
					if(i == j) {
						graph[i][j] = 0;
					}else {
						graph[i][j] = Integer.MAX_VALUE/2;
					}
				}
			}
			
			for(int i = 0; i < edgeN; i++) {
				s = br.readLine().split(" ");
				int n1 = Integer.parseInt(s[0]);
				int n2 = Integer.parseInt(s[1]);
				int dist = Integer.parseInt(s[2]);
				
				graph[n1-1][n2-1] = dist;
			}
			
			for(int k = 0; k < nodeN; k++) { // ���İ��� ���
				for(int i = 0; i < nodeN; i++) { // ����ϴ� ���
					for(int j = 0; j < nodeN; j++) { // �����ϴ� ���
						if(i != j) {
							int d1 = graph[i][j];
							int d2 = graph[i][k] + graph[k][j];
							
							if(d1 >= d2) {
								graph[i][j] = d2;
							}else {
								graph[i][j] = d1;
							}
						}
					}
				}
			}
			
			for(int i = 0; i < nodeN; i++) {
				for(int j = 0; j < nodeN; j++) {
					bw.write(Integer.toString(graph[i][j]) + " ");
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
}
