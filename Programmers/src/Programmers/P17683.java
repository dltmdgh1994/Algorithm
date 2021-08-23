package Programmers;

public class P17683 { // 2 ¹æ±Ý±×°î
	
	public static void main(String[] args) {
		
		P17683 p = new P17683();
		
		String m = "ABC";
		String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		
		String ans = p.solution(m, musicinfos);
		
		System.out.println(ans);
	}
	
	// "12:00,12:14,HELLO,CDEFGAB"
	public String solution(String m, String[] musicinfos) {
        String answer = "";
        int time = 0;
         
        m = makeSimple(m);
        int len = m.length();
        
        
        for(int i = 0; i < musicinfos.length; i++) {
        	
        	String[] s = musicinfos[i].split(",");
        	int minute = Integer.parseInt(s[1].substring(0,2)) - Integer.parseInt(s[0].substring(0,2));
        	int second = Integer.parseInt(s[1].substring(3,5)) - Integer.parseInt(s[0].substring(3,5));
        	int diff = 60*minute + second;
        	String title = s[2];
        	String melody = makeSimple(s[3]);
        	int melodyLen = melody.length(); 
        	 
        	int k = 0;
        	String target = "";
        	for(int j = 0; j < diff; j++) {
        		char c = melody.charAt(k++);
        		
        		if(target.length() == len) {
        			target = target.substring(1);
        			target += c;
        		}else {
        			target += c;
        		}
        		
        		if(k == melodyLen) k = 0;
        		
        		if(m.equals(target)) {
        			if(!answer.equals("")) {
        				if(time < diff) {
        					answer = title;
        					time = diff;
        				}
        			}else {
        				answer = title;
        				time = diff;
        			}
        			
        			break;
        		}
        	}
        }
        
        if(answer.equals("")) {
        	return "(None)";
        }else {
        	return answer;
        }
    }
	
	private String makeSimple(String m) {
		
		m = m.replaceAll("C#", "c");
		m = m.replaceAll("D#", "d");
		m = m.replaceAll("F#", "f");
		m = m.replaceAll("G#", "g");
		m = m.replaceAll("A#", "a");
	    
		return m;
	}
}
