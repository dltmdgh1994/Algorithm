package math;

import java.io.*;

class B2869 { //2869 �����̴� �ö󰡰� �ʹ�.
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String s[] = br.readLine().split(" ");
			
			int up = Integer.parseInt(s[0]);
			int down = Integer.parseInt(s[1]);
			int height = Integer.parseInt(s[2]);
			
			int gab = up - down;
			double cnt = (double)(height - up)/(double)gab;
			cnt = Math.ceil(cnt); // Math.ceil(a) �ø�, Math.abs(a) ���밪, Math.floor(a) ����, Math.round(a) �ݿø�
			
			int day = (int)cnt;
			day++;
			
			bw.write(Integer.toString(day));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
