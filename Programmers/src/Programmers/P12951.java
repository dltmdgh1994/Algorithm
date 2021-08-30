package Programmers;

public class P12951 { // 2 JadenCase 문자열 만들기

	public static void main(String[] args) {
		
		P12951 p = new P12951();
		
		System.out.println(p.solution("He     is"));
	}
	
	// 애초에 공백은 제거하면 안된다.
	public String solution(String s) {
        String answer = "";
        
        s = s.toLowerCase();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(i == 0){
                if(c != 32){
                    answer += s.substring(i,i+1).toUpperCase();
                }else{
                    answer += c;
                }
            }else{
                if(s.charAt(i-1) == 32 && c != 32){
                    answer += s.substring(i,i+1).toUpperCase();
                }else{
                    answer += c;
                }
            }
        }
        
        return answer;
    }

//	public String solution(String s) {
//	    String answer = "";
//	    
//	    s = s.toLowerCase().trim();
//	    String tmp = "";
//	    
//	    for(int i = 0; i < s.length()-1; i++){
//	        char c1 = s.charAt(i);
//	        char c2 = s.charAt(i+1);
//	        
//	        if(c1 != 32){
//	            tmp += c1;
//	            
//	            if(c2 == 32){
//	                tmp += c2;
//	            }
//	        }
//	    }
//	    
//	    tmp += s.charAt(s.length()-1);
//	    
//	    String[] str = tmp.split(" ");
//	    
//	    for(int i = 0; i < str.length; i++){
//	        String tmp1 = str[i].substring(0,1).toUpperCase();
//	        String tmp2 = str[i].substring(1);
//	        
//	        str[i] = tmp1 + tmp2;
//	    }
//	    
//	    answer = String.join(" ", str);
//	    
//	    return answer;
//	}
}
