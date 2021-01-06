package math;

import java.io.*;
import java.util.ArrayList;

class B1978 { //1978 소수 찾기
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine());
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
			
			String s[] = br.readLine().split(" ");
			int a; int cnt = 0;
			for(int i = 0; i < s.length; i++) {
				a = Integer.parseInt(s[i]);
				if(arr.contains(a)) {
					cnt++;
				}
			}
			
			bw.write(Integer.toString(cnt));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
