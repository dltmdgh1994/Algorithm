package Backtracking;

import java.io.*;

class B9663 { // N-Queen
	BufferedReader br;
	BufferedWriter bw;
	
	int num;
	int cnt = 0;
	int[] arr;
	
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			num = Integer.parseInt(br.readLine());
			arr = new int[num];
			
			backtracking(0);
			
			bw.write(Integer.toString(cnt));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	// queen�� ��ġ�� �� �̸� ����ġ�⸦ �ؼ� ������ ����
	private void backtracking(int pos) {
		
		if(pos == num) {
			//���� ������ �� ���� ��츸 ����
			cnt++;
			
			return;
		}
		
		boolean flag;
		
		for(int i = 0; i < num; i++) {
			
			flag= true;
			
			for(int j = 0; j <pos; j++) {
				//���� �� Ȯ��
				if(arr[j] == i) {
					flag = false;
					break;
				}
				
				//�밢�� Ȯ��
				if(arr[j] - i == j - pos || arr[j] - i == pos - j) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				arr[pos] = i;
				backtracking(pos+1);
			}
		}
	}
	
	// ���� �´µ� �ð��ʰ�...
	// queen�� ��ġ�� �� �ִ� ��� ��츦 ����ϰ� ����ġ�⸦ �����ؼ� ������.
//	private void backtracking(int pos) {
//		
//		if(pos > 1) {	
//			for(int i = 0; i < pos-1; i++) {
//				for(int j = i+1; j <pos; j++) {
//					//���� �� Ȯ��
//					if(arr[i] == arr[j]) {
//						return;
//					}
//					
//					//�밢�� Ȯ��
//					if(arr[j] - arr[i] == j - i || arr[j] - arr[i] == i - j) {
//						return;
//					}
//				}
//			}
//		}
//		
//		if(pos == num) {
//			//���� ������ �� ���� ��츸 ����
//			cnt++;
//			
//			return;
//		}
//	
//		for(int i = 0; i < num; i++) {
//			arr[pos] = i;
//			backtracking(pos+1);
//		}
//	}
}