package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P92343 { // 3 양과 늑대
	
	public static void main(String[] args) {
		
		P92343 p = new P92343();
		
		int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
		int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};

	}
	
	ArrayList<ArrayList<Integer>> tree;
	int sCnt = 1;
	int wCnt = 0;
	
    public int solution(int[] info, int[][] edges) {
    	
    	// List의 각 idx에 자식 idx 추가
    	tree = new ArrayList<>();
    	for(int i = 0; i < info.length; i++) {
    		tree.add(new ArrayList<Integer>());
    	}
    	
    	for(int[] edge : edges) {
    		tree.get(edge[0]).add(edge[1]);
    	}
    	
    	int[] possiNode = new int[info.length];
    	
        return sCnt;
    }
    
    private void dfs(int[] info, int node, int[] possiNode) {
    	
    	if(sCnt == wCnt) {
    		return;
    	}
    	
    	int[] tmp = Arrays.copyOf(possiNode, possiNode.length);
    	tmp[node] = 0;
    	
    	ArrayList<Integer> child = tree.get(node);
    	for(int c : child) {
    		tmp[c] = 1;
    	}
    	
    	for(int i = 0; i < possiNode.length; i++) {
    		if(possiNode[i] == 1) {
    			if(info[i] == 0) {
    				dfs(info, i, tmp);
    			}else {
    				dfs(info, i, tmp);
    			}
    		}
    	}
    }
}