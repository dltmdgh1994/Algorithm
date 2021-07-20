package Programmers;

import java.util.*;

public class p42746 { // ���� ū ��
	
	public static void main(String[] args) {
		p42746 p = new p42746();
		
		int[] a = {3, 30, 34, 5, 9};
		
		System.out.println(p.solution(a));
	}

	public String solution(int[] numbers) {
        String answer = "";
        
        String[] num = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
        	num[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(num, (a, b)->{return Integer.parseInt(b+a) - Integer.parseInt(a+b);});
        
        boolean flag = false;
        for(int i = 0; i < num.length; i++) {
        	answer += num[i];
        	
        	if(Integer.parseInt(num[i]) != 0) {
        		flag = true;
        	}
        }
        
        if (!flag){ // ��� ���Ұ� 0�� ���
        	return "0";
        }else {
        	return answer;
        }
    }
}
