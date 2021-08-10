package Programmers;

public class P77885 { // 2�� ���Ϸ� �ٸ� ��Ʈ
	
	public static void main(String[] args) {
		P77885 p = new P77885();

		long[] num = {2, 7};
		long[] ans = p.solution(num);
		
		for(int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
	
	// ���ڸ� �ϳ��� ���ذ��鼭 Ȯ���ϸ� �ð� �ʰ�
	public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
        	long num = numbers[i];
        	
        	if(num%2 == 0) {
        		// ¦���� ��� 0���� ������ 1�� �����ָ� �ȴ�.
        		answer[i] = num+1;
        	}else {
        		// Ȧ���� ��� ���� ���� ���ӵ� 1�� ������ �߿�
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
