package Programmers;

import java.util.*;

public class P42577 { //전화번호 목록

	// https://programmers.co.kr/learn/courses/30/lessons/42577
	public static void main(String[] args) {
		P42577 p = new P42577();
		
		String[] s = {"12","123","1235","567","88"};
		System.out.println(p.solution(s));
	}
	
	public boolean solution(String[] phone_book) {
		
		// 해쉬를 안 쓰면 효율성이 안된다.
		HashSet<String> set = new HashSet<>();
        
		// 문자열 길이가 짧은 순으로 정렬
        Arrays.sort(phone_book, (a, b)->{return a.length() - b.length();});
        
        if(phone_book.length == 1){
            return true;
        }
        
        // 문자열 길이를 저장
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
