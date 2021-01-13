package math;

import java.io.*;

class B11653 {  // 소인수분해
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine());
			//어떤 N이 두 개이상 곱셈(인수)으로 나타낼 수 있을 때 인수 중 한 개 이상은
			//반드시 √N보다 작거나 같다는 것
			for(int i = 2; i <= Math.pow(num, 0.5); i++) {
				while((num % i) == 0) {
					bw.write(Integer.toString(i));
					bw.newLine();
					num /= i;
				}
			}
			
			//for반복문을 종료하고 N이 1이 아니라면 N은 소수이자 인수인 것이 자명
			if(num != 1) {
				bw.write(Integer.toString(num));
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

/*class B11653 {  // 소인수분해
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine());
			for(int i = 2; i <= num; i++) {
				while((num % i) == 0) {
					bw.write(Integer.toString(i));
					bw.newLine();
					num /= i;
				}
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}*/