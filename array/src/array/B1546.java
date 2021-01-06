package array;

import java.io.*;

class B1546 {
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine());
			String str[] = br.readLine().split(" ");
			
			double arr[] = new double[num]; double max = 0;
			for(int i = 0; i < num; i++) {
				arr[i] = Double.parseDouble(str[i]);
				if(arr[i] > max) {
					max = arr[i];
				}
			}
			
			double avg = 0;
			for(int i = 0; i < num; i++) {
				arr[i] = (arr[i]/max)*100;
				avg += arr[i];
			}
			
			avg /= num;
			bw.write(Double.toString(avg));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
