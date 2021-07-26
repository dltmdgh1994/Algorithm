package Programmers;

import java.util.HashMap;

public class P42578 { // 위장

	public static void main(String[] args) {
		P42578 p = new P42578();

	}
	
	int answer = 1;
	
	public int solution(String[][] clothes) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++) {
        	
        	String key = clothes[i][1];
        	
        	if(map.containsKey(key)) {
        		int val = map.get(key)+1;
        		map.put(key, val);
        	}else {
        		map.put(key, 1);
        	}
        }
        
        // (상의 2개 + 안 입는 경우) * (하의 2개 + 안 입는 경우) *...
        // 마지막에 모두 안 입는 경우를 뺀다.
        // 이런 식으로 안 입는 경우를 포함해 빠르게 계산으로 구할 수 있다.
        for(int val : map.values()) {
        	answer *= val+1;
        }
        
        return answer-1;
        
        // 가능한 모든 조합을 직접 구한다. => 시간초과
//        String[] keys = new String[map.size()];
//        boolean[] visited = new boolean[map.size()];
//        int num = 0;
//        for(String key : map.keySet()) {
//        	keys[num++] = key;
//        }
//        
//        for(int i = 0; i < map.size(); i++) {
//        	comb(keys, visited, 0, i+1, map);
//        }
//
//        return answer;
//
    }
	
	// 조합 생성
	private void comb(String[] key, boolean[] visited, int start, int r, HashMap<String, Integer> map) {
			
		if(r == 0) {
			
			int temp = 1;
			
		    for(int i = 0; i < key.length; i++) {
		        if(visited[i]) {
		        	temp *= map.get(key[i]);
		        }
		    }
		    
		    answer += temp;
		        
		    return;
		} 

		for(int i = start; i < key.length; i++) {
		    visited[i] = true;
		    comb(key, visited, i+1, r-1, map);
		    visited[i] = false;
		}
	}
}
