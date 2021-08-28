package Programmers;

public class P17687 { // 2 n진수 게임

	public static void main(String[] args) {
		
		P17687 p = new P17687();
		

		System.out.println(p.solution(16, 30, 3, 3));
	}
	
	// 진법 n, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p

	public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        String temp = "";
        int limit = t*m;
        int size = 0;
        int num = 0;
        
        while(size < limit) {
        	// num을 n진수로 바꿔줌
        	String s = Integer.toString(num++, n);
        	
        	size += s.length();
        	temp += s;
        }
        
        temp = temp.toUpperCase();
        
        int cnt = 1;
        for(int i = 0; i < limit; i++) {
        	char c = temp.charAt(i);
        	
        	if(cnt == p) {
        		answer += c;
        	}
        	
        	if(cnt < m) {
        		cnt++;
        	}else {
        		cnt = 1;
        	}
        }     
        
        // 왜 틀리는지 잘 모르겠다... size 쪽 문제인듯??
//        String temp = "0";
//        int[] arr = new int[20];
//        int limit = t*m;
//        
//        int num = 1;
//        int sum = 1;
//        int size = 1;
//        
//        while(sum < limit) {
//        	size = (int)(Math.log10(num++)/Math.log10(n))+1;
//        	
//        	for(int j = 0; j < size; j++) {
//        		if(arr[j] < n-1) {
//        			arr[j]++;
//        			break;
//        		}else {
//        			arr[j] = 0;
//        		}
//        	}
//        	
//        	for(int j = size-1; j >= 0; j--) {
//        		int a = arr[j];
//        		
//        		if(a == 10) {
//        			temp += "A";
//        		}else if(a == 11) {
//        			temp += "B";
//        		}else if(a == 12) {
//        			temp += "C";
//        		}else if(a == 13) {
//        			temp += "D";
//        		}else if(a == 14) {
//        			temp += "E";
//        		}else if(a == 15) {
//        			temp += "F";
//        		}else {
//        			temp += Integer.toString(a);
//        		}
//        	}
//        	
//        	sum += size;
//        }
//        System.out.println(temp);
//        
//        int cnt = 1;
//        for(int i = 0; i < limit; i++) {
//        	char c = temp.charAt(i);
//        	
//        	if(cnt == p) {
//        		answer += c;
//        	}
//        	
//        	if(cnt < m) {
//        		cnt++;
//        	}else {
//        		cnt = 1;
//        	}
//        }
        
        return answer;
    }
}
