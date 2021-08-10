package Programmers;

public class P77885 { // 2개 이하로 다른 비트
	
	public static void main(String[] args) {
		P77885 p = new P77885();

		long[] num = {2, 7};
		long[] ans = p.solution(num);
		
		for(int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
	
	// 숫자를 하나씩 더해가면서 확인하면 시간 초과
	public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
        	long num = numbers[i];
        	
        	if(num%2 == 0) {
        		// 짝수의 경우 0으로 끝나서 1만 더해주면 된다.
        		answer[i] = num+1;
        	}else {
        		// 홀수의 경우 끝에 오는 연속된 1의 개수가 중요
        		String bit = Long.toBinaryString(num);
        		
        		int cnt = 0;
        		for(int j = bit.length()-1; j >= 0; j--) {
        			if(bit.charAt(j) == '1') {
        				cnt++;
        			}else {
        				break;
        			}
        		}
        		
        		answer[i] = num + (long)Math.pow(2, cnt-1);
        	}
        }
        
        return answer;
    }
}
