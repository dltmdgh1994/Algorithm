package Programmers;

public class P64062 { // 3 ¡�˴ٸ� �ǳʱ�
	
	public static void main(String[] args) {
		
		P64062 p = new P64062();

		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		
		int ans = p.solution(stones, 3);
		System.out.println(ans);
	}
	
	// �̺й��� ���� Ȯ��
    public int solution(int[] stones, int k) {
        int answer = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        int mid = 0;
        
        for(int i = 0; i < stones.length; i++) {
        	if(stones[i] > max) {
        		max = stones[i];
        	}
        	
        	if(stones[i] < min) {
        		min = stones[i];
        	}
        }
        
        // �̺й��� ���� �ǳ� �� �ִ� ¡�˴ٸ� ���� Ȯ��
        while(min <= max && min != 0 && max != 0) {
        	mid = (max+min)/2;
        	
        	if(check(stones, k, mid)) {
        		min = mid+1;
        	}else {
        		answer = mid; // ������� �ǳ� �� ���� ¡�˴ٸ� �ּڰ�
        		max = mid-1; // �� ���� ���� �ǳ� �� ���� ���� �ִ��� Ȯ��
        	}
        }
        
        return answer;
    }
    
    private boolean check(int[] stones, int k, int mid) {
    	
    	int cnt = 0;
    	
    	for(int i = 0; i < stones.length; i++) {
    		if(stones[i] <= mid) {
    			cnt++;
    		}else {
    			cnt = 0;
    		}
    		
    		if(cnt == k) {
    			return false; // �� �ǳ�
    		}
    	}
    	
    	return true; // �ǳ�
    }
	
    // �����̵� ������� Ȯ���ϴ� �ð��ʰ�
    // 5 4 3 2 1 ���� ��� �۾����� ������ �������� �׷���
//    public int solution(int[] stones, int k) {
//        int answer = Integer.MAX_VALUE;
//        int max = 0;
//        
//        for(int i = 0; i < k; i++) {
//
//        	if(stones[i] > max) {
//    			max = stones[i];
//    		}
//        }
//        
//    	if(answer > max) {
//    		answer = max;
//    	}
//        
//        for(int i = 1; i < stones.length-k+1; i++) {
//        	
//        	if(stones[i-1] == max) {
//        		int tmp = 0;
//        		
//        		for(int j = i; j < i+k; j++) {
//            		if(stones[j] > tmp) {
//            			tmp = stones[j];
//            		}
//            	}
//        		
//        		max = tmp;
//        	}else {
//        		if(stones[i+k-1] > max) {
//        			max = stones[i+k-1];
//        		}
//        	}
//        	
//        	if(answer > max) {
//        		answer = max;
//        	}
//        }
//
//        return answer;
//    }
}
