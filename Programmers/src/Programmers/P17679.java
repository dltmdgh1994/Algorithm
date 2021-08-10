package Programmers;

import java.util.*;

public class P17679 { // ������ 4���

	public static void main(String[] args) {
		P17679 p = new P17679();

		int ans = p.solution(7, 2, new String[] {"AA", "BB", "AA", "BB", "ZZ", "ZZ", "CC"});
		System.out.println(ans);
	}
	
	public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        String[][] ele = new String[m][n];
        for(int i = 0; i < m; i++) {
        	ele[i] = board[i].split("");
        }
        
        ArrayList<int[]> ans = new ArrayList<>();
        
        do {
        	ans.clear();
        	
        	// 4��� Ȯ���ؼ� ArrayList�� Add
        	for(int i = 0; i < m; i++) {
            	for (int j = 0; j < n; j++) {
            		int[] result = find4(i, j, m, n, ele);
            		if(result != null) {
            			ans.add(result);
            		}
            	}
            }
        	
        	// 4����� �� 0���� �����
        	for(int i = 0; i < ans.size(); i++) {
        		int[] result = ans.get(i);
        		
        		int row = result[0];
        		int col = result[1];
        		
        		ele[row][col] = "0";
        		ele[row+1][col] = "0";
        		ele[row][col+1] = "0";
        		ele[row+1][col+1] = "0";
        	}
        	
        	// 0���� �� �� ���� �б�
        	while(!check(m, n, ele)) {
        		for(int i = 0; i < n; i++) {
            		for(int j = 0; j < m-1; j++) {
            			if(!ele[j][i].equals("0") && ele[j+1][i].equals("0")) {
            				String temp = ele[j][i];
            				ele[j][i] = ele[j+1][i];
            				ele[j+1][i] = temp;
            			}
            		}
            	}
        	}
        	
//        	for(int i = 0; i < m; i++) {
//        		for(int j = 0; j < n; j++) {
//        			System.out.print(ele[i][j]);
//        		}
//        		System.out.println();
//        	}
//        	System.out.println();
        	
        }while(ans.size() != 0);
        
        for(int i = 0; i < m; i++) {
    		for(int j = 0; j < n; j++) {
    			if(ele[i][j].equals("0")) {
    				answer++;
    			}
    		}
    	}
        
        
        return answer;
    }
	
	// 4��� Ȯ��
	private int[] find4(int row, int col, int m, int n, String[][] ele){
		
		if(row < m-1 && col < n-1) {
			String element = ele[row][col];
			
			if(element.equals("0")) {
				return null;
			}
			
			if(!ele[row+1][col].equals(element)) {
				return null;
			}
			
			if(!ele[row][col+1].equals(element)) {
				return null;
			}
			
			if(!ele[row+1][col+1].equals(element)) {
				return null;
			}
			
			return new int[] {row, col};
		}else {
			return null;
		}
	}
	
	// �߰��� 0 Ȯ��
	private boolean check(int m, int n, String[][] ele) {
		
		for(int i = 0; i < n; i++) {
    		for(int j = 0; j < m-1; j++) {
    			if(!ele[j][i].equals("0") && ele[j+1][i].equals("0")) {
    				return false;
    			}
    		}
    	}
		
		return true;
	}
}
