package etc;

import java.io.*;

public class DQ_42 { // ž�±�

	BufferedReader br;
	BufferedWriter bw;
	
	public static void main(String[] args) {
		
		DQ_42 dq = new DQ_42();
		
		dq.sol();
	}

	// ���μ� ���� �˰���
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
					// ��� ���տ��� ���� ���� ������ ���տ� ����
					if(parent[j] == j) {
						unionParent(parent, 0, j);
						flag = true;
						break;
					}
				}
				
				if(!flag) { // ����Ⱑ �� �� �ִ� ��� ����Ʈ�� ����
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
