package array;

import java.io.*;
import java.text.DecimalFormat;

class B4344{
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine());
			String str[]; int sum; int cnt; int avg; double percent;
			
			for(int i = 0; i < num; i++) {
				str = br.readLine().split(" ");
				int len = Integer.parseInt(str[0]);
				sum = 0;
				int arr[] = new int[len];
				for(int j = 0; j < len; j++) {
					arr[j] = Integer.parseInt(str[j+1]);
					sum += arr[j];
				}
				
				avg = sum/len; cnt = 0;
				for(int j =0; j < len; j++) {
					if(arr[j] > avg) {
						cnt++;
					}
				}
				//Math.round의 경우 40.0이면 40.000으로 만들지 않는다.
				DecimalFormat df = new DecimalFormat("0.000"); //형식 맞춰준다.
				percent = ((double)cnt)/((double)len) * 100;
				String ans = df.format(percent)+"%";
				bw.write(ans);
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
