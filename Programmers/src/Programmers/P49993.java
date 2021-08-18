package Programmers;

import java.util.*;

public class P49993 { // 2 스킬트리

	public static void main(String[] args) {
		
		P49993 p = new P49993();
		
		String[] st = {"BACDE", "CBADF", "AECB", "BDA"};
		
		System.out.println(p.solution("CBD", st));
	}

	public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int len = skill.length();
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < skill.length(); i++) {
        	map.put(skill.charAt(i), i);
        }
        
        for(int i = 0; i < skill_trees.length; i++) {
        	
        	String s = skill_trees[i];
        	
        	int k = 0;
        	boolean flag = false;
        	for(int j = 0; j < s.length(); j++) {
        		
        		char c = s.charAt(j);
        		
        		if(map.containsKey(c)) {
        			int val = map.get(c);
        			
        			if(val == k) {
        				k++;
        			}else {
        				flag = true;
        				break;
        			}
        		}
        	}
        	
        	if(!flag) {
        		answer++;
        	}
        }
        
        return answer;
    }
}
