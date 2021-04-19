package DFS_BFS;

import java.io.*;
import java.util.*;

//5
//11000
//10000
//10000
//10000
//00000

class B2667 { // 단지 번호 붙이기
	BufferedReader br;
	BufferedWriter bw;
	
	int n;
	int[][] arr;
	
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			n = Integer.parseInt(br.readLine());
			
			arr = new int[n][n];
			for(int i = 0; i < n; i++) {
				String str[] = br.readLine().split("");
				for(int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(str[j]);
				}
			}
			
			List<Integer> ans = new ArrayList<>();
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(arr[i][j] != 0) {
						int a = dfs(i, j);
						ans.add(a);
					}
				}
			}
			
			ans.sort(null);
			
			bw.write(Integer.toString(ans.size()));
			bw.newLine();
			for(int i = 0; i < ans.size(); i++) {
				bw.write(Integer.toString(ans.get(i)));
				bw.newLine();
			}
			
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private int dfs(int row, int col) {
		Stack<List<Integer>> stack = new Stack<>();
		int cnt = 0;
		
		arr[row][col] = 0;
		cnt++;
		
		List<Integer> xy = check(row, col);
		if(xy.get(0) != -1) {
			List<Integer> temp = new ArrayList<>();
			temp.add(row);
			temp.add(col);
			stack.push(temp);
			
			List<Integer> temp2 = new ArrayList<>();
			temp2.add(xy.get(0));
			temp2.add(xy.get(1));
			stack.push(temp2);
		}
		
		while(!stack.isEmpty()) {
			
			if(arr[xy.get(0)][xy.get(1)] == 1) {
				arr[xy.get(0)][xy.get(1)] = 0;
				cnt++;
			}
			
//			for(int k = 0; k < n; k++) {
//				for(int l = 0; l < n; l++) {
//					System.out.print(arr[k][l]);
//				}
//				System.out.println();
//			}
//			System.out.println();
//			
			List<Integer> temp = check(xy.get(0), xy.get(1));
			
			if(temp.get(0) != -1) {
				// stack.push(xy); 이런식으로 하니까 xy 값이 바뀌면 stack 내부 값도 바뀐다.
				
				List<Integer> temp2 = new ArrayList<>();
				temp2.add(temp.get(0));
				temp2.add(temp.get(1));
				
				//현재 위치 stack에 push
				stack.push(temp2);
				
				// 다음 위치로 옮긴다.
				xy.set(0, temp.get(0));
				xy.set(1, temp.get(1));
				
//				System.out.println("push : " + temp2.get(0) + " " + temp2.get(1));
//				System.out.println();
				
			}else {
//				for(int i = 0; i < stack.size(); i++) {
//					System.out.println(stack.get(i));
//				}
				
				// 전의 위치를 stack에서 pop
				List<Integer> temp1 = stack.pop();
				
				xy.set(0, temp1.get(0));
				xy.set(1, temp1.get(1));
				
//				System.out.println("pop : " + temp1.get(0) + " " + temp1.get(1));
//				System.out.println();
			}
		}
		
		return cnt;
	}
	
	private List<Integer> check(int row, int col) {
		List<Integer> xy = new ArrayList<>();
		
		if(row == 0) {
			if(col == 0) {
				if(arr[row+1][col] == 1) {
					xy.add(row+1);
					xy.add(col);
					return xy;
				}else if(arr[row][col+1] == 1) {
					xy.add(row);
					xy.add(col+1);
					return xy;
				}else {
					xy.add(-1);
					xy.add(-1);
					return xy;
				}
			}else if(col == n-1) {
				if(arr[row+1][col] == 1) {
					xy.add(row+1);
					xy.add(col);
					return xy;
				}else if(arr[row][col-1] == 1) {
					xy.add(row);
					xy.add(col-1);
					return xy;
				}else {
					xy.add(-1);
					xy.add(-1);
					return xy;
				}
			}else {
				if(arr[row+1][col] == 1) {
					xy.add(row+1);
					xy.add(col);
					return xy;
				}else if(arr[row][col-1] == 1) {
					xy.add(row);
					xy.add(col-1);
					return xy;
				}else if(arr[row][col+1] == 1) {
					xy.add(row);
					xy.add(col+1);
					return xy;
				}else {
					xy.add(-1);
					xy.add(-1);
					return xy;
				}
			}
		}else if(row == n-1) {
			if(col == 0) {
				if(arr[row-1][col] == 1) {
					xy.add(row-1);
					xy.add(col);
					return xy;
				}else if(arr[row][col+1] == 1) {
					xy.add(row);
					xy.add(col+1);
					return xy;
				}else {
					xy.add(-1);
					xy.add(-1);
					return xy;
				}
			}else if(col == n-1) {
				if(arr[row-1][col] == 1) {
					xy.add(row-1);
					xy.add(col);
					return xy;
				}else if(arr[row][col-1] == 1) {
					xy.add(row);
					xy.add(col-1);
					return xy;
				}else {
					xy.add(-1);
					xy.add(-1);
					return xy;
				}
			}else {
				if(arr[row-1][col] == 1) {
					xy.add(row-1);
					xy.add(col);
					return xy;
				}else if(arr[row][col-1] == 1) {
					xy.add(row);
					xy.add(col-1);
					return xy;
				}else if(arr[row][col+1] == 1) {
					xy.add(row);
					xy.add(col+1);
					return xy;
				}else {
					xy.add(-1);
					xy.add(-1);
					return xy;
				}
			}
		}else {
			if(col == 0) {
				if(arr[row-1][col] == 1) {
					xy.add(row-1);
					xy.add(col);
					return xy;
				}else if(arr[row+1][col] == 1) {
					xy.add(row+1);
					xy.add(col);
					return xy;
				}else if(arr[row][col+1] == 1) {
					xy.add(row);
					xy.add(col+1);
					return xy;
				}else {
					xy.add(-1);
					xy.add(-1);
					return xy;
				}
			}else if(col == n-1) {
				if(arr[row-1][col] == 1) {
					xy.add(row-1);
					xy.add(col);
					return xy;
				}else if(arr[row+1][col] == 1) {
					xy.add(row+1);
					xy.add(col);
					return xy;
				}else if(arr[row][col-1] == 1) {
					xy.add(row);
					xy.add(col-1);
					return xy;
				}else {
					xy.add(-1);
					xy.add(-1);
					return xy;
				}
			}else {
				if(arr[row-1][col] == 1) {
					xy.add(row-1);
					xy.add(col);
					return xy;
				}else if(arr[row+1][col] == 1) {
					xy.add(row+1);
					xy.add(col);
					return xy;
				}else if(arr[row][col-1] == 1) {
					xy.add(row);
					xy.add(col-1);
					return xy;
				}else if(arr[row][col+1] == 1) {
					xy.add(row);
					xy.add(col+1);
					return xy;
				}else {
					xy.add(-1);
					xy.add(-1);
					return xy;
				}
			}
		}
	}
}
