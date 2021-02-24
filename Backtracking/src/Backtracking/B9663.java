package Backtracking;

import java.io.*;

class B9663 {
	BufferedReader br;
	BufferedWriter bw;
	
	int num;
	
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			num = Integer.parseInt(br.readLine());
			int arr[] = new int[num];
			for(int i = 0; i < num; i++) {
				arr[i] = 0;
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private void search(int[] arr) {
		
	}

}
