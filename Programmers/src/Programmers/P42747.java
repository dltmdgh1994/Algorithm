package Programmers;

import java.util.ArrayList;
import java.util.Collections;

public class P42747 { // H-Index

	public static void main(String[] args) {
		P42747 p = new P42747();
		
		System.out.println(p.solution(new int[] {3, 0, 6, 1, 5}));
	}
	
	public int solution(int[] citations) {
        
        // byte, char, double, short, long, int, float같은  PrimitiveType의 배열에는 
        // 적용이 불가능하니 Integer같은 Wrapper "Class"를 이용하셔야 한다는 점
//        Arrays.sort(citations, new Comparator<Integer>() {
//        	@Override
//        	public int compare(Integer o1, Integer o2) {
//        		// TODO Auto-generated method stub
//        		return o2.compareTo(o1);
//        	}
//        });  
        
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < citations.length; i++) {
        	arr.add(citations[i]);
        }
        arr.sort(Collections.reverseOrder());
        
        int h = 0;
        while(h < citations.length) {
        	if(arr.get(h) >= h+1) {
        		h++;
        	}else {
        		break;
        	}
        }
        
        return h;
    }
}
