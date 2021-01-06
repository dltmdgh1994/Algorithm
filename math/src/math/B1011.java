package math;

import java.io.*;
import java.util.ArrayList;

class B1011 { //1011 Fly me to the Alpha Centauri
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			//long을 쓰는 이유 int는 2^31-1까지가 범위이기 때문
			ArrayList<Long> arr = new ArrayList<>();
			long start = 1; long gab =1; long cnt = 1;
			arr.add((long)1);
			while(start < Math.pow(2, 31)-1) {
				start += gab; cnt++;
				if(cnt%2 == 0) {
					gab++;
				}
				arr.add(start);
			}
			
			int num = Integer.parseInt(br.readLine()); 
			String s[]; int a; int b; long dis; int count;
			for(int i = 0; i < num; i++) {
				s = br.readLine().split(" ");
				a = Integer.parseInt(s[0]);
				b = Integer.parseInt(s[1]);
				dis = (long)(b-a);
				count = 1;
				while(arr.get(count) < dis) {
					count++;
				}
				
				if(count !=1) {
					count++;
				}
				
				bw.write(Integer.toString(count));
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
