package Programmers;

public class P70129 { // 2 ���� ��ȯ �ݺ��ϱ�
	
	public static void main(String[] args) {
		
		P70129 p = new P70129();

	}
	
	public int[] solution(String s) {
		
		int binaryCnt = 0; // ���� ��ȯ Ƚ��
		int zeroCnt = 0; // ���� 0 ����
        
        while(!s.equals("1")) {
        	
    		int len = 0;
        	
        	for(int i = 0; i < s.length(); i++) {

        		if(s.charAt(i) == '0') {
        			zeroCnt++;
        		}else {
        			len++;
        		}
        	}
        	
        	s = Integer.toBinaryString(len);
        	
        	binaryCnt++;
        }
        
        return new int[] {binaryCnt, zeroCnt};
    }
}
