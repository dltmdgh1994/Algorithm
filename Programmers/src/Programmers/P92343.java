package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class P92343 { // 3 양과 늑대
	
	public static void main(String[] args) {
		
		P92343 p = new P92343();
		
		int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
		int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};

		System.out.println(p.solution(info, edges));
	}
	
	ArrayList<ArrayList<Integer>> tree;
	int ans = 0;
	
    public int solution(int[] info, int[][] edges) {
    	
    	// List의 각 idx에 자식 idx 추가
    	tree = new ArrayList<>();
    	for(int i = 0; i < info.length; i++) {
    		tree.add(new ArrayList<Integer>());
    	}
    	
    	for(int[] edge : edges) {
    		tree.get(edge[0]).add(edge[1]);
    	}
    	
    	int[] possiNode = new int[info.length]; // 접근 가능 노드
    	dfs(info, 0, possiNode, 1, 0);
    	
        return ans;
    }
    
    private void dfs(int[] info, int node, int[] possiNode, int sCnt, int wCnt) {
    	
    	if(sCnt == wCnt) {
    		return;
    	}
    	
    	if(sCnt > ans) {
    		ans = sCnt;
    	}
    	
    	// 깊은 복사를 통해 접근 가능한 노드 갱신
    	int[] tmp = Arrays.copyOf(possiNode, possiNode.length);
    	tmp[node] = 0;
    	
    	ArrayList<Integer> child = tree.get(node);
    	for(int c : child) {
    		tmp[c] = 1;
    	}
    	
    	for(int i = 0; i < tmp.length; i++) {
    		if(tmp[i] == 1) {
    			if(info[i] == 0) {
    				dfs(info, i, tmp, sCnt+1, wCnt);
    			}else {
    				dfs(info, i, tmp, sCnt, wCnt+1);
    			}
    		}
    	}
    }
}