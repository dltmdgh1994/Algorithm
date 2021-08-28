package Programmers;

public class P17687 { // 2 n���� ����

	public static void main(String[] args) {
		
		P17687 p = new P17687();
		

		System.out.println(p.solution(16, 30, 3, 3));
	}
	
	// ���� n, �̸� ���� ������ ���� t, ���ӿ� �����ϴ� �ο� m, Ʃ���� ���� p

	public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        String temp = "";
        int limit = t*m;
        int size = 0;
        int num = 0;
        
        while(size < limit) {
        	// num�� n������ �ٲ���
        	String s = Integer.toString(num++, n);
        	
        	size += s.length();
        	temp += s;
        }
        
        temp = temp.toUpperCase();
        
        int cnt = 1;
        for(int i = 0; i < limit; i++) {
        	char c = temp.charAt(i);
        	
        	if(cnt == p) {
        		answer += c;
        	}
        	
        	if(cnt < m) {
        		cnt++;
        	}else {
        		cnt = 1;
        	}
        }     
        
        // �� Ʋ������ �� �𸣰ڴ�... size �� �����ε�??
//        String temp = "0";
//        int[] arr = new int[20];
//        int limit = t*m;
//        
//        int num = 1;
//        int sum = 1;
//        int size = 1;
//        
//        while(sum < limit) {
//        	size = (int)(Math.log10(num++)/Math.log10(n))+1;
//        	
//        	for(int j = 0; j < size; j++) {
//        		if(arr[j] < n-1) {
//        			arr[j]++;
//        			break;
//        		}else {
//        			arr[j] = 0;
//        		}
//        	}
//        	
//        	for(int j = size-1; j >= 0; j--) {
//        		int a = arr[j];
//        		
//        		if(a == 10) {
//        			temp += "A";
//        		}else if(a == 11) {
//        			temp += "B";
//        		}else if(a == 12) {
//        			temp += "C";
//        		}else if(a == 13) {
//        			temp += "D";
//        		}else if(a == 14) {
//        			temp += "E";
//        		}else if(a == 15) {
//        			temp += "F";
//        		}else {
//        			temp += Integer.toString(a);
//        		}
//        	}
//        	
//        	sum += size;
//        }
//        System.out.println(temp);
//        
//        int cnt = 1;
//        for(int i = 0; i < limit; i++) {
//        	char c = temp.charAt(i);
//        	
//        	if(cnt == p) {
//        		answer += c;
//        	}
//        	
//        	if(cnt < m) {
//        		cnt++;
//        	}else {
//        		cnt = 1;
//        	}
//        }
        
        return answer;
    }
}
