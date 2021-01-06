package array;

import java.io.*;

class B10818 {
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine());
			String str[] = br.readLine().split(" ");
			
			int arr[] = new int[str.length];
			for(int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			
			int max = -1000000; int min = 1000000;
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] > max) {
					max = arr[i];
				}
				if(arr[i] < min) {
					min = arr[i];
				}
			}
			
			bw.write(Integer.toString(min) + " "+ Integer.toString(max) );
			
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
