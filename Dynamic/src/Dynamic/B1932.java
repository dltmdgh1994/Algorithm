package Dynamic;

import java.io.*;

class B1932 { // 정수 삼각형
	BufferedReader br;
	BufferedWriter bw;
	
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine());
			int[][] triangle = new int[num][];
			triangle[0] = new int[1];
			triangle[0][0] = Integer.parseInt(br.readLine());
			
			for(int i = 1; i < num; i++) {
				triangle[i] = new int[i+1];
				String[] s = br.readLine().split(" ");
				
				// 현재 값에 전 단계의 값 중 큰 것을 더함
				triangle[i][0] = Integer.parseInt(s[0]) + triangle[i-1][0]; 
				for(int j = 1; j < i; j++) {
					triangle[i][j] = ((triangle[i-1][j-1] >= triangle[i-1][j]) ? triangle[i-1][j-1] : triangle[i-1][j]) + Integer.parseInt(s[j]);
				}
				triangle[i][i] = Integer.parseInt(s[i]) + triangle[i-1][i-1]; 
			}
			
			int max = 0;
			for(int i = 0; i < num; i++) {
				if(triangle[num-1][i] > max) {
					max = triangle[num-1][i];
				}
			}
			
			bw.write(Integer.toString(max));
			
			br.close();
			bw.close();
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
