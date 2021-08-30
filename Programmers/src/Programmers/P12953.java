package Programmers;

import java.util.*;

public class P12953 { // 2 N���� �ּҰ����(lcm)

	public static void main(String[] args) {
		
		P12951 p = new P12951();
		
		System.out.println(p.solution("He     is"));
	}
	
	// lcm(a,b) = a*b / gcd(a,b) �� �����Ѵ�.
	
	// �� ���� ���μ������ؼ� �ߺ��Ǵ� ���μ��� ������ ū Ƚ����ŭ
	// �׸��� ������ ���μ��� ��� �����ָ� �� ���� �ּҰ����
	public int solution(int[] arr) {
        int answer = 1;
        
        ArrayList<Integer> prime = new ArrayList<>();
        for(int i = 2; i < 100; i++){
            boolean flag = true;
            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i%j == 0){
                    flag = false;
                }
            }
            
            if(flag){
                prime.add(i);
            }
        }
        
        boolean check = true;
        int idx = 0;
        while(check){
            int p = prime.get(idx);
            
            boolean flag1 = false;
            boolean flag2 = true;
            for(int i = 0; i < arr.length; i++){
                if(arr[i]%p == 0){
                    arr[i] /= p;
                    flag1 = true;
                }
                
                if(arr[i] != 1){
                    flag2 = false;
                }
            }
            
            if(flag1){
                answer *= p;
            }else{
                idx++;
            }
            
            if(flag2){
                check = false;
            }
        }
        
        return answer;
    }

}
