package Programmers;

public class P12911 { // 2 ���� ū ����
	
	public static void main(String[] args) {
		
		P12911 p = new P12911();

		p.solution(12);
	}
	
	public int solution(int n) {
        
		// 1�ΰ� ���ش�.
		// int a = Integer.bitCount(n);
        int cnt1 = countOne(n++);
        
        while(countOne(n) != cnt1) {
        	n++;
        }
        
        return n;
    }
	
	private int countOne(int n) {
		int cntOne = 0;
        String num = Integer.toString(n, 2);
        
        for(int i = 0; i < num.length(); i++) {
        	if(num.charAt(i) == '1') {
        		cntOne++;
        	}
        }
        
        return cntOne;
	}
}
