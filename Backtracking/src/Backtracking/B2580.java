package Backtracking;

import java.io.*;

class B2580 { // 스도쿠
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
	
	// queen을 배치할 때 미리 가지치기를 해서 빠르게 수행
	private void backtracking(int pos) {
		
//		if(pos == num) {
//			//서로 공격할 수 없는 경우만 도달
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
//				//같은 열 확인
//				if(arr[j] == i) {
//					flag = false;
//					break;
//				}
//				
//				//대각선 확인
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