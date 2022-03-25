package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class P92342 { // 2 ¾ç±Ã´ëÈ¸

	public static void main(String[] args) {
		
		P92342 p = new P92342();
		
		int[] info = {2,1,1,1,0,0,0,0,0,0,0};
		int[] ans = p.solution(5, info);
		
		for(int i : ans) {
			System.out.print(i + " ");
		}
	}
	
	ArrayList<int[]> candidate;
	int diffScore = 0;
	
    public int[] solution(int n, int[] info) {
    	
    	candidate = new ArrayList<>();
    	
    	int[] result = new int[info.length];
    	findCandidate(n, info, 9, result);
    	
    	if(candidate.size() == 0) {
    		return new int[] {-1};
    	}
    	
        int[] answer = candidate.get(0);
        return answer;
    }
    
    private void findCandidate(int n, int[] info, int idx, int[] result) {
    	
    	if(n == 0 || idx < 0) {
    		if(idx < 0 && n != 0) {
    			result[0] = n;
    		}
    		
			int aScore = 0;
			int lScore = 0;
			
			for(int i = 10; i >= 1; i--) {
				if(info[10-i] != 0 || result[10-i] != 0) {
					if(info[10-i] >= result[10-i]) {
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
					diffScore = (lScore - aScore);
//					for(int i : result) {
//						System.out.print(i + " ");
//					}
//					System.out.println(diffScore + " clear");
				}else if((lScore - aScore) == diffScore) {
					candidate.add(Arrays.copyOf(result, result.length));
				}
			}
    	}
    	
    	for(int i = idx; i >= 0; i--) {
    		if(info[i] < n) {
    			result[i] = info[i]+1;
    			findCandidate(n-result[i], info, i-1, result);
    		}else {
    			findCandidate(n, info, i-1, result);
    		}
    		result[i] = 0;
    	}
    }
}
