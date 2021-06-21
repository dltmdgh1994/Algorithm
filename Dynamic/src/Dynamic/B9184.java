package Dynamic;

import java.io.*;

class B9184 { // 신나는 함수 실행
	BufferedReader br;
	BufferedWriter bw;
	
	int[][][] memo = new int[50][50][50];
	
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			for(int i = 0; i <= 20; i++) {
				for(int j = 0; j <= 20; j++) {
					for(int k = 0; k <= 20; k++) {
						w(i, j, k);
					}
				}
			}
			
			w(20, 20, 20);
			
			while(true) {
				String s[] = br.readLine().split(" ");
				
				int a = Integer.parseInt(s[0]);
				int b = Integer.parseInt(s[1]);
				int c = Integer.parseInt(s[2]);
				
				if(a == -1 && b == -1 && c == -1) {
					break;
				}
				
				if(a <= 0 || b <= 0 || c <= 0) {
					bw.write("w(" + Integer.toString(a) + ", " + Integer.toString(b) + ", "
							+ Integer.toString(c) + ") = " + Integer.toString(1));
				}else if ( a > 20 || b > 20 || c > 20) {
					bw.write("w(" + Integer.toString(a) + ", " + Integer.toString(b) + ", "
							+ Integer.toString(c) + ") = " + Integer.toString(memo[20][20][20]));
				}else {
					bw.write("w(" + Integer.toString(a) + ", " + Integer.toString(b) + ", "
							+ Integer.toString(c) + ") = " + Integer.toString(memo[a][b][c]));
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
	
	private void w(int i, int j, int k) {
		if(i == 0 || j == 0 || k == 0) {
			memo[i][j][k] = 1;
		}
		else if(i < j && j < k) {
			memo[i][j][k] = memo[i][j][k-1] + memo[i][j-1][k-1] - memo[i][j-1][k];
		}else {
			memo[i][j][k] = memo[i-1][j][k] + memo[i-1][j-1][k] + memo[i-1][j][k-1] - memo[i-1][j-1][k-1];
		}
	}
}
