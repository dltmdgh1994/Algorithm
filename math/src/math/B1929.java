package math;

import java.io.*;

class B1929 { //1929 소수 구하기
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String s[] = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			
			boolean flag; int sqrt;
			for(int i = a; i <= b; i++) {
				if(i != 1) { // 1 거르기용
					flag = false;
				}else {
					flag = true;
				}
				// 시간 단축을 위해 그 수의 제곱근까지만 나눠 본다.
				sqrt = (int)(Math.pow(i,0.5));
				for(int j = 2; j <= sqrt; j++) {
					if(i % j == 0) {
						flag = true;
						break;
					}
				}
				if(!flag) {
					bw.write(Integer.toString(i));
					bw.newLine();
				}
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
