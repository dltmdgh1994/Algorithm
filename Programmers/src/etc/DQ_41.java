package etc;

import java.io.*;

public class DQ_41 { // ���� ��ȹ
	
	BufferedReader br;
	BufferedWriter bw;
	
	public static void main(String[] args) {
		
		DQ_41 dq = new DQ_41();
		
		dq.sol();
	}

	// ���μ� ���� �˰���
	public void sol() {
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] s = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int travelN = Integer.parseInt(s[1]);
			
			int[] parent = new int[n];
			for(int i = 0; i < n; i++) {
				parent[i] = i;
			}
			
			for(int i = 0; i < n; i++) {
				s = br.readLine().split(" ");
				for(int j = i; j < n; j++) {
					if(Integer.parseInt(s[j]) == 1) {
						unionParent(parent, i, j);
					}
				}
			}
			
			s = br.readLine().split(" ");
			int start = Integer.parseInt(s[0]);
			boolean flag = false;
			for(int i = 1; i < travelN; i++) {
				// �������� ���� ���տ� ������ �ִ��� Ȯ��
				if(findParent(parent, start) != findParent(parent, Integer.parseInt(s[i]))) {
					flag = true;
				}
			}
			
			if(flag) {
				bw.write("NO");
			}else {
				bw.write("YES");
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
