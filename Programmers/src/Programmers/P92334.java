package Programmers;

import java.util.*;

public class P92334 { // 1 �Ű� ��� �ޱ�
	
	public static void main(String[] args) {
		
		P92334 p = new P92334();
		
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		
		int[] ans = p.solution(id_list, report, 2);
		for(int i : ans) {
			System.out.println(i + " ");
		}
	}

    public int[] solution(String[] id_list, String[] report, int k) {
        
    	// ���� �� �Ű� ���� Ƚ��
    	HashMap<String, Integer> reportedNum = new HashMap<>();
    	// ���� �� �Ű��� ����
    	HashMap<String, HashSet<String>> reportUser = new HashMap<>(); 
    	
    	for(String s : id_list) {
    		reportedNum.put(s, 0);
    		reportUser.put(s, new HashSet<String>());
    	}

    	for(String s : report) {
    		String[] r = s.split(" ");
    		String s1 = r[0];
    		String s2 = r[1];
    		
    		HashSet<String> set = reportUser.get(s1);
    		if(set.add(s2)) { // ������ �ߺ� �Ű� ����
        		int n = reportedNum.get(s2);
        		reportedNum.put(s2, n+1);
    		}
    	}
    	
    	// �������� ����
    	HashSet<String> bannedUser = new HashSet<>();
    	for(String s : reportedNum.keySet()) {
    		if(reportedNum.get(s) >= k) {
    			bannedUser.add(s);
    		}
    	}
    	
    	int[] answer = new int[id_list.length];
    	for(int i = 0; i < id_list.length; i++) {
    		String id = id_list[i];
    		
    		int cnt = 0;
    		HashSet<String> set = reportUser.get(id);
    		for(String s : set) {
    			if(bannedUser.contains(s)) {
    				cnt++;
    			}
    		}
    		
    		answer[i] = cnt;
    	}
        
        return answer;
    }
}
