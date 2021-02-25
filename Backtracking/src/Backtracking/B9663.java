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
	
	// queen을 배치할 때 미리 가지치기를 해서 빠르게 수행
	private void backtracking(int pos) {
		
		if(pos == num) {
			//서로 공격할 수 없는 경우만 도달
			cnt++;
			
			return;
		}
		
		boolean flag;
		
		for(int i = 0; i < num; i++) {
			
			flag= true;
			
			for(int j = 0; j <pos; j++) {
				//같은 열 확인
				if(arr[j] == i) {
					flag = false;
					break;
				}
				
				//대각선 확인
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
	
	// 답은 맞는데 시간초과...
	// queen이 배치될 수 있는 모든 경우를 고려하고 가지치기를 진행해서 느리다.
//	private void backtracking(int pos) {
//		
//		if(pos > 1) {	
//			for(int i = 0; i < pos-1; i++) {
//				for(int j = i+1; j <pos; j++) {
//					//같은 열 확인
//					if(arr[i] == arr[j]) {
//						return;
//					}
//					
//					//대각선 확인
//					if(arr[j] - arr[i] == j - i || arr[j] - arr[i] == i - j) {
//						return;
//					}
//				}
//			}
//		}
//		
//		if(pos == num) {
//			//서로 공격할 수 없는 경우만 도달
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