package DFS_BFS;

import java.io.*;
import java.util.*;

class B2606 { // 바이러스
	BufferedReader br;
	BufferedWriter bw;
	
	List<Integer> ansDfs;
	List<Integer> ansBfs;
	
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int size = Integer.parseInt(br.readLine()); // 노드 개수
			int n = Integer.parseInt(br.readLine()); // 간선 개수
			
			List<List<Integer>> arr = new ArrayList<>();
			for(int i = 0; i < size; i++) {
				List<Integer> list = new ArrayList<>();
				arr.add(list);
			}		
			
			for(int i = 0; i < n; i++) {
				String[] str = br.readLine().split(" ");
				arr.get(Integer.parseInt(str[0])-1).add(Integer.parseInt(str[1])-1);
				arr.get(Integer.parseInt(str[1])-1).add(Integer.parseInt(str[0])-1);
			}
			
			for(int i = 0; i < size; i++) {
				arr.get(i).sort(null);
			}
			
			int[] isVisit = new int[size];
			
			// DFS
//			ansDfs = new ArrayList<>();
//			for(int i = 0; i < isVisit.length; i++) {
//				isVisit[i] = 0; // false
//			}	
//			
//			dfs(arr, isVisit, 0);
//			
//			// 1번을 제외
//			bw.write(Integer.toString(ansDfs.size()-1));
			
			// BFS
			ansBfs = new ArrayList<>();
			for(int i = 0; i < isVisit.length; i++) {
				isVisit[i] = 0; // false
			}	
			
			bfs(arr, isVisit, 0);
			
			// 1번을 제외
			bw.write(Integer.toString(ansBfs.size()-1));
			
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
