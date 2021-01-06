package array;

import java.io.*;

class B2562 {
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int arr[] = new int[9];
			for(int i = 0; i < 9; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			
			int max = 0; int num = 0;
			for(int i = 0; i < 9; i++) {
				if(arr[i] > max) {
					max = arr[i];
					num = i+1;
				}
			}
			
			bw.write(Integer.toString(max));
			bw.newLine();
			bw.write(Integer.toString(num));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
