package Programmers;

import java.util.*;

public class P67258 { // 3 보석 쇼핑

	public static void main(String[] args) {
		
		P67258 p = new P67258();
		
		String[] gems = {"DIA", "EM", "EM", "RUB", "DIA"};
		int[] ans = p.solution(gems);
		
		System.out.println(ans[0]);
		System.out.println(ans[1]);
	}

	// 슬라이딩 윈도우 방식 => for문 하나만 쓰고 공통 요소는 재사용
	public int[] solution(String[] gems) {
        
		// 보석 종류 저장
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < gems.length; i++) {
        	set.add(gems[i]);
        }
        
        int setSize = set.size();
        int min = gems.length+1;
        int stIdx = 0;
        int endIdx = gems.length-1;
        
        if(setSize == 1) {
        	return new int[] {1,1};
        }
        
        int windowSt = 0;
        int windowEnd = 0;
        
        // 보석 별로 가장 마지막 인덱스 저장
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < gems.length; i++) {
        	map.put(gems[i], i);
        	
        	if(map.size() == setSize) {
        		windowEnd = i;
        		
        		// 보석 별로 중복이 가능하므로 마지막 인덱스에 도달할 때까지 반복
        		while(map.size() == setSize) {
        			String gem = gems[windowSt];
        			
        			int idx = map.get(gem);
        			if(idx == windowSt) {
        				map.remove(gem);
        			}else {
        				windowSt++;
        			}
        		}
        		
        		if(windowEnd-windowSt+1 < min) {
        			min = windowEnd-windowSt+1;
        			stIdx = windowSt;
        			endIdx = windowEnd;
        		}
        		
        		if(min == setSize) break;
        	}
        }
        
        // 이중 for문의 경우 시간 초과
//        for(int i = 0; i < gems.length-setSize+1; i++) {
//        	
//        	HashSet<String> gemSet = new HashSet<>();
//        	
//        	for(int j = i; j < gems.length; j++) {
//        		gemSet.add(gems[j]);
//        		
//        		if(gemSet.size() == setSize) {
//        			if(j-i+1 < min) {
//        				min = j-i+1;
//        				stIdx = i;
//        				endIdx = j;
//        			}
//        			
//        			break;
//        		}
//        	}
//        	
//        	if(min == setSize) break;
//        }
        
        return new int[] {stIdx+1, endIdx+1};
    }
}
