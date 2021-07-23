package Programmers;

public class P42860 { // ���̽�ƽ
	
	public static void main(String[] args) {
		P42860 p = new P42860();
		
		System.out.println(p.solution("JEROEN"));
	}

	public int solution(String name) {
        int answer = 0;
        
        String target = "";
        for(int i = 0; i < name.length(); i++) {
        	target += "A";
        }
        
        int i = 0;
        while(!name.equals(target)) {
        	
        	// �ش� ��ġ ���� �ٲٱ�
        	int n = name.charAt(i);
        	
        	if(n-65 <= 13) {
        		answer += (n-65);
        		target = target.substring(0,i) + name.charAt(i) + target.substring(i+1,target.length());
        	}else {
        		answer += (91-n);
        		target = target.substring(0,i) + name.charAt(i) + target.substring(i+1,target.length());
        	}
        	
        	// ����, ������ ���� ���ϱ�
        	int left = i;
        	int leftNum = 0;
        	int right = i;
        	int rightNum = 0;
        	
        	while(name.charAt(left) == target.charAt(left)) {
        		left = left-1;
        		leftNum++;
            	if(left < 0) {
            		left = name.length()-1;
            	}
    	
            	if(leftNum == name.length()) {
            		break;
            	}
        	}
        	
        	while(name.charAt(right) == target.charAt(right)) {
            	right = right+1;
            	rightNum++;
            	if(right >= name.length()) {
            		right = 0;
            	}
            	
            	if(rightNum == name.length()) {
            		break;
            	}
        	}
        	
        	if(leftNum == name.length() && rightNum == name.length()) {
        		break;
        	}
        	
        	// ������ �ǵ帱 �ε��� ���ϱ�
        	if(leftNum >= rightNum) {
        		i = right;
        		answer += rightNum;
        	}else {
        		i = left;
        		answer += leftNum;
        	}
        }
        
        return answer;
    }
}
