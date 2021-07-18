package Programmers;

import java.util.*;

public class P17677 {

	public static void main(String[] args) {
		P17677 p = new P17677();
		
		System.out.println(p.solution("handshake", "shake hands"));;
	}
	
	public int solution(String str1, String str2) {
 
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        str1 = str1.replaceAll("[^A-Z]", "");
        str2 = str2.replaceAll("[^A-Z]", "");
        
        ArrayList<String> arr = new ArrayList<>();
        
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        HashSet<String> all = new HashSet<>();
        HashSet<String> common = new HashSet<>();
        
        
        for(int i = 2; i <= str1.length(); i++) {
        	String str = str1.substring(i-2,i);
        	str = str.replaceAll("[^A-Z]", "");
        	System.out.println(str);
        	arr.add(str);
        }
        
        arr.sort(null);
        
        int cnt = 1;
        set1.add(arr.get(0) + Integer.toString(cnt));
    	all.add(arr.get(0) + Integer.toString(cnt));
    	
        for(int i = 1; i < arr.size(); i++) {
        	String s1 = arr.get(i-1);
        	String s2 = arr.get(i);
        	
        	if(s1.equals(s2)) {
        		s2 += Integer.toString(cnt++);
        		set1.add(s2);
            	all.add(s2);
        	}else if(s1.length() == 2 && s2.length() == 2){
        		s2 += Integer.toString(cnt);
        		cnt = 1;
        		set1.add(s2);
            	all.add(s2);
        	}
        }
        
        arr.clear();
        
        for(int i = 2; i <= str2.length(); i++) {
        	String str = str2.substring(i-2,i);
        	System.out.println(str);
        	arr.add(str);
        }
        
        cnt = 1;
        set2.add(arr.get(0) + Integer.toString(cnt));
    	all.add(arr.get(0) + Integer.toString(cnt));
    	
        for(int i = 1; i < arr.size(); i++) {
        	String s1 = arr.get(i-1);
        	String s2 = arr.get(i);
        	
        	if(s1.equals(s2)) {
        		s2 += Integer.toString(cnt++);
        		set2.add(s2);
            	all.add(s2);
        	}else if(s1.length() == 2 && s2.length() == 2) {
        		s2 += Integer.toString(cnt);
        		cnt = 1;
        		set2.add(s2);
            	all.add(s2);
        	}
        }
        
        for(String str : all) {
        	if(set1.contains(str) && set2.contains(str)) {
        		common.add(str);
        	}
        	System.out.println(str);
        }
        System.out.println();
        for(String str : common) {
        	System.out.println(str);
        }
        
        double ans = (double)common.size()/all.size();
        ans *= 65536;
        
        int answer = (int)ans;
        
        return answer;
    }
}
