package Recursion;

import java.io.*;

class B11729 { // 하노이 탑 이동 순서
	BufferedReader br;
	BufferedWriter bw;
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine());
					
			bw.write(Integer.toString(Hanoi(num)));
			bw.newLine();
			
			howHonoi(num, 1, 3);
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private int Hanoi(int num) {
		if(num == 1) {
			return 1;
		}else {
			return 1 + 2*Hanoi(num-1);
		}
	}
	
	private void howHonoi(int num, int a, int b) {
		try {
			if(num == 1) {
				bw.write(Integer.toString(a) + " "+ Integer.toString(b));
				bw.newLine();
			}else {
				int c = 6 - a - b;
				howHonoi(num-1, a, c);
				bw.write(Integer.toString(a) + " "+ Integer.toString(b));
				bw.newLine();
				howHonoi(num-1, c, b);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
