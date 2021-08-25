package Programmers;

import java.util.*;

public class P1830 { // 3 브라이언의 고민

	public static void main(String[] args) {
		
		P1830 p = new P1830();
		
		System.out.println(p.solution("Aaa"));
		
	}

	// 영문 대문자는 원래 문구, 소문자는 특수기호를 의미
	public String solution(String sentence) {
        String answer = "";
        
        HashSet<Character> set = new HashSet<>();
        
        boolean upper = false;
        char rule1 = '0';
        char rule2 = '0';
        
        for(int i = 0; i < sentence.length(); i++) {
        	char c = sentence.charAt(i);
        	
        	if(c >= 65 && c < 91) { // 대문자
        		
        		if(upper && rule1 == '0') {
        			answer += (" "+c);
        		}else {
        			answer += c;
        		}
        		
        		upper = true;
        	}else { // 소문자
        		
        		if(rule1 != '0' && !upper) {
        			return "invalid";
        		}
        		
        		if(i == 0) {
        			set.add(c);
        			rule1 = c;
        		}else {
        			if(set.contains(c)) {
            			if(rule1 == c) {
            				rule1 = '0';
            				rule2 = '0';

            				if(i != sentence.length()-1) answer += " ";
            				
            			}else if(rule2 != c) {
            				return "invalid";
            			}
            		}else {
            			if(rule2 == '0') {
            				set.add(c);
            				rule2 = c;
            			}else if(rule1 == '0') {
            				set.add(c);
            				rule1 = c;
            				rule2 = '0';
            				
            				answer += " ";
            			}
            		}
        		}
        		
        		upper = false;
        	}
        	
        }
        
        return answer;
    }
}
