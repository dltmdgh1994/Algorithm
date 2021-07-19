package Programmers;

import java.util.*;

public class P17677 { // ���� Ŭ�����͸�

	public static void main(String[] args) {
		P17677 p = new P17677();
		
		System.out.println(p.solution("handshake", "shake hands"));;
	}
	
	public int solution(String str1, String str2) {
 
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        HashMap<String, Integer> set1 = new HashMap<>(); // ù ���� �ܾ� �� ����
        HashMap<String, Integer> set2 = new HashMap<>(); // ���� ���� �ܾ� �� ����
        HashSet<String> key = new HashSet<>(); // ������� �ܾ� ����
        
        for(int i = 2; i <= str1.length(); i++) {
        	String str = str1.substring(i-2,i);
        	str = str.replaceAll("[^A-Z]", "");
        	
        	if(!set1.containsKey(str) && str.length() == 2) {
        		set1.put(str, 1);
        		key.add(str);
        	}else if(set1.containsKey(str) && str.length() == 2) {
        		int cnt = set1.get(str) + 1;
        		set1.put(str, cnt);
        	}
        }
        
        for(int i = 2; i <= str2.length(); i++) {
        	String str = str2.substring(i-2,i);
        	str = str.replaceAll("[^A-Z]", "");
        	
        	if(!set2.containsKey(str) && str.length() == 2) {
        		set2.put(str, 1);
        		key.add(str);
        	}else if(set2.containsKey(str) && str.length() == 2) {
        		int cnt = set2.get(str) + 1;
        		set2.put(str, cnt);
        	}
        }
        
        int all = 0;
        int common = 0;
        for(String k : key) {
        	
        	if(set1.containsKey(k) && set2.containsKey(k)) {
        		int n1 = set1.get(k);
        		int n2 = set2.get(k);
        		
        		if(n1 >= n2) {
        			all += n1;
        			common += n2;
        		}else {
        			all += n2;
        			common += n1;
        		}
        	}else if(set1.containsKey(k)) {
        		all += set1.get(k);
        	}else if(set2.containsKey(k)) {
        		all += set2.get(k);
        	}
        }
        
        // Ư�� ���� ������ key�� �� ���
        if(key.isEmpty()) {
        	return 65536;
        }
        
        double ans = (double)common/all;
        ans *= 65536;
        
        int answer = (int)ans;
        
        return answer;
    }
}
