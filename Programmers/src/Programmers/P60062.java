package Programmers;

import java.util.*;

public class P60062 { // 3 �ܺ� ����
	
	int answer = 0;
	int[][] weakCase;

	public static void main(String[] args) {
		
		P60062 p = new P60062();
		
		int[] weak = {1, 5, 6, 10};
		int[] dist = {1, 2, 3, 4};
		
		int ans = p.solution(12, weak, dist);
		
		System.out.println(ans);
	}
	
    public int solution(int n, int[] weak, int[] dist) {
        
        weakCase = new int[weak.length][weak.length];
        
        // ������ ������� ���¸� ���� ���·� ��� weak ���̽��� �����.
        // [1,5,6,10] => [1,5,6,10],[5,6,10,13],[6,10,13,17],[6,10,13,17,18]
        for(int i = 0; i < weak.length; i++) {
        	for(int j = 0; j < weak.length; j++) {
        		int idx = i+j;
        		
        		if(idx >= weak.length) {
        			idx -= weak.length;
        			weakCase[i][j] = weak[idx] + n;
        		}else {
        			weakCase[i][j] = weak[idx];
        		}
        	}
        }
        
        Arrays.sort(dist);
        
        boolean[] visited = new boolean[dist.length];
        // ������ �̿��Ͽ� ��� dist ���̽��� �����.
        distPermutation(dist, new int[dist.length], visited, 0);
        
        if(answer == 0) {
        	return -1;
        }else {
        	return answer;
        }
    }
    
    private void distPermutation(int[] dist, int[] distCase, boolean[] visited, int idx) {
    	
    	if(idx == dist.length) {
    		// ��� weak ���̽��� ���� ��� dist ���̽��� ���� Ž��
    		for(int[] wc : weakCase) {
    			checkWall(distCase, wc);
    		}
    		
    		return;
    	}
    	
    	for(int i = 0; i < dist.length; i++) {
    		if(!visited[i]) {
    			visited[i] = true;
    			distCase[idx] = dist[i];
    			distPermutation(dist, distCase, visited, idx+1);
    			visited[i] = false;
    		}
    	}
    }
    
    private void checkWall(int[] dc, int[] wc) {
    	int dIdx = 0;
    	int wIdx = 0;
    	int pos = wc[wIdx];
    	
    	while(dIdx < dc.length) {
    		pos += dc[dIdx];
    		
    		while(pos >= wc[wIdx]) {
    			wIdx++;
    			if(wIdx == wc.length) break;
    		}
    		
    		if(wIdx == wc.length) break;
    		dIdx++;
    		pos = wc[wIdx];
    	}
    	
    	// ��� ��� ������ Ž���ߴ��� Ȯ��
    	if(wIdx == wc.length) {
        	if(answer == 0) {
        		answer = dIdx+1;
        	}else if(answer > dIdx+1) {
        		answer = dIdx+1;
        	}
    	}
    }
}
