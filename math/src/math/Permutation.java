package math;

import java.io.*;

class Permutation {
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
			
			int[] output = new int[r];
			
			perm(arr, output, visited, 0, len, r);
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
	
	// 백트래킹
	private void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
		if (depth == r) {
			for(int i = 0; i < r; i++) {
				System.out.print(output[i]);
			}
	        System.out.println();
	        return;
	    }
	 
	    for (int i=0; i<n; i++) {
	        if (visited[i] != true) {
	            visited[i] = true;
	            output[depth] = arr[i];
	            perm(arr, output, visited, depth + 1, n, r);       
	            visited[i] = false;
	        }
	    }
	}
}
