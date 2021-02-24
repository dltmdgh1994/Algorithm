package Backtracking;

import java.io.*;

class B15649 { // N°ú M (1)
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
			boolean[] isUsing = new boolean[limit];
			for(int i = 0; i < limit; i++) {
				isUsing[i] = false;
			}
			
			backtracking(0,  ans, isUsing);
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private void backtracking(int pos, int[] ans, boolean[] isUsing) {
		if(pos == size) { //Pruning
			for(int i = 0; i < size; i++) {
				System.out.print((ans[i]+1) + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < limit; i++) {
			if(!isUsing[i]) { //promising
				ans[pos] = i;
				isUsing[i] = true;
				backtracking(pos+1, ans, isUsing);
				isUsing[i] = false;
			}
		}
	}
}
