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
				//Math.round�� ��� 40.0�̸� 40.000���� ������ �ʴ´�.
				DecimalFormat df = new DecimalFormat("0.000"); //���� �����ش�.
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
