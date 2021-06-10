package Programmers;

public class P12899 { // 124 나라의 숫자
	public static void main(String[] args) {
		P12899 p = new P12899();
		System.out.println(p.solution(12));
	}
	
	// 깔끔 코드
	public String solution(int n) {
		String[] num = {"4","1","2"};
	    String answer = "";

	    while(n > 0){
	        answer = num[n % 3] + answer;
	        // n - 1을 통해 자리올림을 안하는 효과
	        n = (n - 1) / 3;
	    }
	    return answer;
	}
	
//	public String solution(int n) {
//        String answer = "";
//        
//        int num = 1;
//        
//		  // num은 3의 배수
//        while(n > num*3) {
//        	num *= 3;
//        	n -= num;
//        }
//        
//        while(num > 0) {
//        	double q = (double)n/(double)num;
//        	
//        	if(n%num == 0) {
//        		n = num;
//        	}else {
//        		n %= num;
//        	}
//        	
//        	num /= 3;
//        	
//			// q가 소수자리도 갖고 있기 때문에 > 형식으로
//        	if(q > 2) {
//        		answer += "4";
//        	}else if(q > 1) {
//        		answer += "2";
//        	}else {
//        		answer += "1";
//        	}
//        }
//        
//        return answer;
//    }
}
