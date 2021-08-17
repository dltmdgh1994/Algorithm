package Programmers;

import java.util.*;

public class P17680 { // 2 Ä³½Ã

	public static void main(String[] args) {
		
		P17680 p = new P17680();
		
		String[] s = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		
		System.out.println(p.solution(5, s));
	}

	public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize == 0) {
        	answer = 5*cities.length;
        	
        	return answer;
        }
        
        ArrayList<String> cache = new ArrayList<>();
        
        for(int i = 0; i < cities.length; i++) {
        	
        	String s = cities[i].toLowerCase();
        	
        	if(cache.size() == cacheSize) {
        		if(cache.contains(s)) {
        			cache.remove(s);
        			cache.add(s);
        			answer++;
        		}else {
        			cache.remove(0);
        			cache.add(s);
        			answer += 5;
        		}
        	}else {
        		if(cache.contains(s)) {
        			cache.remove(s);
        			cache.add(s);
        			answer++;
        		}else {
        			cache.add(s);
        			answer += 5;
        		}
        	}
        }
        
        return answer;
    }
}
