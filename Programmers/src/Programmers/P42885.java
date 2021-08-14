package Programmers;

import java.util.*;

public class P42885 { // 2 구명보트
	public static void main(String[] args) {
		
		P42885 p = new P42885();;

		int[] people = {70, 50, 80, 50};
		int ans = p.solution(people, 100);
		System.out.println(ans);
	}

	// 보트의 최대 인원 수가 2명인 거를 못 봐서 헤멨다.
	// 괜히 ArrayList.remove 쓰면 시간초과
	public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int start = 0;
        int end = people.length-1;
        
        while(start <= end) {
        	if(people[start]+people[end] <= limit) {
        		start++; end--;
        		answer++;
        	}else {
        		end--;
        		answer++;
        	}
        }
        
        if(start == end) {
        	answer++;
        }
        
        return answer;
    }
}
