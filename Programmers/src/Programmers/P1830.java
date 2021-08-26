package Programmers;

import java.util.*;

public class P1830 { // 3 브라이언의 고민

	public static void main(String[] args) {
		
		P1830 p = new P1830();
		
		String s = "a";
		System.out.println(s.substring(2));
		
//		System.out.println(p.solution("HaEaLaLaObWORLDb"));
		
	}

	// 영문 대문자는 원래 문구, 소문자는 특수기호를 의미
	
	// HELLOWORLD
	// aHELLOaWbObRbLbD
	// HaEaLaLaObWORLDb
	// aHbEbLbLbOacWdOdRdLdDc
	public String solution(String sentence) {
        String answer = "";
        
        HashSet<Character> set = new HashSet<>();
        ArrayList<String> words = new ArrayList<>();
        
        boolean upper;
        boolean rule1;
        
        if(sentence.length() == 1) {
        	char c = sentence.charAt(0);
        	
        	if(c < 91) { // 대문자
        		return sentence;
        	}else { // 소문자
        		return "invalid";
        	}
        }else if(sentence.length() == 0) {
        	return "";
        }

        while(sentence != "") {
        	upper = false;
        	rule1 = false;
        	
        	char c = sentence.charAt(0);
        	
        	if(c < 91) { // 대문자
        		upper = true;
        	}else { // 소문자
        		rule1 = true;
        	}
        	
        	if(rule1) { // rule1 시작
        		int idx = 0;
        		for(int i = 1; i < sentence.length(); i++) {
        			if(c == sentence.charAt(i)) {
        				idx = i;
        				break;
        			}
        		}
        		
        		if(idx == 0) {
        			return "invalid";
        		}else {
        			String temp = sentence.substring(0,idx+1);
        			sentence = sentence.substring(idx+1);
        			words.add(temp);
        		}
        	}else { // rule1 시작이 아닌 경우
        		c = sentence.charAt(1);
        		
        		if(c < 91) { // 대문자
        			String temp = sentence.substring(0,1);
        			sentence = sentence.substring(1);
        			words.add(temp);
            	}else { // 소문자
            		
            	}
        	}
        	
        	
        }
        
        return answer;
    }
}
