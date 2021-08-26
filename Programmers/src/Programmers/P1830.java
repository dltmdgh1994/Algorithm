package Programmers;

import java.util.*;

public class P1830 { // 3 ����̾��� ���

	public static void main(String[] args) {
		
		P1830 p = new P1830();
		
		String s = "a";
		System.out.println(s.substring(2));
		
//		System.out.println(p.solution("HaEaLaLaObWORLDb"));
		
	}

	// ���� �빮�ڴ� ���� ����, �ҹ��ڴ� Ư����ȣ�� �ǹ�
	
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
        	
        	if(c < 91) { // �빮��
        		return sentence;
        	}else { // �ҹ���
        		return "invalid";
        	}
        }else if(sentence.length() == 0) {
        	return "";
        }

        while(sentence != "") {
        	upper = false;
        	rule1 = false;
        	
        	char c = sentence.charAt(0);
        	
        	if(c < 91) { // �빮��
        		upper = true;
        	}else { // �ҹ���
        		rule1 = true;
        	}
        	
        	if(rule1) { // rule1 ����
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
        	}else { // rule1 ������ �ƴ� ���
        		c = sentence.charAt(1);
        		
        		if(c < 91) { // �빮��
        			String temp = sentence.substring(0,1);
        			sentence = sentence.substring(1);
        			words.add(temp);
            	}else { // �ҹ���
            		
            	}
        	}
        	
        	
        }
        
        return answer;
    }
}
