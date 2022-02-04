package etc;

import java.util.ArrayList;

class Permutation {

	private int n;
	private int r;
	private int[] now; // 현재 순열
	private ArrayList<ArrayList<Integer>> result; // 모든 순열
	
	public ArrayList<ArrayList<Integer>> getResult(){
		return result;
	}
	
	public Permutation(int n, int r) {
		this.n = n;
		this.r = r;
		this.now = new int[r];
		this.result = new ArrayList<ArrayList<Integer>>();
	}
	
	public void perm(int[] arr, boolean[] visited, int depth) {
		
		if(depth == r) {
			ArrayList<Integer> tmp = new ArrayList<>();
			for(int i = 0; i < now.length; i++) {
				tmp.add(now[i]);
			}
			result.add(tmp);
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				now[depth] = arr[i];
				perm(arr, visited, depth+1);
				visited[i] = false;
			}
		}
	}
}



