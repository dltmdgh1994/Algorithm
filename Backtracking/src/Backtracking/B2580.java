package Backtracking;

import java.io.*;

class B2580 { // ������
	
	int[][] arr;
	
	public void sol() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			arr = new int[9][9];
			for(int i = 0; i < 9; i++) {
				String str[] = br.readLine().split(" ");
				for(int j = 0; j < 9; j++) {
					int n = Integer.parseInt(str[j]);
					arr[i][j] = n;
				}
			}
			
			backtracking(0, 0);
			
			br.close();
			
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private void backtracking(int row, int col) throws IOException {
		
		if(col == 9) {
			backtracking(row+1, 0);
			return;
		}
		
		if(row == 9) {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					bw.write(Integer.toString(arr[i][j]) + " ");
				}
				bw.newLine();
			}
			
			bw.flush();
			
			// �ٸ� ����� ���� �����Ƿ� �ش��� ã���� return ���� �ʰ� ���� ����
			System.exit(0);
		}
		
		if(arr[row][col] == 0) {
			for(int i = 1; i <= 9; i++) {
				if(check(row, col, i)) {
					arr[row][col] = i;
					backtracking(row, col+1);
				}
			}
			// �����ؼ� ������ ��� ���󺹱͸� ���� 0���� �ʱ�ȭ
			arr[row][col] = 0;
			return;
		}
		
		// �ش� ĭ�� �� ĭ�� �ƴ� ���
		backtracking(row, col+1);
		
	}
	
	private boolean check(int row, int col, int value) {
		
		// �� üũ
		for(int i = 0; i < 9; i++) {
			if(arr[row][i] == value) {
				return false;
			}
		}
		
		//��üũ
		for(int i = 0; i < 9; i++) {
			if(arr[i][col] == value) {
				return false;
			}
		}
		
		int r = (row/3) * 3; //value�� ���� ���簢���� �� ���� ��ġ
		int c = (col/3) * 3; //value�� ���� ���簢���� �� ���� ��ġ
		
		for(int i = r; i < r+3; i++) {
			for(int j = c; j < c+3; j++) {
				if(arr[i][j] == value) {
					return false;
				}
			}
		}
		
		return true;
	}
}

