package Programmers;

import java.util.*;

public class P17684 { // 2 æ–√‡

	public static void main(String[] args) {
		
		P17684 p = new P17684();
		
		p.solution("TOBEORNOTTOBEORTOBEORNOT");
	}

	public int[] solution(String msg) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 1; i <= 26; i++) {
        	String s = (char)(i+64) + "";
        	
        	map.put(s, i);
        }
        
        int val = 27;
        int cnt = 0;
        for(int i = 0; i < msg.length(); i+=cnt) {
        	
        	String s = "";
        	cnt = 0;
        	for(int j = i+1; j < msg.length()+1; j++) {
        		String temp = msg.substring(i,j);
        		
        		if(map.containsKey(temp)) {
        			cnt++;
        			
        			if(j == msg.length()) {
        				ans.add(map.get(temp));
        			}else {
        				s = temp;
        				continue;
        			}
        		}else {
        			map.put(temp, val++);
        			ans.add(map.get(s));
        			break;
        		}
        	}
        }
        
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
        	answer[i] = ans.get(i);
        }
        
        return answer;
    }
}
