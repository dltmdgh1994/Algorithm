package math;

import java.io.*;
import java.util.ArrayList;

class B2581 { //2581 소수
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			ArrayList<Integer> arr = new ArrayList<>();
			//1은 소수가 아니다...
			boolean flag;
			for(int i = 2; i < 10000; i++) {
				flag = false;
				for(int j = 2; j < i; j++) {
					if(i % j == 0) {
						flag = true;
						break;
					}
				}
				if(!flag) {
					arr.add(i);
				}
			}
			
			int a = Integer.parseInt(br.readLine());
			int b = Integer.parseInt(br.readLine());
			
			int sum = 0; int min = -1;
			for(int i = b; i >= a; i-- ) {
				if(arr.contains(i)) {
					sum += i;
					min = i;
				}
			}
			
			if(min == -1) {
				bw.write("-1");
			}else {
				bw.write(Integer.toString(sum));
				bw.newLine();
				bw.write(Integer.toString(min));
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
