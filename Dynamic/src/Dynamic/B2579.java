package Dynamic;

import java.io.*;

class B2579 { // 계단 오르기
	
//	계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다.
//	연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
//	마지막 도착 계단은 반드시 밟아야 한다
	
	BufferedReader br;
	BufferedWriter bw;
	
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine());
			int[] step = new int[num];
			int[][] result = new int[num][2];
			for(int i = 0; i < num; i++) {
				step[i] = Integer.parseInt(br.readLine());
			}
			
			// 처음에 num이 2이하인 경우를 생각하지 못했다.
			if(num == 1) {
				bw.write(Integer.toString(step[0]));
			}else if(num == 2) {
				bw.write(Integer.toString(step[0] + step[1]));
			}else {
				result[0][0] = step[0]; // 1점프 시작
				result[1][0] = result[0][0] + step[1]; // 1점프 시작 + 1점프(시작은 점프가 x) 
				result[1][1] = step[1]; // 2점프 시작
				result[2][0] = result[1][1] + step[2]; // 2점프 시작 + 1점프 
				result[2][1] = result[0][0] + step[2]; // 1점프 시작 + 2점프
				
				for(int i = 3; i < num; i++) {
					// 1점프 뒤에는 2점프만 가능
					result[i][0] = result[i-1][1] + step[i];
					// 2점프 뒤에는 1점프, 2점프 둘다 가능
					result[i][1] = ((result[i-2][0] >= result[i-2][1]) ? result[i-2][0] : result[i-2][1]) + step[i];
				}
				
				int ans = (result[num-1][0] >= result[num-1][1]) ? result[num-1][0] : result[num-1][1];
				
				bw.write(Integer.toString(ans));
			}
			
			br.close();
			bw.close();
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
