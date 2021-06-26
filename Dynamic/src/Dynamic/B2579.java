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
			
			result[0][0] = step[0];
			result[1][0] = step[0] + step[1]; result[1][1] = result[1][0];
			result[2][1] = step[0] + step[2]; result[2][0] = result[2][1];
			
			for(int i = 3; i < num; i++) {
				result[i][0] = result[i-1][1] + step[i];
				result[i][1] = ((result[i-2][0] >= result[i-2][1]) ? result[i-2][0] : result[i-2][1]) + step[i];
			}
			
			int ans = (result[num-1][0] >= result[num-1][1]) ? result[num-1][0] : result[num-1][1];
			
			bw.write(Integer.toString(ans));
			
			br.close();
			bw.close();
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
