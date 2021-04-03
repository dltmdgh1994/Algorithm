package math;

import java.io.*;

class Combination {
	BufferedReader br;
	BufferedWriter bw;
	
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] str = br.readLine().split(" ");
			int len = Integer.parseInt(str[0]);
			int r = Integer.parseInt(str[1]);
			
			String[] s = br.readLine().split(" ");
			
			int[] arr = new int[len];
			boolean[] visited = new boolean[len];
			for(int i = 0; i < len; i++) {
				arr[i] = Integer.parseInt(s[i]);
				visited[i] = false;
			}
			
			comb(arr, visited, 0, len, r);
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
	
	// 백트래킹 이용
	private void comb(int[] arr, boolean[] visited, int start, int n, int r) {
		if(r == 0) {
	        for(int i = 0; i < n; i++) {
	        	if(visited[i]) {
	        		System.out.print(arr[i] + " ");
	        	}
	        }
	        System.out.println();
	        return;
	    } 

	    for(int i=start; i<n; i++) {
	        visited[i] = true;
	        comb(arr, visited, i + 1, n, r - 1);
	        visited[i] = false;
	    }
	}
}
