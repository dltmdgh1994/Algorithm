package Programmers;

import java.util.*;

public class P42577 { //��ȭ��ȣ ���

	// https://programmers.co.kr/learn/courses/30/lessons/42577
	public static void main(String[] args) {
		P42577 p = new P42577();
		
		String[] s = {"12","123","1235","567","88"};
		System.out.println(p.solution(s));
	}
	
	public boolean solution(String[] phone_book) {
		
		// �ؽ��� �� ���� ȿ������ �ȵȴ�.
		HashSet<String> set = new HashSet<>();
        
		// ���ڿ� ���̰� ª�� ������ ����
        Arrays.sort(phone_book, (a, b)->{return a.length() - b.length();});
        
        if(phone_book.length == 1){
            return true;
        }
        
        // ���ڿ� ���̸� ����
        ArrayList<Integer> len = new ArrayList<>();
        for(int i = 0; i < phone_book.length; i++) {
        	if(!len.contains(phone_book[i].length())) {
        		len.add(phone_book[i].length());
        	}
        }
        
        if(len.size() == 1) {
        	return true;
        }
        
        for(int i = 0; i < phone_book.length; i++) {
        	String s1 = phone_book[i];
        	set.add(s1);
        	
        	for(int j = 0; j < len.size(); j++) {
        		int l = len.get(j);
        		
        		if(s1.length() <= l) {
        			break;
        		}else {
        			if(set.contains(s1.substring(0,l))) {
        				return false;
        			}
        		}
        	}
        }
        
        return true;
	}
}
