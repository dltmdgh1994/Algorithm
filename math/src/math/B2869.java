package math;

import java.io.*;

class B2869 { //2869 달팽이는 올라가고 싶다.
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
			cnt = Math.ceil(cnt); // Math.ceil(a) 올림, Math.abs(a) 절대값, Math.floor(a) 버림, Math.round(a) 반올림
			
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
