package func;

import java.io.*;

class B1065 {
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine());
			
			bw.write(Integer.toString(hansu(num)));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public int hansu(int num) {
		int cnt = 0; int a; int z;
		if(num < 100) {
			cnt = num;
		}else {
			cnt = 99;
			for(int i = 100; i <= num; i++) {
				int len = (int)(Math.log10(i)+1); //num의 자릿수
				int arr[] = new int[len];
				a = i;
				for(int j = len-1; j >= 0; j--) {
					z = (int)Math.pow(10, j); //자바는 ^ 대신 Math.pow(밑,지수)
					arr[j] = a/z;
					a = a%z;
				}
				int dif = arr[1] - arr[0];
				boolean bool = true;
				for(int j = len-2; j >=1; j--) {
					if((arr[j+1]-arr[j]) != dif) {
						bool = false;
						break;
					}
				}
				
				if(bool) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
