package Dynamic;

import java.io.*;

class B1149 { // RGB �Ÿ�
	
	// 1�� ���� ���� 2�� ���� ���� ���� �ʾƾ� �Ѵ�.
	// N�� ���� ���� N-1�� ���� ���� ���� �ʾƾ� �Ѵ�.
	// i(2 �� i �� N-1)�� ���� ���� i-1��, i+1�� ���� ���� ���� �ʾƾ� �Ѵ�.
	
	BufferedReader br;
	BufferedWriter bw;
	
	public void sol() {
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine());
			
			int[][] result = new int[num][3];
			
			String[] s = br.readLine().split(" ");
			int r = Integer.parseInt(s[0]);
			int g = Integer.parseInt(s[1]);
			int b = Integer.parseInt(s[2]);
			
			result[0][0] = r;
			result[0][1] = g;
			result[0][2] = b;

			for(int i = 1; i < num; i++) {
				s = br.readLine().split(" ");
				r = Integer.parseInt(s[0]);
				g = Integer.parseInt(s[1]);
				b = Integer.parseInt(s[2]);
				
				// ���� ���� �������� ĥ�� �� �����Ƿ� �ܼ��� ���� ���� �ּҶ�� �ּҰ� �ƴ϶� �� �ܰ��� ���� ���
				result[i][0] = ((result[i-1][1] >= result[i-1][2]) ? result[i-1][2] : result[i-1][1]) + r;
				result[i][1] = ((result[i-1][0] >= result[i-1][2]) ? result[i-1][2] : result[i-1][0]) + g;
				result[i][2] = ((result[i-1][1] >= result[i-1][0]) ? result[i-1][0] : result[i-1][1]) + b;
			}
			
			int min = 1000000;
			for(int i = 0; i < 3; i++) {
				if(result[num-1][i] < min) {
					min = result[num-1][i];
				}
			}
			
			bw.write(Integer.toString(min));
			
			br.close();
			bw.close();
		}catch(IOException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
