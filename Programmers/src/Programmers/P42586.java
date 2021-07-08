package Programmers;

import java.util.*;

public class P42586 { // ��ɰ���
	
	public static void main(String[] args) {
		P42586 p = new P42586();
		
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};
		
		int[] answer = p.solution(progresses, speeds);
		
		for(int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}

	}
	
	public int[] solution(int[] progresses, int[] speeds) {
        
        int len = progresses.length;
        int[] complete = new int[len];
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(!check(complete)) {
        	
        	for(int i = 0; i < len; i++) {
        		if(progresses[i] < 100) {
        			progresses[i] += speeds[i];
        		}
        		
        		if(progresses[i] >= 100 && complete[i] == 0) {
        			complete[i] = 1;
        		}
        	}
        	
        	int cnt = 0;
        	boolean flag = false;
        	for(int i = 0; i < len; i++) {
        		
        		if(complete[i] == 1) {
        			complete[i] = 2;
        			cnt++;
        		}else if(complete[i] == 0) {
        			if(cnt != 0) {
        				ans.add(cnt);
        			}
        			flag = true;
        			// ���� �۾��� ���� �Ϸ�Ǿ���ϱ� ������ break
        			break;
        		}
        	}
        	
        	// �Ϸ�ǰų� ��ô������ ���� ���
        	if(!flag) {
        		if(cnt != 0) {
    				ans.add(cnt);
    			}
        	}
        }
        
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
        	answer[i] = ans.get(i);
        }
        
        return answer;
    }
	
	// �� �۾��� �Ϸ�Ǹ� true, �ƴϸ� false ����
	private boolean check(int[] complete) {
		
		for(int i = 0; i < complete.length; i++) {
			if(complete[i] < 1) {
				return false;
			}
		}
		
		return true;
	}
}
