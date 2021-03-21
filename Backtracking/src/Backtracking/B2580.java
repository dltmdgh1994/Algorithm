package Backtracking;

import java.io.*;

class B2580 { // ������
	BufferedReader br;
	BufferedWriter bw;
	
	int cnt = 0;
	int[][] arr;
	
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			arr = new int[9][9];
			for(int i = 0; i < 9; i++) {
				String str[] = br.readLine().split(" ");
				for(int j = 0; j < 9; j++) {
					arr[i][j] = Integer.parseInt(str[j]);
				}
			}
			
			
			
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					bw.write(Integer.toString(arr[i][j]) + " ");
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
	
	// queen�� ��ġ�� �� �̸� ����ġ�⸦ �ؼ� ������ ����
	private void backtracking(int pos) {
		
//		if(pos == num) {
//			//���� ������ �� ���� ��츸 ����
//			cnt++;
//			
//			return;
//		}
//		
//		boolean flag;
//		
//		for(int i = 0; i < num; i++) {
//			
//			flag= true;
//			
//			for(int j = 0; j <pos; j++) {
//				//���� �� Ȯ��
//				if(arr[j] == i) {
//					flag = false;
//					break;
//				}
//				
//				//�밢�� Ȯ��
//				if(arr[j] - i == j - pos || arr[j] - i == pos - j) {
//					flag = false;
//					break;
//				}
//			}
//			
//			if(flag) {
//				arr[pos] = i;
//				backtracking(pos+1);
//			}
//		}
	}
	
}