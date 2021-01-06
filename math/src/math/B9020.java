package math;

import java.io.*;
import java.util.ArrayList;

class B9020 { //9020 골드바흐의 추측
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine());
			ArrayList<Integer> arr = new ArrayList<>();
			boolean flag; int sqrt;
			for(int i = 2; i <= 10000; i++) {
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
					arr.add(i);
				}
			}
			
			int a; int b; int front = 0; int back = 0;
			for(int i = 0; i < num; i++) {
				a = Integer.parseInt(br.readLine());
				for(int j = 0; j < arr.size(); j++) {
					b = arr.get(j);
					if(a - b >= b && arr.contains(a-b)) {
						front = b;
						back = a - front;
					}
				}
				bw.write(Integer.toString(front)+" "+Integer.toString(back));
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
