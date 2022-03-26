package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class P92342 { // 2 양궁대회

	public static void main(String[] args) {
		
		P92342 p = new P92342();
		
		int[] info = {9,1,0,0,0,0,0,0,0,0,0};
		int[] ans = p.solution(10, info);
		
		for(int i : ans) {
			System.out.print(i + " ");
		}
	}
	
	ArrayList<int[]> candidate;
	int diffScore = 0;
	
    public int[] solution(int n, int[] info) {
    	candidate = new ArrayList<>();
    	int[] ans = new int[] {-1};

    	int[] result = new int[info.length];
    	dfs(n, info, 0, result);
    	
    	if(candidate.size() == 0) {
    		return ans;
    	}
    	
    	int max = 0;
    	int ansIdx = 0;
    	
    	// 라이언이 가장 큰 점수 차이로 우승할 수 있는 방법이 
    	// 여러 가지 일 경우, 가장 낮은 점수를 더 많이 맞힌 경우
    	for(int i = info.length-1; i >= 0; i--) {
    		max = 0;
    		ansIdx = 0;
    		boolean pass = true;
    		for(int j = 0; j < candidate.size(); j++) {
    			int[] arr = candidate.get(j);
    			
    			if(arr[i] > max) {
    				max = arr[i];
    				ansIdx = j;
    				pass = false;
    			}else if(arr[i] == max && max != 0) {
    				pass = true;
    			}
    		}
    		
    		if(max != 0 && !pass) break;
    	}
    	
    	ans = candidate.get(ansIdx);
    	
        return ans;
    }
    
    private void dfs(int n, int[] info, int idx, int[] result) {
    	
    	if(n == 0) {
			int aScore = 0;
			int lScore = 0;
			
			for(int i = 11; i >= 1; i--) {
				if(info[11-i] != 0 || result[11-i] != 0) {
					if(info[11-i] >= result[11-i]) {
						aScore += i;
					}else {
						lScore += i;
					}
				}
			}
			
			if(lScore > aScore) {
				if((lScore - aScore) > diffScore) {
					candidate.clear();
					candidate.add(Arrays.copyOf(result, result.length));
					diffScore = lScore - aScore;
				}else if((lScore - aScore) == diffScore){
					candidate.add(Arrays.copyOf(result, result.length));
				}
			}
			
			return;
    	}
    	
    	for(int i = idx; i < info.length && result[i] <= info[i]; i++) {
    		result[i]++;
    		dfs(n-1, info, idx, result);
    		result[i]--;
    	}
    }
}
