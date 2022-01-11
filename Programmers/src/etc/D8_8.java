package etc;

import java.io.*;

public class D8_8 { // 효율적인 화페 구성

	BufferedReader br;
	BufferedWriter bw;

	public static void main(String[] args) {
		
		D8_8 p = new D8_8();
		
		p.sol();
	}
	
	public void sol() {
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] s = br.readLine().split(" ");
			
			int n = Integer.parseInt(s[0]);
			int num = Integer.parseInt(s[1]);
			
			int[] money = new int[n];
			for(int i = 0; i < n; i++) {
				money[i] = Integer.parseInt(br.readLine());
			}
			
			int[] d = new int[10001];
			for(int i = 0; i < n; i++) {
				d[money[i]] = 1;
			}
			
			for(int i = money[0]+1; i < 10001; i++) {
				for(int j = 0; j < n; j++) {
					if(i-money[j] >= 0) {
						if(d[i-money[j]] != 0) {
							if(d[i] == 0) { // 아직 계산 안된 경우
								d[i] = d[i-money[j]]+1;
							}else { // 이미 계산된 경우
								if(d[i] > d[i-money[j]]+1) {
									d[i] = d[i-money[j]]+1;
								}
							}
						}
					}
				}
			}
			
			if(d[num] == 0) {
				bw.write(Integer.toString(-1));
			}else {
				bw.write(Integer.toString(d[num]));
			}

			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
