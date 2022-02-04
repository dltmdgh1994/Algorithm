package etc;

import java.util.ArrayList;

public class Combination {

	private int n;
	private ArrayList<ArrayList<Integer>> result; // 모든 조합
	
	public ArrayList<ArrayList<Integer>> getResult(){
		return result;
	}
	
	public Combination(int n) {
		this.n = n;
		this.result = new ArrayList<ArrayList<Integer>>();
	}
	
	public void comb(int[] arr, boolean[] visited, int depth, int idx) {
		
		if(idx == 0) {
			ArrayList<Integer> tmp = new ArrayList<>();
			for(int i = 0; i < arr.length; i++) {
				if(visited[i]) {
					tmp.add(arr[i]);
				}
			}
			
			result.add(tmp);
			return;
		}
		
		for(int i = depth; i < n; i++) {
			visited[i] = true;
			comb(arr, visited, i+1, idx-1);
			visited[i] = false;
		}
	}
}
