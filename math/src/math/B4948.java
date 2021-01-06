package math;

import java.io.*;

class B4948 { //4948 베르트랑 공준
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num; int cnt; boolean flag; int sqrt;
			while(true) {
				num = Integer.parseInt(br.readLine());
				if(num == 0 ) {
					break;
				}
				
				cnt = 0;
				for(int i = num+1; i <= num*2; i++) {
					flag = false;
					// 시간 단축을 위해 그 수의 제곱근까지만 나눠 본다.
					sqrt = (int)(Math.pow(i,0.5));
					for(int j = 2; j <= sqrt; j++) {
						if(i % j == 0) {
							flag = true;
							break;
						}
					}
					if(!flag) {
						cnt++;
					}
				}
				bw.write(Integer.toString(cnt));
				bw.newLine();
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
