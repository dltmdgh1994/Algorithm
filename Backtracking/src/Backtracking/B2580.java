package Backtracking;

import java.io.*;
import java.util.*;

class B2580 { // ½ºµµÄí
	BufferedReader br;
	BufferedWriter bw;
	
	int[][] arr;
	
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			arr = new int[9][9];
			for(int i = 0; i < 9; i++) {
				String str[] = br.readLine().split(" ");
				for(int j = 0; j < 9; j++) {
					arr[i][j] = Integer.parseInt(str[j]);
				}
			}
			
			backtracking(0, 0);
			
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					bw.write(Integer.toString(arr[i][j]) + " ");
				}
				bw.newLine();
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private void backtracking(int row, int col) {
		
		if(row == 9 && col == 9) {
			return;
		}
		
	}
	
	
//	private void backtracking(int pos) {
//		
//		if(pos == 9) {
//			return;
//		}
//		
//		Queue<Integer> q1 = new LinkedList<>();
//		for(int i = 0; i < 9; i++) {
//			if(arr[pos][i] == 0) {
//				q1.add(i);
//			}
//		}
//		
//		if(q1.size() >= 1) {
//			int n = q1.poll();
//			int sum = 0;
//			Queue<Integer> q2 = new LinkedList<>();
//			
//			for(int j = 0; j < 9; j++) {
//				sum += arr[j][n];
//				if(arr[j][n] == 0) {
//					q2.add(j);
//				}
//			}
//			
//			if(q2.size() == 1) {
//				arr[q2.poll()][n] = 45 - sum;
//			}
//		}
//		
//		backtracking(pos+1);
//	}
}

