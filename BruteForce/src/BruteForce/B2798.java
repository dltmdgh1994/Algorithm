package BruteForce;

import java.io.*;

class B2798 { // ∫Ì∑¢¿Ë
	BufferedReader br;
	BufferedWriter bw;
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String s1[] = br.readLine().split(" ");
			String s2[] = br.readLine().split(" ");
			int n = Integer.parseInt(s1[0]);
			int limit = Integer.parseInt(s1[1]);
			int arr[] = new int[n];
			
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(s2[i]);
			}
			
			int sum = 0; int max = 0;
			for(int i = 0; i <n-2; i++) {
				for(int j = i+1; j < n-1; j++) {
					for(int k = j+1; k < n; k++) {
						sum = arr[i] + arr[j] + arr[k];
						if(sum <= limit && sum > max) {
							max = sum;
						}
					}
				}
			}
			
			bw.write(Integer.toString(max));
					
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
