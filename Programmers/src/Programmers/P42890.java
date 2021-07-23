package Programmers;

import java.util.*;

public class P42890 { // �ĺ�Ű
	
	public static void main(String[] args) {
		P42890 p = new P42890();
		
		String[][] s = {{"a","1","aaa","c","ng"}, {"b","1","bbb","c","g"},
				{"c","1","aaa","d","ng"}, {"d","2","bbb","d","ng"}};
		System.out.println(p.solution(s));
	}
	
	ArrayList<int[]> temp;

	public int solution(String[][] relation) {
        int answer = 0;
        
        int row = relation[0].length;
        int col = relation.length;
        
        ArrayList<Integer> key = new ArrayList<>();
        
        for(int i = 0; i < row; i++) {
        	HashSet<String> set = new HashSet<>();
        	
        	for(int j = 0; j < col; j++) {
        		set.add(relation[j][i]);
        	}
        	
        	// �ϳ��� �ĺ�Ű�� �����ϴ� ���� �ּҼ��� ������Ű�� ����
        	// �ĺ��� ���Խ�Ű�� �ʴ´�.
        	if(set.size() == col) {
        		answer++;
        	}else {
        		key.add(i);
        	}
        }
        
        ArrayList<Boolean> visited = new ArrayList<>();
        for(int i = 0; i < key.size(); i++) {
        	visited.add(false);
        }
        
        ArrayList<String> keyList = new ArrayList<>();
        
        // �ϳ�¥���� ���������� 2������
        int num = 2;
        while(num <= key.size()) {
        	temp = new ArrayList<>();
        	
        	// �ĺ��κ��� �̾Ƴ� �� �ִ� ���� �� �ĺ�Ű ���� ����
        	comb(key, visited, 0, num, num);

        	for(int i = 0; i < temp.size(); i++) {
        		int[] keyIdx = temp.get(i);
        		
        		HashSet<String> set = new HashSet<String>();
        		
        		for(int j = 0; j < col; j++) {
        			String s = "";
        			
        			for(int k = 0; k < keyIdx.length; k++) {
        				s += relation[j][keyIdx[k]];
        			}
        			
        			set.add(s);
        		}
        		
        		// ���ϼ� ����
        		if(set.size() == col) {
        			boolean flag = false;
        			
        			String target = "";
        			for(int j = 0; j < keyIdx.length; j++) {
        				target += Integer.toString(keyIdx[j]);
        			}
        			
        			// �ּҼ� Ȯ��
        			for(String tempKey : keyList) {
        				
        				int cnt = 0;
        				for(int k = 0; k < tempKey.length(); k++) {
        					// String.contains�� ���ӵ� �͸� �ĺ�
        					// "123".contains("13") => false
        					// ������ �ϳ��� Ȯ��
        					if(target.contains(tempKey.substring(k,k+1))) {
        						cnt++;
        					}
        				}
        				if(cnt == tempKey.length()) {
        					flag = true;
        					break;
        				}
        			}
        			
        			// �ּҼ� ����
        			if(!flag) {
        				answer++;
        				keyList.add(target);
        			}
        		}
        	}
        	
        	num++;
        }
        
        return answer;
    }
	
	// ���� ����
	private void comb(ArrayList<Integer> key, ArrayList<Boolean> visited, int start, int r, int size) {
		
		if(r == 0) {
			int[] temp2 = new int[size];
			int cnt = 0;
			
	        for(int i = 0; i < key.size(); i++) {
	        	if(visited.get(i)) {
	        		temp2[cnt++] = key.get(i);
	        	}
	        }
	        
	        temp.add(temp2);
	        
	        return;
	    } 

	    for(int i=start; i<key.size(); i++) {
	        visited.set(i, true);
	        comb(key, visited, i+1, r-1, size);
	        visited.set(i, false);
	    }
	}
}
