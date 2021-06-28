package Dynamic;

import java.io.*;

class B2579 { // ��� ������
	
//	����� �� ���� �� ��ܾ� �Ǵ� �� ��ܾ� ���� �� �ִ�.
//	���ӵ� �� ���� ����� ��� ��Ƽ��� �� �ȴ�. ��, �������� ��ܿ� ���Ե��� �ʴ´�.
//	������ ���� ����� �ݵ�� ��ƾ� �Ѵ�
	
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
			
			// ó���� num�� 2������ ��츦 �������� ���ߴ�.
			if(num == 1) {
				bw.write(Integer.toString(step[0]));
			}else if(num == 2) {
				bw.write(Integer.toString(step[0] + step[1]));
			}else {
				result[0][0] = step[0]; // 1���� ����
				result[1][0] = result[0][0] + step[1]; // 1���� ���� + 1����(������ ������ x) 
				result[1][1] = step[1]; // 2���� ����
				result[2][0] = result[1][1] + step[2]; // 2���� ���� + 1���� 
				result[2][1] = result[0][0] + step[2]; // 1���� ���� + 2����
				
				for(int i = 3; i < num; i++) {
					// 1���� �ڿ��� 2������ ����
					result[i][0] = result[i-1][1] + step[i];
					// 2���� �ڿ��� 1����, 2���� �Ѵ� ����
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
