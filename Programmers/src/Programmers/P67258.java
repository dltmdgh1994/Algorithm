package Programmers;

import java.util.*;

public class P67258 { // 3 ���� ����

	public static void main(String[] args) {
		
		P67258 p = new P67258();
		
		String[] gems = {"DIA", "EM", "EM", "RUB", "DIA"};
		int[] ans = p.solution(gems);
		
		System.out.println(ans[0]);
		System.out.println(ans[1]);
	}

	// �����̵� ������ ��� => for�� �ϳ��� ���� ���� ��Ҵ� ����
	public int[] solution(String[] gems) {
        
		// ���� ���� ����
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
        
        // ���� ���� ���� ������ �ε��� ����
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < gems.length; i++) {
        	map.put(gems[i], i);
        	
        	if(map.size() == setSize) {
        		windowEnd = i;
        		
        		// ���� ���� �ߺ��� �����ϹǷ� ������ �ε����� ������ ������ �ݺ�
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
        
        // ���� for���� ��� �ð� �ʰ�
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
