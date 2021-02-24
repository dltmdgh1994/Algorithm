package Backtracking;

import java.io.*;

class B15651 { // N°ú M (3)
	BufferedReader br;
	BufferedWriter bw;
	
	int limit; int size;
	
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String str[] = br.readLine().split(" ");
			limit = Integer.parseInt(str[0]);
			size = Integer.parseInt(str[1]);
			
			int[] ans = new int[size];
			
			backtracking(0,  ans);
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private void backtracking(int pos, int[] ans) {
		
		//Pruning
		if(pos == size) { 
			try {
				for(int i = 0; i < size; i++) {
					bw.write(Integer.toString((ans[i]+1)) +" ");
				}
				bw.newLine();
			}catch(IOException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			return;
		}
		
		//promising
		for(int i = 0; i < limit; i++) {
			ans[pos] = i;
			backtracking(pos+1, ans);
		}
	}
}
