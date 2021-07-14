package Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class P42888 { // ¿ÀÇÂ Ã¤ÆÃ¹æ
	
	public static void main(String[] args) {
		P42888 p = new P42888();
		
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		
		String[] ans = p.solution(record);
		
		for(int i = 0; i < ans.length; i++) {
        	System.out.println(ans[i]);
        }
	}
	
	
	public String[] solution(String[] record) {
        
        ArrayList<String[]> ans = new ArrayList<>();
        
        HashMap<String, String> map = new HashMap<>();
        
        for(int i = 0; i < record.length; i++) {
        	String[] input = record[i].split(" ");
        	
        	if(input[0].equals("Enter")) {
        		map.put(input[1], input[2]);
        		ans.add(new String[] {input[1], "0"});
        	}else if(input[0].equals("Leave")) {
        		ans.add(new String[] {input[1], "1"});
        	}else { // Change
        		map.put(input[1], input[2]);
        	}
        }
        
        String[] answer = new String[ans.size()];
        
        for(int i = 0; i < ans.size(); i++) {
        	String[] out = ans.get(i);
        	
        	String name = map.get(out[0]);
        	
        	if(out[1].equals("0")) {
        		answer[i] = name + "´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.";
        	}else {
        		answer[i] = name + "´ÔÀÌ ³ª°¬½À´Ï´Ù.";
        	}
        }
        
        return answer;
    }
}
