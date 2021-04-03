package DFS_BFS;

import java.io.*;
import java.util.*;

class B1260 { // DFS와 BFS
	BufferedReader br;
	BufferedWriter bw;
	
	List<Integer> ansDfs;
	List<Integer> ansBfs;
	
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] s = br.readLine().split(" ");
			int size = Integer.parseInt(s[0]); // 노드 개수
			int n = Integer.parseInt(s[1]); // 간선 개수
			int start = Integer.parseInt(s[2]) - 1; // 시작 위치
			
			List<List<Integer>> arr = new ArrayList<>();
			for(int i = 0; i < size; i++) {
				List<Integer> list = new ArrayList<>();
				arr.add(list);
			}
			
			ansDfs = new ArrayList<>();
			int[] isVisit = new int[size];
			for(int i = 0; i < isVisit.length; i++) {
				isVisit[i] = 0; // false
			}			
			
			for(int i = 0; i < n; i++) {
				String[] str = br.readLine().split(" ");
				arr.get(Integer.parseInt(str[0])-1).add(Integer.parseInt(str[1])-1);
				arr.get(Integer.parseInt(str[1])-1).add(Integer.parseInt(str[0])-1);
			}
			
			for(int i = 0; i < size; i++) {
				arr.get(i).sort(null);
			}
			
			dfs(arr, isVisit, start);
			
			for(int i = 0; i < ansDfs.size(); i++) {
				bw.write(Integer.toString(ansDfs.get(i) +1) + " ");
			}
			bw.newLine();
			
			// BFS
			ansBfs = new ArrayList<>();
			for(int i = 0; i < isVisit.length; i++) {
				isVisit[i] = 0; // false
			}	
			
			bfs(arr, isVisit, start);
			
			for(int i = 0; i < ansBfs.size(); i++) {
				bw.write(Integer.toString(ansBfs.get(i) +1) + " ");
			}
			bw.newLine();
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private void dfs(List<List<Integer>> arr, int[] isVisit, int start) {
		Stack<Integer> stack = new Stack<>();
		
		stack.add(start);
		isVisit[start] = 1;
		ansDfs.add(start);
		
		while(!stack.isEmpty()) {
			int st = stack.pop();
			List<Integer> arr1 = arr.get(st);
			for(int i = 0; i < arr1.size(); i++) {
				int a = arr1.get(i);
				if(isVisit[a] != 1) {
					stack.push(a);
					isVisit[a] = 1;
					ansDfs.add(a);
				}
			}
		}
		
		
		// 재귀 이용
//		List<Integer> arr1 = arr.get(start);
//		isVisit[start] = 1;
//		ansDfs.add(start);
//		
//		for(int i = 0; i < arr1.size(); i++) {
//			int st = arr1.get(i);
//			if(isVisit[st] != 1) {
//				dfs(arr, isVisit, st);
//			}
//			
//		}
	}
	
	private void bfs(List<List<Integer>> arr, int[] isVisit, int start) {
		Deque<Integer> deque = new ArrayDeque<>();
		
		deque.addFirst(start);
		isVisit[start] = 1;
		ansBfs.add(start);
		
		while(!deque.isEmpty()) {
			int st = deque.pollFirst();
			List<Integer> arr1 = arr.get(st);
			for(int i = 0; i < arr1.size(); i++) {
				int a = arr1.get(i);
				if(isVisit[a] != 1) {
					deque.addLast(a);
					isVisit[a] = 1;
					ansBfs.add(a);
				}
			}
		}
	}
}
