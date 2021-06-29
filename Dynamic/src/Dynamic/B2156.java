package Dynamic;

import java.io.*;

class B2156 { // 포도주 시식
	
//	포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야 하고, 마신 후에는 원래 위치에 다시 놓아야 한다.
//	연속으로 놓여 있는 3잔을 모두 마실 수는 없다.
	
	BufferedReader br;
	BufferedWriter bw;
	
	int[][] result;
	
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine());
			
			// i 0 : 그 자리 값
			// i 1 : 1점프 해서 온 값 중 최대값
			// i 2 : 2점프 이상 해서 온 값 중 최대값
			result = new int[num][3];
			for(int i = 0; i < num; i++) {
				result[i][0] = Integer.parseInt(br.readLine());
			}
			
			if(num == 1) {
				bw.write(Integer.toString(result[0][0]));
			}else if(num == 2) {
				bw.write(Integer.toString(result[0][0] + result[1][0]));
			}else {
				for(int i = 1; i < num; i++) {
					result[i][1] = findMax(i, 1) + result[i][0];
					result[i][2] = findMax(i, 2) + result[i][0];
				}
				
				int ans = (result[num-1][2] >= result[num-2][1]) ? result[num-1][2] : result[num-2][1];
				ans = (ans >= result[num-1][1]) ? ans : result[num-1][1];
				bw.write(Integer.toString(ans));
			}
			
			br.close();
			bw.close();
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private int findMax(int i, int j) {
		int max = 0;
		
		if(j == 1) {
			if(result[i-1][0] > max) {
				max = result[i-1][0];
			}
			
			if(result[i-1][2] > max) {
				max = result[i-1][2];
			}
		}else {
			for(int k = 0; k < i-1; k++) {
				for(int l = 0; l < 3; l++) {
					if(result[k][l] > max) {
						max = result[k][l];
					}
				}
			}
		}
		
		return max;
	}
}
