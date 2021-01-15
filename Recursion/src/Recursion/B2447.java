package Recursion;

import java.io.*;

class B2447 { // 별 찍기 - 10
	BufferedReader br;
	BufferedWriter bw;
	char[][] arr;
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			
			//출력을 편하게 하기 위해 배열 사용
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
	
	//분할 정복
	private void drawStar(int x, int y, int n, boolean blank) {
		//가운데에 위치한 부분을 공백으로 채운다.
		if(blank) {
			for(int i = x; i < x+n; i++) {
				for(int j = y; j < y+n; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}
		
		//더 이상 분할 할 수 없을 때 *로 채운다.
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
