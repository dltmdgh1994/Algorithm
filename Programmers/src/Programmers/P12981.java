package Programmers;

import java.util.HashSet;

public class P12981 { // 영어 끝말잇기

	public static void main(String[] args) {
		P12981 p = new P12981();

		String[] s = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		int[] n = p.solution(3, s);
		
		System.out.println(n[0]);
		System.out.println(n[1]);
	}
	
	public int[] solution(int n, String[] words) {
		
		HashSet<String> set = new HashSet<>();

		boolean flag = true;
        int num = 1;
        int order = 1;
        char last = words[0].charAt(words[0].length()-1);
        set.add(words[0]);
        
        for(int i = 1; i < words.length; i++) {
        	
        	if(i % n == 0) {
        		num = 1;
        		order++;
        	}else {
        		num++;
        	}
        	
        	if(words[i].charAt(0) != last || !set.add(words[i])) { // 틀린게 존재
        		flag = false;
        		break;
        	}else {
        		last = words[i].charAt(words[i].length()-1);
        	}
        }
        
        if(flag) {
        	num = 0; order = 0;
        }
        
        return new int[] {num, order};
    }
}
