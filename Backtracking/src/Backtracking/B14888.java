package Backtracking;

import java.io.*;

class B14888 { // 연산자 끼워넣기
	
	int[] arr;
	int[] cal;
	int n;
	
	int max = -1000000000;
	int min = -max;
	
	public void sol() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			n = Integer.parseInt(br.readLine());
			
			arr = new int[n];
			String[] str = br.readLine().split(" ");
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			
			cal = new int[4];
			int cnt = 0;
			str = br.readLine().split(" ");
			for(int i = 0; i < 4; i++) {
				cal[i] = Integer.parseInt(str[i]);
				cnt += cal[i];
			}

			backtracking(cnt, arr[0]);
			
			bw.write(Integer.toString(max));
			bw.newLine();
			bw.write(Integer.toString(min));
			bw.flush();
			
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	// 남은 사칙연산 갯수로 backtracking 진행
	private void backtracking(int cnt, int result) {
		
		if(cnt == 0) {
			if(result > max) {
				max = result;
			}
			
			if(result < min) {
				min = result;
			}
			
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int a = cal[i];
			for(int j = 0; j < a; j++) {
				int num = arr[n-cnt];
				if(i == 0) {
					result += num;
				}else if(i == 1) {
					result -= num;
				}else if(i == 2) {
					result *= num;
				}else {
					result /= num;
				}
				
				cal[i] -= 1;
				backtracking(cnt-1, result);
				
				// 원상 복귀
				if(i == 0) {
					result -= num;
				}else if(i == 1) {
					result += num;
				}else if(i == 2) {
					result /= num;
				}else {
					result *= num;
				}
				cal[i] += 1;
			}
			
		}
	}
}
