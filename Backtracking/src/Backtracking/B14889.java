package Backtracking;

import java.io.*;
import java.util.ArrayList;

class B14889 {
	
	int[][] arr;
	int min = 1000000000;
	
	public void sol() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			arr = new int[n][n];
			for(int i = 0; i < n; i++) {
				String str[] = br.readLine().split(" ");
				for(int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(str[j]);
				}
			}
			
			int[] arr1 = new int[n];
			boolean[] visited = new boolean[n];
			for(int i = 0; i < n; i++) {
				arr1[i] = i;
				visited[i] = false;
			}
			
			visited[0] = true;
			comb(arr1, visited, 1, n, n/2-1);
			
			bw.write(Integer.toString(min));
			bw.flush();
			
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	
	// 백트래킹 이용
	private void comb(int[] arr1, boolean[] visited, int start, int n, int r) {
		if(r == 0) {
			ArrayList<Integer> st = new ArrayList<>();
			ArrayList<Integer> link = new ArrayList<>();
			
	        for(int i = 0; i < n; i++) {
	        	if(visited[i]) {
	        		st.add(arr1[i]);
	        	}else {
	        		link.add(arr1[i]);
	        	}
	        }
	        
	        if(st.size() > 0) {
	        	int stSum = 0;
		        for(int i = 0; i < st.size(); i++) {
		        	for(int j = 0; j < st.size(); j++) {
		        		stSum += arr[st.get(i)][st.get(j)];
		        	}
		        }
		        
		        int linkSum = 0;
		        for(int i = 0; i < link.size(); i++) {
		        	for(int j = 0; j < link.size(); j++) {
		        		linkSum += arr[link.get(i)][link.get(j)];
		        	}
		        }
		        
		        int ans = stSum - linkSum;
		        if(ans > 0) {
		        	if(min > ans) {
		        		min = ans;
		        	}
		        }else {
		        	if(min > -ans) {
		        		min = -ans;
		        	}
		        }
	        }
	        
	        return;
	    } 

	    for(int i=start; i<n; i++) {
	        visited[i] = true;
	        comb(arr1, visited, i + 1, n, r - 1);
	        visited[i] = false;
	    }
	}
}
