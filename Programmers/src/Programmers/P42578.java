package Programmers;

import java.util.HashMap;

public class P42578 { // ����

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
        
        // (���� 2�� + �� �Դ� ���) * (���� 2�� + �� �Դ� ���) *...
        // �������� ��� �� �Դ� ��츦 ����.
        // �̷� ������ �� �Դ� ��츦 ������ ������ ������� ���� �� �ִ�.
        for(int val : map.values()) {
        	answer *= val+1;
        }
        
        return answer-1;
        
        // ������ ��� ������ ���� ���Ѵ�. => �ð��ʰ�
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
	
	// ���� ����
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
