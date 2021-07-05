package Dynamic;

import java.util.ArrayList;
import java.util.Collections;

class Main {
	public static void main(String[] args) {
//		B2565 b = new B2565();
//		b.sol();
		
		Main m = new Main();
		String[] str = m.solution("abcxyqwertyxyabc");
	
		for(int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
	}
	
	public String[] solution(String s) {
String[] answer;
        
        int half = (s.length()+1)/2;
        int len = s.length();
        int base = 0;
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        while(base < half){
            for(int i = base; i < half; i++){
                String start = s.substring(i,i+1);

                if(start.equals(s.substring((len-base)-1,(len-base)))){
                    if(check(s, i, base)){
                    	arr.add(i-base+1);
                    	base = i+1;
                        
                    }
                }
                
                if(i == half-1 && arr.size() == 0){
                    base = i+1;
                }else if(i == half-1 && arr.size() != 0){
                    arr.add((half-base)*2);
                    System.out.println((half-base+1)*2);
                    base = i+1;
                }
            }
        }
        
        
        
        if(arr.size() == 0){
            answer = new String[1];
            
            answer[0] = s;
            return answer;
        }else if(arr.size()%2 != 0){
            answer = new String[arr.size()*2-1];
            
            for(int i = arr.size()-2; i >= 0; i--) {
        		arr.add(arr.get(i));
        	}
            
            int idx = 0;
            for(int i = 0; i < arr.size(); i++){
                int j = arr.get(i);
                answer[i] = s.substring(idx, idx+j);
                idx += j;
            }
            
            return answer;
        }else{
            answer = new String[arr.size()*2];
            
        	for(int i = arr.size()-1; i >= 0; i--) {
        		arr.add(arr.get(i));
        	}
        	
            int idx = 0;
            for(int i = 0; i < arr.size(); i++){
                int j = arr.get(i);
                answer[i] = s.substring(idx, idx+j);
                idx += j;
            }
            
            return answer;
        }
    }
    
    private boolean check(String s, int idx, int base){
        String front = s.substring(base,idx+1);
        String end = s.substring(s.length()-1-idx, s.length()-base);
        
        if(front.equals(end)){
            return true;
        }else{
            return false;
        }
    }
}