package Backtracking;

import java.io.*;

class B2580 { // 스도쿠
	
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
			
			// 다른 경우의 수도 있으므로 해답을 찾으면 return 하지 않고 강제 종료
			System.exit(0);
		}
		
		if(arr[row][col] == 0) {
			for(int i = 1; i <= 9; i++) {
				if(check(row, col, i)) {
					arr[row][col] = i;
					backtracking(row, col+1);
				}
			}
			// 진행해서 막히는 경우 원상복귀를 위해 0으로 초기화
			arr[row][col] = 0;
			return;
		}
		
		// 해당 칸이 빈 칸이 아닌 경우
		backtracking(row, col+1);
		
	}
	
	private boolean check(int row, int col, int value) {
		
		// 행 체크
		for(int i = 0; i < 9; i++) {
			if(arr[row][i] == value) {
				return false;
			}
		}
		
		//열체크
		for(int i = 0; i < 9; i++) {
			if(arr[i][col] == value) {
				return false;
			}
		}
		
		int r = (row/3) * 3; //value가 속한 정사각형의 행 시작 위치
		int c = (col/3) * 3; //value가 속한 정사각형의 열 시작 위치
		
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

