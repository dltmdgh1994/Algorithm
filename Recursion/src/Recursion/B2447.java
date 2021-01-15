package Recursion;

import java.io.*;

class B2447 { // �� ��� - 10
	BufferedReader br;
	BufferedWriter bw;
	char[][] arr;
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			
			//����� ���ϰ� �ϱ� ���� �迭 ���
			arr = new char[n][n];
			drawStar(0, 0, n, false);
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					bw.write(arr[i][j]);
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
	
	//���� ����
	private void drawStar(int x, int y, int n, boolean blank) {
		//����� ��ġ�� �κ��� �������� ä���.
		if(blank) {
			for(int i = x; i < x+n; i++) {
				for(int j = y; j < y+n; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}
		
		//�� �̻� ���� �� �� ���� �� *�� ä���.
		if(n == 1) {
			arr[x][y] = '*';
			return;
		}
		
		int size = n/3;
		int cnt = 0;
		for(int i = x; i < x+n; i += size) {
			for(int j = y; j < y+n; j += size) {
				cnt++;
				if(cnt == 5) {
					drawStar(i, j, size, true);
				}else {
					drawStar(i, j, size, false);
				}
			}
		}
	}
}
